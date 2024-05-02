package com.github.analiviamotta.api.controller;

import com.github.analiviamotta.api.conserto.Conserto;
import com.github.analiviamotta.api.conserto.ConsertoRepository;
import com.github.analiviamotta.api.conserto.DadosCadastroConserto;
import com.github.analiviamotta.api.conserto.DadosListagemConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository consertoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConserto dados){
        consertoRepository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> getConsertos(@PageableDefault( size=2,
            page=0,
            sort={"mecanico.nome"},
            direction = Sort.Direction.ASC ) Pageable paginacao){
        return consertoRepository.findAll(paginacao);
    }

    @GetMapping
    @RequestMapping("/algunsdados")
    public List<DadosListagemConserto> listarAlgunsDadoss(){
        return consertoRepository.findAll().stream().map(DadosListagemConserto::new).toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> optionalConserto = consertoRepository.findById(id);
        if(optionalConserto.isPresent()){
            Conserto conserto = optionalConserto.get();
            return ResponseEntity.ok(conserto);
        }
        return ResponseEntity.notFound().build();
    }
}
