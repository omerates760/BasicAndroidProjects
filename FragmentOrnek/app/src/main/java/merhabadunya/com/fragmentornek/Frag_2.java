package merhabadunya.com.fragmentornek;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by omera on 28.01.2018.
 */

public class Frag_2 extends Fragment {
    private static final String Tag="Fragment1";
    private Button btnFrag1;
    private Button btnFrag2;
    private Button btnFrag3;
    private Button btnFrag4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.frag_2,container,false);
            btnFrag1=view.findViewById(R.id.AnaSayfa);
        btnFrag2=view.findViewById(R.id.Hakkimizda);
        btnFrag3=view.findViewById(R.id.Referanslar);
        btnFrag4=view.findViewById(R.id.Iletisim);

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Fragment1",Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setmViewPager(0);
            }
        });
        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Fragment2",Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setmViewPager(1);
            }
        });
        btnFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Fragment3",Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setmViewPager(2);
            }
        });
        btnFrag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Fragment4",Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setmViewPager(3);
            }
        });

        return view;
    }
}
