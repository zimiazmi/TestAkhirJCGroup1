package com.juaracoding.tugasakhir.stepdefinitions;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.48
@Last Modified 22/04/25 21.48
Version 1.0
*/


import com.juaracoding.tugasakhir.pages.login.LoginPage;
import com.juaracoding.tugasakhir.utils.Constants;
import com.juaracoding.tugasakhir.utils.DriverSingleton;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.juaracoding.tugasakhir.hooks.Hooks.extentTest;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(){
        this.driver = DriverSingleton.getDriver();

        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password){
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        extentTest.log(LogStatus.PASS,"I enter email and password");
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.clickButtonMasuk();
        extentTest.log(LogStatus.PASS,"I click the login button");
    }

}
