package com.juaracoding;

import com.juaracoding.pages.CheckoutPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {
    private static WebDriver driver;
    public static ExtentTest extentTest;
    private static CheckoutPage checkoutpage = new CheckoutPage();

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User mengakses halaman checkout information")
    public void user_mengakses_halaman_checkout_information(){
        checkoutpage.clickcheckout();
        extentTest.log(LogStatus.PASS, "User mengakses halaman checkout information");
    }


    @When("User memasukan informasi yang salah")
    public void user_memasukan_informasi_yang_salah(){
        checkoutpage.failedcheckout("kiki", "bayu");
        Assert.assertEquals(checkoutpage.getErrorMessage(), "Error: Postal Code is required");
        extentTest.log(LogStatus.PASS, "User memasukan informasi yang salah");
    }


    @Then("User memasukkan informasi yang benar")
    public void user_memasukan_yang_benar(){
        checkoutpage.checkout("kiki", "bayu", "16436 Pancoran Mas");
        extentTest.log(LogStatus.PASS, "User memasukkan informasi yang benar");
    }


    @And("User mengakses halaman checkout overview")
    public void user_mengakses_halaman_checkout_overview(){
        checkoutpage.clickContinue();
        extentTest.log(LogStatus.PASS, "User mengakses halaman checkout overview");
    }

    @When("User memeriksa product di checkout overview benar")
    public void user_memeriksa_product_di_checkout_overview(){
        Assert.assertEquals(checkoutpage.getProduct1value(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(checkoutpage.getProduct2value(), "Sauce Labs Fleece Jacket");
        extentTest.log(LogStatus.PASS, "User memeriksa product di checkout overview benar");
    }

    @Then("User mengakses halaman Thank You")
    public void user_mengakses_halaman_thank_you(){
        checkoutpage.clickFinish();
        extentTest.log(LogStatus.PASS, "User memeriksa product di checkout overview benar");
    }

    @And("User kembali ke halaman dashboard")
    public void user_kembali_ke_halaman_dashboard(){
        checkoutpage.clickBackHome();
        extentTest.log(LogStatus.PASS, "User kembali ke halaman dashboard");
    }
}
