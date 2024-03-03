Feature: Checkout Feature
  Scenario: User sudah menambahkan product ke keranjang
    Given User mengakses halaman checkout information
    When User memasukan informasi yang salah
    Then User memasukkan informasi yang benar
    And User mengakses halaman checkout overview
    When User memeriksa product di checkout overview benar
    Then User mengakses halaman Thank You
    And User kembali ke halaman dashboard