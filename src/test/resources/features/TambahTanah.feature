Feature: Tambah tanah yang dilakukan oleh Super Admin

  Scenario: Berhasil Menambahkan tanah yang dilakukan oleh Super Admin
    Given Login
    When Admin navigasi menu kelola Tanah
    And Super Admin menekan tombol "Tambah Tanah"
    And Super Admin memasukkan nama asset "asetCoba"
    And Super Admin memasukkan Detail alamat "Jl Vokasi jaya"
    And Super Admin memasukkan RT "12"
    And Super Admin memasukkan RW "14"
    And Super Admin memilih padukuhan "Palemsari"
    And Super Admin memilih status kepemilikan "Milik Pemerintah"
    And Super Admin memilih status tanah "Disewakan"
    And Super Admin memasukkan luas tanah "500"
    And Super Admin mengklik titik pada peta
    When Super Admin mengklik tombol Add
    Then sistem menampilkan message "Data tanah berhasil ditambahkan"