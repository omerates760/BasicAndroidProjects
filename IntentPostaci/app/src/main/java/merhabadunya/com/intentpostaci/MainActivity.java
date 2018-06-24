package merhabadunya.com.intentpostaci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calistir(View goster){
        Intent aktar=new Intent(this,Postaci.class);
        startActivity(aktar);

    }
}
