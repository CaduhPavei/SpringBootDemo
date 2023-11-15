package com.senac.demo.service;

import com.senac.demo.model.Fornecedor;
import com.senac.demo.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public Fornecedor salvar(Fornecedor entity) {
        return repository.save(entity);
    }

    public List<Fornecedor> buscaTodos(){
        return repository.findAll();}
    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Fornecedor alterar(Long id,Fornecedor alterado){
        Optional<Fornecedor> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Fornecedor fornecedor = encontrado.get();

            fornecedor.setCnpj(alterado.getCnpj());
            fornecedor.setEmail(alterado.getEmail());
            fornecedor.setEndereco(alterado.getEndereco());
            fornecedor.setRazaoSocial(alterado.getRazaoSocial());
            fornecedor.setTelefone(alterado.getTelefone());

            return repository.save(fornecedor);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}
