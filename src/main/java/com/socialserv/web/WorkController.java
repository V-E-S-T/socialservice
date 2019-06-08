package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import com.socialserv.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        return "page";
//        return "index";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String save( final Action action, final BindingResult bindingResult, final HttpServletRequest req){


        final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
        Action action1 = standartActionStorage.getById(actionId);
        workService.save(action1);
        return "welldone";
    }




}
