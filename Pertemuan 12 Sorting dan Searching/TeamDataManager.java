// TeamDataManager.java
// Class untuk mengelola data tim dan operasi dasar

import java.util.ArrayList;

public class TeamDataManager {
    private ArrayList<Player> teamA;
    private ArrayList<Player> teamB;
    private ArrayList<Player> teamC;
    
    public TeamDataManager() {
        initializeTeams();
    }
    
    // Inisialisasi data tim berdasarkan data yang diberikan
    private void initializeTeams() {
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();
        teamC = new ArrayList<>();
        
        // Data Tim A: {tinggi, berat}
        int[][] dataTimA = {
            {168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60},
            {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}
        };
        
        // Data Tim B: {tinggi, berat}
        int[][] dataTimB = {
            {170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58},
            {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}
        };
        
        // Populate Tim A
        for (int i = 0; i < dataTimA.length; i++) {
            teamA.add(new Player(i + 1, dataTimA[i][0], dataTimA[i][1], "Tim A"));
        }
        
        // Populate Tim B
        for (int i = 0; i < dataTimB.length; i++) {
            teamB.add(new Player(i + 1, dataTimB[i][0], dataTimB[i][1], "Tim B"));
        }
    }
    
    // Getter methods untuk mengakses data tim
    public ArrayList<Player> getTeamA() {
        return new ArrayList<>(teamA); // Return copy untuk keamanan
    }
    
    public ArrayList<Player> getTeamB() {
        return new ArrayList<>(teamB); // Return copy untuk keamanan
    }
    
    public ArrayList<Player> getTeamC() {
        return new ArrayList<>(teamC); // Return copy untuk keamanan
    }
    
    // Method untuk copy Tim B ke Tim C
    public void copyTeamBToTeamC() {
        teamC.clear(); // Clear existing data
        for (Player player : teamB) {
            teamC.add(player.copyToTeam("Tim C"));
        }
    }
    
    // Method untuk menampilkan data tim
    public void displayTeam(String teamName) {
        ArrayList<Player> team;
        
        switch (teamName.toUpperCase()) {
            case "TIM A":
            case "A":
                team = teamA;
                break;
            case "TIM B":
            case "B":
                team = teamB;
                break;
            case "TIM C":
            case "C":
                team = teamC;
                break;
            default:
                System.out.println("Tim tidak ditemukan: " + teamName);
                return;
        }
        
        System.out.println("\n--- " + teamName + " ---");
        if (team.isEmpty()) {
            System.out.println("Tim kosong");
        } else {
            for (Player p : team) {
                System.out.println(p);
            }
        }
    }
    
    // Method untuk menampilkan semua tim
    public void displayAllTeams() {
        System.out.println("=== DATA TIM FUTSAL ===");
        displayTeam("Tim A");
        displayTeam("Tim B");
        if (!teamC.isEmpty()) {
            displayTeam("Tim C");
        }
    }
    
    // Method untuk mendapatkan gabungan semua pemain
    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(teamA);
        allPlayers.addAll(teamB);
        if (!teamC.isEmpty()) {
            allPlayers.addAll(teamC);
        }
        return allPlayers;
    }
    
    // Method untuk mendapatkan jumlah pemain per tim
    public void displayTeamSizes() {
        System.out.println("\n=== JUMLAH PEMAIN ===");
        System.out.println("Tim A: " + teamA.size() + " pemain");
        System.out.println("Tim B: " + teamB.size() + " pemain");
        System.out.println("Tim C: " + teamC.size() + " pemain");
    }
}