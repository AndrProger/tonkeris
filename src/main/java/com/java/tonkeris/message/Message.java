package com.java.tonkeris.message;

import org.springframework.boot.Banner;
import org.springframework.ui.Model;

public class Message {
    private String display;
    private String title="";
    private String text="";

    public Message(String display) {
        this.display =display;
    }

    public Message(String display, String title, String text) {
        this.display =display;
        this.title = title;
        this.text = text;
    }
    public Model genInModel(Model model){
        Message mes=new Message(display,title,text);
        model.addAttribute("message", mes);
        return model;
    }

    public String getDisplay() {
        return "display: "+ display+";";
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
