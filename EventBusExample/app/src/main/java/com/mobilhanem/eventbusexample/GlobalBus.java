package com.mobilhanem.eventbusexample;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by alper on 05/02/17.
 */

public class GlobalBus {

    private static EventBus eventBus;

    public static EventBus getBus() {
        if (eventBus == null)
            eventBus = EventBus.getDefault();
        return eventBus;
    }
}
