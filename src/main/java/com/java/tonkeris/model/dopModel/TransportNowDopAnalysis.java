package com.java.tonkeris.model.dopModel;

import com.java.tonkeris.model.TransportNow;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TransportNowDopAnalysis   {
    private  Long id;
    private Long id_analysis;

    private String num;

    private String type;

    private String numTrail;

    private Date actionDate;

    private Long id_grainReception;

    public String getStatysAnalysis() {
        if (id_analysis==null){
            return ("Нет");
        }
        else
            return("Был"+id_analysis);
    }

    public TransportNowDopAnalysis(Long id,String num, String type, String numTrail, Date actionDate, Long id_grainReception, Long id_analysis) {
        this.id = id;
        this.num = num;
        this.type = type;
        this.numTrail = numTrail;
        this.actionDate = actionDate;
        this.id_grainReception = id_grainReception;
        this.id_analysis = id_analysis;
    }

    public TransportNowDopAnalysis(String num) {
        this.num = num;
    }

    public TransportNowDopAnalysis() {
    }

    public String getTime(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
        return formatForDateNow.format(actionDate);
    }
    public String getDate(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(actionDate);
    }

    public Long getId_analysis() {
        return id_analysis;
    }

    public String getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public String getNumTrail() {
        return numTrail;
    }


    public Long getId_grainReception() {
        return id_grainReception;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TransportNowDopAnalysis{" +
                "id_analysis=" + id_analysis +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", numTrail='" + numTrail + '\'' +
                ", actionDate=" + actionDate +
                ", id_grainReception=" + id_grainReception +
                '}';
    }
}
