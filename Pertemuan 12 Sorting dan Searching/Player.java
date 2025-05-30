// Player.java
// Class untuk merepresentasikan data pemain futsal

public class Player {
    private int height; // tinggi badan (cm)
    private int weight; // berat badan (kg)
    private String team; // nama tim
    private int playerNumber; // nomor pemain
    
    // Constructor
    public Player(int playerNumber, int height, int weight, String team) {
        this.playerNumber = playerNumber;
        this.height = height;
        this.weight = weight;
        this.team = team;
    }
    
    // Getter methods
    public int getHeight() { 
        return height; 
    }
    
    public int getWeight() { 
        return weight; 
    }
    
    public String getTeam() { 
        return team; 
    }
    
    public int getPlayerNumber() { 
        return playerNumber; 
    }
    
    // Setter methods
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public void setTeam(String team) { 
        this.team = team; 
    }
    
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    
    // Override toString untuk display yang mudah dibaca
    @Override
    public String toString() {
        return String.format("Player %d (%s): Height=%dcm, Weight=%dkg", 
                           playerNumber, team, height, weight);
    }
    
    // Method untuk membuat copy player dengan tim berbeda
    public Player copyToTeam(String newTeam) {
        return new Player(this.playerNumber, this.height, this.weight, newTeam);
    }
    
    // Method untuk membandingkan kesamaan data (tanpa mempertimbangkan tim dan nomor)
    public boolean hasSamePhysicalData(Player other) {
        return this.height == other.height && this.weight == other.weight;
    }
}