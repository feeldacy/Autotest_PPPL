package stepDefinitions;

import io.cucumber.java.cs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;
import test.KelolaTanahPage;
import test.TambahTanahPage;

import test.NavbarComponents;

public class TambahTanahNegativeSteps extends baseUtil{
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);
    KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);
    TambahTanahPage tambahTanahPage = new TambahTanahPage(baseUtil.driver);

    @Given("Login Super Admin")
    public void AdminSudahLogin(){
        loginStep();
    }

    @When("Admin dinavigasikan menu kelola Tanah")
    public void AdminNavigasiKeMenuKelolaTanah() {
        navbarComponents.clickButton(navbarComponents.kelolaTanah);
    }

    @And("Super Admin click tombol Tambah Tanah")
    public void superAdminClickTombolTambahTanah() {
        kelolaTanahPage.clickButton(kelolaTanahPage.btnTambahTanah);
    }

    @And("Super Admin fill nama asset \"asetCoba\"")
    public void superAdminFillNamaAsset() {
        WebElement inputNamaAset = driver.findElement(By.id("nama_tanah"));
        inputNamaAset.sendKeys("asetCoba");
    }

    @And("Super Admin fill Detail alamat \"Jl Vokasi jaya\"")
    public void superAdminFillAlamat() {
        WebElement inputNamaAset = driver.findElement(By.id("detail-alamat"));
        inputNamaAset.sendKeys("Jl Vokasi jaya");
    }


    @And("Super Admin choose RW \"14\"")
    public void SuperAdminFillRW() {
        WebElement inputNamaAset = driver.findElement(By.id("rw"));
        inputNamaAset.sendKeys(Integer.toString(14));
    }

    @And("Super Admin choose padukuhan \"Palemsari\"")
    public void SuperAdminChoosePadukuhan() {
        WebElement dropdown = driver.findElement(By.id("padukuhan")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Palemsari");
    }

    @And("Super Admin choose status kepemilikan \"Milik Pemerintah\"")
    public void SuperAdminChooseKepemilikan() {
        WebElement dropdown = driver.findElement(By.id("status_kepemilikan")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Milik Pemerintah");
    }

    @And("Super Admin choose status tanah \"Disewakan\"")
    public void SuperAdminChooseTanah() {
        WebElement dropdown = driver.findElement(By.id("status_tanah")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Disewakan");
    }

    @And("Super Admin choose luas tanah \"500\"")
    public void SuperAdminFillLuas() {
        WebElement inputNamaAset = driver.findElement(By.id("luas_tanah"));
        inputNamaAset.sendKeys(Integer.toString(500));
    }

    @And("Super Admin click titik pada peta")
    public void SuperAdminFillPeta() {
        WebElement peta = driver.findElement(By.className("leaflet-draw-draw-polygon")); // atau class dari div peta
        Actions actions = new Actions(driver);

        actions.moveToElement(peta, 100, 100).click().perform();
        actions.moveToElement(peta, 150, 150).click().perform();
        actions.moveToElement(peta, 200, 100).click().perform();
        actions.moveToElement(peta, 100, 100).click().perform();
    }

    @When("Super Admin click tombol Add")
    public void SuperAdminClickAdd() {
        tambahTanahPage.clickButton(tambahTanahPage.tombolAdd);
    }

    @Then("sistem menampilkan error {string}")
    public void TampilkanPesanError() {
    }
}
