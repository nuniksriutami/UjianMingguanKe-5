package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest {
    private static WebDriver driver;
    public static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static CartPage cartPage = new CartPage();

    public CartPageTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User mengakses login page")
    public void user_mengakses_halaman_login(){
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "User mengakses halaman login");
    }

    @When("User memasukan username yang benar")
    public void user_memasukan_username_yang_valid(){
        loginPage.inputUsername("standard_user");
        extentTest.log(LogStatus.PASS, "User memasukan username yang valid");
    }

    @And("User memasukan password yang benar")
    public void user_memasukan_password_yang_valid(){
        loginPage.inputPassword("secret_sauce");
        extentTest.log(LogStatus.PASS, "User memasukan password yang valid");
    }

    @And("User klik button login")
    public void user_klik_tombol_login(){
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User klik tombol login");
    }

    @Then("User berhasil login dan diarahkan ke page utama atau dashboard")
    public void user_berhasil_login_dan_diarahkan_ke_halaman_utama_atau_dashboard(){
        Assert.assertEquals(loginPage.getTxtDasboard(), "Swag Labs");
        extentTest.log(LogStatus.PASS, "User berhasil login dan diarahkan ke halaman utama atau dashboard");
    }

    @Given("User berada di home page")
    public void user_berada_di_home_page(){
        Assert.assertEquals(loginPage.getTxtDasboard(), "Swag Labs");
        extentTest.log(LogStatus.PASS, "User berada di home page");
    }

    @When("User menambahkan specific product kedalam keranjang")
    public void user_nemambahkan_product_kedalam_keranjang(){
        cartPage.clickBtnATC();
        cartPage.clickBtnATC2();
        extentTest.log(LogStatus.PASS, "User menambahkan specific product kedalam keranjang");
    }

    @Then("Keranjang harus menampilkan product yang benar")
    public void user_memastikan_product_masuk_keranjang(){
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getTxtProduct1(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getTxtProduct2(), "Sauce Labs Fleece Jacket");
        extentTest.log(LogStatus.PASS, "Keranjang harus menampilkan product yang benar");
    }
}
