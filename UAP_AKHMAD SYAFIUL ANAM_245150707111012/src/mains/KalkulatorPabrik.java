package uap.mains;

import java.util.Scanner;
import uap.models.Torus;
import uap.models.Sphere;

public class KalkulatorPabrik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("AKHMAD SYAFIUL ANAM");
        System.out.println("245150707111012");
        System.out.println("=============================================");

        // Donat dengan lubang (Torus)
        System.out.println("Donat dengan lubang");
        System.out.println("=============================================");
        System.out.print("Isikan Radius (major) : ");
        String majorInput = scanner.nextLine().trim();
        majorInput = majorInput.replace(",", "."); 
        double majorR = Double.parseDouble(majorInput);  

        System.out.print("Isikan radius (minor) : ");
        String minorInput = scanner.nextLine().trim();
        minorInput = minorInput.replace(",", ".");
        double minorR = Double.parseDouble(minorInput);  

        Torus torus = new Torus(majorR, minorR);
        torus.setName("Donat dengan lubang");
        System.out.println("=============================================");
        torus.printinfo();

        // Donat tanpa lubang (Sphere)
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        System.out.print("Isikan radius : ");
        String rInput = scanner.nextLine().trim();
        rInput = rInput.replace(",", ".");
        double r = Double.parseDouble(rInput);           

        Sphere sphere = new Sphere(r);
        sphere.setName("Donat tanpa lubang");
        System.out.println("=============================================");
        sphere.printinfo();

        scanner.close();
    }
}
