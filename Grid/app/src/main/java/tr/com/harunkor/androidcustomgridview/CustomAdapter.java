package tr.com.harunkor.androidcustomgridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by harunkor on 08.09.2017.
 */

public class CustomAdapter extends BaseAdapter {

    String [] result;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Activity activity, String[] itemlist) {
        // TODO Auto-generated constructor stub
        result=itemlist;
        context=activity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView textitem;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;


        rowView = inflater.inflate(R.layout.grid_item_row, null);
        holder.textitem=(TextView) rowView.findViewById(R.id.itemtext);

        holder.textitem.setText(result[position]);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Tıklandı "+result[position], Toast.LENGTH_SHORT).show();
            }
        });


        return rowView;


    }





}
