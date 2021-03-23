package com.raphael.to_do_list.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raphael.to_do_list.dtos.NovaTarefaDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "to_do_list",name = "tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "prazo")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date prazo;

    @Column(name = "completa" )
    private boolean completa;

    public TarefaModel(){
    }

    public TarefaModel(NovaTarefaDto tarefa){
        this.descricao = tarefa.getDescricao();
        this.prazo = tarefa.getPrazo();
        this.completa = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
}
