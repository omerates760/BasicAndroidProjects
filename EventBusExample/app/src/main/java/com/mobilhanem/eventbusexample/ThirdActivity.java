package com.mobilhanem.eventbusexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mobilhanem.eventbusexample.event.ActivityToActivityEvent;
import com.mobilhanem.eventbusexample.model.User;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ThirdActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtSurname;
    private TextView txtAge;
    private TextView txtDepartment;
    @Override
    protected void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtName = (TextView)findViewById(R.id.txtName);
        txtSurname = (TextView)findViewById(R.id.txtSurname);
        txtDepartment = (TextView)findViewById(R.id.txtDepartment);
        txtAge = (TextView)findViewById(R.id.txtAge);

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(ActivityToActivityEvent event) {
        txtName.setText("Ad:"+" "+event.getUser().getName());
        txtSurname.setText("Soyad:"+" "+event.getUser().getSurname());
        txtDepartment.setText("Bölüm:"+" "+event.getUser().getDepartment());
        txtAge.setText("Yaş:"+" "+String.valueOf(event.getUser().getAge()));
    }
}
