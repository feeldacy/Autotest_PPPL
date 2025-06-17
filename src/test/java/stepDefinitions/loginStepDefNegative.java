package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.LoginPage;


public class loginStepDefNegative{


    @Given("Super Admin memiliki akun dengan berisi email {string} dan password {string}")
    public void super_admin_memiliki_akun_dengan_email_dan_password(String email, String password) {
        System.out.println("Verifying account exists with email: " + email);
    }

    @When("Super Admin membuka halaman login user")
    public void super_admin_membuka_halaman_login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(baseUtil.driver);
        baseUtil.driver.get("https://digitalmap-umbulharjo.madanateknologi.web.id/login");
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/login", loginPage.getCurrentUrl());
    }

    @And("Super Admin memasukkan data email {string} dan password {string}")
    public void super_admin_memasukkan_email_dan_password(String email, String password) {
        LoginPage loginPage = new LoginPage(baseUtil.driver);

        loginPage.kirimData(loginPage.emailLocator, email);
        loginPage.kirimData(loginPage.passwordLocator, password);
    }

    @When("Super Admin menekan button Masuk")
    public void super_admin_menekan_tombol() {
        LoginPage loginPage = new LoginPage(baseUtil.driver);

        loginPage.clickLoginButton();
    }

    @Then("Sistem menampilkan error {string}")
    public void superAdminMelihatPesanError(String errorMsg) {
    }
}