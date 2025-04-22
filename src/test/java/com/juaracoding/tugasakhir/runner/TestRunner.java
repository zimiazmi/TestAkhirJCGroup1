package com.juaracoding.tugasakhir.runner;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 22.08
@Last Modified 22/04/25 22.08
Version 1.0
*/


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = {"src/main/resources/features"},
                glue = {"com.juaracoding.tugasakhir.stepdefinitions", "com.juaracoding.tugasakhir.hooks"},
                plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})


public class TestRunner extends AbstractTestNGCucumberTests {
}
