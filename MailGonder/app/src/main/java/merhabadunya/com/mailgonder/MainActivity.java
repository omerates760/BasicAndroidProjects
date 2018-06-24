package merhabadunya.com.mailgonder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Calistir(View goster){

        //İSTEK DEMEK >>INTENT
        Intent aktar=null,chooer=null;

        aktar=new Intent(aktar.ACTION_SEND);
        //MAİL OLDUĞUNU ANLAMAK İÇİN BUNU KULLAN
        aktar.setData(Uri.parse("mailto:"));
        String[] mailler={"omerates760@gmail.com", "omerates@hotmail.com"};
        aktar.putExtra(Intent.EXTRA_EMAIL ,mailler);
        aktar.putExtra(Intent.EXTRA_SUBJECT ,"Deneme Konu");
        aktar.putExtra(Intent.EXTRA_TEXT,"MERHABA BU BİR İÇERİK");
        //MAİLLER İLGİLİ İSTEK OLDUĞUNU ANLAMAK İÇİN BUNU YAP
        aktar.setType("message/rfc822");
        chooer=Intent.createChooser(aktar,"Mail Gönder");
        startActivity(chooer);
    }
}
