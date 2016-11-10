package br.univel.diego.usuario.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.univel.diego.model.UsuarioModel;
import br.univel.diego.repository.UsuarioRepository;
import br.univel.diego.repository.entity.UsuarioEntity;
import br.univel.diego.uteis.Uteis;

/**
 * @author Diego Rhoden
 *criado para login, logout e verificação de quem está logado
 * 9 de nov de 2016 às 12:37:37
 */
/*mandando a classe em um bean gerenciado pelo CDI*/
@Named(value="usuarioController")
/*definição do escopo do bean*/
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	/*injeção de dependencia em usuarioModel*/
	@Inject
	private UsuarioModel usuarioModel;
	/*injeção de dependencia em usuarioRepository*/
	@Inject
	private UsuarioRepository usuarioRepository;
	/*injeção de dependencia em usuarioEntity*/
	@Inject
	private UsuarioEntity usuarioEntity;
	/*Getter*/
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	/*Setter*/
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	/*método para pegar o usuario que tá logado(autenticado)*/
	public UsuarioModel GetUsuarioSession(){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		return (UsuarioModel)facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}
	/*pega a instancia atual e desloga, voltando para a index*/
	public String Logout(){

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index.xhtml?faces-redirect=true";
	}
	/*método para fazer login, com validação se o campo está vazio*/
	public String EfetuarLogin(){

		if(StringUtils.isEmpty(usuarioModel.getUsuario()) || StringUtils.isBlank(usuarioModel.getUsuario())){

			Uteis.Mensagem("Favor informar o login!");
			return null;
		}
		else if(StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())){

			Uteis.Mensagem("Favor informara senha!");
			return null;
		}
		else{	

			usuarioEntity = usuarioRepository.ValidaUsuario(usuarioModel);

			if(usuarioEntity!= null){

				usuarioModel.setSenha(null);
				usuarioModel.setCodigo(usuarioEntity.getCodigo());


				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);


				return "sistema/home?faces-redirect=true";
			}
			else{

				Uteis.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}


	}

}