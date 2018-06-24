package merhabadunya.com.aramayap_rehbereeris;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Calisma_izni  {
    private static final int ARAMA_YAP_KOD = 100;
    private static final int REHBER_izni= 200;
    Button btnArama,btnRehber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnArama=findViewById(R.id.Arama);
        btnRehber=findViewById(R.id.Rehber);

    }

    @Override
    public void izinVerildi(int requestCode) {
        if(requestCode==ARAMA_YAP_KOD)
        {
            aramayap();
        }
        if (requestCode==REHBER_izni)
        {
            rehbereEris();
        }
    }


    public void calistir(View view) {

        if(view.getId()==R.id.Arama)
        {
            String[]istenilenizinler={Manifest.permission.CALL_PHONE};
            MainActivity.super.izinAl(istenilenizinler,ARAMA_YAP_KOD);
            aramayap();


        }
        if(view.getId()==R.id.Rehber)
        {
            String[]istenilenizinler={Manifest.permission.READ_CONTACTS ,Manifest.permission.WRITE_CONTACTS};
            MainActivity.super.izinAl(istenilenizinler,REHBER_izni);
        }

    }

    @SuppressLint("MissingPermission")
    public void aramayap(){

        Intent i=new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:05511231607"));
        startActivity(i);
    }
    public void rehbereEris(){

        Toast.makeText(this,"REHBERE ERİŞİLDİ !",Toast.LENGTH_LONG).show();
    }
}
