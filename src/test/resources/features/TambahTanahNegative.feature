Feature: Gagal menambahkan tanah yang dilakukan oleh Super Admin

  Scenario: Gagal Menambahkan tanah yang dilakukan oleh Super Admin karena kolom RT kosong
    Given Login Super Admin
    When Admin dinavigasikan menu kelola Tanah
    And Super Admin click tombol "Tambah Tanah"
    And Super Admin fill nama asset "asetCoba"
    And Super Admin fill Detail alamat "Jl Vokasi jaya"
    And Super Admin choose RW "14"
    And Super Admin choose padukuhan "Palemsari"
    And Super Admin choose status kepemilikan "Milik Pemerintah"
    And Super Admin choose status tanah "Disewakan"
    And Super Admin choose luas tanah "500"
    And Super Admin click titik pada peta
    When Super Admin click tombol Add
    Then sistem menampilkan error "Validasi gagal"