package merhabadunya.com.konumuygulamasi2.Konum;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by omera on 16.04.2018.
 */

public class Loc extends Service{
    Timer timer;
    LocationManager locationManager;
    @Nullable
    @Override
    public IBinder onBind(Intent ıntent) {

        return null;

    }

    @Override
    public void onCreate() {                //Servis startService(); metoduyla çağrıldığında çalışır
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);// bilinen en son konumu alır.

                if (location != null) {


                }
            }
        },0,1000);


    }

}

