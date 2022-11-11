package com.java.tonkeris.message;

import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHeader {
    private Date date;
    private String dateStr;
    private String timeStr;

    private DateTimeHeader() {
        Date date=new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm");
        dateStr=formatForDateNow.format(date);
        timeStr=formatForTimeNow.format(date);
    }

    public String getDateStr() {
        return dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public static Model getDateModel(Model model){
        DateTimeHeader dateTimeHeader=new DateTimeHeader();
        model.addAttribute("dateNow",dateTimeHeader);
        return  model;
    }
}
