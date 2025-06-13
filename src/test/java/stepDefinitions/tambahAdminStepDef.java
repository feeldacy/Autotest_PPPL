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

    @Given("Super Admin sudah login ke dalam sistem")
    public void super_admin_sudah_login(){
        loginStep();
    }


    @When("Super Admin navigasi ke menu kelola admin")
    public void superAdminNavigasiKeMenuKelolaAdmin() {
        KelolaAdminPage kelolaAdminPage = new KelolaAdminPage(baseUtil.driver);
        NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);

        navbarComponents.clickButton(navbarComponents.kelolaAdminMenu);

        String currentUrl = kelolaAdminPage.getCurrentUrl();
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/admin", currentUrl, "Halaman yang terbuka bukan halaman kelola admin");
    }

    @And("Super Admin mengklik tombol {string}")
    public void superAdminMengklikTombol(String arg0) {
        KelolaAdminPage kelolaAdminPage = new KelolaAdminPage(baseUtil.driver);
        kelolaAdminPage.clickButton(kelolaAdminPage.tambahAdminBtn);

        String sideBarTitle = kelolaAdminPage.getText(kelolaAdminPage.tamabahAdminSideBar);

        Assertions.assertEquals("Tambah Admin", sideBarTitle, "Side Bar Title tidak cocok.");
    }

    @And("Super Admin mengisi form dengan data valid")
    public void superAdminMengisiFormDenganDataValid() {
        KelolaAdminPage kelolaAdminPage = new KelolaAdminPage(baseUtil.driver);

        kelolaAdminPage.kirimData(kelolaAdminPage.fieldName, "");
    }

    @Then("Sistem menyimpan admin baru")
    public void sistemMenyimpanAdminBaru() {

    }

    @And("Admin baru muncul di daftar admin")
    public void adminBaruMunculDiDaftarAdmin() {
    }
}
