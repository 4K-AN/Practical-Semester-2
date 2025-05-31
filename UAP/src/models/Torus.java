package uap.models;

import uap.bases.Shape;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;
import uap.interfaces.ThreeDimensional; 

public class Torus extends Shape
        implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {

    private double majorRadius; // R (cm)
    private double minorRadius; // r (cm)

    public Torus() {
        super();
        this.majorRadius = 0;
        this.minorRadius = 0;
    }

    public Torus(double majorRadius, double minorRadius) {
        super();
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() {
        // V = 2 * π^2 * R * r^2
        return 2 * PI * PI * majorRadius * minorRadius * minorRadius;
    }

    @Override
    public double getSurfaceArea() {
        // A = 4 * π^2 * R * r
        return 4 * PI * PI * majorRadius * minorRadius;
    }

    @Override
    public double getMass() {
        // m = density * surfaceArea * thickness
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }

    @Override
    public double calculateCost() {
        double massKg = gramToKilogram();
        int kgRounded = (int) Math.ceil(massKg);
        return kgRounded * PRICE_PER_KG;
    }

    @Override
    public void printinfo() {
        double volume = getVolume();
        double surfaceArea = getSurfaceArea();
        double massGram = getMass();
        double massKg = gramToKilogram();
        double biaya = calculateCost();

        System.out.println("=============================================");
        System.out.printf("Volume : %.2f%n", volume);
        System.out.printf("Luas permukaan : %.2f%n", surfaceArea);
        System.out.printf("Massa : %.2f%n", massGram);
        System.out.printf("Massa dalam kg : %.2f%n", massKg);
        System.out.printf("Biaya kirim : Rp%.0f%n", biaya);
        System.out.println("=============================================");
    }
}
