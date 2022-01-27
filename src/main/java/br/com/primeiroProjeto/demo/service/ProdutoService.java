package br.com.primeiroProjeto.demo.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import br.com.primeiroProjeto.demo.model.Produto;
import br.com.primeiroProjeto.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
//	public ProdutoService(ProdutoRepository repo) {
//		this.produtoRepository = repo;
//	}
	
	public Produto create(Produto p) {
		return produtoRepository.save(p);
	}
	
}
