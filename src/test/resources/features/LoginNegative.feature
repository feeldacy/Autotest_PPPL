Feature: Validasi message password untuk login oleh Super Admin
  As a Super Admin
  I want to see proper error messages
  So that I know when my password is incorrect

  Scenario Outline: TC-02 - Login dengan password yang tidak valid
    Given Super Admin memiliki akun dengan berisi email "<email>" dan password "<password>"
    When Super Admin membuka halaman login user
    And Super Admin memasukkan data email "<email>" dan password "<password>"
    When Super Admin menekan button Masuk
    Then Sistem menampilkan error "Password salah, mohon masukkan password yang sesuai"

    Examples:
      | email                   | password  |
      | testingSuperA@gmail.com | jajaSAdmi |