package merhabadunya.com.listactivty;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity{
    String[] aylar={"1","2","3","4","5","6","7","8","9","0","10","11","12","13","14","15"};
    ListView liste;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        liste=getListView();
        ArrayAdapter<String> adap= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,aylar);
        liste.setAdapter(adap);}

         public void calistir(View goster){
        Intent aktar=new Intent(this,Main2.class);
        startActivity(aktar);

        }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView gecici=(TextView) v;
        Toast.makeText(this,((TextView) v).getText()+"\b ID="+id,Toast.LENGTH_LONG).show();

    }


}

