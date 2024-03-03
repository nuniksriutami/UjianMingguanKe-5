Feature: Add to Cart Feature
  # 1
  Scenario: User dapat berhasil login dengan menggunakan kredensial yang benar
    Given User mengakses login page
    When User memasukan username yang benar
    And User memasukan password yang benar
    And User klik button login
    Then User berhasil login dan diarahkan ke page utama atau dashboard
  # 2
  Scenario: User menambahkan product ke dalam cart
    Given User berada di home page
    When User menambahkan specific product kedalam keranjang
    Then Keranjang harus menampilkan product yang benar