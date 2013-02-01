package com.zwort.matahata.core.dao.impl;

import com.zwort.matahata.core.dao.OperationDAO;
import com.zwort.matahata.core.model.Operation;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 1/27/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "operationDAO")
public class OperationDAOJpaImpl extends EntityDAOJpaImpl<Operation> implements OperationDAO {

    public OperationDAOJpaImpl() {
        super(Operation.class);
    }

}
