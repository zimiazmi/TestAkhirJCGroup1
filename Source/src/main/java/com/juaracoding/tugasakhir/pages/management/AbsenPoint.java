package com.juaracoding.tugasakhir.pages.management;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 19.56
@Last Modified 22/04/25 19.56
Version 1.0
*/


import com.juaracoding.tugasakhir.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static com.juaracoding.tugasakhir.utils.DriverSingleton.driver;

public class AbsenPoint {

    private Actions actions;

    @FindBy(xpath = "//p [@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement headerAbsenPoint;

    @FindBy(xpath = "//input[@id='search']")
    WebElement kolomSearch;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement buttonReset;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement buttonSearch;

    @FindBy(xpath = "//button[text()='Tambahkan']")
    WebElement buttonTambahkan;

    @FindBy(xpath = "//input[@id='name']")
    WebElement kolomName;

    @FindBy(xpath = "//input[@id='latitude']")
    WebElement kolomLatitude;

    @FindBy(xpath = "//input[@id='longitude']")
    WebElement kolomLongitude;

    @FindBy(xpath = "//input[@id='max_radius']")
    WebElement kolomMaxRadius;

    @FindBy(xpath = "//input[@id='description']")
    WebElement kolomDescription;

    @FindBy(xpath = "//button[text()='Tambah']")
    WebElement buttonTambah;

    @FindBy(xpath = "//button[text()='Batal']")
    WebElement buttonBatal;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-lbx4ee']")
    WebElement latitudeDataSearch;

    @FindBy(xpath = "//*[@class='feather feather-more-vertical ']")
    WebElement threeDot;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[1]")
    WebElement buttonEdit;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[2]")
    WebElement buttonDelete;

    @FindBy(xpath = "//button[text()='Simpan']")
    WebElement buttonSimpan;

    @FindBy(xpath = "//button[@type='submit' and text()='Ya']")
    WebElement buttonDeleteConfirmYes;

    @FindBy(xpath = "//button[@type='button' and text()='Tidak']")
    WebElement buttonDeleteConfirmNo;

    public AbsenPoint(WebDriver driver){
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeaderAbsenPoint(){
        return headerAbsenPoint.getText();
    }

    public String getLatitudeDataSearch(){
        return latitudeDataSearch.getText();
    }

    public WebElement getKolomName() {
        return kolomName;
    }

    public WebElement getKolomLatitude() {
        return kolomLatitude;
    }

    public WebElement getKolomLongitude() {
        return kolomLongitude;
    }

    public WebElement getKolomMaxRadius() {
        return kolomMaxRadius;
    }

    public WebElement getKolomDescription() {
        return kolomDescription;
    }

    public WebElement getButtonDeleteConfirmYes(){
        return buttonDeleteConfirmYes;
    }


    public void fillColumnSearch(String name){
        kolomSearch.sendKeys(name);
    }

    public void clickButtonReset(){
        buttonReset.click();
    }

    public void clickButtonSearch(){
        buttonSearch.click();
    }

    public void clickButtonTambahkan(){
        buttonTambahkan.click();
    }

    public void fillLocationPointActions(String name, double latitude, double longitude, int radius, String description){
        actions.click(kolomName).sendKeys(name)
                .pause(Duration.ofSeconds(1))
                .click(kolomLatitude).sendKeys(String.format(Locale.US,"%.6f", latitude))
                .pause(Duration.ofSeconds(1))
                .click(kolomLongitude).sendKeys(String.format(Locale.US,"%.6f", longitude))
                .pause(Duration.ofSeconds(1))
                .click(kolomMaxRadius).sendKeys(String.valueOf(radius))
                .pause(Duration.ofSeconds(1))
                .click(kolomDescription).sendKeys(description)
                .build()
                .perform();
    }

    public void clickButtonTambah(){
        buttonTambah.click();
    }

    public void clickButtonSimpan(){
        buttonSimpan.click();
    }

    public void clickButtonBatal(){
        buttonBatal.click();
    }

    // Dapatkan seluruh row yang match nama
    public WebElement getRowByName(String name) {
        return driver.findElement(
                By.xpath("//tr[.//h6[text()='" + name + "']]")
        );
    }

    public List<WebElement> getCellsFromRow(String name) {
        WebElement row = getRowByName(name);
        return row.findElements(By.tagName("td"));
    }

    public void clickThreeDot() {
        By threeDotLocator = By.xpath("//*[@id='__next']/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[1]/td[6]/div/div/button");
        WaitUtils.waitForElementPresence(driver, threeDotLocator, 60);
        WebElement threeDotElement = WaitUtils.waitForElementToBeClickableBy(driver, threeDotLocator, 60);
        threeDotElement.click();
    }

    public void waitForActionMenu() {
        By actionMenuLocator = By.id("card-actions-menu");
        WaitUtils.waitForElementPresence(driver, actionMenuLocator, 20);
    }

    public void clickEditButton() {
        By editButtonLocator = By.xpath("/html/body/div[3]/div[3]/ul/li[1]");
        WaitUtils.waitForElementPresence(driver, editButtonLocator, 20);
        WebElement editbuttonElement = WaitUtils.waitForElementToBeClickableBy(driver, editButtonLocator, 20);
        editbuttonElement.click();
    }

    public void clickDeleteButton() {
        By deleteButtonLocator = By.xpath("/html/body/div[3]/div[3]/ul/li[2]");
        WaitUtils.waitForElementPresence(driver, deleteButtonLocator, 20);
        WebElement deletebuttonElement = WaitUtils.waitForElementToBeClickableBy(driver, deleteButtonLocator, 20);
        deletebuttonElement.click();
    }

    public void clickConfirmDeleteYes(){
        buttonDeleteConfirmYes.click();
    }

    public void updateName(String name){
        kolomName.clear();
        kolomName.sendKeys(name);
    }

    public void updateLatitude(String latitude){
        kolomLatitude.clear();
        kolomLatitude.sendKeys(latitude);
    }

    public void updateLongitude(String longitude){
        kolomLongitude.clear();
        kolomLongitude.sendKeys(longitude);
    }

    public void updateRadius(String radius){
        kolomMaxRadius.clear();
        kolomMaxRadius.sendKeys(radius);
    }

    public void updateDescription(String description){
        kolomDescription.clear();
        kolomDescription.sendKeys(description);
    }




}
