Responsi Praktikum Pemrograman Berorientasi Objek

Nama: Sari Nur Aini 
NIM: H1D025082
Tema: SPBU

## Deskripsi Singkat

Simulasi SPBU yang melayani pembelian BBM subsidi (Pertalite, Solar) dan non-subsidi
(Pertamax, Dexlite). Petugas melayani kendaraan satu per satu, sistem memvalidasi aturan
tiap kelompok BBM (terdaftar subsidi, kuota harian, stok, dan uang), mencetak struk,
serta memantau stok tangki.

## Struktur Class

BahanBakar (abstract)
├── BBMSubsidi      implements Struk, Subsidi
└── BBMNonSubsidi   implements Struk

Pertalite dan Solar adalah objek `BBMSubsidi`; Pertamax dan Dexlite adalah objek
`BBMNonSubsidi`. Perbedaan perilaku ada pada kelompok subsidi dan non-subsidi, sedangkan
perbedaan antar jenis BBM hanya pada data (harga, subsidi, kuota).

| Class / Interface | Peran |
|---|---|
| `BahanBakar` | Superclass abstract: data BBM, stok, harga, `layaniPembelian()` abstract |
| `BBMSubsidi` | Aturan BBM subsidi: wajib terdaftar dan dibatasi kuota harian |
| `BBMNonSubsidi` | Aturan BBM non-subsidi: semua kendaraan boleh membeli |
| `Kendaraan` | Plat nomor, status terdaftar subsidi, dan liter subsidi hari ini |
| `Petugas` | Melayani transaksi dan mengecek stok |
| `Transaksi` | Catatan satu transaksi yang berhasil |
| `Struk`, `Subsidi` (interface) | Kontrak cetak struk dan perhitungan subsidi |
| `Main` | Alur pengujian |


## Cara Compile dan Run (Terminal)

Dari folder root repositori:

```bash
cd src
javac -d ../out *.java
cd ..
java -cp out Main
```

Syarat: JDK 11 atau lebih baru (`javac -version` untuk mengecek).

## Screenshot Luaran Program

![Output](ScreenshotOutput1.png)
![Output](ScreenshotOutput2.png)
![Output](ScreenshotOutput3.png)
![Output](ScreenshotOutput4.png)
![Output](ScreenshotOutput5.png)
![Output](ScreenshotOutput6.png)
![Output](ScreenshotOutput7.png)
![Output](ScreenshotOutput8.png)
![Output](ScreenshotOutput9.png)
![Output](ScreenshotOutput10.png)
![Output](ScreenshotOutput11.png)
![Output](ScreenshotOutput12.png)
