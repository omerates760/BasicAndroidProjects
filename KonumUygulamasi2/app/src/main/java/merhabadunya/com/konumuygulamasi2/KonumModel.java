package merhabadunya.com.konumuygulamasi2;

public class KonumModel {
    private long id;
    private Double KonumX;
    private Double KonumY;
    private Double Cap;
    private String Aciklama;



    public KonumModel(long id, Double konumX, Double konumY, Double cap, String aciklama) {
        this.id = id;
        KonumX = konumX;
        KonumY = konumY;
        Cap = cap;

        Aciklama=aciklama;
    }

    public KonumModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getKonumX() {
        return KonumX;
    }

    public void setKonumX(Double konumX) {
        KonumX = konumX;
    }

    public Double getKonumY() {
        return KonumY;
    }

    public void setKonumY(Double konumY) {
        KonumY = konumY;
    }
    public Double getCap() {
        return Cap;
    }

    public void setCap(Double cap) {
        Cap = cap;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }
}
