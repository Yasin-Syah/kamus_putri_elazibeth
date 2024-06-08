import java.util.Scanner;
import java.util.TreeSet;

public class KamusPutriElizabeth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan paragraf (max 5000):");
        String input = scan.nextLine().toLowerCase();
        String[] kalimat = input.split("[^a-zA-Z]+");

        TreeSet<String> kataUnik = new TreeSet<>();
                                                    
        for (String kata : kalimat) {
            if (!kata.isEmpty()) {
                kataUnik.add(kata);
            }
        }

        int maksKata = 5000; 
        int hitungan = 0; 
        MyHashMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
        int i = 1;

        for (String kata : kataUnik) {
            if (hitungan >= maksKata) {
                break; 
            }
            myHashMap.put(i, kata);
            i++;
            hitungan++;
        }
        int j = 1;
        for (int l = hitungan; l != 0; l--) {
            System.out.println(myHashMap.get(j));
            j++;
        }
    }
}
