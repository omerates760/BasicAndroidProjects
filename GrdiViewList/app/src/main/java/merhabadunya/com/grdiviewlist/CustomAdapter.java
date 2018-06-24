package merhabadunya.com.grdiviewlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by omera on 30.04.2018.
 */

public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] osNameList, int[] osImages) {
        // TODO Auto-generated constructor stub
        result=osNameList;
        context=mainActivity;
        imageId=osImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Holder{
        TextView os_text;
        ImageView os_img;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        Holder holder=new Holder();
        View rowView;
        rowView=inflater.inflate(R.layout.sample_gridlayout,null);
        holder.os_text=(TextView)rowView.findViewById(R.id.os_texts);
        holder.os_img= (ImageView) rowView.findViewById(R.id.os_images);
        holder.os_text.setText(result[i]);
        holder.os_img.setImageResource(imageId[i]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You Clicked "+result[i], Toast.LENGTH_SHORT).show();
            }
        });


        return rowView;
    }
}
