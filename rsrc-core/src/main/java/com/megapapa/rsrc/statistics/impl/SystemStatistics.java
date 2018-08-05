package com.megapapa.rsrc.statistics.impl;

import com.megapapa.rsrc.statistics.Statistics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemStatistics implements Statistics {

    private long startTime;

    public SystemStatistics() {
        this.startTime = System.currentTimeMillis();
    }

    public String uptime() {
        Date date = new Date(System.currentTimeMillis() - startTime);
        DateFormat messageDateFormat = new SimpleDateFormat("dd HH::mm::ss.SSS");
        return messageDateFormat.format(date);
    }

    @Override
    public void createReport() {

    }
}
