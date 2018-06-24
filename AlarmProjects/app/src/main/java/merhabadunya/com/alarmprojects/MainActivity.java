package merhabadunya.com.alarmprojects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import merhabadunya.com.alarmprojects.navbar.FragmentAyar;
import merhabadunya.com.alarmprojects.navbar.FragmentKelime;
import merhabadunya.com.alarmprojects.navbar.FragmentMain;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase FDB;
    DatabaseReference DBR;
    public static ArrayList<String> listDataEn;
     public static ArrayList<String> listDataTR;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Ana Ekran");
                    FragmentMain fragmentMain=new FragmentMain();
                    android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content,fragmentMain,"FragmentName");
                    fragmentTransaction.commit();


                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Kelimeler");
                    FragmentKelime fragmentKelime=new FragmentKelime();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content,fragmentKelime,"FragmentName");
                    fragmentTransaction1.commit();

                    return true;
                case R.id.navigation_notifications:
                    setTitle("Kelime Ekle");
                    FragmentAyar fragmentAyar=new FragmentAyar();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content,fragmentAyar,"FragmentName");
                    fragmentTransaction2.commit();

                    return true;

            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("My Alarm");
        FragmentMain fragmentMain=new FragmentMain();
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragmentMain,"FragmentName");
        fragmentTransaction.commit();
        listDataEn=new ArrayList<>();
        listDataTR=new ArrayList<>();
        FDB = FirebaseDatabase.getInstance();
        DBR = FDB.getReference("kelimeler");

        DBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot key:dataSnapshot.getChildren()) {
                    String dataEn = key.getKey();
                    String dataTr = key.getValue().toString();
                    listDataTR.add(dataTr);
                    listDataEn.add(dataEn);
                    //listDataEn.add(dataTr);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }


}
