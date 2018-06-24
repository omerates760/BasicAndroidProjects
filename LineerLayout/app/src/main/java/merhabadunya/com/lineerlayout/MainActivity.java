package merhabadunya.com.lineerlayout;

import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout lin;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lin=new LinearLayout(this);
        btn=new Button(this);
        txt=new TextView(this);
        LinearLayout.LayoutParams boyutlar=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        lin.setLayoutParams(boyutlar);
        LinearLayout.LayoutParams boyutlar1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btn.setLayoutParams(boyutlar1);
        LinearLayout.LayoutParams boyutlar2=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txt.setLayoutParams(boyutlar2);

        lin.setOrientation(LinearLayout.VERTICAL);
        btn.setText("Tıkla");
        btn.setTextColor(Color.CYAN);
        txt.setText("Tıklandım !");

        lin.addView(btn);
        lin.addView(txt);

        setContentView(lin);
    }
}
