/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2pbo;

/**
 *
 * @author USER
 */
public class Peminjaman {
    
    private String kode_buku;
    private String nama_buku;
    private String nama_peminjam;
    private String tanggal_pinjam;
    private String tanggal_pengembalian;


    public Peminjaman() {
    }

    public Peminjaman(String kode_buku, String nama_buku, String nama_peminjam, String tanggal_pinjam, String tanggal_pengembalian) {
        this.kode_buku = kode_buku;
        this.nama_buku = nama_buku;
        this.nama_peminjam = nama_peminjam;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_pengembalian = tanggal_pengembalian;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public void setNama_buku(String nama_buku) {
        this.nama_buku = nama_buku;
    }

    public String getNama_peminjam() {
        return nama_peminjam;
    }

    public void setNama_peminjam(String nama_peminjam) {
        this.nama_peminjam = nama_peminjam;
    }

    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public String getTanggal_pengembalian() {
        return tanggal_pengembalian;
    }

    public void setTanggal_pengembalian(String tanggal_pengembalian) {
        this.tanggal_pengembalian = tanggal_pengembalian;
    }
}
