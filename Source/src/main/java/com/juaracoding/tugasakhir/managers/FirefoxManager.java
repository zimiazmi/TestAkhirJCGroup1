package com.juaracoding.tugasakhir.managers;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.12
@Last Modified 22/04/25 21.12
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxManager {

    public static WebDriver buildDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        return new FirefoxDriver(options);

    }

}
