package com.socialserv.repository.dataJpaReposytory;

import com.socialserv.model.Work;
import com.socialserv.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DataJpaWorkRepository implements WorkRepository {

    @Autowired
    CrudWorkRepository crudWorkRepository;

    @Transactional
    @Override
    public Work save(Work work) {
        return crudWorkRepository.save(work);
    }

    @Override
    public boolean delete(int id) {
        return crudWorkRepository.delete(id) != 0;
    }

    @Override
    public Work get(int id) {
        return crudWorkRepository.findById(id).orElse(null);
    }

    @Override
    public List<Work> getAll(int id) {
        return crudWorkRepository.getAll(id);
    }
}
