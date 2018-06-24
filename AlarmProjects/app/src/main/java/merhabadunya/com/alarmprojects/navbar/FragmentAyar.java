package merhabadunya.com.alarmprojects.navbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import merhabadunya.com.alarmprojects.MainActivity;
import merhabadunya.com.alarmprojects.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAyar extends Fragment {

        EditText tr,en;
        Button tikla;
        FirebaseDatabase FD;
        DatabaseReference DR;

    public FragmentAyar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ayar, container, false);
        // Inflate the layout for this fragment

       tr=view.findViewById(R.id.editText);
        en=view.findViewById(R.id.editText2);

       tikla=view.findViewById(R.id.button2);

        FD=FirebaseDatabase.getInstance();
        DR=FD.getReference("kelimeler");
        tikla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // String key=DR.push().getKey();
               DatabaseReference databaseReference=FD.getReference("kelimeler");
               databaseReference.child(tr.getText().toString()).setValue(en.getText().toString());
                Toast.makeText(getContext(), "KELİME EKLENDİ !", Toast.LENGTH_SHORT).show();
                tr.setText("");
                en.setText("");
            }
        });

        return view;

    }

}
