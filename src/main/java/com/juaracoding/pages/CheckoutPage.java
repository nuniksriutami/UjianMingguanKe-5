package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement BtnCheckout;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement UserFN;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement UserLN;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement PostCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement btnContinue;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    private WebElement ErrorMssg;

    //product validation di checokut
    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    private WebElement ProductNameCheckout1;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    private WebElement ProductNameCheckout2;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement BtnFinish;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement ThankYouPage;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElement btnBackHome;

    public void clickcheckout(){ BtnCheckout.click(); }
    public void clickContinue(){ btnContinue.click(); }
    public void clickFinish(){ BtnFinish.click(); }
    public void clickBackHome(){ btnBackHome.click(); }

    public String getErrorMessage(){
        return ErrorMssg.getText();
    }
    public String getThankyouMessage(){ return ThankYouPage.getText(); }
    public String getProduct1value(){ return ProductNameCheckout1.getText(); }
    public String getProduct2value(){ return ProductNameCheckout2.getText(); }




    public void checkout(String firstname, String lastname, String postcode){
        this.UserFN.sendKeys(firstname);
        this.UserLN.sendKeys(lastname);
        this.PostCode.sendKeys(postcode);
        btnContinue.click();
    }

    public void failedcheckout(String firstname, String lastname){
        this.UserFN.sendKeys(firstname);
        this.UserLN.sendKeys(lastname);
//        this.PostCode.sendKeys(postcode);
        btnContinue.click();
    }
}
