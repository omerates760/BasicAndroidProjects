package merhabadunya.com.basedinamiklistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.ulkelerListesi);


        OmerAtes adapter=new OmerAtes(this);
        liste.setAdapter(adapter);

    }
}
