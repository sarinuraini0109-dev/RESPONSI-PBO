/**Catatan satu transaksi pembelian yang sudah berhasil.**/

public class Transaksi {

    private final String nomor;
    private Kendaraan kendaraan;
    private BahanBakar bahanBakar;
    private double liter;
    private double total;
    private double kembalian;

    public Transaksi(String nomor, Kendaraan kendaraan, BahanBakar bahanBakar,
                     double liter, double total) {
        this(nomor, kendaraan, bahanBakar, liter, total, 0);
    }

    public Transaksi(String nomor, Kendaraan kendaraan, BahanBakar bahanBakar,
                     double liter, double total, double kembalian) {
        this.nomor = nomor;
        this.kendaraan = kendaraan;
        this.bahanBakar = bahanBakar;
        this.liter = liter;
        this.total = total;
        this.kembalian = kembalian;
    }

    public String getNomor() {
        return nomor;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public BahanBakar getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(BahanBakar bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }
}
