Feature: Hapus Data Tanah

  As a Super Admin
  I want to menghapus data tanah yang sudah tidak relevan
  So that daftar data tanah tetap terjaga dan akurat

  Background:
    Given Super Admin sudah login dan berada di halaman Kelola Tanah

  Scenario: TC-07 - Hapus data tanah dengan nama asset tertentu
    When Super Admin memilih data tanah dengan nama asset "test1" dan menekan tombol "Hapus"
    And Sistem menampilkan pop-up konfirmasi penghapusan
    Then Super Admin menekan tombol "Hapus" pada konfirmasi
    And Data tanah dengan nama asset "test1" tidak lagi muncul di daftar tanah
