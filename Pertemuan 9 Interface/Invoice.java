// Class Invoice merepresentasikan belanjaan yang dilakukan oleh karyawan
public class Invoice implements Payable {
    private String productName;      // Nama produk yang dibeli
    private int quantity;            // Jumlah produk yang dibeli
    private int pricePerItem;        // Harga per item produk

    // Constructor untuk menginisialisasi data invoice
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // Implementasi method dari interface Payable
    // Menghitung total harga = jumlah x harga per item
    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    // Getter untuk masing-masing atribut
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }
}
