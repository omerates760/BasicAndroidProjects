package com.mobilhanem.eventbusexample.event;

import com.mobilhanem.eventbusexample.model.User;

/**
 * Created by alper on 06/02/17.
 */

public class ActivityToActivityEvent {

    private User user;

    public User getUser() {
        return user;
    }

    public ActivityToActivityEvent(User user) {
        this.user = user;
    }
}
