package com.java.tonkeris.controller.Analysis;

import com.java.tonkeris.controller.AllController;
import com.java.tonkeris.message.DateTimeHeader;
import com.java.tonkeris.model.BasicAnalysis;
import com.java.tonkeris.model.GrainReception;
import com.java.tonkeris.model.TransportNow;
import com.java.tonkeris.model.dopModel.TransportNowDopAnalysis;
import com.java.tonkeris.repository.BasicAnalysisRepository;
import com.java.tonkeris.repository.GrainReceptionRepository;
import com.java.tonkeris.repository.TransportNowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class basicAnalysisController {
    @Autowired
    private TransportNowRepository transportNowRepository;
    @Autowired
    private BasicAnalysisRepository basicAnalysisRepository;
    @Autowired
    private GrainReceptionRepository grainReceptionRepository;
    @Autowired
    private  AllController allController;



    @GetMapping("/basicAnalysis")
    public String basicAnalysis(Model model){
        DateTimeHeader.getDateModel(model);
        allController.getTransportTableModel(model);

        allController.aboutTapBlockBlock(model);
        getStatysAnalys(model);

        model.addAttribute("analysis",new BasicAnalysis());
        model.addAttribute("status","Отсутствует");
        return "basicAnalysis";
    }
    @GetMapping("/basicAnalysis/{id}")
    public String basicAnalysisId(@PathVariable(value="id") long id, Model model){
        DateTimeHeader.getDateModel(model);

        if(!transportNowRepository.existsById(id))
            return "redirect:/basicAnalysis";

        allController.getTransportTableModel(model,id);

        allController.aboutTapBlockNone(model);;
        getStatysAnalys(model);
        Long idBasicAnalysis=transportNowRepository.getIdBasicFromIdTransport(id);

        if(idBasicAnalysis!=null){
            allController.analysisInfoBlock(model);
            BasicAnalysis basicAnalysisNow=basicAnalysisRepository.findByIdOnlyOne(idBasicAnalysis);
            allController.btnDisabled(model);
            model.addAttribute("analysis",basicAnalysisNow);
            model.addAttribute("status","Проведен");
        }
        else {
            allController.analysisInfoNone(model);
            model.addAttribute("analysis",new BasicAnalysis());
            model.addAttribute("status","Отсутствует");
        }
        return "basicAnalysis";
    }

    @PostMapping("/basicAnalysis/{id}")
    public String basicAnalysisPost(
            @PathVariable(value="id") long id,
            BasicAnalysis basicAnalysis,
            Model model
    ){
        basicAnalysis.setId(null);
        basicAnalysisRepository.save(basicAnalysis);

        Optional<TransportNow> transportsNow= transportNowRepository.findById(id);
        ArrayList<TransportNow> transportsNowList= new ArrayList<>();
        transportsNow.ifPresent(transportsNowList::add);

        long idGrain=transportsNowList.get(0).getId_grainReception();

        Optional<GrainReception> grainReception= grainReceptionRepository.findById(idGrain);

        ArrayList<GrainReception> grainReceptionList= new ArrayList<>();
        grainReception.ifPresent(grainReceptionList::add);
        GrainReception nowGrainReception=grainReceptionList.get(0);

        nowGrainReception.setId_basic(basicAnalysis.getId());
        grainReceptionRepository.save(nowGrainReception);
        return "redirect:/basicAnalysis";
    }
    public Model getStatysAnalys(Model model){

        List<TransportNowDopAnalysis> list =transportNowRepository.getTransportNowByDopAnalysis();
        model.addAttribute("transportNowDopAnalysis",list);
        return model;
    }
}
