package tr.com.harunkor.androidcustomgridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

   private GridView gridView;
   private Context context;
   private String [] itemlist={"A","B","C","E","K","P","S","Q","J","F","G","U","T","K","X","M","N","R"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView) findViewById(R.id.gridviewid);
        gridView.setAdapter(new CustomAdapter(this, itemlist));








    }
}
