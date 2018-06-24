package merhabadunya.com.konumuygulamasi2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class KonumDBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "konum.db";
    private static final int DATABASE_VERSION = 1 ;
    public static final String TABLE_NAME = "KonumTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_Konum_x = "konumx";
    public static final String COLUMN_Konum_y = "konumy";
    public static final String COLUMN_Cap = "cap";
    public static final String COLUMN_Aciklama = "aciklama";
   public KonumDBhelper(Context context)
   {
       super(context, DATABASE_NAME , null, DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_Aciklama + " TEXT NOT NULL, " +
                    COLUMN_Cap + " REAL NOT NULL, " +
                    COLUMN_Konum_x + " REAL NOT NULL, " +
                    COLUMN_Konum_y + " REAL NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // you can implement here migration process
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }
    public void YeniKonum(KonumModel person) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_Konum_x, person.getKonumX());
        values.put(COLUMN_Konum_y, person.getKonumY());
        values.put(COLUMN_Aciklama,person.getAciklama());
        values.put(COLUMN_Cap,person.getCap());


        // insert
        sqLiteDatabase.insert(TABLE_NAME,null, values);
        sqLiteDatabase.close();
    }
    /**Query records, give options to filter results**/
    public List<KonumModel> KonumListe(String filter) {
        String query;
        if(filter.equals("")){
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        }else{
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;
        }
        List<KonumModel> konumModelLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        KonumModel konumModel;

        if (cursor.moveToFirst()) {
            do {
                konumModel =new KonumModel();

                konumModel.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                konumModel.setKonumX(cursor.getDouble(cursor.getColumnIndex(COLUMN_Konum_x)));
                konumModel.setKonumY(cursor.getDouble(cursor.getColumnIndex(COLUMN_Konum_y)));
                konumModel.setAciklama(cursor.getString(cursor.getColumnIndex(COLUMN_Aciklama)));
                konumModel.setCap(cursor.getDouble(cursor.getColumnIndex(COLUMN_Cap)));


                konumModelLinkedList.add(konumModel);
            } while (cursor.moveToNext());
        }


        return konumModelLinkedList;
    }
    public KonumModel getKonumModel(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        KonumModel receivedPerson = new KonumModel();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPerson.setKonumX(cursor.getDouble(cursor.getColumnIndex(COLUMN_Konum_x)));
            receivedPerson.setKonumX(cursor.getDouble(cursor.getColumnIndex(COLUMN_Konum_y)));
            receivedPerson.setAciklama(cursor.getString(cursor.getColumnIndex(COLUMN_Aciklama)));
            receivedPerson.setCap(cursor.getDouble(cursor.getColumnIndex(COLUMN_Cap)));

        }



        return receivedPerson;


    }
    public void deletePersonRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE _id='"+id+"'");
        Toast.makeText(context, "DELETED.", Toast.LENGTH_SHORT).show();

    }
}
