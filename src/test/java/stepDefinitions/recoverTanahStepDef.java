package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import test.KelolaTanahPage;
import test.NavbarComponents;
import test.RestoreTanahPage;

public class recoverTanahStepDef extends baseUtil {

    RestoreTanahPage restoreTanahPage = new RestoreTanahPage(baseUtil.driver);
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);
    KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);

    @Given("Super Admin sudah login ke dalam sistem - Restore Tanah")
    public void superAdminSudahLoginKeSistem(){
        loginStep();
    }

    @When("Super Admin membuka halaman Kelola Tanah")
    public void superAdminMembukaHalamanKelolaTanah() {
        navbarComponents.clickButton(navbarComponents.kelolaTanahMenu);
        String currentUrl = kelolaTanahPage.getCurrentUrl();
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/ManageGround", currentUrl);
    }

    @And("Super Admin mengklik tombol Pulihkan Data")
    public void superAdminMengklikTombolPulihkanData() {
        kelolaTanahPage.clickButton(kelolaTanahPage.tombolRecoverData);
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/restore-data", restoreTanahPage.getCurrentUrl());
    }

    @And("Super Admin menekan tombol aksi reload")
    public void superAdminMenekanTombolAksi() {
        restoreTanahPage.clickButton(restoreTanahPage.tombolRestore);
        Assertions.assertEquals("Konfirmasi Pemulihan Data", restoreTanahPage.getText(restoreTanahPage.titleModal));
    }

    @And("Super Admin mengonfirmasi dengan menekan tombol Pulihkan Data")
    public void superAdminMengonfirmasiDenganMenekanTombolPulihkanData() {
        restoreTanahPage.clickButton(restoreTanahPage.tombolPulihkan);

        baseUtil.driver.navigate().refresh();
    }

    @Then("Data tanah yang sebelumnya dihapus berhasil dipulihkan")
    public void dataTanahYangSebelumnyaDihapusBerhasilDipulihkan() {
        String toastMsg = restoreTanahPage.getText(restoreTanahPage.toastMessageSuccess);

        Assertions.assertEquals("Data berhasil, dipulihkan!", toastMsg);
    }

    @And("Data tersebut kembali tampil di daftar pada halaman Kelola Tanah")
    public void dataTersebutKembaliTampilDiDaftarPadaHalamanKelolaTanah() {
        restoreTanahPage.clickButton(restoreTanahPage.tombolKembali);
        // verification
    }
}
