package merhabadunya.com.resimgonder;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //BU DURUMLARDA TELEFON VERİLERİNE ERİŞMEK İÇİN MANİFESTTEN İZİN ALINMASI GEREKLİ
    public void calistir(View v){
        File uzanti=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String[] ResimListesi=uzanti.list();

        for(String teker:ResimListesi){

            Toast.makeText(this,uzanti.toString()+"/"+teker,Toast.LENGTH_LONG).show();
        }


    }
}
