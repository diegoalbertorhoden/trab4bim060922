package br.univel.diego.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Diego Rhoden
 * esta classe terá um método de recuperação do EntityManager
 * 9 de nov de 2016 às 02:13
 */

public class Uteis {
	
	public static EntityManager JpaEntityManager(){
		 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		ExternalContext externalContext = facesContext.getExternalContext();
 
		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
		return (EntityManager)request.getAttribute("entityManager");
	} 
	
		/*este método com a instancia atual joga uma mensagem como alerta na tela*/
		public static void Mensagem(String mensagem){
	 
			FacesContext facesContext = FacesContext.getCurrentInstance();
	 
			facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
		}
	 
		/*este método é igual ao anterior, porém como atendção e não alerta*/
		public static void MensagemAtencao(String mensagem){
	 
			FacesContext facesContext = FacesContext.getCurrentInstance();
	 
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
		}
	 
		/*esta é como mensagem de informação*/
		public static void MensagemInfo(String mensagem){
	 
			FacesContext facesContext = FacesContext.getCurrentInstance();
	 
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
		}
	
}
