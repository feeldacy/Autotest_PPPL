Feature: Menambah Admin

  As a Super Admin
  I want to be able to add a new admin
  So that I can delegate tasks and help manage the system

  Background:
    Given Super Admin sudah login ke dalam sistem

  Scenario: Super Admin berhasil menambahkan admin baru
    When Super Admin navigasi ke menu kelola admin
    And Super Admin mengklik tombol "Tambah Admin"
    And Super Admin mengisi form dengan data valid
    And Super Admin mengklik tombol "Tambah"
    Then Sistem menyimpan admin baru
    And Admin baru muncul di daftar admin
