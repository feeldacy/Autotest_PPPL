Feature: Memulihkan Data Tanah yang Dihapus (Soft Delete)

  As a Super Admin
  I want to restore deleted land data
  So that I can recover data that was previously soft-deleted

  Background:
    Given Super Admin sudah login ke dalam sistem - Restore Tanah

  Scenario: Memulihkan data tanah yang telah dihapus
    When Super Admin membuka halaman Kelola Tanah
    And Super Admin mengklik tombol Pulihkan Data
    And Super Admin menekan tombol aksi reload
    And Super Admin mengonfirmasi dengan menekan tombol Pulihkan Data
    Then Data tanah yang sebelumnya dihapus berhasil dipulihkan
    And Data tersebut kembali tampil di daftar pada halaman Kelola Tanah
