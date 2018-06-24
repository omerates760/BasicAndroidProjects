package com.mobilhanem.eventbusexample;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobilhanem.eventbusexample.event.ActivityToActivityEvent;
import com.mobilhanem.eventbusexample.event.ActivityToFragmentEvent;
import com.mobilhanem.eventbusexample.fragment.FirstFragment;
import com.mobilhanem.eventbusexample.fragment.SecondFragment;
import com.mobilhanem.eventbusexample.model.User;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private EditText editText;
    private Button sendBtn, sendData;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragments();

        sendBtn = (Button)findViewById(R.id.sendBtnMsg);
        editText = (EditText)findViewById(R.id.edittextMsg);
        sendData = (Button)findViewById(R.id.sendBtnObject);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()>0){
                    GlobalBus.getBus().post(new ActivityToFragmentEvent(editText.getText().toString()));
                }
            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                user = new User("Alper","Beyler","Bilgisayar Mühendisi",25);
                GlobalBus.getBus().postSticky(new ActivityToActivityEvent(user));
                startActivity(intent);
            }
        });
    }

    private void addFragments() {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_one,new FirstFragment(),"fragmentOne");
        fragmentTransaction.add(R.id.fragment_two,new SecondFragment(),"fragmentTwo");
        fragmentTransaction.commit();
    }
}
