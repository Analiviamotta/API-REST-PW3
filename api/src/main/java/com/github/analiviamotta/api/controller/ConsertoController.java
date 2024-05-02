package com.github.analiviamotta.api.controller;

import com.github.analiviamotta.api.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository consertoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados,
                                    UriComponentsBuilder uriComponentsBuilder){
        var conserto = new Conserto(dados);
        consertoRepository.save(conserto);
        var uri = uriComponentsBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
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
        return consertoRepository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> optionalConserto = consertoRepository.findById(id);
        if(optionalConserto.isPresent()){
            Conserto conserto = optionalConserto.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacao dados){
        Conserto conserto = consertoRepository.getReferenceById(dados.id());
        conserto.atualizaDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }


}
