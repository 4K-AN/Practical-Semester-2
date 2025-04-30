// Interface Payable digunakan untuk menyatakan bahwa suatu objek memiliki nilai yang bisa dibayar
public interface Payable {
    // Method ini akan diimplementasikan oleh setiap class yang mewakili item yang harus dibayar
    double getPayableAmount();
}
