package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import test.KelolaAdminPage;
import test.NavbarComponents;

public class tambahAdminStepDefNegative extends baseUtil {
    KelolaAdminPage kelolaAdminPage = new KelolaAdminPage(baseUtil.driver);
    NavbarComponents navbarComponents = new NavbarComponents(baseUtil.driver);

    @Given("Super Admin telah masuk ke dalam sistem")
    public void superAdminTelahMasukKeDalamSistem() {
        loginStep(); // asumsi ini adalah method yang login sebagai super admin
    }

    @And("Super Admin berada di halaman Kelola Admin")
    public void superAdminBeradaDiHalamanKelolaAdmin() {
        navbarComponents.clickButton(navbarComponents.kelolaAdminMenu);
        Assertions.assertEquals("https://digitalmap-umbulharjo.madanateknologi.web.id/admin", kelolaAdminPage.getCurrentUrl());
    }

    @When("Super Admin menekan tombol \"Tambah Admin\"")
    public void superAdminMenekanTombolTambahAdmin() {
        kelolaAdminPage.clickButton(kelolaAdminPage.tambahAdminBtn);
        Assertions.assertTrue(kelolaAdminPage.isTxtTambahAdminVisible());
    }

    @And("Super Admin memasukkan nama {string}")
    public void superAdminMemasukkanNama(String nama) {
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldName, nama);
    }

    @And("Super Admin memasukkan email {string}")
    public void superAdminMemasukkanEmail(String email) {
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldEmail, email);
    }

    @And("Super Admin memasukkan password {string}")
    public void superAdminMemasukkanPassword(String password) {
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldPass, password);
    }

    @And("Super Admin memasukkan konfirmasi password {string}")
    public void superAdminMemasukkanKonfirmasiPassword(String konfirmasiPassword) {
        kelolaAdminPage.kirimData(kelolaAdminPage.fieldConfirmPass, konfirmasiPassword);
    }

    @And("Super Admin mengklik tombol Tambah")
    public void superAdminMengklikTombolTambah() {
        kelolaAdminPage.clickButton(kelolaAdminPage.tombolTambah);
    }

    @Then("sistem menampilkan pesan error {string}")
    public void sistemMenampilkanPesanError(String expectedError) {
        Assertions.assertTrue(kelolaAdminPage.isPesanErrorMenambahkanAdminVisible(),
                "Toast error tidak muncul");

        String actualToast = kelolaAdminPage.getText(kelolaAdminPage.toastMessage);
        Assertions.assertTrue(actualToast.contains(expectedError),
                "Pesan error tidak sesuai. Ditemukan: " + actualToast);
    }

    @And("admin baru tidak ditambahkan ke dalam sistem")
    public void adminBaruTidakDitambahkanKeDalamSistem() {
        Assertions.assertFalse(kelolaAdminPage.isAdminEmailExist("rahmat@example.com"),
                "Email tetap muncul meskipun gagal menambahkan admin");
    }
}
