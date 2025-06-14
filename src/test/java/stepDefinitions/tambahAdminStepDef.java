package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.testng.asserts.Assertion;
import test.KelolaAdminPage;
import test.KelolaTanahPage;
import test.NavbarComponents;

public class tambahAdminStepDef extends baseUtil{
    KelolaAdminPage kelolaAdminPage = new KelolaAdminPage(baseUtil.driver);
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);

    String generatedEmail;

    @Given("Super Admin sudah login ke dalam sistem")
    public void superAdminSudahLogin(){
        loginStep();
    }

    @When("Super Admin navigasi ke menu kelola admin")
    public void superAdminNavigasiKeMenuKelolaAdmin() {
        navbarComponents.clickButton(navbarComponents.kelolaAdminMenu);

        String currentUrl = kelolaAdminPage.getCurrentUrl();
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/admin", currentUrl);
    }

    @And("Super Admin mengklik tombol {string}")
    public void superAdminMengklikTombol(String arg0) {
        kelolaAdminPage.clickButton(kelolaAdminPage.tambahAdminBtn);
        Assertions.assertTrue(kelolaAdminPage.isTxtTambahAdminVisible());
    }

    @And("Super Admin mengisi form dengan data valid")
    public void superAdminMengisiFormDenganDataValid() {
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldName, "TestPPPL2");
        generatedEmail = "TestPPPL" + System.currentTimeMillis() + "@gmail.com";
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldEmail, generatedEmail);
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldPass, "admin123");
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldConfirmPass, "admin123");
        kelolaAdminPage.clickButton(kelolaAdminPage.tombolTambah);
    }

    @Then("Sistem menyimpan admin baru")
    public void sistemMenyimpanAdminBaru() {

    }

    @And("Admin baru muncul di daftar admin")
    public void adminBaruMunculDiDaftarAdmin() {
        Assertions.assertTrue(kelolaAdminPage.isAdminEmailExist(generatedEmail),
                "Email admin tidak ditemukan di daftar admin.");
    }
}
