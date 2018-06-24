package merhabadunya.com.klasoroluturma_izin;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    //izin verilirse geriye bir kod dönecek o kodu burda tutucaz
    private static final int YAZMA_IZNI=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(this);


  }

    @Override
    public void onClick(View view) {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
             {
                 if(izinVarmi()==true)
                 {
                     KlasorOlustur();
                 }
                 else
                 {
                     iziniste();
                 }
             }
            else
             {
                KlasorOlustur();
             }

    }
    public void iziniste(){
        String[] izinler=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this,izinler,YAZMA_IZNI);
    }
    public Boolean izinVarmi(){
        String[] izinler=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        int izinSayisi=0;
        for (String gecici :izinler)
        {
                izinSayisi= ActivityCompat.checkSelfPermission(this,"İzinler");
                //EĞER İZİN VARSA -1 DÖNDER
            if(!(izinSayisi==getPackageManager().PERMISSION_GRANTED)){
                //izin verilmemişsse if te tanımladık
                return false;
            }

        }


    return true;
    }
    public void KlasorOlustur(){

        File dosya=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"YeniKlasör");
        if(dosya.exists())
        {
            Toast.makeText(this,"Bu Klasör sisteminizde zaten var !",Toast.LENGTH_LONG).show();
        }
        else
        {
            Boolean durum=dosya.mkdir();
            if(durum==true)
            {
                Toast.makeText(this,"Klasör oluştu !",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"Klasör oluşturulamadı !",Toast.LENGTH_LONG).show();
            }
        }
    }
    //İSTENİLEN İZİN SONUCU KULLANICI KARARINI-NELER YAPILACAĞINI BURDAN YAPIYORUZ


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
           Boolean izinVerildi=true;
            switch (requestCode)
            {
                case YAZMA_IZNI:
                    for(int durum :grantResults)
                    {
                        izinVerildi=izinVerildi && (durum== PackageManager.PERMISSION_GRANTED);
                    }
                break;
                default:
                    izinVerildi=false;

                    break;
            }
            if(izinVerildi)
            {
                KlasorOlustur();
            }
            else
            {
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
                {
                    Toast.makeText(this,"diske yazmak için iznin gerekiyor budı bıdı",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this,"gerekli izni vermedin canın cehenneme !!",Toast.LENGTH_LONG).show();
                }

            }
    }
}
