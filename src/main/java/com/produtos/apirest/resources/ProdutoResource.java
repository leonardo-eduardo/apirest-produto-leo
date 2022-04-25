package com.produtos.apirest.resources;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	private final ProdutoService produtoService;
		
	public ProdutoResource(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping(value = "/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	@ResponseBody
	public Iterable<Produto> listaProdutos() {
		Iterable<Produto> listaProdutos = produtoService.todosProdutos();
		return listaProdutos;
	}

	@GetMapping(value = "/produtos/{id}")
	@ApiOperation(value = "Retorna um único produto")
	public Optional<Produto> ProdutoUnico(@PathVariable(value = "id") Long id) {
		return produtoService.produtoPorId(id);
	}

	@PostMapping(value = "/produtos")
	@ApiOperation(value = "Salva um produto")
	public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(produtoService.salvaProduto(produto));

	}

	@DeleteMapping(value = "/produtos/{id}")
	@ApiOperation(value = "Apaga um único produto")
	public void deletaProduto(@PathVariable(value = "id") Long id) {
		produtoService.deletaProduto(id);
	}

	@PutMapping(value = "/produtos/{id}")
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody Produto produtoatualizado) {
		produtoatualizado = produtoService.atualizaProduto(id, produtoatualizado);
		return ResponseEntity.ok().body(produtoatualizado);

	}
}
