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
