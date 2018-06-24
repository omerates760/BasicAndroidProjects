package merhabadunya.com.fragmentornek;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omera on 28.01.2018.
 */

public class StartPageAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> myFragment=new ArrayList<>();
    private final List<String> myFragmentTitle=new ArrayList<>();

    public StartPageAdapter(FragmentManager fm) {
        super(fm);
    }
    public void AddFragment(Fragment fragment,String Title)    {

        myFragment.add(fragment);
        myFragmentTitle.add(Title);
    }

    @Override
    public Fragment getItem(int position) {

        return myFragment.get(position);

    }

    @Override
    public int getCount() {

        return myFragment.size();
    }
}
