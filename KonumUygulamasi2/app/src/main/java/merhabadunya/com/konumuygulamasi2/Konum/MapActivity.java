package merhabadunya.com.konumuygulamasi2.Konum;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Location;

import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import merhabadunya.com.konumuygulamasi2.KonumAdapter;
import merhabadunya.com.konumuygulamasi2.KonumDBhelper;
import merhabadunya.com.konumuygulamasi2.KonumModel;
import merhabadunya.com.konumuygulamasi2.R;


/**
 * Created by omera on 15.03.2018.
 */

public class MapActivity extends AppCompatActivity
        implements

        OnMapReadyCallback
       {


    public static Double x, y;
    private KonumDBhelper konumDBhelper = new KonumDBhelper(MapActivity.this);
    private KonumModel konumModel;
    private KonumAdapter adapter;
    String filter = "";
    Boolean VeriAlindimi = new Boolean(false);


    //BURASI HARİTA AÇILDIĞINDA OLUŞTURULAN MARKER LAR .
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "SERVİS HAZIR", Toast.LENGTH_LONG).show();
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        ArrayList<KonumModel> liste = new ArrayList<>();
        SQLiteDatabase db = this.konumDBhelper.getWritableDatabase();
        Cursor satir = db.query(KonumDBhelper.TABLE_NAME, new String[]{KonumDBhelper.COLUMN_ID, KonumDBhelper.COLUMN_Konum_x, KonumDBhelper.COLUMN_Konum_y}, null, null, null, null, null);
        while (satir.moveToNext()) {

            KonumModel model = new KonumModel();
            model.setKonumX(satir.getDouble(1));
            model.setKonumY(satir.getDouble(2));
            liste.add(model);
            // Log.e("KONUM","X:"+model.getKonumX());
            //Log.e("KONUM","Y:"+model.getKonumY());
            MarkerOptions mark = new MarkerOptions().position(new LatLng(model.getKonumX(), model.getKonumY()));
            mMap.addMarker(mark);
        }


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {


                if (VeriAlindimi == false) {
                    LayoutInflater inflater = MapActivity.this.getLayoutInflater();
                    View v = inflater.inflate(R.layout.cap_aciklama_layout, null);


                    final EditText Cap = v.findViewById(R.id.Cap);
                    final EditText Aciklama = v.findViewById(R.id.Aciklama);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);


                    builder.setView(v);


                    builder.setPositiveButton("EKLE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Cap.equals("") || Aciklama.equals("")) {
                                //(Cap.getText().toString().matches("") && Aciklama.getText().toString().matches("")

                                Toast.makeText(MapActivity.this, "ALAN BOŞ BIRAKILMAZ", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();
                                VeriAlindimi = false;
                            } else {
                                VeriAlindimi = true;


                            }
                            if (VeriAlindimi == true) {
                                MarkerEkle(latLng, Double.valueOf(Cap.getText().toString()), Aciklama.getText().toString());
                                VeriAlindimi = false;

                            }


                        }
                    })
                            .setNegativeButton("EKLEME", null)
                            .create();
                    builder.show();


                }


            }

        });
    }


    private void MarkerEkle(LatLng latLng, Double Cap, String Aciklama) {
        x = latLng.latitude;
        y = latLng.longitude;

        konumModel = new KonumModel();
        konumModel.setKonumX(x);
        konumModel.setKonumY(y);
        konumModel.setAciklama(Aciklama);
        konumModel.setCap(Cap);
        konumDBhelper.YeniKonum(konumModel);

        adapter = new KonumAdapter(konumDBhelper.KonumListe(filter), MapActivity.this, KonumAdapter.mRecyclerV);
        KonumAdapter.mRecyclerV.setAdapter(adapter);
       // Toast.makeText(MapActivity.this, "Enlem :" + x + "\n Boylam: " + y + "\n Çap : " + Cap, Toast.LENGTH_SHORT).show();

        Toast.makeText(MapActivity.this, "KONUM LİSTEYE EKLENDİ !", Toast.LENGTH_SHORT).show();


        moveCamera(latLng, "-", Cap);
    }

    //private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int REQUEST_CODE = 1234;
    private GoogleMap mMap;
    Boolean mLokasyonIzin = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        izinAl();


        // initialize GoogleMaps
        //initGMaps();

        // create GoogleApiClient

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    private void moveCamera(LatLng latLng, String baslik, Double cap) {

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title(baslik);
        mMap.addMarker(markerOptions);

    }

    public void initMap() {
        Log.d("ONAY", "İZİNMAP");
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(MapActivity.this);
    }

    public void izinAl() {
        Log.d("ONAY", "İZİN AL");
        String[] izinler = {Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == getPackageManager().PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION) == getPackageManager().PERMISSION_GRANTED) {
                mLokasyonIzin = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this, izinler, REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, izinler, REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLokasyonIzin = false;
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults.length > 0) {

                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            mLokasyonIzin = false;
                            Log.d("ONAY", "İZİN HATA");
                            return;
                        }
                    }
                    mLokasyonIzin = true;
                    Log.d("ONAY", "İZİN ALINDI");

                    initMap();

                }

            }
        }
    }



}
