package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import test.NavbarComponents;
import test.KelolaTanahPage;

public class detailTanahStepDef extends baseUtil {
    @Given("Super Admin sudah login")
    public void super_admin_sudah_login_dan_berada_di_halaman_kelola_tanah(){
        loginStep();
    }

    @When("Super Admin menekan tombol Kelola Tanah")
    public void superAdminMenekanTombolKelolaTanah() {
        NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);

        navbarComponents.clickButton(navbarComponents.kelolaTanahMenu);
    }

    @And("Super Admin berada di halaman Kelola Tanah")
    public void superAdminBeradaDiHalamanKelolaTanah() {
        KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);

        Assert.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/ManageGround", kelolaTanahPage.getCurrentUrl());
    }

    @And("Super Admin menekan tombol detail untuk melihat detail informasi tanah")
    public void superAdminMenekanTombolUntukMelihatDetailInformasiTanah() {
        KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);

        kelolaTanahPage.clickButton(kelolaTanahPage.detailBtn);
    }

    @Then("Sistem menampilkan informasi lengkap dari tanah tersebut")
    public void sistemMenampilkanInformasiLengkapDariTanahTersebut() {
        KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);

        Assert.assertEquals("Detail Informasi Tanah", kelolaTanahPage.getText(kelolaTanahPage.modalDetailTitle));
    }

    @And("Data ditampilkan dengan benar sesuai ID {string}")
    public void dataDitampilkanDenganBenarSesuaiID(String arg0) {
    }
}
