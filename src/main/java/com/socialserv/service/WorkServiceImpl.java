package com.socialserv.service;

import com.socialserv.model.Action;
import com.socialserv.model.Work;
import com.socialserv.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{

    private final WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public Work save(Work work) {
        work.setRegistered(LocalDateTime.now());
//        LocalDateTime registered= LocalDateTime.now();
//        Work work = new Work(action, registered);
        return workRepository.save(work);
    }

    @Override
    public boolean delete(int id) {
        return workRepository.delete(id);
    }

    @Override
    public Work get(int id) {
        return workRepository.get(id);
    }

    @Override
    public List<Work> getAll(int id) {
        return workRepository.getAll(id);
    }
}
