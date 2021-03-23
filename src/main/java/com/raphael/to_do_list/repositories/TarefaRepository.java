package com.raphael.to_do_list.repositories;

import com.raphael.to_do_list.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel,Long> {
}
