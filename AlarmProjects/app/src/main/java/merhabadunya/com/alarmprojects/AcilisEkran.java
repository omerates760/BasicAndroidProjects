package merhabadunya.com.alarmprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AcilisEkran extends AppCompatActivity {
    ImageView logo;
    TextView logoTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis_ekran);
        logo=findViewById(R.id.logo);
        logoTxt=findViewById(R.id.logoText);
        Animation myAnim= AnimationUtils.loadAnimation(AcilisEkran.this,R.anim.mytrans);
        logo.setAnimation(myAnim);
        logoTxt.setAnimation(myAnim);
        final Intent  i=new Intent(this,MainActivity.class);
        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }

            }
        });thread.start();
    }
}
