package merhabadunya.com.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calistir(View goster)
    {
        Intent i=null;
        if (R.id.button==goster.getId())
        {
            Intent aktar=new Intent(i.ACTION_VIEW);
            aktar.setData(Uri.parse("geo:41.038286,28.970330"));
            startActivity(aktar);

        }
    }
}
