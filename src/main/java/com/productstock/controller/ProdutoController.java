package com.productstock.controller;

import com.productstock.model.produto.AlterarProdutos;
import com.productstock.model.produto.CadastroProdutos;
import com.productstock.model.produto.Produto;
import com.productstock.model.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/formulario")
    public String listarProdutos(Long id, Model model) {
        if (id != null) {
            Produto produto = repository.getReferenceById(id);
            model.addAttribute("produto", produto);
        }
        return "produtos/formularioProdutos";
    }

    @GetMapping
    public String listagemProdutos(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "produtos/listagemProdutos";
    }

    @PostMapping
    @Transactional
    public String cadastrarProduto(CadastroProdutos dadosProduto) {
        Produto produto = new Produto(dadosProduto);
        repository.save(produto);
        return "redirect:/produtos";
    }

    @PutMapping
    @Transactional
    public String alterarProduto(AlterarProdutos dadosProduto) {
        Produto produto = repository.getReferenceById(dadosProduto.id());
        produto.atualizaDados(dadosProduto);
        return "redirect:/produtos";
    }

    @DeleteMapping
    @Transactional
    public String removerProduto(Long id) {
        repository.deleteById(id);
        return "redirect:produtos";
    }



}
