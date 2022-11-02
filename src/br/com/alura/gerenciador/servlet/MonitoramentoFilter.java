package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		//Executar a a��o
		chain.doFilter(request, response);		
		
		long depois = System.currentTimeMillis(); // Calcular o tempo que a aplica��o demora para executar;
		System.out.println("Tempo de execu��o da acao: " + acao + " -> " + (depois - antes));
		
	}
	
	

}
