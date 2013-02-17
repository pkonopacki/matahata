package com.zwort.matahata.core.service;

import com.zwort.matahata.core.dao.CurrencyDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.service.impl.CurrencyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 2/15/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceImplTest {

    private static final String VALID_ISO_CODE = "CAD";
    private static final String INVALID_ISO_CODE = "CHJ";

    @InjectMocks
    private CurrencyServiceImpl currencyService = new CurrencyServiceImpl();

    @Mock
    private CurrencyDAO mockCurrencyDao;

    @Before
    public final void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByISOCode() throws DAOException, ServiceException {
        Currency currency = new Currency();
        currency.setIsoCode(VALID_ISO_CODE);
        when(mockCurrencyDao.getByISOCode(VALID_ISO_CODE)).thenReturn(currency);

        Currency found = currencyService.getByIsoCode(VALID_ISO_CODE);

        assertEquals(currency, found);
        verify(mockCurrencyDao).getByISOCode(VALID_ISO_CODE);

        verifyNoMoreInteractions(mockCurrencyDao);

    }

    @Test
    public void getReferenceCurrency() throws DAOException, ServiceException {
        Currency currency = new Currency();
        when(mockCurrencyDao.getReferenceCurrency()).thenReturn(currency);

        Currency found = currencyService.getReferenceCurrency();

        assertEquals(currency, found);
        verify(mockCurrencyDao).getReferenceCurrency();

        verifyNoMoreInteractions(mockCurrencyDao);

    }

//    @Test
//    public void getAllActive() throws DAOException, ServiceException {
//        fail();
//    }

}
