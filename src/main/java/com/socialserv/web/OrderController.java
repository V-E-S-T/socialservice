package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = "/basic")
    public String basicOrder(Model model){
        List<Action> basicActions = StandartActionStorage.getActionListBasic();
        model.addAttribute("basicActions", basicActions);
        return "page";
    }

    @RequestMapping(value = "/morder")
    public String morderOrder(Model model){
        List<Action> basicActions = StandartActionStorage.getActionListBasic();
        model.addAttribute("basicActions", basicActions);
        return "page";
    }

    @RequestMapping(value = "/border")
    public String orderOrder(Model model){
        List<Action> basicActions = StandartActionStorage.getActionListBasic();
        model.addAttribute("basicActions", basicActions);
        return "page";
    }

}
