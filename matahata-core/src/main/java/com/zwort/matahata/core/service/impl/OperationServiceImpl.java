package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.OperationDAO;
import com.zwort.matahata.core.model.Operation;
import com.zwort.matahata.core.service.OperationService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 1/27/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OperationServiceImpl extends EntityServiceImpl<Operation> implements OperationService {

    @Override
    public OperationDAO getDao() {
        return (OperationDAO) dao;
    }

    @Inject
    public void setDao(OperationDAO dao) {
        super.setDao(dao);
    }

}
