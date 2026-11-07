/**
 * Dexlite: bahan bakar diesel non-subsidi. Khusus mesin diesel, jadi motor dilarang.
 */
public class Dexlite extends BBMNonSubsidi {

    public Dexlite() {
        super("DXL", "Dexlite", "CN 51", 13000, 500);
    }

    public Dexlite(double stokAwal) {
        super("DXL", "Dexlite", "CN 51", 13000, 500, stokAwal);
    }

    @Override
    public boolean layaniPembelian(Kendaraan kendaraan, double liter) {
        if (liter <= 0) {
            System.out.println("Pembelian ditolak: jumlah liter tidak valid.");
            return false;
        } else if (kendaraan.getJenis().equals("MOTOR")) {
            System.out.println("Pembelian ditolak: motor tidak boleh mengisi Dexlite.");
            return false;
        } else if (liter > getStokLiter()) {
            System.out.println("Pembelian ditolak: stok Dexlite tidak cukup (sisa "
                    + getStokLiter() + " L).");
            return false;
        } else {
            catatPenjualan(liter);
            System.out.println(kendaraan.getPlat() + " berhasil beli " + liter + " L Dexlite.");
            return true;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: %s%n", "Aturan", "khusus mesin diesel, motor dilarang");
    }
}
