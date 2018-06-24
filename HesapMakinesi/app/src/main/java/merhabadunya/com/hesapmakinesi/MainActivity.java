package merhabadunya.com.hesapmakinesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button hesapla;
    EditText nm1,nm2;
    TextView goster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hesapla=findViewById(R.id.button);
        nm1=findViewById(R.id.txt1);
        goster=findViewById(R.id.goster);
        nm2=findViewById(R.id.txt2);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1,s2;
                goster.setText(Integer.parseInt(String.valueOf(nm1))+Integer.parseInt(String.valueOf(nm2)));

            }
        });

    }
}
