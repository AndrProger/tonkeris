package com.java.tonkeris.controller.Transport;


import com.java.tonkeris.controller.AllController;
import com.java.tonkeris.message.DateTimeHeader;
import com.java.tonkeris.model.GrainReception;
import com.java.tonkeris.model.TransportNow;
import com.java.tonkeris.model.TypeTransportDir;
import com.java.tonkeris.repository.GrainReceptionRepository;
import com.java.tonkeris.repository.TransportNowRepository;
import com.java.tonkeris.repository.TypeTransportDirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransportAddController {
    @Autowired
    private TransportNowRepository transportNowRepository;

    @Autowired
    private GrainReceptionRepository grainReceptionRepository;
    @Autowired
    private TypeTransportDirRepository typeTransportDirRepository;
    @Autowired
    private AllController allController;

    @GetMapping("/transportAdd")
    public String TransportAdd(Model model) {

        DateTimeHeader.getDateModel(model);
        allController.getTransportTableModel(model);

        Iterable<TypeTransportDir>transportsType= typeTransportDirRepository.findAll();
        model.addAttribute("transportsType",transportsType);
        return "transportAdd";

    }

    @PostMapping("/transportAdd")
    public String TransportAddPost(@RequestParam String num,@RequestParam String type, @RequestParam String num_trail, Model model) {

        GrainReception grainReception =new GrainReception();
        System.out.println(grainReception);
        grainReceptionRepository.save(grainReception);
        System.out.println(grainReception);
        TransportNow transport=new TransportNow(num,type,num_trail, grainReception.getId());
        transportNowRepository.save(transport);
        return "redirect:/transportAdd";
    }

}


