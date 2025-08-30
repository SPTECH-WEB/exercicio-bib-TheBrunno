package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void registrarLivro(Integer quantidade){
        if(quantidade != null){
            if(quantidade > 0 && ativa){
                qtdLivros+=quantidade;
            }
        }
    }

    public Integer emprestar(Integer quantidade){
        if(quantidade == null || quantidade <= 0 || quantidade > qtdLivros || !ativa){
            return null;
        }else{
            qtdLivros -= quantidade;
            return quantidade;
        }
    }

    public Integer devolver(Integer quantidade){
        if(quantidade == null || quantidade <= 0 || !ativa){
            return null;
        }else{
            qtdLivros += quantidade;
            return quantidade;
        }
    }

    public Integer desativar(){
        if (ativa){
            ativa = false;
            Integer qtdLivrosAnterior = qtdLivros;
            qtdLivros = 0;

            return qtdLivrosAnterior;
        }else{
            return null;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(this.ativa && destino.ativa){
            if(quantidade <= this.qtdLivros){
                destino.qtdLivros += quantidade;
                this.qtdLivros -= quantidade;
            }
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual == null || percentual <= 0){
            return false;
        }else{
            this.multaDiaria += percentual+0.15;
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
