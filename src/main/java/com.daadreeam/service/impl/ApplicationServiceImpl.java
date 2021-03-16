package com.daadreeam.service.impl;

import com.daadreeam.service.ApplicationService;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class ApplicationServiceImpl implements ApplicationService {

    private String time = null;

    @Override
    public String handle() {
        if(time == null) {
            LocalTime localTime = LocalTime.now();
            time = "Application 方法调用时间 =" + localTime.get(ChronoField.HOUR_OF_DAY) + ":" + localTime.get(ChronoField.MINUTE_OF_HOUR) + ":" + localTime.get(ChronoField.SECOND_OF_MINUTE);
        }
        return time;
    }
}
