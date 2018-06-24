package merhabadunya.com.listevieww;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView liste;
    String[] Gunler={
            "Ocak ingilizce -> January",
            "Şubat ingilizce -> February",
            "Mart ingilizce -> March",
            "Nisan ingilizce -> April",
            "Mayıs ingilizce -> May",
            "Haziran ingilizce -> June",
            "Temmuz ingilizce -> July",
            "Ağustos ingilizce -> August",
            "Eylül ingilizce -> September",
            "Ekim ingilizce -> October",
            "Kasım ingilizce -> November",
            "Kasım ingilizce -> November",
            "Kasım ingilizce -> November",
            "Kasım ingilizce -> November",
            "Kasım ingilizce -> November",
            "Aralık ingilizce -> December"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=(ListView) findViewById(R.id.Liste);
        //android.R.layout.simple_list_item_1---Burda kullanıcıya veriler nasıl gösterileceği belirtilir
        //Gunler----veriler burdan okunucak
        ArrayAdapter<String> adap=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Gunler);
        liste.setAdapter(adap);
        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView gecici=(TextView) view;
        Toast.makeText(this,gecici.getText().toString(),Toast.LENGTH_SHORT).show();

    }
}
