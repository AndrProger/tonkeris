package com.java.tonkeris.controller;

import com.java.tonkeris.model.TransportNow;
import com.java.tonkeris.repository.TransportNowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@Scope("singleton")
public class AllController {

    private  TransportNowRepository transportNowRepository;


    public AllController(TransportNowRepository transportNowRepository) {
        this.transportNowRepository = transportNowRepository;
    }

    public   Model getTransportTableModel(Model model, long id){
        addAllTransportsNow(model);

        Optional<TransportNow> transportsNow= transportNowRepository.findById(id);
        ArrayList<TransportNow> transportsNowList= new ArrayList<>();
        transportsNow.ifPresent(transportsNowList::add);

        model.addAttribute("transportNow",transportsNowList.get(0));
        return model;
    }
    public   Model getTransportTableModel(Model model){
        addAllTransportsNow(model);


        TransportNow transportsNowList=new TransportNow();

        model.addAttribute("transportNow",transportsNowList);
        return model;
    }
    private  Model addAllTransportsNow(Model model){
        Iterable<TransportNow>allTransportsNow= transportNowRepository.findAll();
        for (TransportNow t:allTransportsNow
             ) {
            System.out.println(t.getNum());
        }

        model.addAttribute("allTransportsNow",allTransportsNow);
        return model;
    }
    private Model aboutTapBlockBlock(Model model){
        model.addAttribute("aboutTapBlock","display: block;");
        model.addAttribute("transportNowBlock","display: none;");
        return model;
    }
    private Model aboutTapBlockNone(Model model){
        model.addAttribute("aboutTapBlock","display: none;");
        model.addAttribute("transportNowBlock","display: block;");

        return model;
    }
}
