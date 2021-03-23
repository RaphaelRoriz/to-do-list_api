package com.raphael.to_do_list.controllers;

import com.raphael.to_do_list.dtos.NovaTarefaDto;
import com.raphael.to_do_list.models.TarefaModel;
import com.raphael.to_do_list.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping(value = "/cadastrar")
    public TarefaModel cadastrar(@Valid @RequestBody NovaTarefaDto tarefa){
        return tarefaService.cadastrarTarefa(tarefa);
    }

}
