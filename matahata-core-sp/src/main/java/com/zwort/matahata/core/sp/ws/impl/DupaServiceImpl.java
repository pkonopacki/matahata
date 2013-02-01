package com.zwort.matahata.core.sp.ws.impl;

import com.zwort.matahata.core.sp.adapter.AccountManagementAdapter;
import com.zwort.matahata.core.sp.adapter.SubstituteSellerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import zwort.com.matahata.services._1.*;

import javax.jws.WebParam;

public class DupaServiceImpl implements DupaServicePortType {

    @Autowired
    private SubstituteSellerAdapter substituteSellerAdapter;

    @Autowired
    private AccountManagementAdapter accountManagementAdapter;


    @Override
    public FindExpensesByCategoriesResponse findExpensesByCategories(
            FindExpensesByCategories findExpensesByCategories) {
        return substituteSellerAdapter.sellSubstitute(findExpensesByCategories);
    }

    @Override
    public FindSumsByCategoriesAndCurrenciesResp findSumsByCategoriesAndCurrencies(@WebParam(partName = "findSumsByCategoriesAndCurrencies", name = "findSumsByCategoriesAndCurrencies", targetNamespace = "http://com.zwort/matahata/Services/1") FindSumsByCategoriesAndCurrencies findSumsByCategoriesAndCurrencies) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategory(
            FindExpensesByPlanForCategory findExpensesByPlanForCategory) {
        return substituteSellerAdapter.findExpensesByPlanForCategoryResponse(findExpensesByPlanForCategory);
    }

    @Override
    public GetAccountStateResponse getAccountState(
            GetAccountStateRequestList getAccountState) {
        return accountManagementAdapter.getAccountState(getAccountState);
    }

    @Override
    public FindExpensesByBeneficiariesResp findExpensesByBeneficiaries(
            FindExpensesByBeneficiaries findExpensesByBeneficiaries) {
        return substituteSellerAdapter.findExpensesByBeneficiaries(findExpensesByBeneficiaries);
    }

}
