package uap.interfaces;

public interface MassCalculable {
    int DENSITY = 8;         // 8 g/cm^3 for stainless steel 304
    double THICKNESS = 0.5;  // 0.5 cm thickness

    double getMass();
}
