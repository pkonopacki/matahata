package com.zwort.matahatasvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @RequestMapping("/")
    public String index() {
        return "ala ma kota";
    }
}
