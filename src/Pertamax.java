/**Pertamax: bahan bakar non-subsidi, semua kendaraan boleh beli.**/

public class Pertamax extends BBMNonSubsidi {

    public Pertamax() {
        super("PMX", "Pertamax", "RON 92", 13500, 1000);
    }

    public Pertamax(double stokAwal) {
        super("PMX", "Pertamax", "RON 92", 13500, 1000, stokAwal);
    }

    @Override
    public boolean layaniPembelian(Kendaraan kendaraan, double liter) {
        if (liter <= 0) {
            System.out.println("Pembelian ditolak: jumlah liter tidak valid.");
            return false;
        } else if (liter > getStokLiter()) {
            System.out.println("Pembelian ditolak: stok Pertamax tidak cukup (sisa "
                    + getStokLiter() + " L).");
            return false;
        } else {
            catatPenjualan(liter);
            System.out.println(kendaraan.getPlat() + " berhasil beli " + liter + " L Pertamax.");
            return true;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: %s%n", "Aturan", "semua kendaraan boleh membeli");
    }
}
