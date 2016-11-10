package br.univel.diego.repository;

import java.io.Serializable;

import javax.persistence.Query;

import br.univel.diego.model.UsuarioModel;
import br.univel.diego.repository.entity.UsuarioEntity;
import br.univel.diego.uteis.Uteis;

/**
 * @author Diego Rhoden
 *aqui teremos o validausuario
 * 9 de nov de 2016 às 02:29:47
 */

public class UsuarioRepository implements Serializable {
		
	private static final long serialVersionUID = 1L;
	 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			/*consulta do entity manager*/
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			/*usuario e senha*/
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			/*este metodo getsingleresult retorna um object, porém com o cast ele retornará um usuarioentity*/
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
	
}
