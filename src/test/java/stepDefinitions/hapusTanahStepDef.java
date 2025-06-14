package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import test.KelolaTanahPage;
import test.NavbarComponents;

public class hapusTanahStepDef extends baseUtil{

    KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);

    @Given("Super Admin sudah login dan berada di halaman Kelola Tanah")
    public void super_admin_sudah_login(){

        loginStep();
        navbarComponents.clickButton(navbarComponents.kelolaTanahMenu);
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/ManageGround", kelolaTanahPage.getCurrentUrl());
    }

    @When("Super Admin memilih data tanah dengan nama asset {string} dan menekan tombol {string}")
    public void super_admin_memilih_data_tanah_dengan_nama_asset_dan_menekan_tombol(String namaAsset, String tombol) {
        kelolaTanahPage.hapusDataTanahBerdasarkanNama(namaAsset);
    }



    @And("Sistem menampilkan pop-up konfirmasi penghapusan")
    public void sistem_menampilkan_pop_up_konfirmasi_penghapusan() {
        Assertions.assertTrue(kelolaTanahPage.isTxtKonfirmasiHapusnVisible());
    }

    @Then("Super Admin menekan tombol {string} pada konfirmasi")
    public void super_admin_menekan_tombol_hapus_pada_konfirmasi(String tombol) {
        kelolaTanahPage.clickButton(kelolaTanahPage.tombolDeleteModal);
    }

    @And("Data tanah dengan nama asset {string} tidak lagi muncul di daftar tanah")
    public void data_tanah_tidak_lagi_muncul(String namaAsset) {
        Assertions.assertTrue(kelolaTanahPage.isDataTanahDenganNamaTidakTampil(namaAsset));
    }

}
