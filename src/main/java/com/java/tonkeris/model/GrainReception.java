package com.java.tonkeris.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class GrainReception {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    private Date date;

    private int kg;

    private Long id_staticTransport;
    private Long id_farms;
    private Long id_chemical;
    private Long id_idk;
    private Long id_organoleptic;
    private Long id_weed;
    private Long id_basic;
    private Long id_additional;

    public GrainReception() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        if (date==null)
            return "Не завершен";
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(date);
    }

    public void setDate(Date actionDate) {
        this.date = actionDate;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public Long getId_staticTransport() {
        return id_staticTransport;
    }

    public void setId_staticTransport(Long id_staticTransport) {
        this.id_staticTransport = id_staticTransport;
    }

    public Long getId_farms() {
        return id_farms;
    }

    public void setId_farms(Long id_farms) {
        this.id_farms = id_farms;
    }

    public Long getId_chemical() {
        return id_chemical;
    }

    public void setId_chemical(Long id_chemical) {
        this.id_chemical = id_chemical;
    }

    public Long getId_idk() {
        return id_idk;
    }

    public void setId_idk(Long id_idk) {
        this.id_idk = id_idk;
    }

    public Long getId_organoleptic() {
        return id_organoleptic;
    }

    public void setId_organoleptic(Long id_organoleptic) {
        this.id_organoleptic = id_organoleptic;
    }

    public Long getId_weed() {
        return id_weed;
    }

    public void setId_weed(Long id_weed) {
        this.id_weed = id_weed;
    }

    public Long getId_basic() {
        return id_basic;
    }

    public void setId_basic(Long id_basic) {
        this.id_basic = id_basic;
    }

    public Long getId_additional() {
        return id_additional;
    }

    public void setId_additional(Long id_additional) {
        this.id_additional = id_additional;
    }

    @Override
    public String toString() {
        return "GrainReception{" +
                "id=" + id +
                ", date=" + date +
                ", kg=" + kg +
                ", id_staticTransport=" + id_staticTransport +
                ", id_farms=" + id_farms +
                ", id_chemical=" + id_chemical +
                ", id_idk=" + id_idk +
                ", id_organoleptic=" + id_organoleptic +
                ", id_weed=" + id_weed +
                ", id_basic=" + id_basic +
                ", id_additional=" + id_additional +
                '}';
    }
}
