package com.juaracoding.tugasakhir.hooks;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.42
@Last Modified 22/04/25 21.42
Version 1.0
*/


import com.juaracoding.tugasakhir.utils.Browser;
import com.juaracoding.tugasakhir.utils.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    @Before
    public void setup(Scenario scenario){
        DriverSingleton.setDriver(Browser.CHROME);
    }

    @After
    public void endScenarioTest(Scenario scenario){
        DriverSingleton.exit();
    }

}
