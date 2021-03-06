package br.com.adriel.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*AUTOR ADRIEL
 * NESSA CLASE VAMOS VALIDAR SE O USUARIO ESTA LOGADO NO SISTEMA
 * PARA PERMITIR ACESSO AOS ARQUIVOS QUE ESTAO NA PASTA SISTEMA
 * SE NAO EXISTIR USUARIO ELE RETORNA A PAGINA DE LOGIN*/

import br.com.adriel.model.UsuarioModel;

@WebFilter("/sistema/*")
public class AutenticacaoFilter implements Filter {

   public AutenticacaoFilter() {

   }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession httpSession 				= ((HttpServletRequest) request).getSession(); 

		HttpServletRequest httpServletRequest   = (HttpServletRequest) request;

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if(httpServletRequest.getRequestURI().indexOf("index.xhtml") <= -1){

			UsuarioModel usuarioModel =(UsuarioModel) httpSession.getAttribute("usuarioAutenticado");

			if(usuarioModel == null){

				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/index.xhtml");

			}
			else{

				chain.doFilter(request, response);
			}
		}		
		else{

			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}