package uap.models;

import uap.bases.Shape;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;
import uap.interfaces.ThreeDimensional;  

public class Sphere extends Shape
        implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {

    private double radius; // r (cm)

    public Sphere() {
        super();
        this.radius = 0;
    }

    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        // V = (4/3) * π * r^3
        return (4.0 / 3.0) * PI * radius * radius * radius;
    }

    @Override
    public double getSurfaceArea() {
        // A = 4 * π * r^2
        return 4 * PI * radius * radius;
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
