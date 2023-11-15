package com.senac.demo.service;

import com.senac.demo.model.Cliente;
import com.senac.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente entity) {
        return repository.save(entity);
    }
    public List<Cliente> buscaTodos(){
        return repository.findAll();}
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Cliente alterar(Long id,Cliente alterado){
        Optional<Cliente> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Cliente cliente = encontrado.get();

            cliente.setCpf(alterado.getCpf());
            cliente.setEmail(alterado.getEmail());
            cliente.setEndereco(alterado.getEndereco());
            cliente.setLimiteCredito(alterado.getLimiteCredito());
            cliente.setTelefone(alterado.getTelefone());

            return repository.save(cliente);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}
