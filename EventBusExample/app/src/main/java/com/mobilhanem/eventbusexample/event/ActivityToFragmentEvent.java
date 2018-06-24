package com.mobilhanem.eventbusexample.event;

/**
 * Created by alper on 05/02/17.
 */

public class ActivityToFragmentEvent {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public ActivityToFragmentEvent(String msg) {
        this.msg = msg;
    }
}
