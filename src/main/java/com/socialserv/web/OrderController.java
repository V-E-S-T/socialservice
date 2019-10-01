package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import com.socialserv.model.Order;
import com.socialserv.model.Work;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping()
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

    @RequestMapping(value = "/{packet}", method= RequestMethod.GET)
    public String orderGet(@PathVariable("packet") String packet, @ModelAttribute("Order") Order order, @ModelAttribute("WorkList") ArrayList<Work> workList1, Model model){

//        List<Work> workList;

        System.out.println("BASIC");

        List<Work> workList;
        if(packet.equals(StandartActionStorage.BASIC)){
            workList = StandartActionStorage.getActionListBasic().stream().map(action -> new Work(action, LocalDateTime.now())).collect(Collectors.toList());
        }
        else if(packet.equals(StandartActionStorage.ALL_INCLUSIVE)){
            workList = StandartActionStorage.getActionListAllInclude().stream().map(action -> new Work(action, LocalDateTime.now())).collect(Collectors.toList());
        }
        else if(packet.equals(StandartActionStorage.PREMIUM)){
            workList = StandartActionStorage.getActionListPremium().stream().map(action -> new Work(action, LocalDateTime.now())).collect(Collectors.toList());
        }
        else {
            workList = StandartActionStorage.getAll().stream().map(action -> new Work(action, LocalDateTime.now())).collect(Collectors.toList());
        }

        order.setWorkList(workList);

        model.addAttribute("order", order);

        return "order";
    }

    @ModelAttribute("Order")
    public Order addOrder(){
        Order order = new Order();
        return order;
    }

    @ModelAttribute("WorkList")
    public ArrayList<Work> addWorkList(){
        return new ArrayList<>();
    }

    @RequestMapping(path = "/order/ppp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id, HttpServletRequest request, Model model, @ModelAttribute("workList") List<Work> workList){

        workList.remove(id);


//        final Integer actionId = Integer.valueOf(request.getParameter("actionId"));
//        Action action1 = standartActionStorage.getById(actionId);
//        workService.save(action1);
        return "order";
    }

}
