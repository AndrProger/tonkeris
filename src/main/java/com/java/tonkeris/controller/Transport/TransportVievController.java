package com.java.tonkeris.controller.Transport;

import com.java.tonkeris.message.DateTimeHeader;
import com.java.tonkeris.model.GrainReception;
import com.java.tonkeris.model.TransportNow;
import com.java.tonkeris.model.TypeTransportDir;
import com.java.tonkeris.repository.GrainReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransportVievController {

    @Autowired
    private GrainReceptionRepository grainReceptionRepository;

    @GetMapping("/transportViev")
    public String TransportAdd(Model model) {
        model= DateTimeHeader.getDateModel(model);
        Iterable<GrainReception>rec= grainReceptionRepository.findAll();
        model.addAttribute("rec",rec);

        return "transportViev";

    }
}
