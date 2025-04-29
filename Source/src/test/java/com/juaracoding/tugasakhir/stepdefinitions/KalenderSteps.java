package com.juaracoding.tugasakhir.stepdefinitions;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/29/2025 11:14 AM
@Last Modified 4/29/2025 11:14 AM
Version 1.0
*/

import com.juaracoding.tugasakhir.pages.dashboard.Dashboard;
import com.juaracoding.tugasakhir.pages.management.Kalender;
import com.juaracoding.tugasakhir.utils.DriverSingleton;
import com.juaracoding.tugasakhir.utils.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.juaracoding.tugasakhir.utils.DriverSingleton.driver;


public class KalenderSteps {

    private WebDriver driver;
    private Dashboard dashboard;
    private Kalender kalender;

    public  KalenderSteps(){
        this.driver = DriverSingleton.getDriver();

        this.dashboard = new Dashboard(driver);
        this.kalender = new Kalender(driver);
    }

    @Given("I am on the kalender page")
    public void i_am_on_the_kalender_page(){
        dashboard.goToManagementMenu();
        dashboard.scrollSidebarToBottom();
        WaitUtils.waitForElementToBeClickable(driver, dashboard.getElementKalender(), 10);
        dashboard.goToKalenderMenu();
        WaitUtils.waitForNProgressToFinish(driver);

    }

    @When("I input kalender data with kalender unit {string}")
    public void i_input_kalender_data_with_kalender_unit(String kalenderUnit){
        kalender.clickButtonTambahkanKalender();
        kalender.fillKalenderUnit(kalenderUnit);
    }

    @And("I click the add button kalender")
    public void i_click_the_add_button_Kalender(){
        kalender.clickTambah();
        kalender.waitForSubmitToFinish(driver);
    }

    @Given("I enter {string} in search column kalender")
    public void i_enter_name_in_search_column_kalender(String name){
        kalender.fillColumnSearch(name);
    }

    @And("I click the search button kalender")
    public void i_click_the_Search_button_kalender(){
        kalender.clickButtonSearch();
        WaitUtils.waitForNProgressToFinish(driver);
    }

    @Then("I should see a row {string}")
    public void i_should_see_a_row(String expected){
        String actual = kalender.getNameKalenderUnit();
        Assert.assertEquals(actual, expected);
    }


}
