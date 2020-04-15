package com.ut.loans.express.processing.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DataReadController
 */
@RefreshScope
@RequestMapping("/test")
@RestController
public class DataReadController {

    @Value("${message:fail}")
    private String rd;

    @GetMapping(path = "/val")
    public String val() {
        System.out.println(rd);
        // @Value("${test.value}") String val
        return rd;
    }
}