// HeightComparator.java
// Comparator untuk sorting berdasarkan tinggi badan

import java.util.Comparator;

public class HeightComparator implements Comparator<Player> {
    private boolean ascending;
    
    // Constructor dengan parameter ascending/descending
    public HeightComparator(boolean ascending) {
        this.ascending = ascending;
    }
    
    // Default constructor (ascending)
    public HeightComparator() {
        this.ascending = true;
    }
    
    @Override
    public int compare(Player p1, Player p2) {
        if (ascending) {
            return Integer.compare(p1.getHeight(), p2.getHeight());
        } else {
            return Integer.compare(p2.getHeight(), p1.getHeight());
        }
    }
    
    // Method untuk mengubah urutan sorting
    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
    
    public boolean isAscending() {
        return ascending;
    }
}