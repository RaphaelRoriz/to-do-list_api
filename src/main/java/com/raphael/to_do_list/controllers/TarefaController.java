package com.raphael.to_do_list.controllers;

import com.raphael.to_do_list.dtos.NovaTarefaDto;
import com.raphael.to_do_list.models.TarefaModel;
import com.raphael.to_do_list.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping(value = "/cadastrar")
    public TarefaModel cadastrar(@Valid @RequestBody NovaTarefaDto tarefa){
        return tarefaService.cadastrarTarefa(tarefa);
    }

    @GetMapping()
    public ResponseEntity<List<TarefaModel>> listar(){
        return tarefaService.listarTarefas();
    }

    @GetMapping(value = "/{idTarefa}")
    public ResponseEntity<TarefaModel> getTarefa(@PathVariable("idTarefa") Long idTarefa){
        return tarefaService.getTarefa(idTarefa);
    }

}
