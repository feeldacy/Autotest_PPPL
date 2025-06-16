Feature: Logout
  As a Super Admin
  I want to securely log out from the system
  So that my session is properly terminated

  Scenario: TC-01 - Logout dengan User role SuperAdmin
    Given Super Admin login ke sistem
    And Super Admin navigasi ke profile avatar
    When Super Admin menekan tombol logout
    Then Super Admin melihat message "Logout successful"