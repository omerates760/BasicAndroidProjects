package merhabadunya.com.konumuygulamasi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KonumEkle extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mAgeEditText;

    private Button mAddBtn;

    private KonumDBhelper konumDBhelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konum_ekle);

        mNameEditText = (EditText)findViewById(R.id.KonumEkleX);
        mAgeEditText = (EditText)findViewById(R.id.KonumEkleY);

        mAddBtn = (Button)findViewById(R.id.KonumEkleButon);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                savePerson();
            }
        });
    }
    private void savePerson(){
        String kx = mNameEditText.getText().toString().trim();
        String ky = mAgeEditText.getText().toString().trim();

        konumDBhelper = new KonumDBhelper(this);

        if(kx.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(ky.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an age", Toast.LENGTH_SHORT).show();
        }



        //create new person
        KonumModel konum = new KonumModel();
        konumDBhelper.YeniKonum(konum);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }
    private void goBackHome(){
        startActivity(new Intent(KonumEkle.this, MainActivity.class));
    }
}
