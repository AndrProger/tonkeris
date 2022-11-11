package com.java.tonkeris.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class TransportNow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String num;

    @NotNull
    @Column(nullable = false)
    private String type;
    private String numTrail;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    private Date actionDate;

    @NotNull
    @Column(nullable = false)
    private Long id_grainReception;

    public TransportNow(String num, String type, String numTrail, Long id_staticTransport) {
        this.num = num;
        this.type = type;
        this.numTrail = numTrail;
        this.id_grainReception =id_staticTransport;
        this.actionDate =new Date();;
    }

    public TransportNow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumTrail() {
        return numTrail;
    }

    public void setNumTrail(String numTrail) {
        this.numTrail = numTrail;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public Long getId_grainReception() {
        return id_grainReception;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    public String getTime(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
        return formatForDateNow.format(actionDate);
    }
    public String getDate(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(actionDate);
    }

    @Override
    public String toString() {
        return "TransportNow{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", numTrail='" + numTrail + '\'' +
                ", actionDate=" + actionDate +
                ", id_grainReception=" + id_grainReception +
                '}';
    }
}
