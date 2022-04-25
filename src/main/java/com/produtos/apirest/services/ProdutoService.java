package com.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> todosProdutos(){
		return produtoRepository.findAll();
		
	}
	
	public Optional<Produto> produtoPorId(Long id) {
		Optional<Produto> prod = produtoRepository.findById(id);
		return prod;
		
	}
	
	public Produto salvaProduto(Produto produto) {
		return produtoRepository.save(produto);
		
	}

	public void deletaProduto(Long id) {
		produtoRepository.deleteById(id);
		
	}
	
	public Produto atualizaProduto(Long id, Produto produtoatualizado) {  
		
		Produto produto = produtoRepository.getById(id);
		produto.setNome(produtoatualizado.getNome());
		produto.setQuantidade(produtoatualizado.getQuantidade());
		produto.setValor(produtoatualizado.getValor());
		produto = produtoRepository.save(produto);  
		return produto;
	}
	
}