/**
 * 
 */
package br.com.desafioCoopersystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bruno
 *
 */

@Table(name = "tb_usuario")
@Entity
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "ds_senha")
	private String dsSenha;

	@Column(name = "ds_tipo")
	private String dsTipo;
	
	@Column(name = "ds_nome")
	private String dsNome;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "ds_endereco")
	private Integer dsEndereco;
	
	@Column(name = "telefone")
	private Integer telefone;

	@Column(name = "ds_email")
	private Integer dsEmail;

}
