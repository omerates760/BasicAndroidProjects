package merhabadunya.com.gridview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    GridView liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        liste=findViewById(R.id.BayrakListe);

        OmerAdapter adap=new OmerAdapter(this );

        liste.setAdapter(adap);
    }
}
