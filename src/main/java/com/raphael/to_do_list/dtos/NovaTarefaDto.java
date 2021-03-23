package com.raphael.to_do_list.dtos;

import java.util.Date;

public class NovaTarefaDto {

    private String descricao;
    private Date prazo;

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
}
