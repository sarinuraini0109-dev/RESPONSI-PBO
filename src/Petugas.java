/**
 * Petugas SPBU: melayani transaksi kendaraan satu per satu dan mengecek stok tangki.
 */
public class Petugas {

    // id petugas tidak boleh berubah
    private final String id;

    private String nama;
    private int jumlahTransaksi;

    public Petugas(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.jumlahTransaksi = 0;
    }

    // melayani satu kendaraan, mengembalikan true jika transaksi berhasil
    public boolean layaniTransaksi(Kendaraan kendaraan, BahanBakar bahan, double liter,
                                   double uangDibayar) {
        System.out.printf("%n%s (%s) isi %s L %s, bayar Rp%,.0f%n", kendaraan.getPlat(),
                kendaraan.getJenis(), liter, bahan.getNama(), uangDibayar);

        double total = bahan.hitungTotal(liter);
        if (uangDibayar < total) {
            System.out.printf("Pembayaran ditolak: total Rp%,.0f, uang kurang Rp%,.0f.%n", total,
                    total - uangDibayar);
            return false;
        }
        boolean berhasil = bahan.layaniPembelian(kendaraan, liter);
        if (!berhasil) {
            return false;
        }

        double kembalian = uangDibayar - total;
        jumlahTransaksi++;
        String nomorTransaksi = String.format("TRX-%03d", jumlahTransaksi);
        Transaksi transaksi = new Transaksi(nomorTransaksi, kendaraan, bahan, liter, total,
                kembalian);

        // setiap pelanggan yang transaksinya berhasil mendapat struk
        if (bahan instanceof Struk) {
            Struk struk = (Struk) bahan;
            struk.cetakStruk(transaksi);
        }
        return true;
    }

    public void cekStok(BahanBakar bahan) {
        String status;
        if (bahan.stokMenipis()) {
            status = "MENIPIS, segera isi " + bahan.kebutuhanIsi() + " L";
        } else {
            status = "AMAN";
        }
        System.out.printf("  %-14s: %s L dari %s L - %s%n", bahan.getNama(),
                bahan.getStokLiter(), bahan.getKapasitasTangki(), status);
    }

    public void cekSemuaStok(BahanBakar[] semua) {
        System.out.println("Aman bila stok di atas " + BahanBakar.STOK_MINIMUM
                + " L, menipis bila " + BahanBakar.STOK_MINIMUM
                + " L atau kurang (harus segera diisi).");
        for (BahanBakar bahan : semua) {
            cekStok(bahan);
        }
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(int jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }
}
