package com.juaracoding.tugasakhir.utils;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.19
@Last Modified 22/04/25 21.19
Version 1.0
*/


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    // Wait sampai element clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeClickableBy(WebDriver driver, By locator, int timeoutSeconds) {
        int attempts = 0;
        while (attempts < 3) { // maksimal 3x retry kalau stale
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            } catch (StaleElementReferenceException e) {
                System.out.println("Caught StaleElementReferenceException. Retrying... Attempt " + (attempts + 1));
                attempts++;
            }
        }
        throw new TimeoutException("Element not clickable after multiple retries due to StaleElementReferenceException");
    }


        // Wait sampai element visible
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Cek apakah element muncul dalam waktu tertentu
    public static boolean isElementPresent(WebDriver driver, WebElement element, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Tunggu sampai element hadir di DOM
    public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
