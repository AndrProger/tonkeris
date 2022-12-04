package com.java.tonkeris.controller;

import com.java.tonkeris.message.DateTimeHeader;
import com.java.tonkeris.model.BasicAnalysis;
import com.java.tonkeris.repository.BasicAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class filterController {
    private final BasicAnalysisRepository basicAnalysisRepository;

    public filterController(BasicAnalysisRepository basicAnalysisRepository) {
        this.basicAnalysisRepository = basicAnalysisRepository;
    }

    @GetMapping(value = "/filter" )
    public String postFilter(
            Model model,
            @RequestParam(value = "byhumidity",required = false) Double byhumidity,
            @RequestParam(value = "tohumidity",required = false) Double tohumidity,
            @RequestParam(value = "humidity_filtr",required = false) Boolean humidityBool,
            @RequestParam(value = "bynatura",required = false) Double bynatura,
            @RequestParam(value = "tonatura",required = false) Double tonatura,
            @RequestParam(value = "natura_filtr",required = false) Boolean naturaBool,
            @RequestParam(value = "vitreous",required = false) String vitreous,
            @RequestParam(value = "vitreous_filtr",required = false) Boolean vitreousBool,
            @RequestParam(value = "byclass",required = false) Integer byclass,
            @RequestParam(value = "toclass",required = false) Integer toclass,
            @RequestParam(value = "class_filtr",required = false) Boolean classBool,
            @RequestParam(value = "type",required = false) String type,
            @RequestParam(value = "type_filtr",required = false) Boolean typeBool

    ){
//        Boolean check=request.getParameter("humidity_filtr");
        DateTimeHeader.getDateModel(model);
        if (humidityBool==null){
            byhumidity=0d;
            tohumidity=100d;
        }
        if(naturaBool==null){
            bynatura=0d;
            tonatura=5000d;
        }
        if(vitreousBool==null){
            vitreous="";
        }
        if(classBool==null){
            byclass=1;
            toclass=5;
        }
        if(typeBool==null){
            type="";
        }
        System.out.println(byhumidity+" "+ tohumidity+ " " + humidityBool + " " + bynatura + " "+ tonatura
                +" "+ naturaBool + " " + vitreous + " " +vitreousBool+ " "+ byclass+" " + toclass +" "+ classBool +" " +type + " " +typeBool) ;

        List<BasicAnalysis> list=  basicAnalysisRepository.findParamFilt(byhumidity, tohumidity,bynatura,tonatura,vitreous,byclass,toclass,type );
        for (BasicAnalysis b:list){
            System.out.println(b);
        }
        model.addAttribute("basicAnalysis", list);
        return  "filter";
    }
}
