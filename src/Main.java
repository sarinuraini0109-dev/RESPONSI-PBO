public class Main {

    private static void tampilkanKendaraan(Kendaraan k) {
        String status = k.isTerdaftarSubsidi() ? "terdaftar BBM subsidi" : "belum terdaftar BBM subsidi";
        System.out.println("  " + k.getPlat() + " (" + k.getJenis() + ") - " + status);
    }

    private static String yaTidak(boolean nilai) {
        return nilai ? "ya" : "tidak";
    }

    // keterangan singkat sebelum transaksi, supaya jelas apa yang sedang diuji
    private static void kasus(String keterangan) {
        System.out.print("\n>> " + keterangan);
    }

    public static void main(String[] args) {

        // ---------- bahan bakar dibuat (konstruktor overload: tanpa dan dengan stok awal) ----------
        Pertalite pertalite = new Pertalite();
        Pertamax pertamax = new Pertamax();
        Dexlite dexlite = new Dexlite(200);
        Solar solar = new Solar(120);

        System.out.println("SPBU sedang bersiap buka.");
        System.out.println("Stok awal Pertalite : " + pertalite.getStokLiter() + " L (kosong)");
        System.out.println("Stok awal Pertamax  : " + pertamax.getStokLiter() + " L (kosong)");
        System.out.println();

        // method void yang mengubah stok
        System.out.println("Pagi ini truk tangki mengirim Pertalite 150 L dan Pertamax 500 L:");
        pertalite.isiStok(150);
        pertamax.isiStok(500);
        System.out.println();

        System.out.println("Tambah Pertamax 2000 L, padahal tangki hanya 1000 L:");
        pertamax.isiStok(2000);
        System.out.println();

        // semua jenis disimpan di array bertipe BahanBakar (abstract class)
        // tampilkanInfo() ditimpa tiap subclass dan memanggil super.tampilkanInfo()
        BahanBakar[] semua = { pertalite, pertamax, dexlite, solar };
        System.out.println("Data bahan bakar yang dijual hari ini.");
        System.out.println();
        for (BahanBakar b : semua) {
            b.tampilkanInfo();
            System.out.println();
        }

        // ---------- petugas dan kendaraan ----------
        Petugas budi = new Petugas("PTG-01", "Budi");
        System.out.println("Petugas yang jaga: " + budi.getNama() + " (ID " + budi.getId() + ")");
        System.out.println();

        Kendaraan motor1 = new Kendaraan("R 1234 AB", "MOTOR", true);
        Kendaraan motor2 = new Kendaraan("R 4321 EF", "MOTOR", true);
        Kendaraan mobil1 = new Kendaraan("R 555 XY", "MOBIL");      // belum terdaftar subsidi
        Kendaraan truk1 = new Kendaraan("R 8821 CD", "TRUK", true);


        // ---------- konstanta dan atribut final ----------
        System.out.println("Aturan tetap SPBU:");
        System.out.println("  Stok dianggap menipis jika sisa " + BahanBakar.STOK_MINIMUM + " L atau kurang");
        System.out.println("  Kuota Pertalite per kendaraan per hari : " + Pertalite.KUOTA_HARIAN + " L");
        System.out.println("  Batas Solar per transaksi              : " + Solar.MAKS_PER_TRANSAKSI + " L");
        System.out.println("Data berikut juga tidak bisa diganti setelah dibuat:");
        System.out.println("  Kode Solar: " + solar.getKode() + ", plat motor pertama: " + motor1.getPlat()
                + ", ID petugas: " + budi.getId());
        System.out.println();

        // ---------- getter, setter, dan method yang mengembalikan nilai ----------
        System.out.println("Uji setter pada objek Dexlite contoh (bukan Dexlite yang dijual):");
        Dexlite dexliteUji = new Dexlite();
        System.out.printf("  Harga awal                       : Rp%,.0f%n", dexliteUji.getHargaPerLiter());
        dexliteUji.setHargaPerLiter(-500);
        System.out.printf("  Setelah diubah ke -500 (ditolak) : Rp%,.0f%n", dexliteUji.getHargaPerLiter());
        dexliteUji.setHargaPerLiter(13500);
        System.out.printf("  Setelah diubah ke 13.500         : Rp%,.0f%n", dexliteUji.getHargaPerLiter());
        System.out.println();

        System.out.printf("Contoh hitung biaya beli 20 L Pertalite = Rp%,.0f%n", pertalite.hitungTotal(20));
        System.out.println();

        System.out.println("Cek stok sebelum buka:");
        budi.cekSemuaStok(semua);

        // ---------- transaksi ----------
        // layaniPembelian() adalah abstract method, tiap subclass mengisinya dengan if/else
        // yang membaca dan mengubah state (stok bahan bakar dan kuota kendaraan)
        System.out.println("\nSPBU buka. Transaksi hari ini:");

        kasus("1");
        budi.layaniTransaksi(motor1, pertalite, 15, 200000);

        kasus("2");
        budi.layaniTransaksi(mobil1, pertalite, 10, 100000);

        kasus("3");
        budi.layaniTransaksi(mobil1, pertamax, 30, 500000);

        kasus("4");
        budi.layaniTransaksi(motor2, dexlite, 5, 100000);

        kasus("5");
        budi.layaniTransaksi(truk1, solar, 50, 400000);

        kasus("6");
        budi.layaniTransaksi(motor1, pertalite, 110, 1500000);

        kasus("7");
        budi.layaniTransaksi(truk1, solar, 80, 600000);

        kasus("8");
        budi.layaniTransaksi(motor2, pertamax, 5, 50000);

        kasus("9");
        budi.layaniTransaksi(truk1, dexlite, 120, 2000000);

        System.out.println("\nTransaksi berhasil: " + budi.getJumlahTransaksi() + " dari 9 percobaan");
        System.out.println("Kuota subsidi motor pertama yang terpakai: " + motor1.getLiterSubsidiHariIni()
                + " L dari " + Pertalite.KUOTA_HARIAN + " L");
        System.out.println();

        // ---------- polimorfisme interface ----------
        // objek diakses lewat variabel bertipe interface
        Struk strukPertalite = new Pertalite(100);
        Struk strukDexlite = new Dexlite(100);
        Subsidi subsidiSolar = new Solar(100);

        Transaksi contoh1 = new Transaksi("TRX-UJI-1", motor1, pertalite, 5, 50000);
        Transaksi contoh2 = new Transaksi("TRX-UJI-2", truk1, dexlite, 5, 65000, 35000);

        System.out.println("Cetak struk lewat variabel bertipe interface Struk.");
        System.out.println("\nStruk contoh Pertalite (bersubsidi, ada nilai subsidi):");
        strukPertalite.cetakStruk(contoh1);
        System.out.println("\nStruk contoh Dexlite (non-subsidi, subsidi tidak ada):");
        strukDexlite.cetakStruk(contoh2);

        System.out.println("\nHitung subsidi lewat variabel bertipe interface Subsidi (contoh Solar):");
        System.out.printf("  Subsidi per liter : Rp%,.0f%n", subsidiSolar.getSubsidiPerLiter());
        System.out.printf("  Subsidi 10 liter  : Rp%,.0f%n", subsidiSolar.hitungSubsidi(10));
        System.out.println();

        // ---------- pewarisan dan multiple interface ----------
        System.out.println("Kelompok tiap bahan bakar:");
        for (BahanBakar b : semua) {
            String kelompok = (b instanceof BBMSubsidi) ? "BBMSubsidi" : "BBMNonSubsidi";
            System.out.println("  " + b.getNama() + " -> kelompok " + kelompok
                    + ", bisa cetak struk (Struk): " + yaTidak(b instanceof Struk)
                    + ", punya subsidi (Subsidi): " + yaTidak(b instanceof Subsidi));
        }
        System.out.println();


        System.out.println("Ringkasan penjualan hari ini:");
        for (BahanBakar b : semua) {
            System.out.println("  " + b.getNama() + " terjual " + b.getTotalTerjual() + " L dalam "
                    + b.getJumlahTransaksi() + " transaksi");
        }
        System.out.println();

        System.out.println("SPBU tutup. Cek stok:");
        budi.cekSemuaStok(semua);

        System.out.println("\nStok yang menipis diisi ulang sampai penuh:");
        for (BahanBakar b : semua) {
            if (b.stokMenipis()) {
                b.isiStok(b.kebutuhanIsi());
            }
        }

        System.out.println("\nCek stok setelah pengisian:");
        budi.cekSemuaStok(semua);
    }
}