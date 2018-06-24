package merhabadunya.com.alarmprojects.navbar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import merhabadunya.com.alarmprojects.AlarmReciever;
import merhabadunya.com.alarmprojects.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {

    private Button StartAlarmBtn;
    private TimePickerDialog timePickerDialog;
    final static int REQUEST_CODE = 1;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ) {
        view = inflater.inflate(R.layout.fragment_fragment_main,
                container, false);


         StartAlarmBtn =view.findViewById(R.id.sayfa);
        StartAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickerDialog(false);
            }
        });




        return view;
    }
    private void openPickerDialog(Boolean is24hour) {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24hour);
        timePickerDialog.setTitle("ALARM KUR");
        timePickerDialog.show();
    }
    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, i);
            calSet.set(Calendar.MINUTE, i1);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);
            if (calSet.compareTo(calNow) <= 0) {

                calSet.add(Calendar.DATE, 1);
            }

            setAlarm(calSet);
        }

    };

    private void setAlarm(Calendar alarmCalender) {


        //MainActivity dd=new MainActivity();

        // BURASI HATALI KISIM

        //ALARMRECİEVER CLASSINA GİTMİYOR İNTENT

        Toast.makeText(getActivity(), "ALARM KURULDU !!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity(), AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), REQUEST_CODE, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmCalender.getTimeInMillis(), pendingIntent);


    }


}

