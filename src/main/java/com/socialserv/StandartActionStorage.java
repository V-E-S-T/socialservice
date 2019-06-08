package com.socialserv;

import com.socialserv.model.Action;
import com.socialserv.model.Specialization;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StandartActionStorage {

    private static final Action CLEAN = new Action(0, 100, "Light cleaning service", 60, Specialization.CLEANER);
    private static final Action CARRY = new Action(1, 50, "Carrier service", 60, Specialization.CARRIER);
    private static final Action MEDICAL = new Action(2,100, "Simple medical services", 60, Specialization.MEDIC);

    private static final List<Action> actionList = new ArrayList<Action>()
    {{add(CLEAN);
        add(CARRY);
        add(MEDICAL);}};

    public Action getAction(String actionName){
        switch (actionName){
            case "CLEAN": return CLEAN;
            case "CARRY": return CARRY;
            case "MEDICAL": return MEDICAL;
            default: return null;
        }
    }

    public List<Action> getAll(){
        return actionList;
    }

    public Action getById(int actionId){
//        actionList.forEach(action -> action.getId() == actionId ? action);
        for (Action action: actionList){
            if (action.getId() == actionId){
                return action;
            }
        }
        return null;
    }
}
