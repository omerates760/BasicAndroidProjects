package merhabadunya.com.dinamiklistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by omera on 16.01.2018.
 */

public class GenelListview extends ArrayAdapter<String> {
    Context ct;
    String[] ulkead;
    String[] ulketanim;
    int[] resimler;

    GenelListview(Context c, String[] ulkeAd , String[] ulkeTanim, int[] resimler){
        // BU SÜPER KLASNIN Bİ ÖNEMİ YOK,HATA ALMAYALIM DİYE YAPTIK
        super(c,R.layout.tek_satir,R.id.textView,ulkeAd);
        this.ct=c;
        this.ulkead=ulkeAd;
        this.ulketanim=ulkeTanim;
        this.resimler=resimler;


    }

    @NonNull
    @Override// VAROLAN METOTU KENDİMİZE GÖRE UYARLAMAK DEMEK
    public View getView(int position, View convertView,ViewGroup parent) {
        //BU GETVİEW METOTU LİSTELEMEDEKİ TEK SATIR SAYISI KADAR ÇALIŞTIRILARAK UYGULANIR
        View goster=convertView;
        if(goster==null)
        {
            LayoutInflater lf= (LayoutInflater) ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
            goster=lf.inflate(R.layout.tek_satir,parent,false);

        }


        ImageView tek_img=goster.findViewById(R.id.imageView);
        TextView tek_baslik=goster.findViewById(R.id.textView);
        TextView tek_tanim=goster.findViewById(R.id.textView2);

        tek_img.setImageResource(resimler[position]);
        tek_baslik.setText(ulkead[position]);
        tek_tanim.setText(ulketanim[position]);



        return goster;
    }
}
