package com.juaracoding.tugasakhir.pages.management;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 19.57
@Last Modified 22/04/25 19.57
Version 1.0
*/


import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Kalender {

    @FindBy(xpath = "//p [@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement headerKalender;

    @FindBy(xpath = "//input[@id='search']")
    WebElement kolomSearch;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement buttonReset;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement buttonSearch;

    @FindBy(xpath = "//button[text()='Tambahkan Kalender']")
    WebElement buttonTambahkan;

    @FindBy(xpath = "//input[@id='name']")
    WebElement columnKalenderUnitName;

    @FindBy(xpath = "//button[text()='Tambah']")
    WebElement buttonTambah;

    @FindBy(xpath = "//button[text()='Batal']")
    WebElement buttonBatal;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[1]/h6")
    WebElement kalenderUnitNameTable;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]/div/div/button")
    WebElement threeDot;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[1]")
    WebElement buttonView;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[3]/div/table/tbody/tr/td[4]/div/div/button")
    WebElement threeDotView;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[3]/div/table/tbody/tr/td[1]")
    WebElement viewTanggal;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[3]/div/table/tbody/tr/td[2]")
    WebElement viewTipe;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/div[1]/div/div/div/div[3]/div/table/tbody/tr/td[3]")
    WebElement viewDeskripsi;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[1]")
    WebElement buttonViewEdit;

    @FindBy(xpath = "//*[@id='mui-13']")
    WebElement columnTanggal;

    @FindBy(xpath = "//div[@id='type']")
    WebElement columnPilihTipeCuti;

    @FindBy(xpath = "//li[@data-value='cuti_bersama']")
    WebElement columnCutiBersama;

    @FindBy(xpath = "//li[@data-value='libur_nasional']")
    WebElement columnLiburNasioal;

    @FindBy(xpath = "//input[@id='description']")
    WebElement columnDescription;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[2]")
    WebElement buttonViewDelete;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[2]")
    WebElement buttonEdit;

    @FindBy(xpath = "//*[@id='card-actions-menu']/div[3]/ul/li[3]")
    WebElement buttonDelete;

    @FindBy(xpath = "//button[text()='Simpan']")
    WebElement buttonSimpan;

    @FindBy(xpath = "//button[@type='submit' and text()='Ya']")
    WebElement buttonDeleteConfirmYes;

    @FindBy(xpath = "//button[@type='button' and text()='Tidak']")
    WebElement buttonDeleteConfirmNo;

    public Kalender(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String getHeaderKalender(){
        return headerKalender.getText();
    }

    public void fillColumnSearch(String search){
        kolomSearch.sendKeys(search);
    }

    public void clickButtonReset(){
        buttonReset.click();
    }

    public void clickButtonSearch(){
        buttonSearch.click();
    }

    public String getNameKalenderUnit(){
        return kalenderUnitNameTable.getText();
    }

    public void clickButtonTambahkanKalender(){
        buttonTambahkan.click();
    }

    public void fillKalenderUnit(String nameKalender){
        columnKalenderUnitName.sendKeys(nameKalender);
    }

    public void clickTambah(){
        buttonTambah.click();
    }

    public void clickBatal(){
        buttonBatal.click();
    }

    public void waitForSubmitToFinish(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By loadingLocator = By.xpath("//*[contains(text(),'Submitting...')]");

        // Tunggu loading submitting hilang
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingLocator));
    }

    public void clickThreeDot(){
        threeDot.click();
    }

    public void clickView(){
        buttonView.click();
    }

    public void clickThreeDotView(){
        threeDotView.click();
    }

    public void clickEditView(){
        buttonViewEdit.click();
    }

    public void fillTanggal(String date){
        columnTanggal.sendKeys(date);
    }

    public void selectTipeCutiBersama(){
        columnPilihTipeCuti.click();
        columnCutiBersama.click();
    }

    public void selectTipeLiburNasional(){
        columnPilihTipeCuti.click();
        columnLiburNasioal.click();
    }

    public void fillDeskripsi(String desc){
        columnDescription.sendKeys(desc);
    }

    public void clickSimpan(){
        buttonSimpan.click();
    }

    public void clickDeleteView(){
        buttonViewDelete.click();
    }

    public void clickEdit(){
        buttonEdit.click();
    }

    public void clickDelete(){
        buttonDelete.click();
    }



}
