package br.univel.diego.model;

import java.io.Serializable;

/**
 * @author Diego Rhoden
 * só getters and setters
 * 9 de nov de 2016 às 02:25:48
 */

public class UsuarioModel implements Serializable{
	
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
