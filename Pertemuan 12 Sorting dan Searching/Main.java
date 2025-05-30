// Main.java
// Class utama untuk menjalankan program manajemen tim futsal

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PROGRAM MANAJEMEN TIM FUTSAL ===");
        System.out.println("Implementasi Collection Sorting dan Searching");
        System.out.println("============================================");
        
        // Inisialisasi komponen program
        TeamDataManager dataManager = new TeamDataManager();
        SortingOperations sortingOps = new SortingOperations(dataManager);
        SearchOperations searchOps = new SearchOperations(dataManager);
        
        // Tampilkan data awal
        System.out.println("\n1. MENAMPILKAN DATA AWAL");
        dataManager.displayAllTeams();
        
        // ===== BAGIAN 1: SORTING DAN OPERASI COLLECTION =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("BAGIAN 1: SORTING DAN OPERASI COLLECTION");
        System.out.println("=".repeat(60));
        
        // 1a. Sorting berdasarkan tinggi badan
        System.out.println("\n1a. SORTING BERDASARKAN TINGGI BADAN");
        sortingOps.sortByHeight();
        
        // 1b. Sorting berdasarkan berat badan  
        System.out.println("\n1b. SORTING BERDASARKAN BERAT BADAN");
        sortingOps.sortByWeight();
        
        // 1c. Nilai min dan max
        System.out.println("\n1c. NILAI MIN DAN MAX TINGGI BADAN & BERAT BADAN");
        sortingOps.findMinMaxValues();
        
        // Demonstrasi fitur tambahan (copy Tim B ke Tim C, sorting per tim, dll)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("DEMONSTRASI FITUR TAMBAHAN");
        System.out.println("=".repeat(60));
        
        // Copy Tim B -> Tim C
        System.out.println("\nMenyalin Tim B ke Tim C...");
        dataManager.copyTeamBToTeamC();
        dataManager.displayTeam("Tim C");
        
        // Contoh sorting satu tim: Tim A berdasarkan tinggi (descending)
        System.out.println("\nContoh sorting Tim A berdasarkan tinggi (descending):");
        sortingOps.sortSingleTeam("Tim A", "height", false);
        
        // Tampilkan ukuran tim
        dataManager.displayTeamSizes();
        
        // ===== BAGIAN 2: BINARY SEARCH PADA ARRAYLIST =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("BAGIAN 2: BINARY SEARCH PADA ARRAYLIST");
        System.out.println("=".repeat(60));
        
        // 2a. Tampilkan jumlah pemain per tim
        System.out.println("2a. Jumlah pemain per tim:");
        System.out.println("    Tim A: " + dataManager.getTeamA().size() + " pemain");
        System.out.println("    Tim B: " + dataManager.getTeamB().size() + " pemain");
        
        // 2b. Cari tinggi 168cm dan 160cm di Tim B
        searchOps.searchHeightInTeamB();
        
        // 2c. Cari berat 56kg dan 53kg di Tim A
        searchOps.searchWeightInTeamA();
        
        // 2d. Cek apakah ada pemain di Tim A yang tingginya 168cm
        int cekHeight = 168;
        boolean ada168 = searchOps.existsHeightInTeamA(cekHeight);
        System.out.printf("\n2d. Apakah ada pemain di Tim A dengan tinggi %d cm? %s%n",
                          cekHeight, (ada168 ? "Ada" : "Tidak ada"));
    }
}
