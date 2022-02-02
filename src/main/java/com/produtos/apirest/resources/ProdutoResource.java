package com.produtos.apirest.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(value="/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping(value="/produto/{id}")
	@ApiOperation(value="Retorna um único produto")
	public Optional<Produto> ProdutoUnico(@PathVariable(value= "id") Long id){
		return produtoRepository.findById(id);
	}
		
		
	@PostMapping(value="/produto")
	@ApiOperation(value="Salva um produto")
	public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(produtoRepository.save(produto));
		
	}
	
	@DeleteMapping(value="/produto/{id}")
	@ApiOperation(value="Apaga um único produto")
	public void deletaProduto(@PathVariable(value="id") Long id) {
		produtoRepository.deleteById(id);	
	}
	
	@PutMapping(value="/produto/{id}")
	@ApiOperation(value="Atualiza um produto")
	public void atualizaProduto(@RequestBody Produto produto, @PathVariable(value="id") Long id) {
		produtoRepository.save(produto);
			
	}
}
