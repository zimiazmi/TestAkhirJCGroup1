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
import com.juaracoding.tugasakhir.utils.ScreenshotUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.juaracoding.tugasakhir.utils.DateUtil.getTodayDateFolder;

public class Hooks {

    public static ExtentReports reports;
    public static ExtentTest extentTest;
    public static Scenario scenario;

    @Before
    public void setup(Scenario scenario){
        DriverSingleton.setDriver(Browser.CHROME);
        String dateFolder = getTodayDateFolder();


        if (reports == null) {
            String reportPath = "target/reports/" + dateFolder + "/extent-report.html";
            reports = new ExtentReports(reportPath);
        }
        Hooks.scenario = scenario;
        extentTest = reports.startTest(scenario.getName());
    }

    @After
    public void endScenarioTest(Scenario scenario){
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverSingleton.getDriver(), scenario.getName());
            extentTest.log(LogStatus.FAIL, "Scenario Failed : " + scenario.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
        } else {
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverSingleton.getDriver(), scenario.getName());
            extentTest.log(LogStatus.PASS, "Scenario Passed : " + scenario.getName());
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
        }
        reports.endTest(extentTest);
        reports.flush();

        DriverSingleton.exit();
    }

}
