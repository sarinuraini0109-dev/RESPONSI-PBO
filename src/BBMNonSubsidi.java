/** Kelompok bahan bakar non-subsidi.**/

public abstract class BBMNonSubsidi extends BahanBakar implements Struk {

    public BBMNonSubsidi(String kode, String nama, String kualitas, double hargaPerLiter,
                                double kapasitasTangki) {
        super(kode, nama, kualitas, hargaPerLiter, kapasitasTangki);
    }

    public BBMNonSubsidi(String kode, String nama, String kualitas, double hargaPerLiter,
                                double kapasitasTangki, double stokAwal) {
        super(kode, nama, kualitas, hargaPerLiter, kapasitasTangki, stokAwal);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: %s%n", "Subsidi", "tidak ada");
    }

    @Override
    public void cetakStruk(Transaksi transaksi) {
        cetakRincian(transaksi);
        System.out.printf("  %-14s: %s%n", "Subsidi", "tidak ada");
        System.out.println("=====================================");
    }
}
