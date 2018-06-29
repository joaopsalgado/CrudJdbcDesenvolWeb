package aluno.jpa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/aluno")
public class AlunoController extends HttpServlet {
	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
			if (result == null) { result = padrao;}
		        return result;
	            }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String mensagem;
			String es = valor(req, "escolha", "");
			String idade = valor(req, "idade", "");
			String nome = valor(req, "nome", "");
			String sobrenome = valor(req, "nome", "");
			if (es.equals("incluir")) {
			    AlunoDAO.inclui(idade, nome, sobrenome);
				mensagem = "Sua escolha foi processada com sucesso!";
			} else if (es.equals("alterar")) {
				AlunoDAO.alterar(idade, nome, sobrenome);
				mensagem = "Alteração realizada com sucesso.";
			} else if (es.equals("excluir")) {
				AlunoDAO.excluir(idade, nome, sobrenome);
				mensagem = "Exclusão realizada com sucesso.";
			} else if (es.equals("")) {
				mensagem = "";
			} else {
				throw new IllegalArgumentException("Escolha \"" + es + "\" com erro.");
			}
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("aluno", AlunoDAO.listar());
			
			req.getRequestDispatcher("/jpa/aluno-view.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}
