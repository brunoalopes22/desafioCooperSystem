package br.com.desafioCoopersystem.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.desafioCoopersystem.model.UsuarioModel;

public interface UsuarioRepository extends Repository<UsuarioModel, Integer>{

	 void save(UsuarioModel usuarioModel);
	 
	 void delete(UsuarioModel usuarioModel);
 
	 List<UsuarioModel> findAll();
 
	 UsuarioModel findOne(Integer id);
	
}
