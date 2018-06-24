package merhabadunya.com.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omera on 15.02.2018.
 */

public class veri_katmani {
    SQLiteDatabase Db;  //ASIL DATABASE
    sorgu_katmani bdp;  //BENİM KURCALICAĞIM DATABASE
    public veri_katmani(Context c){
        bdp=new sorgu_katmani(c);

    }
    public void ac(){
        Db=bdp.getWritableDatabase();
    }
    public void kapat(){
        bdp.close();

    }

    public void kullaniciOlustur(kullanici k){
        //String isim="ömer ateş";
        //kullanici k=new kullanici();
        //k.setIsim(isim);
        ContentValues val=new ContentValues();
        val.put("isim",k.getIsim());
        Db.insert("kullanici",null,val);


    }
    public void kullaniciSil(kullanici k){
        int id=k.getId();
        Db.delete("kullanici","id="+id,null);
    }
    public List<kullanici> listele(){
        List<kullanici> liste=new ArrayList<kullanici>();
        //KAYITLSRINDAN ÜZERİNDEN TEKER TEKER GEÇMEYE SAĞLAR CURSOR.
        Cursor cus=Db.query("kullanici", new String[]{"[id,isim]"},null,null,null,null,null);
        cus.moveToFirst();//GELEN ELEMANLARI TEK TEK OKU
        //sSON ELEMANA GELENE KADAR DÖNDÜR
        while(!cus.isAfterLast())
        {
            int id= cus.getInt(0);
            String isim=cus.getString(1);

            String eleman=" "+id+"-"+isim;
            kullanici k=new kullanici(isim,id );

            liste.add(k);


        }
        return liste;
    }
}
