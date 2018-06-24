package merhabadunya.com.basitfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Configuration configuration=getResources().getConfiguration();
        if(configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            Hakkimizda hakkimizda=new Hakkimizda();
            fragmentTransaction.replace(R.id.main,hakkimizda);

        }else
        {
            Galeri galeri= new Galeri();
            fragmentTransaction.replace(R.id.main,galeri);
        }
        fragmentTransaction.commit();


    }
}
