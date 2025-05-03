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
import com.juaracoding.tugasakhir.utils.DateUtil;
import com.juaracoding.tugasakhir.utils.DriverSingleton;
import com.juaracoding.tugasakhir.utils.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

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
        WaitUtils.waitForSubmitToFinish(driver);
    }

    @Given("I enter {string} in search column kalender")
    public void i_enter_name_in_search_column_kalender(String name){
        WaitUtils.waitForElementToBeClickable(driver, kalender.getKolomSearch(), 10);
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

    @Then("I should see a empty row")
    public void i_should_see_a_empty_row(){
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='__next']/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr"));
        Assert.assertTrue(rows.isEmpty(),"Expected no results");
    }

    @And("I edit kalender unit to {string}")
    public void i_edit_kalender_unit_to(String newKalenderUnit){
        kalender.clickThreeDot();
        kalender.clickEditButton();
        kalender.updateKalenderUnit(newKalenderUnit);
        kalender.clickSimpan();
        WaitUtils.waitForSubmitToFinish(driver);
        WaitUtils.waitForNProgressToFinish(driver);
    }

    @Then("I delete kalender data")
    public void i_delete_kalender_data(){
        kalender.clickThreeDot();
        kalender.clickDeleteButton();
        WaitUtils.waitForElementToBeClickable(driver, kalender.getButtonDeleteConfirmYes(), 10);
        kalender.clickConfirmDeleteYes();
        WaitUtils.waitForSubmitToFinish(driver);
    }

    @And("I view kalender data")
    public void i_view_kalender_data(){
        kalender.clickThreeDot();
        kalender.clickView();
        WaitUtils.waitForNProgressToFinish(driver);
    }

    @Then("I should see detail data kalender with:")
    public void i_should_see_detail_data_kalender_with(io.cucumber.datatable.DataTable dataTable){
        List<List<String>> data = dataTable.asLists(String.class);

        String rawDate = data.get(1).get(0);
        String expectedTanggal = DateUtil.formatTanggal(rawDate);
        String expectedTipe = data.get(1).get(1);;
        String expectedDeskripsi = data.get(1).get(2);

        String actualTanggal = kalender.getTanggalView();
        String actualTipe = kalender.getTipeView();
        String actualDeskripsi = kalender.getDeskripsiView();

        Assert.assertEquals(actualTanggal, expectedTanggal);
        Assert.assertEquals(actualTipe, expectedTipe);
        Assert.assertEquals(actualDeskripsi, expectedDeskripsi);

    }

    @And("I edit detail data kalender to newTanggal {string}, newTipe {string}, newDeskripsi {string}")
    public void i_edit_detail_data_kalender_to_new_tanggal_new_tipe_new_deskripsi(String newTanggal, String newTipe, String newDeskripsi) {
        kalender.clickThreeDotView();
        kalender.clickEditViewButton();
        kalender.updateTanggalCuti(newTanggal, newTipe, newDeskripsi);
        kalender.clickSimpan();
        WaitUtils.waitForSubmitToFinish(driver);
    }

    @Given("I reload the page")
    public void i_reload_the_page() {
        driver.navigate().refresh();
        WaitUtils.waitForLoadingReloadToFinish(driver);
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String expectedMessage){
        By errorMessage = By.xpath("//*[@id='name-helper-text']");
        WaitUtils.waitForVisibility(driver, errorMessage, 10);
        String actualMessage = kalender.getErrorMessageKalenderUnit();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("I input detail data kalender to tanggal {string}, tipe {string}, deskripsi {string}")
    public void i_input_detail_data_kalender_to_tanggal_tipe_deskripsi(String tanggal, String tipe, String deskripsi) {
        kalender.clickButtonTambahkanKalender();
        kalender.updateTanggalCuti(tanggal, tipe, deskripsi);
        kalender.clickTambah();
        WaitUtils.waitForSubmitToFinish(driver);
        WaitUtils.waitForNProgressToFinish(driver);
    }
}
