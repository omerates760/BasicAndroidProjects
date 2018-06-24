package merhabadunya.com.konumuygulamasi2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class KonumAdapter extends RecyclerView.Adapter<KonumAdapter.ViewHolder> {
    private List<KonumModel> konumModelList;
    private Context mContext;
    public static RecyclerView mRecyclerV;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView konumx;
        public TextView konumy;
        public TextView cap;
        public TextView idTxt;
        public TextView Aciklama;



        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            konumx = (TextView) v.findViewById(R.id.KonumX);
            konumy = (TextView) v.findViewById(R.id.KonumY);
            idTxt=v.findViewById(R.id.textView2);
            Aciklama=v.findViewById(R.id.aciklama);
            cap= v.findViewById(R.id.textView);

        }
    }
    public void add(int position, KonumModel konumModel ) {
        konumModelList.add(position, konumModel);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        konumModelList.remove(position);
        notifyItemRemoved(position);
    }
    public KonumAdapter(List<KonumModel> myDataset, Context context, RecyclerView recyclerView) {
        konumModelList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }
    @Override
    public KonumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.single_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final KonumModel konumModel = konumModelList.get(position);
        holder.konumx.setText("KonumX: " + konumModel.getKonumX());
        holder.konumy.setText("KonumY: " + konumModel.getKonumY());
        holder.idTxt.setText(String.valueOf(konumModel.getId()));
        holder.Aciklama.setText(konumModel.getAciklama());
        holder.cap.setText(String.valueOf(konumModel.getCap()));

        //holder.personOccupationTxtV.setText("Occupation: " + person.getOccupation());
       // Picasso.with(mContext).load(person.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.personImageImgV);

        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Seçiniz");
                builder.setMessage(" Konumu silmek istiyor musunuz ?");

                builder.setNeutralButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        KonumDBhelper dbHelper = new KonumDBhelper(mContext);
                        dbHelper.deletePersonRecord(konumModel.getId(), mContext);
                         mRecyclerV.removeViewInLayout(holder.layout.getRootView());
                      //  mRecyclerV.removeViewAt(position);
                        konumModelList.remove(position);

                        notifyItemRemoved(holder.getAdapterPosition());

                        notifyItemRangeChanged(position, konumModelList.size());
                        notifyDataSetChanged();


                    }
                });
                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });


    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return konumModelList.size();
    }


}
