package com.juaracoding.tugasakhir.strategies;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.13
@Last Modified 22/04/25 21.13
Version 1.0
*/


import com.juaracoding.tugasakhir.managers.ChromeManager;
import com.juaracoding.tugasakhir.managers.FirefoxManager;
import com.juaracoding.tugasakhir.utils.Browser;
import org.openqa.selenium.WebDriver;

public class DriverStrategies {

    public static WebDriver setStrategy(String browser){
        if (browser.equals(Browser.CHROME)){
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        }else {
            return ChromeManager.buildDriver();
        }
    }

}
