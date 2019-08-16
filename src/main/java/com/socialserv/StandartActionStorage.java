package com.socialserv;

import com.socialserv.model.Action;
import com.socialserv.model.Specialization;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StandartActionStorage {

    public static final String BASIC = "basic";
    public static final String ALL_INCLUSIVE = "all_inclusive";
    public static final String PREMIUM = "premium";

    private static final Action CLEAN = new Action(0, 100, "Light cleaning service", 60, Specialization.CLEANER);
    private static final Action CARRY = new Action(1, 50, "Carrier service", 60, Specialization.CARRIER);
    private static final Action MEDICAL = new Action(2,100, "Simple medical services", 60, Specialization.MEDIC);

    private static final List<Action> actionListAll = new ArrayList<Action>()
    {{add(CLEAN);
        add(CARRY);
        add(MEDICAL);}};
    private static final List<Action> actionListBasic = new ArrayList<Action>()
    {{add(CLEAN);
        add(CARRY);}};
    private static final List<Action> actionListAllInclude = new ArrayList<Action>()
    {{add(CLEAN);
        add(MEDICAL);}};
    private static final List<Action> actionListPremium = new ArrayList<Action>()
    {{add(CARRY);
        add(MEDICAL);}};

    public Action getAction(String actionName){
        switch (actionName){
            case "CLEAN": return CLEAN;
            case "CARRY": return CARRY;
            case "MEDICAL": return MEDICAL;
            default: return null;
        }
    }

    public static List<Action> getAll(){
        return actionListAll;
    }

    public static List<Action> getActionListBasic() {
        return actionListBasic;
    }

    public static List<Action> getActionListAllInclude() {
        return actionListAllInclude;
    }

    public static List<Action> getActionListPremium() {
        return actionListPremium;
    }

    public Action getById(int actionId){
//        actionListAll.forEach(action -> action.getId() == actionId ? action);
        for (Action action: actionListAll){
            if (action.getId() == actionId){
                return action;
            }
        }
        return null;
    }
}
