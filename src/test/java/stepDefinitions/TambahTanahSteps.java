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

public class TambahTanahSteps extends baseUtil{
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);
    KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);
    TambahTanahPage tambahTanahPage = new TambahTanahPage(baseUtil.driver);

    @Given("Login")
    public void AdminSudahLogin(){
        loginStep();
    }

    @When("Super Admin navigasi menu kelola Tanah")
    public void superAdminNavigasiKeMenuKelolaTanah() {
        navbarComponents.clickButton(navbarComponents.kelolaTanah);
    }

    @And("Super Admin menekan tombol Tambah Tanah")
    public void superAdminMengklikTombolTambahTanah() {
        kelolaTanahPage.clickButton(kelolaTanahPage.btnTambahTanah);
    }

    @And("Super Admin memasukkan nama asset \"asetCoba\"")
    public void superAdminMengisiNamaAsset() {
        WebElement inputNamaAset = driver.findElement(By.id("nama_tanah"));
        inputNamaAset.sendKeys("asetCoba");
    }

    @And("Super Admin memasukkan Detail alamat \"Jl Vokasi jaya\"")
    public void superAdminMengisiAlamat() {
        WebElement inputNamaAset = driver.findElement(By.id("detail-alamat"));
        inputNamaAset.sendKeys("Jl Vokasi jaya");
    }

    @And("Super Admin memasukkan RT \"12\"")
    public void SuperAdminMengisiRT() {
        WebElement inputNamaAset = driver.findElement(By.id("rt"));
        inputNamaAset.sendKeys(Integer.toString(12));
    }

    @And("Super Admin memasukkan RW \"14\"")
    public void SuperAdminMengisiRW() {
        WebElement inputNamaAset = driver.findElement(By.id("rw"));
        inputNamaAset.sendKeys(Integer.toString(14));
    }

    @And("Super Admin memilih padukuhan \"Palemsari\"")
    public void SuperAdminMengisiPadukuhan() {
        WebElement dropdown = driver.findElement(By.id("padukuhan")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Palemsari");
    }

    @And("Super Admin memilih status kepemilikan \"Milik Pemerintah\"")
    public void SuperAdminMengisiKepemilikan() {
        WebElement dropdown = driver.findElement(By.id("status_kepemilikan")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Milik Pemerintah");
    }

    @And("Super Admin memilih status tanah \"Disewakan\"")
    public void SuperAdminMengisiTanah() {
        WebElement dropdown = driver.findElement(By.id("status_tanah")); // ganti dengan ID-nya
        Select select = new Select(dropdown);
        select.selectByVisibleText("Disewakan");
    }

    @And("Super Admin memasukkan luas tanah \"500\"")
    public void SuperAdminMengisiLuas() {
        WebElement inputNamaAset = driver.findElement(By.id("luas_tanah"));
        inputNamaAset.sendKeys(Integer.toString(500));
    }

    @And("Super Admin mengklik titik pada peta")
    public void SuperAdminMengisiPeta() {
        WebElement peta = driver.findElement(By.className("leaflet-draw-draw-polygon")); // atau class dari div peta
        Actions actions = new Actions(driver);

        actions.moveToElement(peta, 100, 100).click().perform();
        actions.moveToElement(peta, 150, 150).click().perform();
        actions.moveToElement(peta, 200, 100).click().perform();
        actions.moveToElement(peta, 100, 100).click().perform();
    }

    @When("Super Admin mengklik tombol Add")
    public void SuperAdminMengklikAdd() {
        tambahTanahPage.clickButton(tambahTanahPage.tombolAdd);
    }

    @Then("sistem menampilkan message {string}")
    public void TampilkanPesanMessage() {
    }
}
