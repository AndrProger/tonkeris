package com.java.tonkeris.controller.Analysis;

import com.java.tonkeris.controller.AllController;
import com.java.tonkeris.message.DateTimeHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class additionalAnalysisController {

    @Autowired
    private AllController allController;

    @GetMapping("/additionalAnalysis")
    public String basicAnalysis(Model model){
        DateTimeHeader.getDateModel(model);
        allController.getTransportTableModel(model);

        model.addAttribute("aboutTapBlock","display: block;");
        model.addAttribute("transportNowBlock","display: none;");

        return "additionalAnalysis";
    }
}
