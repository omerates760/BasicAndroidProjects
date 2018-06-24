package com.mobilhanem.eventbusexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobilhanem.eventbusexample.GlobalBus;
import com.mobilhanem.eventbusexample.R;
import com.mobilhanem.eventbusexample.event.ActivityToFragmentEvent;

import org.greenrobot.eventbus.Subscribe;


public class SecondFragment extends Fragment {

    private TextView txtMsg;

    @Override
    public void onResume() {
        super.onResume();
        GlobalBus.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        GlobalBus.getBus().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        txtMsg = (TextView)view.findViewById(R.id.txtMessageFirstFragment);
        return view;
    }

    @Subscribe
    public void onEvent(ActivityToFragmentEvent messageEvent){

        txtMsg.setText(messageEvent.getMsg());
    }
}
