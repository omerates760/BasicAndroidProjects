package merhabadunya.com.layoutinflater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static merhabadunya.com.layoutinflater.R.layout.activity_sub;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    LinearLayout ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater l= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View goster=l.inflate(activity_sub,null);
        // ANA LAYOUTA EKLEDİK ÖNCE
        /*
        rl=findViewById(R.id.activity_main);
        rl.addView(goster );
        */
        //ANA LAYOUTUN İÇİNDEKİ LAYOUTA EKLEDİK SONRA
        ln=findViewById(R.id.My_Layout);
        ln.addView(goster);
    }
}
