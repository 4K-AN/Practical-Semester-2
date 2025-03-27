public class TestJaket {
    public static void main(String[] args) {
        // Pengujian berbagai kasus
        System.out.println("TESTING CLASS JAKET\n");

        // Test case 1: Pembelian < 100 unit (harga normal)
        System.out.println("Test Case 1: 50 Jaket A");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("A", 50) + "\n");

        // Test case 2: Pembelian > 100 unit (diskon berlaku)
        System.out.println("Test Case 2: 150 Jaket A");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("A", 150) + "\n");

        // Test case 3: Pembelian < 100 unit (harga normal)
        System.out.println("Test Case 3: 80 Jaket B");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("B", 80) + "\n");

        // Test case 4: Pembelian > 100 unit (diskon berlaku)
        System.out.println("Test Case 4: 200 Jaket B");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("B", 200) + "\n");

        // Test case 5: Pembelian < 100 unit (harga normal)
        System.out.println("Test Case 5: 90 Jaket C");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("C", 90) + "\n");

        // Test case 6: Pembelian > 100 unit (diskon berlaku)
        System.out.println("Test Case 6: 120 Jaket C");
        System.out.println("Total Harga: Rp" + Jaket.hitungHarga("C", 120) + "\n");

        // Test case 7: Input tidak valid
        try {
            System.out.println("Test Case 7: 50 Jaket X (Invalid)");
            System.out.println("Total Harga: Rp" + Jaket.hitungHarga("X", 50) + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
