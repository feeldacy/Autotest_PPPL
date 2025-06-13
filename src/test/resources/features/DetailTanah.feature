Feature: Lihat Detail Data Tanah

  As a Super Admin
  I want to melihat informasi lengkap dari data tanah
  So that saya dapat memverifikasi detail data yang tersimpan

  Background:
    Given Super Admin sudah login

  Scenario: TC-09 - Melihat detail data tanah yang tersedia
    When Super Admin menekan tombol Kelola Tanah
    And Super Admin berada di halaman Kelola Tanah
    And Super Admin menekan tombol detail untuk melihat detail informasi tanah
    Then Sistem menampilkan informasi lengkap dari tanah tersebut
    And Data ditampilkan dengan benar sesuai ID "T002"