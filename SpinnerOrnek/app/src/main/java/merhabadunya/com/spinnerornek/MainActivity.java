package merhabadunya.com.spinnerornek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp1;
    Spinner sp2;
    TextView txt1;
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        txt1=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);

        ArrayAdapter adap=ArrayAdapter.createFromResource(this,R.array.Gunler,android.R.layout.simple_spinner_item);
        sp1.setAdapter(adap);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);

        ArrayAdapter adap1 = ArrayAdapter.createFromResource(this,R.array.Mevsimler, android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adap1);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView gecici= (TextView) view;
        Toast.makeText(this,"Seçilen Öğe=  "+gecici.getText()+"\n Sırası=  "+adapterView.getSelectedItemPosition(),Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
