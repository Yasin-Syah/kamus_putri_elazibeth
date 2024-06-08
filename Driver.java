import java.util.Scanner;
import java.util.TreeSet;

public class KamusPutriElizabeth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan paragraf (max 500):");
        String input = scan.nextLine().toLowerCase(); // Mengubah semua huruf menjadi huruf kecil
        String[] kalimat = input.split("[^a-zA-Z]+"); // Memisahkan kata-kata berdasarkan karakter non-alphabetic

        TreeSet<String> kataUnik = new TreeSet<>(); // Menggunakan TreeSet untuk mengurutkan kata-kata secara alfabetis
                                                    
        for (String kata : kalimat) {
            if (!kata.isEmpty()) { // Mengabaikan string kosong
                kataUnik.add(kata);
            }
        }
          int maksKata = 5000; // Batas maksimal kata dalam kamus
        int hitungan = 0; // Jumlah kata yang sudah disimpan
        MyHashMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
        int i = 1;

        for (String kata : kataUnik) {
            if (hitungan >= maksKata) {
                break; // Hentikan jika sudah mencapai batas maksimal
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
