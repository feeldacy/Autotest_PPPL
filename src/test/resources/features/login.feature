Feature: Login
    As a Super Admin
    I want to log into the system
    So that I can mengakses dashboard sesuai role

    Scenario Outline: Successful login with valid credentials
        Given Super Admin memiliki akun dengan email "<email>" dan password "<password>"
        When Super Admin membuka halaman login
        And Super Admin memasukkan email "<email>" dan password "<password>"
        And Super Admin menekan tombol Masuk
        Then Super Admin berhasil diarahkan ke dashboard sesuai role

        Examples:
            | email                   | password   |
            | testingSuperA@gmail.com | jajaSAdmin |