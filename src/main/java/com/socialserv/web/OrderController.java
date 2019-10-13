package com.socialserv.web;

import com.socialserv.StandartActionStorage;
import com.socialserv.model.Action;
import com.socialserv.model.ShoppingCart;
import com.socialserv.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionScope
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ShoppingCart cart;

//    @RequestMapping()
//    public String basicOrder(Model model){
//        List<Action> basicActions = StandartActionStorage.getActionListBasic();
//        model.addAttribute("basicActions", basicActions);
//        return "page";
//    }

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
    public String orderGet(@PathVariable(value = "packet", required = false) String packet, Model model){

        List<Work> workList;

        if(packet.equals(StandartActionStorage.BASIC)){
            cart.setWorkList(
                    getWorkList(StandartActionStorage.getActionListBasic())
            );
        }
        else if(packet.equals(StandartActionStorage.ALL_INCLUSIVE)){
            cart.setWorkList(
                    getWorkList(StandartActionStorage.getActionListAllInclude())
            );
        }
        else if(packet.equals(StandartActionStorage.PREMIUM)){
            cart.setWorkList(
                    getWorkList(StandartActionStorage.getActionListPremium())
            );
        }
        else if(packet.equals(StandartActionStorage.ALL_ACTIONS)){
//            model.addAttribute("allWorksList", getWorkList(StandartActionStorage.getAll()));
            return "order";
        }

        workList =  cart.getWorkList();
        model.addAttribute("workList", workList);
        return "order";
    }

//    @ModelAttribute("Order")
//    public Order addOrder(){
//        Order order = new Order();
//        return order;
//    }

    @ModelAttribute("allWorkList")
    public List<Work> allWorkList(){
        return getWorkList(StandartActionStorage.getAll());
    }

    @RequestMapping(path = "/delete/{index}", method = RequestMethod.GET)
    public String delete(@PathVariable("index") int index, Model model){
        cart.deleteWork(index);
        model.addAttribute("workList", cart.getWorkList());
        return "order";
    }

    private List<Work> getWorkList(List<Action> actionList){
        return actionList.stream()
                .map(action -> new Work(action, LocalDateTime.now()))
                .collect(Collectors.toList());
    }

}
