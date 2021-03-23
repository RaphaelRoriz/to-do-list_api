package com.raphael.to_do_list.services;

import com.raphael.to_do_list.dtos.NovaTarefaDto;
import com.raphael.to_do_list.models.TarefaModel;
import com.raphael.to_do_list.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    public TarefaModel cadastrarTarefa(NovaTarefaDto tarefa) {
        return tarefaRepository.save(new TarefaModel(tarefa));
    }

    public ResponseEntity<List<TarefaModel>> listarTarefas() {
        List<TarefaModel> tarefas = tarefaRepository.findAll();
        if(tarefas.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(tarefas);
        }
    }

    public ResponseEntity<TarefaModel> getTarefa(Long idTarefa) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(idTarefa);
        if (tarefa.isPresent()){
            return ResponseEntity.ok().body(tarefa.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
