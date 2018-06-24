package merhabadunya.com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by omera on 14.02.2018.
 */
//BU KATMAN VERİTABANI YOKSA OLUŞTUR VARSA DÜZENLEMEK İÇİN YAPILDI
public class sorgu_katmani extends SQLiteOpenHelper {
    public sorgu_katmani(Context context) {
        super(context,"kullanici",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table kullaniciTbl (id integer primary key,isim text)";
        db.execSQL(sql);

    }
//android versiyon takibi burda sağlanır
    @Override
    public void onUpgrade(SQLiteDatabase db, int eski, int yeni) {
        db.execSQL("drop table kullaniciTbl");

    }
}
