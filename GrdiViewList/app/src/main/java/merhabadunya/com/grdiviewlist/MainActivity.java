package merhabadunya.com.grdiviewlist;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {
    GridView gridView;
    public static String[] osNameList = {
            "Android",
            "iOS",
            "Linux",
            "MacOS",
            "MS DOS",
            "Symbian",
            "Windows 10",
            "Windows XP",
    };
    public static int[] osImages = {
            R.mipmap.a1,
            R.mipmap.a3,
            R.mipmap.a3,
            R.mipmap.a4,
            R.mipmap.a5,
            R.mipmap.a6,
            R.mipmap.a7,
            R.mipmap.a8,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.customgrid);
        gridView.setAdapter(new CustomAdapter(this,osNameList,osImages));
    }
}
