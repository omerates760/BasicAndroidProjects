package merhabadunya.com.fragmentornek;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String Tag="MainActivity";
    private StartPageAdapter mStartPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartPageAdapter=new StartPageAdapter(getSupportFragmentManager());
        mViewPager=findViewById(R.id.Main);
        SetupViewPager(mViewPager);
    }
    private void SetupViewPager(ViewPager viewPager)
    {
        StartPageAdapter adapter=new StartPageAdapter(getSupportFragmentManager();
        adapter.AddFragment(new Frag_1(),"Fragment11");
        adapter.AddFragment(new Frag_2(),"Fragment2m");
        adapter.AddFragment(new Frag_3(),"Fragment3m");
        adapter.AddFragment(new Frag_4(),"Fragment4m");
        viewPager.setAdapter(adapter);
    }
    public void setViewPager(int fragNum){
        mViewPager.setCurrentItem(fragNum);

    }
}
