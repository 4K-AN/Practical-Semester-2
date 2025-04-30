// Class utama untuk menjalankan program koperasi karyawan
public class KoperasiKaryawan {
    public static void main(String[] args) {
        // Membuat beberapa invoice sebagai simulasi belanjaan
        Invoice invoice1 = new Invoice("Beras 5kg", 2, 65000);
        Invoice invoice2 = new Invoice("Minyak Goreng 2L", 3, 28000);
        Invoice invoice3 = new Invoice("Gula 1kg", 5, 15000);

        // Menggabungkan invoice ke dalam array
        Invoice[] belanjaanBudi = {invoice1, invoice2, invoice3};

        // Membuat objek karyawan dengan gaji dan belanjaan
        Employee budi = new Employee(1001, "Budi Santoso", 4500000, belanjaanBudi);

        // Menampilkan detail karyawan dan belanjaan secara lengkap
        budi.displayEmployeeDetails();

        // Menampilkan semua item yang dapat dibayar (gaji & belanjaan) secara polimorfis
        System.out.println("\n===== POLIMORFISME =====");
        Payable[] payableItems = {budi, invoice1, invoice2, invoice3};

        int i = 1;
        for (Payable item : payableItems) {
            if (item instanceof Employee emp) {
                System.out.println("Payable #" + i + ": Gaji " + emp.getName() + " - Rp" + String.format("%,.0f", emp.getPayableAmount()));
            } else if (item instanceof Invoice inv) {
                System.out.println("Payable #" + i + ": Invoice " + inv.getProductName() + " - Rp" + String.format("%,.0f", inv.getPayableAmount()));
            }
            i++;
        }
    }
}
