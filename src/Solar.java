/**
 * Solar: bahan bakar diesel bersubsidi. Tidak untuk motor dan dibatasi per transaksi.
 */
public class Solar extends BBMSubsidi implements Struk, Subsidi {

    public static final double MAKS_PER_TRANSAKSI = 200.0;

    public Solar() {
        super("SLR", "Solar", "CN 48", 6800, 500, 3000);
    }

    public Solar(double stokAwal) {
        super("SLR", "Solar", "CN 48", 6800, 500, 3000, stokAwal);
    }

    @Override
    public boolean layaniPembelian(Kendaraan kendaraan, double liter) {
        if (liter <= 0) {
            System.out.println("Pembelian ditolak: jumlah liter tidak valid.");
            return false;
        } else if (kendaraan.getJenis().equals("MOTOR")) {
            System.out.println("Pembelian ditolak: motor tidak boleh mengisi Solar.");
            return false;
        } else if (!kendaraanTerdaftar(kendaraan)) {
            return false;
        } else if (liter > MAKS_PER_TRANSAKSI) {
            System.out.println("Pembelian ditolak: maksimal " + MAKS_PER_TRANSAKSI
                    + " L per transaksi.");
            return false;
        } else if (liter > getStokLiter()) {
            System.out.println("Pembelian ditolak: stok Solar tidak cukup (sisa "
                    + getStokLiter() + " L).");
            return false;
        } else {
            catatPenjualan(liter);
            System.out.println(kendaraan.getPlat() + " berhasil beli " + liter + " L Solar.");
            return true;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: %s%n", "Aturan",
                "subsidi, maks " + MAKS_PER_TRANSAKSI + " L per transaksi, motor dilarang");
    }
}
