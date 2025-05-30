// SearchOperations.java
// Class untuk menangani operasi pencarian (binary search) dan analisis data tim

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SearchOperations {
    private TeamDataManager dataManager;

    public SearchOperations(TeamDataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * 2b. Binary search untuk Tim B berdasarkan tinggi badan:
     *     - Menampilkan list tinggi badan Tim B yang sudah di-sort.
     *     - Menghitung jumlah kemunculan untuk 168 cm dan 160 cm.
     *     - Memberikan hasil binarySearch (found index / insertion point).
     */
    public void searchHeightInTeamB() {
        System.out.println("\n=== BINARY SEARCH TINGGI BADAN TIM B ===");

        ArrayList<Player> teamB = dataManager.getTeamB();

        // Buat list berisi semua nilai height Tim B lalu sort ascending
        ArrayList<Integer> heightsB = new ArrayList<>();
        for (Player p : teamB) {
            heightsB.add(p.getHeight());
        }
        Collections.sort(heightsB);

        System.out.println("Tinggi badan Tim B (sorted): " + heightsB);

        // Cari tinggi 168 cm
        searchSpecificHeight(heightsB, 168);

        // Cari tinggi 160 cm
        searchSpecificHeight(heightsB, 160);
    }

    /**
     * 2c. Binary search untuk Tim A berdasarkan berat badan:
     *     - Menampilkan list berat badan Tim A yang sudah di-sort.
     *     - Menghitung jumlah kemunculan untuk 56 kg dan 53 kg.
     *     - Memberikan hasil binarySearch (found index / insertion point).
     */
    public void searchWeightInTeamA() {
        System.out.println("\n=== BINARY SEARCH BERAT BADAN TIM A ===");

        ArrayList<Player> teamA = dataManager.getTeamA();

        // Buat list berisi semua nilai weight Tim A lalu sort ascending
        ArrayList<Integer> weightsA = new ArrayList<>();
        for (Player p : teamA) {
            weightsA.add(p.getWeight());
        }
        Collections.sort(weightsA);

        System.out.println("Berat badan Tim A (sorted): " + weightsA);

        // Cari berat 56 kg
        searchSpecificWeight(weightsA, 56);

        // Cari berat 53 kg
        searchSpecificWeight(weightsA, 53);
    }

    // Helper method untuk mencari jumlah dan posisi tinggi tertentu
    private void searchSpecificHeight(ArrayList<Integer> heights, int targetHeight) {
        int count = Collections.frequency(heights, targetHeight);
        int index = Collections.binarySearch(heights, targetHeight);

        System.out.println("\nTinggi " + targetHeight + "cm:");
        System.out.println("- Jumlah pemain: " + count);
        System.out.println("- Binary search result: " +
                (index >= 0 ? "Found at index " + index : "Not found (" + index + ")"));

        if (index >= 0) {
            System.out.println("- Penjelasan: Ditemukan di posisi indeks " + index +
                    " dalam list yang sudah terurut");
        } else {
            int insertionPoint = -(index + 1);
            System.out.println("- Penjelasan: Tidak ditemukan. Jika ingin disisipkan, " +
                    "posisinya akan berada di indeks " + insertionPoint);
        }
    }

    // Helper method untuk mencari jumlah dan posisi berat tertentu
    private void searchSpecificWeight(ArrayList<Integer> weights, int targetWeight) {
        int count = Collections.frequency(weights, targetWeight);
        int index = Collections.binarySearch(weights, targetWeight);

        System.out.println("\nBerat " + targetWeight + "kg:");
        System.out.println("- Jumlah pemain: " + count);
        System.out.println("- Binary search result: " +
                (index >= 0 ? "Found at index " + index : "Not found (" + index + ")"));

        if (index >= 0) {
            System.out.println("- Penjelasan: Ditemukan di posisi indeks " + index +
                    " dalam list yang sudah terurut");
        } else {
            int insertionPoint = -(index + 1);
            System.out.println("- Penjelasan: Tidak ditemukan. Jika ingin disisipkan, " +
                    "posisinya akan berada di indeks " + insertionPoint);
        }
    }

    /**
     * 2d. Cek apakah ada pemain di Tim A yang mempunyai tinggi = targetHeight.
     *     Mengembalikan true jika setidaknya satu pemain dengan nilai tersebut ada.
     */
    public boolean existsHeightInTeamA(int targetHeight) {
        ArrayList<Player> teamA = dataManager.getTeamA();

        // Buat list berisi semua height Tim A lalu sort ascending
        ArrayList<Integer> heightsA = new ArrayList<>();
        for (Player p : teamA) {
            heightsA.add(p.getHeight());
        }
        Collections.sort(heightsA);

        // Gunakan binarySearch untuk mengecek keberadaan
        int idx = Collections.binarySearch(heightsA, targetHeight);
        return idx >= 0;
    }

    /**
     * (Opsional) Fitur tambahan: Cek kesamaan nilai tinggi/berat antara Tim A dan Tim B
     */
    public void checkCommonValues() {
        System.out.println("\n=== CEK KESAMAAN DATA ANTARA TIM A DAN TIM B ===");

        ArrayList<Player> teamA = dataManager.getTeamA();
        ArrayList<Player> teamB = dataManager.getTeamB();

        // Kumpulkan nilai tinggi dan berat Tim A ke dalam set (unik)
        Set<Integer> heightsA = new HashSet<>();
        Set<Integer> weightsA = new HashSet<>();
        for (Player p : teamA) {
            heightsA.add(p.getHeight());
            weightsA.add(p.getWeight());
        }

        // Kumpulkan nilai tinggi dan berat Tim B ke dalam set (unik)
        Set<Integer> heightsB = new HashSet<>();
        Set<Integer> weightsB = new HashSet<>();
        for (Player p : teamB) {
            heightsB.add(p.getHeight());
            weightsB.add(p.getWeight());
        }

        // Tampilkan data unik tiap tim
        System.out.println("\nData unik Tim A:");
        System.out.println("- Tinggi badan: " + heightsA);
        System.out.println("- Berat badan: " + weightsA);

        System.out.println("\nData unik Tim B:");
        System.out.println("- Tinggi badan: " + heightsB);
        System.out.println("- Berat badan: " + weightsB);

        // Cek kesamaan tinggi badan
        Set<Integer> commonHeights = new HashSet<>(heightsA);
        commonHeights.retainAll(heightsB);

        System.out.println("\n--- Analisis Kesamaan Tinggi Badan ---");
        if (commonHeights.isEmpty()) {
            System.out.println("Tidak ada tinggi badan yang sama antara Tim A dan Tim B");
        } else {
            System.out.println("Tinggi badan yang sama: " + commonHeights + " cm");
            displayPlayersWithCommonHeights(teamA, teamB, commonHeights);
        }

        // Cek kesamaan berat badan
        Set<Integer> commonWeights = new HashSet<>(weightsA);
        commonWeights.retainAll(weightsB);

        System.out.println("\n--- Analisis Kesamaan Berat Badan ---");
        if (commonWeights.isEmpty()) {
            System.out.println("Tidak ada berat badan yang sama antara Tim A dan Tim B");
        } else {
            System.out.println("Berat badan yang sama: " + commonWeights + " kg");
            displayPlayersWithCommonWeights(teamA, teamB, commonWeights);
        }

        // Validasi menggunakan Collections.disjoint()
        ArrayList<Integer> listHeightsA = new ArrayList<>(heightsA);
        ArrayList<Integer> listHeightsB = new ArrayList<>(heightsB);
        ArrayList<Integer> listWeightsA = new ArrayList<>(weightsA);
        ArrayList<Integer> listWeightsB = new ArrayList<>(weightsB);

        boolean heightDisjoint = Collections.disjoint(listHeightsA, listHeightsB);
        boolean weightDisjoint = Collections.disjoint(listWeightsA, listWeightsB);

        System.out.println("\n--- Validasi dengan Collections.disjoint() ---");
        System.out.println("Tinggi badan disjoint (tidak ada yang sama): " + heightDisjoint);
        System.out.println("Berat badan disjoint (tidak ada yang sama): " + weightDisjoint);
    }

    // Helper: tampilkan daftar pemain (Tim A vs Tim B) untuk setiap tinggi yang sama
    private void displayPlayersWithCommonHeights(ArrayList<Player> teamA,
                                                 ArrayList<Player> teamB,
                                                 Set<Integer> commonHeights) {
        for (Integer height : commonHeights) {
            System.out.println("\nPemain dengan tinggi " + height + "cm:");
            System.out.println("  Tim A:");
            for (Player p : teamA) {
                if (p.getHeight() == height) {
                    System.out.println("    " + p);
                }
            }
            System.out.println("  Tim B:");
            for (Player p : teamB) {
                if (p.getHeight() == height) {
                    System.out.println("    " + p);
                }
            }
        }
    }

    // Helper: tampilkan daftar pemain (Tim A vs Tim B) untuk setiap berat yang sama
    private void displayPlayersWithCommonWeights(ArrayList<Player> teamA,
                                                 ArrayList<Player> teamB,
                                                 Set<Integer> commonWeights) {
        for (Integer weight : commonWeights) {
            System.out.println("\nPemain dengan berat " + weight + "kg:");
            System.out.println("  Tim A:");
            for (Player p : teamA) {
                if (p.getWeight() == weight) {
                    System.out.println("    " + p);
                }
            }
            System.out.println("  Tim B:");
            for (Player p : teamB) {
                if (p.getWeight() == weight) {
                    System.out.println("    " + p);
                }
            }
        }
    }

    /**
     * (Opsional) Fitur tambahan: pencarian kustom pada satu tim berdasarkan kriteria 'height' atau 'weight'.
     *
     * @param team     Nama tim ("Tim A", "Tim B", atau "Tim C")
     * @param criteria "height"/"tinggi" atau "weight"/"berat"
     * @param value    Nilai yang ingin dicari (contoh: 170cm atau 65kg)
     */
    public void searchCustomValue(String team, String criteria, int value) {
        ArrayList<Player> targetTeam;

        switch (team.toUpperCase()) {
            case "TIM A":
            case "A":
                targetTeam = dataManager.getTeamA();
                break;
            case "TIM B":
            case "B":
                targetTeam = dataManager.getTeamB();
                break;
            case "TIM C":
            case "C":
                targetTeam = dataManager.getTeamC();
                break;
            default:
                System.out.println("Tim tidak ditemukan: " + team);
                return;
        }

        // Buat daftar nilai berdasarkan kriteria
        ArrayList<Integer> values = new ArrayList<>();
        if (criteria.equalsIgnoreCase("height") || criteria.equalsIgnoreCase("tinggi")) {
            for (Player p : targetTeam) {
                values.add(p.getHeight());
            }
        } else if (criteria.equalsIgnoreCase("weight") || criteria.equalsIgnoreCase("berat")) {
            for (Player p : targetTeam) {
                values.add(p.getWeight());
            }
        } else {
            System.out.println("Kriteria tidak valid. Gunakan 'height' atau 'weight'.");
            return;
        }

        // Sort ascending
        Collections.sort(values);

        int count = Collections.frequency(values, value);
        int index = Collections.binarySearch(values, value);

        System.out.println("\n=== PENCARIAN CUSTOM ===");
        System.out.println("Tim: " + team);
        System.out.println("Kriteria: " + criteria);
        System.out.println("Nilai yang dicari: " + value);
        System.out.println("Jumlah ditemukan: " + count);
        System.out.println("Binary search result: " +
                (index >= 0 ? "Found at index " + index : "Not found (" + index + ")"));
    }
}
