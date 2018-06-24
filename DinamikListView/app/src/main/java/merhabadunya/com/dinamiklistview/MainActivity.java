package merhabadunya.com.dinamiklistview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView ulkeList;
    String[] ulkeAd;
    String[] ulkeTanim;

    int[] bayraklar={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5
            ,R.drawable.a6,R.drawable.a7,R.drawable.a8
            ,R.drawable.a9,R.drawable.a10,R.drawable.a11,
            R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ulkeList=findViewById(R.id.ulkeList);
        //STRİNG XML DE TANIMLALAMANAN DEĞERLERİ ÇAĞIRMAK İÇİN KULLANILIR
        Resources kaynak=getResources();
        ulkeAd=kaynak.getStringArray(R.array.UlkeAdlari);
        ulkeTanim=kaynak.getStringArray(R.array.UlkeTanimlari);

        GenelListview adap=new GenelListview(this,ulkeAd,ulkeTanim,bayraklar);

        ulkeList.setAdapter(adap);

    }

}
