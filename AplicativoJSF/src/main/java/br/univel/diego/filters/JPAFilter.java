package br.univel.diego.filters;
 
import java.io.IOException;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author Diego Rhoden
 * Este arquivo foi criado pra responder as requisições do faces servlet
 * 9 de nov de 2016 às 01:24
 */

@WebFilter(servletNames ={ "Faces Servlet" })
public class JPAFilter implements Filter {
 
 
	private EntityManagerFactory entityManagerFactory;
 
	private String persistence_unit_name = "unit_app";
 
    public JPAFilter() {
 
    }
    /**metodo que destroi o componente*/
	public void destroy() {
 
		this.entityManagerFactory.close();
	}
	/**este método "substitui" o doGet que utilizamos no servlet"*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
		/*temos aqui a criação do Entity Manager*/
		EntityManager entityManager =  this.entityManagerFactory.createEntityManager();
 
		/*adicionando o entitymanager à requisição*/
		request.setAttribute("entityManager", entityManager);
 
		/*começo da transação*/
		entityManager.getTransaction().begin();
 
		/*faces servlet é iniciado*/
		chain.doFilter(request, response);
 
		try {
 
			/*temos o tratamento, se nao der erro, faz commit*/
			entityManager.getTransaction().commit();
 
		} catch (Exception e) {
 
			/*caso tenha erro, roda o rollback*/
			entityManager.getTransaction().rollback();
		}
		finally{
 
			/*terminou tudo finaliza o entityManager*/
			entityManager.close();
		}
	}
 
	public void init(FilterConfig fConfig) throws ServletException {
 
		/*comando que cria o entityManagerFactory segundo o persistence.xml*/
		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistence_unit_name); 
	}
 
}