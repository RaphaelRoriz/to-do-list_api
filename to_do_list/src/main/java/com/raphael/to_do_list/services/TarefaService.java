package com.raphael.to_do_list.services;

import com.raphael.to_do_list.dtos.NovaTarefaDto;
import com.raphael.to_do_list.models.TarefaModel;
import com.raphael.to_do_list.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    public TarefaModel cadastrarTarefa(NovaTarefaDto tarefa) {
        return tarefaRepository.save(new TarefaModel(tarefa));
    }
}
