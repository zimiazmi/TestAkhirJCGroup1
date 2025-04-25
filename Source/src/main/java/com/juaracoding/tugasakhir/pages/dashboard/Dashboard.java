package com.juaracoding.tugasakhir.pages.dashboard;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/24/2025 1:41 PM
@Last Modified 4/24/2025 1:41 PM
Version 1.0
*/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.juaracoding.tugasakhir.utils.DriverSingleton.driver;

public class Dashboard {

    @FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']")
    WebElement dashboardMenu;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'])[3]")
    WebElement managementMenu;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-8atqhb'])[4]")
    WebElement sidebarManagement;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'])[11]")
    WebElement absenPoint;

    public Dashboard(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getTextDashboardMenu(){
        return dashboardMenu.getText();
    }

    public void goToManagementMenu(){
        managementMenu.click();
    }

    public void goToAbsenPointMenu(){
        absenPoint.click();
    }

    public void scrollSidebarToBottom() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", sidebarManagement);
    }

    public WebElement getElemementAbsenPoint(){
        return absenPoint;
    }


}
