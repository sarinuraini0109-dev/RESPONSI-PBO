/**Pertalite: bahan bakar bersubsidi dengan kuota harian per plat nomor.**/

public class Pertalite extends BBMSubsidi implements Struk, Subsidi {

    public static final double KUOTA_HARIAN = 120.0;

    public Pertalite() {
        super("PTL", "Pertalite", "RON 90", 10000, 1000, 2500);
    }

    public Pertalite(double stokAwal) {
        super("PTL", "Pertalite", "RON 90", 10000, 1000, 2500, stokAwal);
    }

    @Override
    public boolean layaniPembelian(Kendaraan kendaraan, double liter) {
        if (liter <= 0) {
            System.out.println("Pembelian ditolak: jumlah liter tidak valid.");
            return false;
        } else if (!kendaraanTerdaftar(kendaraan)) {
            return false;
        } else if (liter > getStokLiter()) {
            System.out.println("Pembelian ditolak: stok Pertalite tidak cukup (sisa "
                    + getStokLiter() + " L).");
            return false;
        } else if (kendaraan.getLiterSubsidiHariIni() + liter > KUOTA_HARIAN) {
            double sisa = KUOTA_HARIAN - kendaraan.getLiterSubsidiHariIni();
            System.out.println("Pembelian ditolak: melebihi kuota harian " + kendaraan.getPlat()
                    + " (sisa " + sisa + " L).");
            return false;
        } else {
            catatPenjualan(liter);
            kendaraan.tambahLiterSubsidi(liter);
            System.out.println(kendaraan.getPlat() + " berhasil beli " + liter + " L Pertalite.");
            return true;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: %s%n", "Aturan",
                "subsidi, kuota " + KUOTA_HARIAN + " L per kendaraan");
    }
}
