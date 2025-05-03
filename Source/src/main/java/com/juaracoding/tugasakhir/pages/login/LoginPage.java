package com.juaracoding.tugasakhir.pages.login;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.21
@Last Modified 22/04/25 21.21
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;

public class LoginPage {

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonMasuk;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void fillPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickButtonMasuk(){
        buttonMasuk.click();
    }

}
