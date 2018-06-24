package merhabadunya.com.konumuygulamasi2;

import android.Manifest;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Collections;
import java.util.List;

import merhabadunya.com.konumuygulamasi2.Konum.Loc;
import merhabadunya.com.konumuygulamasi2.Konum.MapActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private KonumDBhelper dbHelper;
    public KonumAdapter adapter;
    private String filter = "";
    private static final String TAG = "MainActivity";
    private static final int HATA = 9001;

    //GEOFENCE DEĞİŞKENLER


    Button btnMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //initialize the variables
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //populate recyclerview
        populaterecyclerView(filter);

        if (ServicesCalistir()) {
            init();
        }
        ServisCalisiyormu();
        if (!ServisCalisiyormu()) {
            //Toast.makeText(this, "SERVİS" + ServicesCalistir(), Toast.LENGTH_SHORT).show();
            Intent servisIntent = new Intent(MainActivity.this, Loc.class);
            startService(servisIntent);

        }

    }




    private Boolean ServisCalisiyormu() {//Servis Çalışıyor mu kontrol eden fonksiyon
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo services : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (Loc.class.getName().equals(services.service.getClassName())) {

                return true;

            }
        }

        return false;

    }

    private void init() {
        btnMap = findViewById(R.id.button);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);

            }
        });

    }

    public Boolean ServicesCalistir() {

        Log.d(TAG, "Services version okey");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "Services: Çalışıyor");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, HATA);
            dialog.show();
        } else {
            Toast.makeText(this, "Servis çalışmıyor", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void populaterecyclerView(String filter) {
        dbHelper = new KonumDBhelper(this);
        adapter = new KonumAdapter(dbHelper.KonumListe(filter), this, mRecyclerView);
        mRecyclerView.setAdapter(adapter);


    }

}