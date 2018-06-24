package merhabadunya.com.listethree;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omera on 24.01.2018.
 */

public class CustomAdap extends ArrayAdapter<VeriSatir> {
    Context ct;
    int layoutid;
    List<VeriSatir> veri=null;

    public CustomAdap(@NonNull Context context, int resource, @NonNull List<VeriSatir> objects) {
        super(context, resource, objects);
        this.layoutid=resource;
        this.ct=context;
        this.veri=objects;
    }
    public class VeriKilit{
        ImageView resim;
        TextView isimler;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        VeriKilit kilit=null;
        if(convertView==null)
        {
            LayoutInflater inf=((Activity)ct).getLayoutInflater();
            convertView=inf.inflate(layoutid,parent,false);
            kilit =new VeriKilit();
            kilit.isimler=convertView.findViewById(R.id.textView);
            kilit.resim=convertView.findViewById(R.id.imageView);

            convertView.setTag(kilit);
        }
        else {
            kilit = (VeriKilit) convertView.getTag();
        }



        return convertView;
    }
}
