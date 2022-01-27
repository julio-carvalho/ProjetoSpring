package br.com.primeiroProjeto.demo;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.primeiroProjeto.demo.model.Cliente;
import br.com.primeiroProjeto.demo.model.Endereco;
import br.com.primeiroProjeto.demo.model.Produto;
import br.com.primeiroProjeto.demo.repository.EnderecoRepository;
import br.com.primeiroProjeto.demo.service.ClienteService;
import br.com.primeiroProjeto.demo.service.ProdutoService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		List<Produto> lista = new ArrayList<Produto>();
		

		// Produtos
		Produto produto = new Produto("Melância",400);
		Produto produto2 = new Produto("Uva",200);
		Produto produto3 = new Produto("Laranja",500);

//		lista.add(produto);
//		lista.add(produto2);
//		lista.add(produto3);
		// Endereco
		
		
		Endereco endereco = new Endereco("Rua X","São Gabriel","São Paulo");
				
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1998,10,6);
		Cliente cliente = new Cliente("Julio Carvalho", "julio@gmail.com", dataNascimento, endereco, Arrays.asList(produto,produto2,produto3));
		
		produto.setCliente(cliente);
		produto2.setCliente(cliente);
		produto3.setCliente(cliente);
		
		
		
		clienteService.create(cliente);
	
	}
	

	

}
