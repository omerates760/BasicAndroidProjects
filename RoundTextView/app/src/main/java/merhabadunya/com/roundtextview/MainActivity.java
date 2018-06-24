package merhabadunya.com.roundtextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread MyScreen = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    //5 saniye sonunda class davet et.
                    Intent tt=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(tt);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        MyScreen.start();
    }

    }

