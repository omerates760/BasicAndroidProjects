package merhabadunya.com.toastmesaj;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calistir(View goster){
        //TOAST MESAJI ALTTA BELLİ SANİYE GÖRÜNEN MESAJDIR
        if (R.id.button==goster.getId())
        {
            //context:kaynaklara erişmeyi sağlar
            Toast.makeText(this,"Merhaba Dünya",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast acilan=new Toast(this);
            LayoutInflater sayfa=getLayoutInflater();

            @SuppressLint("ResourceType") View v=sayfa.inflate(R.layout.ikinci, (ViewGroup) findViewById(R.layout.ikinci));
            acilan.setView(v);
            acilan.show();
        }


    }
}
