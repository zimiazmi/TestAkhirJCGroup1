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

@CucumberOptions(
        tags = "@Positive",
        features = {"src/test/resources/features"},
                glue = {"com.juaracoding.tugasakhir.stepdefinitions", "com.juaracoding.tugasakhir.hooks"},
                plugin = {"pretty","html:target/cucumber-reporting/reports.html",
                        "json:target/cucumber-reporting/reports.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {
}
