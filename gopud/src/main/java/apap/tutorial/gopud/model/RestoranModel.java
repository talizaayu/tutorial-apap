package apap.tutorial.gopud.model;

public class RestoranModel {
    private String idRestoran;
    private String nama;
    private String alamat;
    private Integer nomorTelepon;


    public RestoranModel(String idRestoran, String nama, String alamat, Integer nomorTelepon) {
        this.idRestoran = idRestoran;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdRestoran() {
        return this.idRestoran;
    }

    public void setIdRestoran(String idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return this.nomorTelepon;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    
}