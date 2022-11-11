package com.java.tonkeris.controller.Transport;

import com.java.tonkeris.message.DateTimeHeader;
import com.java.tonkeris.message.Message;
import com.java.tonkeris.model.TypeTransportDir;
import com.java.tonkeris.repository.TypeTransportDirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TransportDirectoryController {
    @Autowired
    private TypeTransportDirRepository transportDirRep;

    private Model modelAllTypes(Model model,Long id,String editDelBtn){

        // выборка всех типов для таблицы "Типы транспорта" ${object-typesAll}(transportDirectory)
        Iterable<TypeTransportDir>typesAll= transportDirRep.findAll();
        model.addAttribute("typesAll",typesAll);
        // ------------------------------------------------------------

        // выборка одного типа для поля "edit type" ${object-typeEdit}(transportDirectory)
        if(id == 0)
        {
            TypeTransportDir typeEdit=new TypeTransportDir("");
            model.addAttribute("typeEdit",typeEdit);
        }
        else {
            Optional<TypeTransportDir> typeEdit= transportDirRep.findById(id);
            ArrayList<TypeTransportDir> typeEditList= new ArrayList<>();
            typeEdit.ifPresent(typeEditList::add);

            model.addAttribute("typeEdit",typeEditList.get(0));
        }
        // ------------------------------------------------------------

        //Отображение кнопак "редактировать" "удалить " ${object-editDelBtn}(transportDirectory)
        {
            String strStyle = "display: ";
            strStyle += editDelBtn;
            model.addAttribute("styleEditDelBtn", strStyle);
        }
        // ------------------------------------------------------------


        return model;
    }




    @GetMapping("/transportDirectory")
    public String transportDirectory(Model model) {

        model= DateTimeHeader.getDateModel(model);
        model=modelAllTypes(model,0L,"none");
        model=new Message("none").genInModel(model);
        return "transportDirectory";

    }

    @GetMapping("/transportDirectory/{id}")
    public String transportDirecrtoryId(@PathVariable(value="id") long id,  Model model){
        if(!transportDirRep.existsById(id))
            return "redirect:/transportDirectory";
        model= DateTimeHeader.getDateModel(model);
        model=modelAllTypes(model,id,"block");
        model=new Message("none").genInModel(model);
        return "transportDirectory";
    }



    @PostMapping(value = "/transportDirectory")
    public String transportDirectoryAdd(@RequestParam String name,  Model model) {
        Iterable<TypeTransportDir>transports= transportDirRep.findAll();
        for (TypeTransportDir tr:transports) {
            if(tr.getName().equals(name)){
                String strMessage="Не удалось создать тип \""+name+"\", так как запись уже существует";
                model=modelAllTypes(model,0L,"none");
                model=new Message("block", "Ошибка",strMessage).genInModel(model);
                return "transportDirectory";
            }

        }


        TypeTransportDir transportDir= new TypeTransportDir(name);
        transportDirRep.save(transportDir);

        return "redirect:/transportDirectory";
    }

    @PostMapping(value = "/transportDirectory/{id}", params = "edit")
    public String transportUpdate(@PathVariable(value="id") long id,@RequestParam String nameEdit,Model model){
        TypeTransportDir transportDir=transportDirRep.findById(id).orElseThrow();
        Iterable<TypeTransportDir>transports= transportDirRep.findAll();
        for (TypeTransportDir tr:transports) {
            if(tr.getName().equals(nameEdit)){
                String strMessage="Не удалось изменить тип \""+transportDir.getName()+"\", на\""+nameEdit +"\" так как такая запись уже существует";
                model=modelAllTypes(model,0L,"none");
                model=new Message("block", "Ошибка",strMessage).genInModel(model);
                return "transportDirectory";
            }

        }
        transportDir.setName(nameEdit);
        transportDirRep.save(transportDir);

        return "redirect:/transportDirectory";
    }

    @PostMapping(value = "/transportDirectory/{id}", params = "delete")
    public String transportDelete(@PathVariable(value="id") long id,Model model){
        TypeTransportDir transportDir=transportDirRep.findById(id).orElseThrow();
        transportDirRep.delete(transportDir);
        return "redirect:/transportDirectory";
    }
}
