package merhabadunya.com.aramayap_rehbereeris;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by omera on 21.01.2018.
 */

public abstract class Calisma_izni extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //BİDEN FAZLA İZİN OLABİLRİĞİ DURUM İ.İN DİZİ TANIMLA,TEK TANIMLAMA
    //BackKod istenilen tüm izinler için ortak sayı tutar
    public void izinAl(final String[] istenilen_izin, final int BackKod){
        int izinKontrol= PackageManager.PERMISSION_GRANTED;
        //KULLANICIDAN NEDEN İSTEDİĞİMİZİ BELİRTMEK İÇİN POPUP KULLANILIRIZ ALTTA,
        Boolean mazeretGoster=false;
        //İSTENİLEN İZİNLER VERİLMİŞMİ BAKARLIM
        for(String gecici:istenilen_izin)
        {
            //izinkotntol=0 ise izin/izinler verilmiştir.-1 ise izinler verilmemiştir
            izinKontrol=izinKontrol+ ContextCompat.checkSelfPermission(this,gecici);
            /*
                    1   1    =1
                    1   0    =1
                    0   0    =0
                    1   0    =1

             */

             //MAZERET GOSTER FALSE TUR,EĞER COMPAT TRUE DÖNERSE 1  0 >1 YANİ TRUE DÖNER
            //mazeretgoster =true ise kullanıcı izni reddetmiştir ona mazeret sun
            //mazeretgoster=false ise kullanıcıya ilk defa izin sorulmuştur
            mazeretGoster=mazeretGoster || ActivityCompat.shouldShowRequestPermissionRationale(this,gecici);

        }
        if(izinKontrol !=PackageManager.PERMISSION_GRANTED)
        {
            //YANİ BÜTÜN İZİNLER VERİLMEMİŞSSE BUNLARI YAP
            //o zaman mazeret gösterelim ki izin versin
             if(mazeretGoster==true)
             {
                 AlertDialog.Builder build= new AlertDialog.Builder(this);
                 build.setTitle("Neden İzin Vermelisin ?");
                 build.setMessage("Arama yapmak istiyorsan bu izne ihtiyaç var !");
                 build.setNegativeButton("İZİN VERMİYORUM", new DialogInterface.OnClickListener() {

                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                     }
                 });
                 build.setPositiveButton("İZİN VERMEK İSTİYORUM", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         ActivityCompat.requestPermissions(Calisma_izni.this,istenilen_izin,BackKod);
                     }
                 });
                 build.show();
             }
             else
             {
                 ActivityCompat.requestPermissions(Calisma_izni.this,istenilen_izin,BackKod);
             }
        }
        else
        {
            izinVerildi(BackKod);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int izinKontrol=PackageManager.PERMISSION_GRANTED;// 0 VAR
        for( int izindurumu : grantResults)
        {
            //izinkontrol 0 ise tüm izinler verilmiştir.
            izinKontrol=izinKontrol+izindurumu;
        }
        if((grantResults.length>0 )&& izinKontrol==PackageManager.PERMISSION_GRANTED)
        {
            izinVerildi(requestCode);
        }
        else{
            AlertDialog.Builder build= new AlertDialog.Builder(this);
            build.setTitle("izin lazım kardeşim");
            build.setMessage("Ayarlardan izin ver lütfen !");
            build.setNegativeButton("benim değil mi vermicem ", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            build.setPositiveButton("al sana izin !", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(intent);                }
            });
            build.show();

        }
    }

    public abstract void izinVerildi(int requestCode);
}
