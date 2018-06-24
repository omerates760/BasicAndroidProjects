package merhabadunya.com.alarmprojects;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorular extends AppCompatActivity {
    private TextView kelime1, kelime2, kelime3;
    private EditText cevir1, cevir2, cevir3;
    public static boolean e1 = false, e2 = false, e3 = false;

    Context c = Sorular.this;
    public void Kontrol() {
        if (e1 == true && e2 == true && e3 == true) {

            Toast.makeText(c, "BAŞARILI", Toast.LENGTH_LONG).show();
            AlarmReciever dd = new AlarmReciever();
            dd.ringtone.stop();
            finish();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorular);
        kelime1 = findViewById(R.id.kelime1);
        kelime2 = findViewById(R.id.kelime2);
        kelime3 = findViewById(R.id.kelime3);

        Random k1 = new Random();
        final int aaa,bbb,ccc;
        aaa=k1.nextInt(MainActivity.listDataEn.size());
        bbb=k1.nextInt(MainActivity.listDataEn.size());
        ccc=k1.nextInt(MainActivity.listDataEn.size());

        kelime1.setText(MainActivity.listDataEn.get(aaa));
        kelime2.setText(MainActivity.listDataEn.get(bbb));
        kelime3.setText(MainActivity.listDataEn.get(ccc));


        cevir1 = findViewById(R.id.cevir1);
        cevir2 = findViewById(R.id.cevir2);
        cevir3 = findViewById(R.id.cevir3);

        cevir1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().equals(MainActivity.listDataTR.get(aaa))) {
                    e1 = true;
                    cevir1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.tik, 0);


                } else {
                    e1 = false;
                    cevir1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.yanlis, 0);

                }
                Kontrol();


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cevir2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals(MainActivity.listDataTR.get(bbb))) {
                    e2 = true;
                    cevir2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.tik, 0);


                } else {
                    e2 = false;
                    cevir2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.yanlis, 0);


                }
                Kontrol();

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        cevir3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (charSequence.toString().equals(MainActivity.listDataTR.get(ccc))) {
                    e3 = true;
                    cevir3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.tik, 0);

                    Log.e("SORULAR","XXX");
                } else {
                    e3 = false;
                    cevir3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.yanlis, 0);


                }
                Kontrol();


            }


            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }
}
