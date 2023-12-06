
package TB.Entitty;


public class Pasien {

    private int id;
    private String kodepasien;
    private String nama;
    private String jenkel;
    private String alamat;
    private String penyakit;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the kodepasien
     */
    public String getKodepasien() {
        return kodepasien;
    }

    /**
     * @param kodepasien the kodepasien to set
     */
    public void setKodepasien(String kodepasien) {
        this.kodepasien = kodepasien;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenkel
     */
    public String getJenkel() {
        return jenkel;
    }

    /**
     * @param jenkel the jenkel to set
     */
    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the penyakit
     */
    public String getPenyakit() {
        return penyakit;
    }

    /**
     * @param penyakit the penyakit to set
     */
    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
}
