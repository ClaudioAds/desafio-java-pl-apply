package br.com.selecaojava.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String regiao;
    private String estado;

    public Endereco() {
    }

    public Endereco(String regiao, String estado) {
        this.regiao = regiao;
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "regiao='" + regiao + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
