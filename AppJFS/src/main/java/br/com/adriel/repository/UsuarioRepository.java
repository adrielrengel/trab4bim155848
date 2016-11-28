package br.com.adriel.repository;

import java.io.Serializable;

import javax.persistence.Query;
 
import br.com.adriel.model.UsuarioModel;
import br.com.adriel.repository.entity.UsuarioEntity;
import br.com.adriel.uteis.Uteis;
 
 /*AUTOR ADRIEL
  * USADO PARA VALIDAR SE USUARIO EXISTE */
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
}