Feature: Validasi Tambah Admin oleh Super Admin

  Scenario: Gagal menambahkan admin karena password dan konfirmasi password tidak sama
    Given Super Admin telah masuk ke dalam sistem
    And Super Admin berada di halaman Kelola Admin
    When Super Admin menekan tombol "Tambah Admin"
    And Super Admin memasukkan nama "Rahmat Nur"
    And Super Admin memasukkan email "rahmat@example.com"
    And Super Admin memasukkan password "password123"
    And Super Admin memasukkan konfirmasi password "password321"
    And Super Admin mengklik tombol Tambah
    Then sistem menampilkan pesan error "Password yang dimasukkan tidak cocok✖"
    And admin baru tidak ditambahkan ke dalam sistem
