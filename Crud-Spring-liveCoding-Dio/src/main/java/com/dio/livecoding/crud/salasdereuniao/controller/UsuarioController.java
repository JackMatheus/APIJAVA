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
import com.dio.livecoding.crud.salasdereuniao.model.Room;
import com.dio.livecoding.crud.salasdereuniao.model.TarefaModel;
import com.dio.livecoding.crud.salasdereuniao.model.UsuarioModel;
import com.dio.livecoding.crud.salasdereuniao.repository.UsuarioRepository;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping("/usuario")
    public List<UsuarioModel> getAllUsuario() {
      return repository.findAll();
    }    
    
    @PostMapping(path = "/usuario")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
        return repository.save(usuario);
    }
    
    @GetMapping(path = "/usuario/{codigo}")
    public Optional<UsuarioModel> consultarPeloCodigoId(@PathVariable Integer codigo) {
 		return repository.findById(codigo);
 	
    }    
	
	@DeleteMapping(path = "usuario/deletar/{codigo}")
	public void deletar(@PathVariable Integer codigo) {
		repository.deleteById(codigo);
	}
	
	@PutMapping(path = "/usuario/{codigo}")
	public ResponseEntity<UsuarioModel> atualizarPeloCodigoId(@PathVariable (value = "id") Integer codigo,
								@Valid @RequestBody UsuarioModel usuarioDetails) throws ResourceNotFoundException {
	UsuarioModel usuario = repository.findById(codigo)
	 .orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + codigo));

	usuario.setNome(usuarioDetails.getNome());
	usuario.setEmail(usuarioDetails.getEmail());
	final UsuarioModel updateUsuario = repository.save(usuario);
	return ResponseEntity.ok(updateUsuario);

	}

    

}
