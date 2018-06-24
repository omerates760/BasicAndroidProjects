package merhabadunya.com.db;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ListActivity {
    Button ekle,sil;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //UYGULAMA AÇILIR AÇILMAZ DB AÇILSIN
        final veri_katmani vk=new veri_katmani(this);
        vk.ac();

        //BÜTÜN KULLANICILARI LİSTEDE GÖSTER
        List<kullanici> kullanicilar=vk.listele();
        final ArrayAdapter<kullanici> adapter=new ArrayAdapter<kullanici>(this,android.R.layout.simple_list_item_1,kullanicilar);
        setListAdapter(adapter);

        ekle=findViewById(R.id.Ekle);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullanici k=new kullanici("ali demir",1);
                vk.kullaniciOlustur(k);
                adapter.add(k);
            }
        });
        sil=findViewById(R.id.Sil);
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullanici k=(kullanici) getListAdapter().getItem(0);
                vk.kullaniciSil(k);
                adapter.remove(k);
            }
        });
        list=findViewById(R.id.Liste);
    }
}
