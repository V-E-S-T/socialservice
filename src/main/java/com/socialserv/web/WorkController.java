package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import com.socialserv.model.Order;
import com.socialserv.model.Work;
import com.socialserv.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    StandartActionStorage standartActionStorage;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String services(Model model){

        List<Action> allActions = standartActionStorage.getAll();

        List<Work> workList_bazovij = allActions.stream()
                                        .filter(action -> (action.getId() == 0) || (action.getId() ==1))
                                        .map(action -> new Work(action, null)).collect(Collectors.toList());
        List<Work> workList_vse_vklucheno = allActions.stream()
                .filter(action -> (action.getId() == 0) || (action.getId() ==2))
                .map(action -> new Work(action, null)).collect(Collectors.toList());
        List<Work> workList_premium = allActions.stream()
                .filter(action -> (action.getId() == 1) || (action.getId() ==2))
                .map(action -> new Work(action, null)).collect(Collectors.toList());

        model.addAttribute("actions", standartActionStorage.getAll());
        model.addAttribute("order", new Order());
        model.addAttribute("workList_bazovij", workList_bazovij);
        model.addAttribute("workList_vse_vklucheno", workList_vse_vklucheno);
        model.addAttribute("workList_premium", workList_premium);

        model.addAttribute("order", new Order());

        return "page";
//        return "index";
    }

//    @RequestMapping(value = "/order", method= RequestMethod.GET)
    @RequestMapping(value = "/order", method= RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
//    public String order(@ModelAttribute(value="order") Order order){
    public String order(Model model){

        //final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
//        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "welldone";
    }

    @RequestMapping(value = "/order", method= RequestMethod.GET)
    public String orderGet(Model model){

        //final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
//        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "welldone";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String save( final Action action, final BindingResult bindingResult, final HttpServletRequest req){


        final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "welldone";
    }




}
