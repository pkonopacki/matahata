package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.IncomeDAO;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 1/27/13
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class IncomeServiceImpl extends EntityServiceImpl<Income> implements IncomeService {

    @Override
    public IncomeDAO getDao() {
        return (IncomeDAO) dao;
    }

    @Autowired
    public void setDao(IncomeDAO dao) {
        super.setDao(dao);
    }

}
