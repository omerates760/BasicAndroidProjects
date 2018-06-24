package merhabadunya.com.db;

/**
 * Created by omera on 14.02.2018.
 */

public class kullanici {
    String isim;
    int id;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }
    //Değeri stringe çevirir
    public String toString(){

        return " "+id+"-"+isim;

    }
}
