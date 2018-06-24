package merhabadunya.com.alarmprojects.navbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import merhabadunya.com.alarmprojects.MainActivity;
import merhabadunya.com.alarmprojects.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKelime extends Fragment {
    RecyclerView myRec;
    public static MyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_kelime, container, false);
        myRec = view.findViewById(R.id.myRecl);

        RecyclerView.LayoutManager LM = new LinearLayoutManager(getContext().getApplicationContext());
        myRec.setHasFixedSize(true);
        myRec.setLayoutManager(LM);
        myRec.setItemAnimator(new DefaultItemAnimator());
        myRec.addItemDecoration(new DividerItemDecoration(getContext().getApplicationContext(), LinearLayout.VERTICAL));

        adapter = new MyAdapter(MainActivity.listDataTR,MainActivity.listDataEn);

        myRec.setAdapter(adapter);


        return view;
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        List<String> listArray;
        ArrayList<String> listDataEn;
        public MyAdapter(ArrayList<String> listDataEn, List<String> List) {
            this.listArray = List;
            this.listDataEn=listDataEn;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String data = listArray.get(position);
            String data1=listDataEn.get(position);
            holder.MyText.setText(data);
            holder.MyText1.setText(data1);


        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView MyText,MyText1;

            public MyViewHolder(View itemView) {
                super(itemView);
                MyText = itemView.findViewById(R.id.Mytext);
                MyText1 = itemView.findViewById(R.id.Mytext1);
            }
        }

        @Override
        public int getItemCount() {
            return listArray.size();
        }
    }


}
