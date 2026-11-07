/**Data kendaraan yang mengisi bahan bakar. Plat nomor dipakai sebagai identitas dan menghitung kuota BBM subsidi per kendaraan.**/

public class Kendaraan {

    // plat nomor tidak boleh berubah setelah kendaraan didaftarkan
    private final String plat;

    private String jenis; // MOTOR, MOBIL, atau TRUK
    private boolean terdaftarSubsidi;
    private double literSubsidiHariIni;

    public Kendaraan(String plat, String jenis) {
        this(plat, jenis, false);
    }

    public Kendaraan(String plat, String jenis, boolean terdaftarSubsidi) {
        this.plat = plat;
        this.jenis = jenis;
        this.terdaftarSubsidi = terdaftarSubsidi;
        this.literSubsidiHariIni = 0;
    }

    public void tambahLiterSubsidi(double liter) {
        this.literSubsidiHariIni += liter;
    }

    public String getPlat() {
        return plat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public boolean isTerdaftarSubsidi() {
        return terdaftarSubsidi;
    }

    public void setTerdaftarSubsidi(boolean terdaftarSubsidi) {
        this.terdaftarSubsidi = terdaftarSubsidi;
    }

    public double getLiterSubsidiHariIni() {
        return literSubsidiHariIni;
    }

    public void setLiterSubsidiHariIni(double literSubsidiHariIni) {
        this.literSubsidiHariIni = literSubsidiHariIni;
    }
}
