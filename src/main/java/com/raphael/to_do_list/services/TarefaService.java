package com.raphael.to_do_list.services;

import com.raphael.to_do_list.dtos.NovaTarefaDto;
import com.raphael.to_do_list.dtos.TarefaUpdateDto;
import com.raphael.to_do_list.models.TarefaModel;
import com.raphael.to_do_list.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return ResponseEntity.ok().body(tarefas);
    }

    public ResponseEntity<TarefaModel> getTarefa(Long idTarefa) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(idTarefa);
        if (tarefa.isPresent()){
            return ResponseEntity.ok().body(tarefa.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity deletarTarefa(Long idTarefa) {
        try {
            tarefaRepository.deleteById(idTarefa);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity updateTarefa(TarefaUpdateDto tarefaDto, Long idTarefa) {
        Optional<TarefaModel> tarefaOpt = tarefaRepository.findById(idTarefa);
        if (tarefaOpt.isPresent()) {
            tarefaOpt.get().atualizarTarefa(tarefaDto);
            tarefaRepository.save(tarefaOpt.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
