package merhabadunya.com.checkboxtogglebutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener {

    CheckBox cek;
    ToggleButton btn;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cek=(CheckBox) findViewById(R.id.checkBox);
        cek.setOnClickListener(this);
        btn=(ToggleButton) findViewById(R.id.toggleButton);
        btn.setOnCheckedChangeListener(this);
        rl=(RelativeLayout) findViewById(R.id.relativ);
    }

    @Override
    public void onClick(View view) {
        CheckBox gecici=(CheckBox)view;
        if(gecici.isChecked())
        {
            Toast.makeText(this,"Tikleme seçildi",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Tikleme kaldırıldı ",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
        {

            rl.setBackgroundColor(Color.BLUE);
        }
        else
        {
            rl.setBackgroundColor(Color.GREEN);
        }
    }
}
