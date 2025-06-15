package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.LoginPage;

import test.NavbarComponents;
import test.LogoutPage;

public class LogoutSteps extends baseUtil {
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);
    LogoutPage logoutPage = new LogoutPage(baseUtil.driver);

    @Given("Super Admin login ke sistem")
    public void superAdminSudahLogin(){
        loginStep();
    }

    @When("Super Admin navigasi ke profile avatar")
    public void NavigasiProfil() {
        navbarComponents.clickButton(navbarComponents.profilAvatar);
    }

    @When("Super Admin menekan tombol logout")
    public void clickProfileAvatar() {
        logoutPage.clickBtn(logoutPage.logoutButton);
    }

    @Then("Super Admin melihat message {string}")
    public void superAdminMelihatPesanError(String errorMsg) {
    }
}
