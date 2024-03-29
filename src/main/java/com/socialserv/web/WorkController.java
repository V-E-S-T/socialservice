package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.dto.ModalAction;
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

        List<Action> basicActions = allActions.stream()
                                        .filter(action -> (action.getId() == 0) || (action.getId() ==1))
                                        .collect(Collectors.toList());
        List<Action> allInclusiveActions = allActions.stream()
                .filter(action -> (action.getId() == 0) || (action.getId() ==2))
                .collect(Collectors.toList());
        List<Action> premiumActions = allActions.stream()
                .filter(action -> (action.getId() == 1) || (action.getId() ==2))
                .collect(Collectors.toList());

        model.addAttribute("actions", allActions);
//        model.addAttribute("order", new Order());
        model.addAttribute("basicActions", basicActions);
        model.addAttribute("allInclusiveActions", allInclusiveActions);
        model.addAttribute("premiumActions", premiumActions);

//        model.addAttribute("order", new Order());

        return "page";
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

    @RequestMapping(value = "/basic", method= RequestMethod.GET)
//    @ResponseBody
//    public List<ModalAction> basic(@ModelAttribute("basicActions") List<Action> basicActions, Model model){
    public String basic(@ModelAttribute("basicActions") List<Action> basicActions, Model model){

        List<Action> allActions = basicActions;

//        List<Work> basic = allActions.stream()
//                .filter(action -> (action.getId() == 0) || (action.getId() ==1))
//                .map(action -> new Work(action, null)).collect(Collectors.toList());

        List<ModalAction> basic = allActions.stream()
                .filter(action -> (action.getId() == 0) || (action.getId() ==1))
                .map(action -> new ModalAction(action, 1, 1)).collect(Collectors.toList());

        model.addAttribute("actions", basic);

        //final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
//        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
//        return basic;
        return "page";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String save( final Action action, final BindingResult bindingResult, final HttpServletRequest req){


        final Integer actionId = Integer.valueOf(req.getParameter("actionId"));
        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "welldone";
    }

    @RequestMapping(path = "/modal/{id}/delete", method = RequestMethod.GET)
    public String delete( @PathVariable("id") long id, HttpServletRequest request, Model model){




        final Integer actionId = Integer.valueOf(request.getParameter("actionId"));
        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "welldone";
    }




}
