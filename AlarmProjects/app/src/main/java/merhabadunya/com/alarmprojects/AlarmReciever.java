package merhabadunya.com.alarmprojects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by omera on 9.02.2018.
 */

public class AlarmReciever extends BroadcastReceiver {
    public static Ringtone ringtone;

    @Override
    public void onReceive(Context context, Intent ıntent) {



        Toast.makeText(context, "ALARM ÇALIYOR !", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context,Sorular.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
         ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();


    }




}
