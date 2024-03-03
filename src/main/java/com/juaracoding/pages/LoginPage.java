package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    // Locator Find Element menggunakan PageFactory
    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnLogin;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement btnMenu;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement btnLogout;
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement appLogo;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement txtInvalidCredentials;

    public void formLogin() {
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
    }

    // return getText
    public String getTxtAppLogo() {
        return appLogo.getText();
    }

    public void inputUsername(String username) {
        this.username.sendKeys(username);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickBtnLogin() {
        btnLogin.click();
    }

    public String getTxtDasboard() {
        return appLogo.getText();
    }

    public void logout() {
        btnMenu.click();
        btnLogout.click();
    }

    public String getTxtInvalidCredentials() {
        return txtInvalidCredentials.getText();
    }
}

