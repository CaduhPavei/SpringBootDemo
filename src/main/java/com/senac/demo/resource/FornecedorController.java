package com.senac.demo.resource;

import com.senac.demo.model.Fornecedor;
import com.senac.demo.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

        @Autowired
        private FornecedorService service;

        @PostMapping
        public ResponseEntity create (@RequestBody Fornecedor entity) {
            Fornecedor save = service.salvar(entity);
            return ResponseEntity.created(URI.create("/api/fornecedores/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll(){
            List<Fornecedor> fornecedores = service.buscaTodos();
            return ResponseEntity.ok(fornecedores);
        }

        @GetMapping ("{id}")
        public ResponseEntity fundById(@PathVariable("id") Long id) {
            Fornecedor produto = service.buscarPorId(id);
            return ResponseEntity.ok(produto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Fornecedor entity) {
            Fornecedor alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
}
