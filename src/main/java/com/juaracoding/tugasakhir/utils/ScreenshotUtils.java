package com.juaracoding.tugasakhir.utils;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.47
@Last Modified 22/04/25 21.47
Version 1.0
*/


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.juaracoding.tugasakhir.utils.DateUtil.getTimestamp;
import static com.juaracoding.tugasakhir.utils.DateUtil.getTodayDateFolder;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        String timeStamp = getTimestamp();
        String dateFolder = getTodayDateFolder();
        String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timeStamp + ".png";

        String directory = "target/reports/" + dateFolder + "/screenshots/";
        String fullPath = directory + screenshotName;

        try {
            // Buat folder kalau belum ada
            File folder = new File(directory);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(fullPath));

            // relatif ke "target/extent-report.html"
            return "screenshots/" + screenshotName;

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }

}
