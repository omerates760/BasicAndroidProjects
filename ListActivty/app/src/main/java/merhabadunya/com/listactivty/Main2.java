package merhabadunya.com.listactivty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2 extends AppCompatActivity {
    String[] mevsimler={"Pazartesi", "Sali","Çarsamba","Persembe", "Cuma", "Cumartesi","Pazar"};
    ListView liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        liste=(ListView) findViewById(R.id.liste);

        ArrayAdapter<String> dap=new ArrayAdapter<String>(this,R.layout.activity_tek__satir,R.id.txt,mevsimler);
        liste.setAdapter(dap);
    }
}
