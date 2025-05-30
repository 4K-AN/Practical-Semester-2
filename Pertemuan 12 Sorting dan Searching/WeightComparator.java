// WeightComparator.java
// Comparator untuk sorting berdasarkan berat badan

import java.util.Comparator;

public class WeightComparator implements Comparator<Player> {
    private boolean ascending;
    
    // Constructor dengan parameter ascending/descending
    public WeightComparator(boolean ascending) {
        this.ascending = ascending;
    }
    
    // Default constructor (ascending)
    public WeightComparator() {
        this.ascending = true;
    }
    
    @Override
    public int compare(Player p1, Player p2) {
        if (ascending) {
            return Integer.compare(p1.getWeight(), p2.getWeight());
        } else {
            return Integer.compare(p2.getWeight(), p1.getWeight());
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