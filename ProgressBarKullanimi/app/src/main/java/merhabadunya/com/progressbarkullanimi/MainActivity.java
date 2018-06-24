package merhabadunya.com.progressbarkullanimi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<user> kullaniciList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rec);

        mAdapter=new UserAdapter(kullaniciList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        
        userData();
    }

    private void userData() {

        user movie = new user("A", "Action & Adventure", "2015");
        kullaniciList.add(movie);

        movie = new user("B", "Animation, Kids & Family", "2015");
        kullaniciList.add(movie);

        movie = new user("C", "Action", "2015");
        kullaniciList.add(movie);

        movie = new user("D", "Animation", "2015");
        kullaniciList.add(movie);

        movie = new user("E", "Science Fiction & Fantasy", "2015");
        kullaniciList.add(movie);

        movie = new user("F", "Action", "2015");
        kullaniciList.add(movie);

        movie = new user("G", "Animation", "2009");
        kullaniciList.add(movie);

        movie = new user("H", "Science Fiction", "2009");
        kullaniciList.add(movie);

        movie = new user("K", "Animation", "2014");
        kullaniciList.add(movie);

        movie = new user("L", "Action & Adventure", "2008");
        kullaniciList.add(movie);

        movie = new user("M", "Science Fiction", "1986");
        kullaniciList.add(movie);

        movie = new user("N", "Animation", "2000");
        kullaniciList.add(movie);

        movie = new user("P", "Science Fiction", "1985");
        kullaniciList.add(movie);

        movie = new user("R", "Action & Adventure", "1981");
        kullaniciList.add(movie);

        movie = new user("S", "Action & Adventure", "1965");
        kullaniciList.add(movie);

        movie = new user("T", "Science Fiction & Fantasy", "2014");
        kullaniciList.add(movie);


        movie = new user("B", "Animation, Kids & Family", "2015");
        kullaniciList.add(movie);

        movie = new user("C", "Action", "2015");
        kullaniciList.add(movie);

        movie = new user("D", "Animation", "2015");
        kullaniciList.add(movie);

        movie = new user("E", "Science Fiction & Fantasy", "2015");
        kullaniciList.add(movie);

        movie = new user("F", "Action", "2015");
        kullaniciList.add(movie);

        movie = new user("G", "Animation", "2009");
        kullaniciList.add(movie);

        movie = new user("H", "Science Fiction", "2009");
        kullaniciList.add(movie);

        movie = new user("K", "Animation", "2014");
        kullaniciList.add(movie);

        movie = new user("L", "Action & Adventure", "2008");
        kullaniciList.add(movie);

        movie = new user("M", "Science Fiction", "1986");
        kullaniciList.add(movie);

        movie = new user("N", "Animation", "2000");
        kullaniciList.add(movie);

        movie = new user("P", "Science Fiction", "1985");
        kullaniciList.add(movie);

        movie = new user("R", "Action & Adventure", "1981");
        kullaniciList.add(movie);

        movie = new user("S", "Action & Adventure", "1965");
        kullaniciList.add(movie);

        movie = new user("T", "Science Fiction & Fantasy", "2014");
        kullaniciList.add(movie);
        mAdapter.notifyDataSetChanged();
    }
}
