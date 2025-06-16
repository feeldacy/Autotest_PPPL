Feature: Edit Data Tanah

  As a Super Admin
  I want to mengedit data tanah
  So that informasi yang ditampilkan dapat diperbarui sesuai kondisi terbaru

  Background:
    Given Super Admin sudah login dan berada di halaman Kelola Tanah

  Scenario Outline: TC-05 - Edit data tanah dengan informasi valid
    When Super Admin menekan tombol edit pada data tanah yang dipilih
    And Super Admin mengisi form edit dengan data baru "<nama_tanah>"
    And Super Admin menekan tombol Perbarui
    Then Sistem menampilkan pesan Data tanah berhasil diperbarui
    And Data tanah ditampilkan dengan informasi terbaru di halaman Kelola Tanah

    Examples:
      | nama_tanah    |
      | Tanah Edit    |
      | Tanah Baru 01 |

  Scenario Outline: TC-06 - Edit data tanah dengan data tidak valid
    When Super Admin menekan tombol edit pada data tanah yang dipilih
    And Super Admin mengisi form edit dengan data baru "<nama_tanah_salah>" dan "<luas_tanah_salah>"
    And Super Admin menekan tombol Perbarui
    Then Sistem menampilkan pesan error gagal memperbarui data tanah

    Examples:
      | nama_tanah_salah | luas_tanah_salah     |
      | Tanah Salah      | Lima ratus           |
