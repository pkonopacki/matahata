package com.zwort.matahata.core.dao.impl;

import com.zwort.matahata.core.dao.IncomeDAO;
import com.zwort.matahata.core.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 1/27/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "incomeDAO")
public class IncomeDAOImpl extends EntityDAOJpaImpl<Income> implements IncomeDAO {

    public IncomeDAOImpl() {
        super(Income.class);
    }

//    public IncomeDAOImpl(Class<Income> type) {
//        super(type);
//    }

}
