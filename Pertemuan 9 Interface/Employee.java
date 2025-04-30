// Class Employee merepresentasikan seorang karyawan
// Class ini juga mengimplementasikan interface Payable
public class Employee implements Payable {
    private int registrationNumber;    // Nomor registrasi karyawan
    private String name;               // Nama karyawan
    private int salaryPerMonth;        // Gaji bulanan
    private Invoice[] invoices;        // Daftar belanjaan (hutang) di koperasi

    // Constructor untuk menginisialisasi data karyawan dan daftar invoice
    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    // Mengembalikan gaji sebelum dipotong (sesuai kontrak interface Payable)
    @Override
    public double getPayableAmount() {
        return salaryPerMonth;
    }

    // Menghitung total nilai semua belanjaan (invoice) karyawan
    public double getTotalInvoices() {
        double total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getPayableAmount();
        }
        return total;
    }

    // Menghitung gaji akhir setelah dikurangi total hutang belanjaan
    public double getFinalSalary() {
        return getPayableAmount() - getTotalInvoices();
    }

    // Menampilkan informasi lengkap karyawan dan detail belanjaannya
    public void displayEmployeeDetails() {
        System.out.println("===== DETAIL KARYAWAN =====");
        System.out.println("Nomor Registrasi: " + registrationNumber);
        System.out.println("Nama: " + name);
        System.out.println("Gaji per Bulan: Rp" + String.format("%,d", salaryPerMonth));
        System.out.println("Total Belanjaan: Rp" + String.format("%,.0f", getTotalInvoices()));
        System.out.println("Gaji Akhir: Rp" + String.format("%,.0f", getFinalSalary()));

        System.out.println("\n===== DETAIL BELANJAAN =====");
        for (int i = 0; i < invoices.length; i++) {
            System.out.println("Belanjaan #" + (i + 1) + ":");
            System.out.println("Nama Produk: " + invoices[i].getProductName());
            System.out.println("Jumlah: " + invoices[i].getQuantity());
            System.out.println("Harga per Item: Rp" + String.format("%,d", invoices[i].getPricePerItem()));
            System.out.println("Total: Rp" + String.format("%,.0f", invoices[i].getPayableAmount()));
            System.out.println("-----------------------");
        }
    }

    // Getter methods
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public Invoice[] getInvoices() {
        return invoices;
    }
}
