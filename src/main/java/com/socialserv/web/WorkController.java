package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import com.socialserv.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    StandartActionStorage standartActionStorage;

    @RequestMapping(value = "/")
    public String services(Model model){
        model.addAttribute("actions", standartActionStorage.getAll());
        return "index";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String saveWork(Action action){

        workService.save(action);
        return "welldone";
    }




}
