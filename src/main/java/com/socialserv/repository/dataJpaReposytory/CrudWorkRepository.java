package com.socialserv.repository.dataJpaReposytory;

import com.socialserv.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudWorkRepository extends JpaRepository<Work, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Work w WHERE w.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Work save(Work work);

    @Override
    Optional<Work> findById(Integer id);

    @Query("SELECT w FROM Work w WHERE w.id=:id ORDER BY w.registered DESC")
    List<Work> getAll(@Param("id") int id);
}
