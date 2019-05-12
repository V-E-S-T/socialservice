package com.socialserv.service;

import com.socialserv.model.Action;
import com.socialserv.model.Work;

import java.util.List;

public interface WorkService {

    Work save(Action action);

    boolean delete(int id);

    Work get(int id);

    // ORDERED dateTime desc
    List<Work> getAll(int id);
}
