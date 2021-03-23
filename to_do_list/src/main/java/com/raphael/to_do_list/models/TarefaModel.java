package com.raphael.to_do_list.models;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private Date PRAZO;

    @Column(name = "completa" )
    private boolean completa;

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

    public Date getPRAZO() {
        return PRAZO;
    }

    public void setPRAZO(Date PRAZO) {
        this.PRAZO = PRAZO;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
}
