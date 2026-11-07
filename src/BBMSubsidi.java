/**Kelompok bahan bakar bersubsidi**/

public abstract class BBMSubsidi extends BahanBakar implements Struk, Subsidi {

    private double subsidiPerLiter;

    public BBMSubsidi(String kode, String nama, String kualitas, double hargaPerLiter,
                             double kapasitasTangki, double subsidiPerLiter) {
        super(kode, nama, kualitas, hargaPerLiter, kapasitasTangki);
        this.subsidiPerLiter = subsidiPerLiter;
    }

    public BBMSubsidi(String kode, String nama, String kualitas, double hargaPerLiter,
                             double kapasitasTangki, double subsidiPerLiter, double stokAwal) {
        super(kode, nama, kualitas, hargaPerLiter, kapasitasTangki, stokAwal);
        this.subsidiPerLiter = subsidiPerLiter;
    }

    // hanya kendaraan yang terdaftar yang boleh membeli BBM subsidi
    protected boolean kendaraanTerdaftar(Kendaraan kendaraan) {
        if (kendaraan.isTerdaftarSubsidi()) {
            return true;
        } else {
            System.out.println("Pembelian ditolak: " + kendaraan.getPlat()
                    + " belum terdaftar BBM subsidi.");
            return false;
        }
    }

    @Override
    public double hitungSubsidi(double liter) {
        return liter * subsidiPerLiter;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-14s: Rp%,.0f per liter%n", "Subsidi", subsidiPerLiter);
    }

    @Override
    public void cetakStruk(Transaksi transaksi) {
        cetakRincian(transaksi);
        System.out.printf("  %-14s: Rp%,.0f%n", "Subsidi", hitungSubsidi(transaksi.getLiter()));
        System.out.println("=====================================");
    }

    @Override
    public double getSubsidiPerLiter() {
        return subsidiPerLiter;
    }

    public void setSubsidiPerLiter(double subsidiPerLiter) {
        this.subsidiPerLiter = subsidiPerLiter;
    }
}
