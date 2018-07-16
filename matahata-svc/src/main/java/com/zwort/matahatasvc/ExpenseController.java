package com.zwort.matahatasvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {

    @RequestMapping("/expense")
    public List<String> createExpenses(List<Expense> expenses) throws Exception {
        //TODO: No Go Only Now Remove AFAP
        return null;
    }
}
