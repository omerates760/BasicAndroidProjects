package merhabadunya.com.mediaplayer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cal,dur;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal=findViewById(R.id.button);
        dur=findViewById(R.id.button2);
        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.a);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.button)
        {

               mediaPlayer.start();
            cal.setEnabled(false);
            dur.setEnabled(true);

        }
        else if(view.getId()==R.id.button2){

            mediaPlayer.pause();
            dur.setEnabled(false);
            cal.setEnabled(true);
        }

    }
}
