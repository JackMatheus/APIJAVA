package com.dio.livecoding.crud.salasdereuniao.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dio.livecoding.crud.salasdereuniao.exception.ResourceNotFoundException;
import com.dio.livecoding.crud.salasdereuniao.model.TarefaModel;
import com.dio.livecoding.crud.salasdereuniao.repository.TarefaRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TarefaController {
	@Autowired
	private TarefaRepository repository;	
	
	  @GetMapping(path = "/tarefa")
	  public List<TarefaModel> getAllTarefas() {
	    return repository.findAll();	  
	  }

	@PostMapping(path = "/tarefa")
	public TarefaModel salvar(@RequestBody TarefaModel tarefa) {
		return repository.save(tarefa);
	}
	
	@GetMapping(path = "/tarefa/{codigo}")
	public Optional<TarefaModel> consultarPeloCodigoId(@PathVariable Integer codigo) {
		return repository.findById(codigo);
	}
	
	
	@DeleteMapping(path = "tarefa/deletar/{codigo}")
	public void deletar(@PathVariable Integer codigo) {
		repository.deleteById(codigo);
	}
	
	@PutMapping(path = "/tarefa/{codigo}")
	public ResponseEntity<TarefaModel> atualizarPeloCodigoId(@PathVariable (value = "id") Integer codigo,
								@Valid @RequestBody TarefaModel tarefaDetails) throws ResourceNotFoundException {
	TarefaModel tarefa = repository.findById(codigo)
	 .orElseThrow(() -> new ResourceNotFoundException("Tarefa not found for this id :: " + codigo));

	tarefa.setDescricao(tarefaDetails.getDescricao());
	tarefa.setPrioridade(tarefaDetails.getPrioridade());
	final TarefaModel updateTarefa = repository.save(tarefa);
	return ResponseEntity.ok(updateTarefa);

	}




}
