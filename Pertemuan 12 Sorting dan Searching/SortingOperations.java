// SortingOperations.java
// Class untuk menangani operasi sorting dan pencarian min/max

import java.util.ArrayList;
import java.util.Collections;

public class SortingOperations {
    private TeamDataManager dataManager;
    
    public SortingOperations(TeamDataManager dataManager) {
        this.dataManager = dataManager;
    }
    
    // 1a. Sorting berdasarkan tinggi badan
    public void sortByHeight() {
        System.out.println("\n=== SORTING BERDASARKAN TINGGI BADAN ===");
        
        // Gabungkan kedua tim
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(dataManager.getTeamA());
        allPlayers.addAll(dataManager.getTeamB());
        
        // Ascending
        Collections.sort(allPlayers, new HeightComparator(true));
        System.out.println("\n--- Tinggi Badan (Ascending) ---");
        displayPlayerList(allPlayers);
        
        // Descending
        Collections.sort(allPlayers, new HeightComparator(false));
        System.out.println("\n--- Tinggi Badan (Descending) ---");
        displayPlayerList(allPlayers);
    }
    
    // 1b. Sorting berdasarkan berat badan
    public void sortByWeight() {
        System.out.println("\n=== SORTING BERDASARKAN BERAT BADAN ===");
        
        // Gabungkan kedua tim
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(dataManager.getTeamA());
        allPlayers.addAll(dataManager.getTeamB());
        
        // Ascending
        Collections.sort(allPlayers, new WeightComparator(true));
        System.out.println("\n--- Berat Badan (Ascending) ---");
        displayPlayerList(allPlayers);
        
        // Descending
        Collections.sort(allPlayers, new WeightComparator(false));
        System.out.println("\n--- Berat Badan (Descending) ---");
        displayPlayerList(allPlayers);
    }
    
    // 1c. Cari nilai max dan min tinggi badan dan berat badan
    public void findMinMaxValues() {
        System.out.println("\n=== NILAI MAKSIMUM DAN MINIMUM ===");
        
        ArrayList<Player> teamA = dataManager.getTeamA();
        ArrayList<Player> teamB = dataManager.getTeamB();
        
        // Tim A
        System.out.println("\n--- Tim A ---");
        findMinMaxForTeam(teamA, "Tim A");
        
        // Tim B
        System.out.println("\n--- Tim B ---");
        findMinMaxForTeam(teamB, "Tim B");
        
        // Gabungan kedua tim
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(teamA);
        allPlayers.addAll(teamB);
        System.out.println("\n--- Gabungan Tim A & B ---");
        findMinMaxForTeam(allPlayers, "Gabungan");
    }
    
    // Helper method untuk mencari min/max satu tim
    private void findMinMaxForTeam(ArrayList<Player> team, String teamName) {
        if (team.isEmpty()) {
            System.out.println(teamName + " kosong");
            return;
        }
        
        // Cari min/max tinggi badan
        Player minHeightPlayer = Collections.min(team, new HeightComparator(true));
        Player maxHeightPlayer = Collections.max(team, new HeightComparator(true));
        
        // Cari min/max berat badan
        Player minWeightPlayer = Collections.min(team, new WeightComparator(true));
        Player maxWeightPlayer = Collections.max(team, new WeightComparator(true));
        
        System.out.println("Tinggi Badan:");
        System.out.println("  Min: " + minHeightPlayer.getHeight() + "cm (Player " + 
                          minHeightPlayer.getPlayerNumber() + " - " + minHeightPlayer.getTeam() + ")");
        System.out.println("  Max: " + maxHeightPlayer.getHeight() + "cm (Player " + 
                          maxHeightPlayer.getPlayerNumber() + " - " + maxHeightPlayer.getTeam() + ")");
        
        System.out.println("Berat Badan:");
        System.out.println("  Min: " + minWeightPlayer.getWeight() + "kg (Player " + 
                          minWeightPlayer.getPlayerNumber() + " - " + minWeightPlayer.getTeam() + ")");
        System.out.println("  Max: " + maxWeightPlayer.getWeight() + "kg (Player " + 
                          maxWeightPlayer.getPlayerNumber() + " - " + maxWeightPlayer.getTeam() + ")");
    }
    
    // Helper method untuk menampilkan daftar pemain
    private void displayPlayerList(ArrayList<Player> players) {
        for (Player p : players) {
            System.out.println(p);
        }
    }
    
    // Method tambahan: sorting hanya satu tim
    public void sortSingleTeam(String teamName, String criteria, boolean ascending) {
        ArrayList<Player> team;
        
        switch (teamName.toUpperCase()) {
            case "TIM A":
            case "A":
                team = dataManager.getTeamA();
                break;
            case "TIM B":
            case "B":
                team = dataManager.getTeamB();
                break;
            case "TIM C":
            case "C":
                team = dataManager.getTeamC();
                break;
            default:
                System.out.println("Tim tidak ditemukan: " + teamName);
                return;
        }
        
        System.out.println("\n--- Sorting " + teamName + " berdasarkan " + criteria + 
                          (ascending ? " (Ascending)" : " (Descending)") + " ---");
        
        if (criteria.equalsIgnoreCase("height") || criteria.equalsIgnoreCase("tinggi")) {
            Collections.sort(team, new HeightComparator(ascending));
        } else if (criteria.equalsIgnoreCase("weight") || criteria.equalsIgnoreCase("berat")) {
            Collections.sort(team, new WeightComparator(ascending));
        } else {
            System.out.println("Kriteria tidak valid. Gunakan 'height' atau 'weight'");
            return;
        }
        
        displayPlayerList(team);
    }
}