package merhabadunya.com.basedinamiklistview;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class TekSatir{

    String ulke;
    String tanim;
    int bayrak;

    TekSatir(String u, String t, int b){
        this.ulke=u;
        this.tanim=t;
        this.bayrak=b;
    }
}

class ViewYerTutucu{
    ImageView img;
    TextView ulke;
    TextView tanim;

    ViewYerTutucu(View v){
        img=  v.findViewById(R.id.iVBayrak);
        ulke=  v.findViewById(R.id.tvUlke);
        tanim=  v.findViewById(R.id.tvTanim);

    }

}


public class OmerAtes extends BaseAdapter {

    ArrayList liste;
    Context context;

    OmerAtes(Context c){
        context=c;

        liste=new ArrayList();
        Resources kaynaklar=c.getResources();
        String[] ulkeAdlari=kaynaklar.getStringArray(R.array.ulkeAdlari);
        String[] ulkeTanimlari=kaynaklar.getStringArray(R.array.ulke_tanimlari);
        int[] bayrakResimleri={R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
                R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,
                R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12,
                R.drawable.a13, R.drawable.a14, R.drawable.a15,};

        for (int k=0; k<15; k++)
        {


            liste.add(new TekSatir(ulkeAdlari[k],ulkeTanimlari[k], bayrakResimleri[k]));

        }

    }



    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int i) {
        return liste.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View satir=view;
        ViewYerTutucu yerTutucu=null;
        if(satir==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            satir=inflater.inflate(R.layout.tek_satir,viewGroup,false);
            yerTutucu=new ViewYerTutucu(satir);
            satir.setTag(yerTutucu);
        }
        else{

            yerTutucu= (ViewYerTutucu) satir.getTag();
        }


        TekSatir gecici= (TekSatir) liste.get(i);

        yerTutucu.img.setImageResource(gecici.bayrak);
        yerTutucu.ulke.setText(gecici.ulke);
        yerTutucu.tanim.setText(gecici.tanim);

        return satir;
    }
}
