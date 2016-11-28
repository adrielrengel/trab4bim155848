package br.com.adriel.model;

import java.io.Serializable;
/*AUTOR: ADRIEL
 * NESSA CLASE ESTAMOS CRIANDO O MODELO DO USUARIO
 * SETANDO OS ATRIBUTOS QUE CADA USUARIO TERÁ*/
public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String codigo;
	private String usuario;
	private String senha;
 
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
}