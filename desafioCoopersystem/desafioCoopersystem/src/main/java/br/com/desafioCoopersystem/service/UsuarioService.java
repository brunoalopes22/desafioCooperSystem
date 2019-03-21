package br.com.desafioCoopersystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioCoopersystem.model.UsuarioModel;
import br.com.desafioCoopersystem.model.ResponseModel;
import br.com.desafioCoopersystem.repository.UsuarioRepository;


@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioService;

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody UsuarioModel usuario) {

		try {

			this.usuarioService.save(usuario);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UM USUARIO
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody UsuarioModel usuario) {

		try {

			this.usuarioService.save(usuario);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * CONSULTAR TODOS OS USUARIOS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<UsuarioModel> consultar() {

		return this.usuarioService.findAll();
	}

	/**
	 * BUSCAR UM USUARIO PELO ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody UsuarioModel buscar(@PathVariable("id") Integer id) {

		return this.usuarioService.findOne(id);
	}

	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id) {

		UsuarioModel usuarioModel = usuarioService.findOne(id);

		try {

			usuarioService.delete(usuarioModel);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
