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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;
import java.util.Map;


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
        WaitUtils.waitForElementToBeClickable(driver, absenPoint.getKolomName(), 5);
        WaitUtils.waitForElementToBeClickable(driver, absenPoint.getKolomLatitude(), 5);
        WaitUtils.waitForElementToBeClickable(driver, absenPoint.getKolomLongitude(), 5);
        WaitUtils.waitForElementToBeClickable(driver, absenPoint.getKolomMaxRadius(), 5);
        WaitUtils.waitForElementToBeClickable(driver, absenPoint.getKolomDescription(), 5);
        absenPoint.fillLocationPointActions(name, latitude, longitude, radius, description);
    }

    @And("I click the add button")
    public void i_click_the_add_button(){
        absenPoint.clickButtonTambah();
        absenPoint.waitForSubmitToFinish(driver);
    }

    @When("I enter {string} in search column")
    public void i_enter_the_name_in_search_column(String name){
        absenPoint.fillColumnSearch(name);
    }

    @And("I click the search button")
    public void I_click_the_search_button(){
        absenPoint.clickButtonSearch();
    }

    @Then("I should see a row with:")
    public void i_should_see_a_row_with(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String expectedName = data.get(1).get(0);
        String expectedLatitude = data.get(1).get(1);;
        String expectedLongitude = data.get(1).get(2);
        String expectedRadius = data.get(1).get(3);
        String expectedDescription = data.get(1).get(4);

        List<WebElement> cells = absenPoint.getCellsFromRow(expectedName);

        Assert.assertEquals(expectedName, cells.get(0).getText());
        Assert.assertEquals(expectedLatitude, absenPoint.getLatitudeDataSearch());
        Assert.assertEquals(expectedLongitude, cells.get(2).getText());
        Assert.assertEquals(expectedRadius, cells.get(3).getText());
        Assert.assertEquals(expectedDescription, cells.get(4).getText());
    }

    @And("I update absen point data to:")
    public void i_update_absen_point_data_to(io.cucumber.datatable.DataTable dataTable) {

        absenPoint.clickThreeDot();
        absenPoint.waitForActionMenu();
        absenPoint.clickEditButton();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        absenPoint.updateName(data.get("Name"));
        absenPoint.updateLatitude(data.get("Latitude"));
        absenPoint.updateLongitude(data.get("Longitude"));
        absenPoint.updateRadius(data.get("Radius"));
        absenPoint.updateDescription(data.get("Description"));

        absenPoint.clickButtonSimpan();
        absenPoint.waitForSubmitToFinish(driver);
    }

    @Then("I delete absen point data")
    public void i_delete_absen_point_data(){
        absenPoint.clickThreeDot();
        absenPoint.clickDeleteButton();
        absenPoint.clickConfirmDeleteYes();
        absenPoint.waitForSubmitToFinish(driver);
    }



}
