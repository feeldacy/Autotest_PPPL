package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import test.EditTanahPage;
import test.KelolaTanahPage;
import test.NavbarComponents;

public class editTanahStepDef extends baseUtil{
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);
    KelolaTanahPage kelolaTanahPage = new KelolaTanahPage(baseUtil.driver);
    EditTanahPage editTanahPage = new EditTanahPage(baseUtil.driver);

    @Given("Super Admin sudah login dan berada di halaman Kelola Tanah")
    public void super_telah_masuk_ke_sistem(){
        loginStep();
        navbarComponents.clickButton(navbarComponents.kelolaTanahMenu);
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/ManageGround", kelolaTanahPage.getCurrentUrl());
    }


    @When("Super Admin menekan tombol edit pada data tanah yang dipilih")
    public void superAdminMenekanTombolEditPadaDataTanahYangDipilih() {
        kelolaTanahPage.clickButton(kelolaTanahPage.tombolEdit);
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/EditGround/DT-00002", editTanahPage.getCurrentUrl());
    }

    @And("Super Admin mengisi form edit dengan data baru {string}")
    public void superAdminMengisiFormEditDenganDataBaru(String nama_tanah) {
        editTanahPage.kirimData(editTanahPage.fieldNamaTanah, nama_tanah);
    }

    @And("Super Admin menekan tombol Perbarui")
    public void superAdminMenekanTombolPerbarui() {
        editTanahPage.clickButton(editTanahPage.tombolPerbarui);
    }

    @Then("Sistem menampilkan pesan Data tanah berhasil diperbarui")
    public void sistemMenampilkanPesanDataTanahBerhasilDiperbarui() {
        //
    }

    @And("Data tanah ditampilkan dengan informasi terbaru di halaman Kelola Tanah")
    public void dataTanahDitampilkanDenganInformasiTerbaruDiHalamanKelolaTanah() {
        //
    }

    @And("Super Admin mengisi form edit dengan data baru {string} dan {string}")
    public void superAdminMengisiFormEditDenganDataBaruDan(String nama_tanah, String luas_tanah) {
        editTanahPage.kirimData(editTanahPage.fieldNamaTanah, nama_tanah);
        editTanahPage.kirimData(editTanahPage.fieldLuasTanah, luas_tanah);
    }

    @Then("Sistem menampilkan pesan error gagal memperbarui data tanah")
    public void sistemMenampilkanPesanErrorGagalMemperbaruiDataTanah() {
        //
    }
}
