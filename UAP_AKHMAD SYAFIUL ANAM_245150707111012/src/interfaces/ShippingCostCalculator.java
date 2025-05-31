package uap.interfaces;

public interface ShippingCostCalculator {
    int PRICE_PER_KG = 2000; // biaya kirim per kg

    double calculateCost();
}
