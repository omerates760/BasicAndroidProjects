package merhabadunya.com.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img1,img2,img3,img4,img5,img6,img7;
    @Override
    //İSTEĞİMİZ BİRİNCİ RESME TIKLANILDIĞINDA RESİM KAYBOLSUN VE İKİNCİ RESİM GÖRÜLSÜN
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.imageView3);
        img2=findViewById(R.id.imageView4);
        img3=findViewById(R.id.imageView5);
        img4=findViewById(R.id.imageView6);
        img5=findViewById(R.id.imageView7);
        img6=findViewById(R.id.imageView8);
        img7=findViewById(R.id.imageView9);


        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
    }
    String ddd;
    @Override
    public void onClick(View view) {
        for( int i=2;i>1;i++) {
            if (view.getId() == R.id.imageView3) {
                img1.setVisibility(View.GONE);
                img2.setVisibility(View.VISIBLE);
                break;
            } else if (view.getId() == R.id.imageView4) {
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.VISIBLE);
                break;
            } else if (view.getId() == R.id.imageView5) {
                img3.setVisibility(View.GONE);
                img4.setVisibility(View.VISIBLE);
                break;
            } else if (view.getId() == R.id.imageView6) {
                img4.setVisibility(View.GONE);
                img5.setVisibility(View.VISIBLE);
                break;
            } else if (view.getId() == R.id.imageView7) {
                img5.setVisibility(View.GONE);
                img6.setVisibility(View.VISIBLE);
                break;
            } else if (view.getId() == R.id.imageView8) {
                img6.setVisibility(View.GONE);
                img7.setVisibility(View.VISIBLE);
                break;
            }
            continue;

        }
    }
}
