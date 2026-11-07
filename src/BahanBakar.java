/** Superclass abstract untuk semua jenis bahan bakar yang dijual di SPBU. **/

public abstract class BahanBakar {

    // konstanta global: batas stok tangki dianggap menipis (liter)
    public static final double STOK_MINIMUM = 100.0;

    // atribut instans kekal, kode bahan bakar tidak boleh berubah
    private final String kode;

    private String nama;
    private String kualitas;
    private double hargaPerLiter;
    private double kapasitasTangki;
    private double stokLiter;
    private double totalTerjual;
    private int jumlahTransaksi;

    public BahanBakar(String kode, String nama, String kualitas, double hargaPerLiter,
                      double kapasitasTangki) {
        this(kode, nama, kualitas, hargaPerLiter, kapasitasTangki, 0);
    }

    public BahanBakar(String kode, String nama, String kualitas, double hargaPerLiter,
                      double kapasitasTangki, double stokLiter) {
        this.kode = kode;
        this.nama = nama;
        this.kualitas = kualitas;
        this.hargaPerLiter = hargaPerLiter;
        this.kapasitasTangki = kapasitasTangki;
        this.stokLiter = stokLiter;
        this.totalTerjual = 0;
        this.jumlahTransaksi = 0;
    }

    // method abstract: tiap jenis bahan bakar punya aturan layanan sendiri
    public abstract boolean layaniPembelian(Kendaraan kendaraan, double liter);

    // method fungsi (mengembalikan nilai)
    public double hitungTotal(double liter) {
        return liter * hargaPerLiter;
    }

    public boolean stokMenipis() {
        return stokLiter <= STOK_MINIMUM;
    }

    // berapa liter yang muat lagi sampai tangki penuh
    public double kebutuhanIsi() {
        return kapasitasTangki - stokLiter;
    }

    // method prosedur (void)
    public void isiStok(double liter) {
        if (liter <= 0) {
            System.out.println("Pengisian ditolak: jumlah liter tidak valid.");
        } else if (stokLiter + liter > kapasitasTangki) {
            System.out.println("Pengisian ditolak: melebihi kapasitas tangki " + nama
                    + " (hanya muat " + kebutuhanIsi() + " L lagi).");
        } else {
            this.stokLiter += liter;
            System.out.println("Stok " + nama + " ditambah " + liter + " L");
        }
    }

    // info yang sama untuk semua jenis bahan bakar, subclass menambah baris aturannya
    public void tampilkanInfo() {
        System.out.println("[" + kode + "] " + nama);
        System.out.printf("  %-14s: %s%n", "Kualitas", kualitas);
        System.out.printf("  %-14s: Rp%,.0f%n", "Harga/liter", hargaPerLiter);
        System.out.printf("  %-14s: %s L dari %s L%n", "Stok", stokLiter, kapasitasTangki);
        System.out.printf("  %-14s: %s L%n", "Total terjual", totalTerjual);
        System.out.printf("  %-14s: %dx%n", "Transaksi", jumlahTransaksi);
    }

    // dipakai subclass setelah transaksi berhasil
    protected void catatPenjualan(double liter) {
        this.stokLiter -= liter;
        this.totalTerjual += liter;
        this.jumlahTransaksi++;
    }

    // bagian struk yang sama untuk semua jenis bahan bakar
    protected void cetakRincian(Transaksi transaksi) {
        System.out.println("=============== STRUK ===============");
        System.out.printf("  %-14s: %s%n", "No. transaksi", transaksi.getNomor());
        System.out.printf("  %-14s: %s (%s)%n", "Plat", transaksi.getKendaraan().getPlat(),
                transaksi.getKendaraan().getJenis());
        System.out.printf("  %-14s: %s (%s)%n", "BBM", nama, kualitas);
        System.out.printf("  %-14s: Rp%,.0f%n", "Harga/liter", hargaPerLiter);
        System.out.printf("  %-14s: %s L%n", "Jumlah", transaksi.getLiter());
        System.out.printf("  %-14s: Rp%,.0f%n", "Total", transaksi.getTotal());
        System.out.printf("  %-14s: Rp%,.0f%n", "Bayar",
                transaksi.getTotal() + transaksi.getKembalian());
        System.out.printf("  %-14s: Rp%,.0f%n", "Kembalian", transaksi.getKembalian());
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKualitas() {
        return kualitas;
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    public double getHargaPerLiter() {
        return hargaPerLiter;
    }

    public void setHargaPerLiter(double hargaPerLiter) {
        if (hargaPerLiter > 0) {
            this.hargaPerLiter = hargaPerLiter;
        }
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public double getStokLiter() {
        return stokLiter;
    }

    public void setStokLiter(double stokLiter) {
        if (stokLiter >= 0) {
            this.stokLiter = stokLiter;
        }
    }

    public double getTotalTerjual() {
        return totalTerjual;
    }

    public void setTotalTerjual(double totalTerjual) {
        this.totalTerjual = totalTerjual;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(int jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }
}
