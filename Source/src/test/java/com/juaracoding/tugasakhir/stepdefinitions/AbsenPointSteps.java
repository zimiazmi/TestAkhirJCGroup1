package com.juaracoding.tugasakhir.stepdefinitions;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/24/2025 2:54 PM
@Last Modified 4/24/2025 2:54 PM
Version 1.0
*/

import com.juaracoding.tugasakhir.pages.dashboard.Dashboard;
import com.juaracoding.tugasakhir.pages.management.AbsenPoint;
import com.juaracoding.tugasakhir.utils.DriverSingleton;
import com.juaracoding.tugasakhir.utils.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AbsenPointSteps {

    private WebDriver driver;
    private AbsenPoint absenPoint;
    private Dashboard dashboard;

    public AbsenPointSteps(){
        this.driver = DriverSingleton.getDriver();

        this.dashboard = new Dashboard(driver);
        this.absenPoint = new AbsenPoint(driver);
    }

    @Given("I am on the absen point page")
    public void i_am_on_the_absen_point_page(){
        dashboard.goToManagementMenu();
        //butuh scrol
        dashboard.scrollSidebarToBottom();
        WaitUtils.waitForElementToBeClickable(driver, dashboard.getElemementAbsenPoint(), 10);
        dashboard.goToAbsenPointMenu();
    }

    @When("I input location point data with name {string} , latitude {double} , longitude {double} , radius {int} , description {string}")
    public void i_input_location_point_data_with_name_latitude_longitude_radius_description(String name, double latitude, double longitude, int radius, String description){
        absenPoint.clickButtonTambahkan();
        absenPoint.fillLocationPointActions(name, latitude, longitude, radius, description);
    }

    @And("I click the add button")
    public void i_click_the_add_button(){
        absenPoint.clickButtonTambah();
    }
}
