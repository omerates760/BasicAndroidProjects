package merhabadunya.com.gridview1;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by omera on 18.01.2018.
 */

class Ulke{

    int ulkeresmi;
    String ulkeadi;

    Ulke(int resim,String ad){
        this.ulkeresmi=resim;
        this.ulkeadi=ad;



    }

}
public class OmerAdapter extends BaseAdapter {
  Context cc;
    ArrayList<Ulke> tumUlkeler;
    OmerAdapter(Context ct){
        tumUlkeler=new ArrayList<Ulke>();
        Resources kaynak=ct.getResources();
        String[] ulkeAd=kaynak.getStringArray(R.array.ulkeAdlari);
        int[] resim={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
                R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,
                R.drawable.a14,R.drawable.a15,};
        cc=ct;

        for(int i=0;i<15;i++)
        {

           Ulke gecici=new Ulke(resim[i],ulkeAd[i]);
            tumUlkeler.add(gecici);

        }
    }



    @Override
    public int getCount() {

        return tumUlkeler.size();
    }

    @Override
    public Object getItem(int i) {
       return tumUlkeler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inf= (LayoutInflater) cc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View teksatir= inf.inflate(R.layout.tek_satir,viewGroup,false);
        ImageView img=teksatir.findViewById(R.id.imageView);
        img.setImageResource(tumUlkeler.get(i).ulkeresmi);

        return teksatir;

    }
}
