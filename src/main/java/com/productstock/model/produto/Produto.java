package com.productstock.model.produto;

import jakarta.persistence.*;


@Entity
@Table(name ="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidade;

    public Produto() {
    }
    public Produto(CadastroProdutos dadosProduto) {
        this.nome = dadosProduto.nomeProduto();
        this.valor = dadosProduto.valorProduto();
        this.quantidade = dadosProduto.quantidadeProduto();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void atualizaDados(AlterarProdutos dadosProduto) {
        this.nome = dadosProduto.nomeProduto();
        this.valor = dadosProduto.valorProduto();
        this.quantidade = dadosProduto.quantidadeProduto();
    }
}
