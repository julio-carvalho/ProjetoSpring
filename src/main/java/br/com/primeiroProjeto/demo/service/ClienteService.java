package br.com.primeiroProjeto.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.primeiroProjeto.demo.exception.ResourceNotFoundException;
import br.com.primeiroProjeto.demo.model.Cliente;
import br.com.primeiroProjeto.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	public Cliente create(Cliente c) {
		return clienteRepository.save(c); 
	}
	
	public Cliente update(Cliente c, String nome, String email, Long id) throws ResourceNotFoundException {
		Cliente cliente = new Cliente();
		Cliente found = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
		
		return clienteRepository.save(c);
	}
}
