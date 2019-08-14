package com.socialserv.dto;

import com.socialserv.model.Action;

public class ModalAction {

    Action action;
    int actionsPerWeek;
    int weekCounter;

    public ModalAction(Action action, int actionsPerWeek, int weekCounter) {
        this.action = action;
        this.actionsPerWeek = actionsPerWeek;
        this.weekCounter = weekCounter;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getActionsPerWeek() {
        return actionsPerWeek;
    }

    public void setActionsPerWeek(int actionsPerWeek) {
        this.actionsPerWeek = actionsPerWeek;
    }

    public int getWeekCounter() {
        return weekCounter;
    }

    public void setWeekCounter(int weekCounter) {
        this.weekCounter = weekCounter;
    }
}
