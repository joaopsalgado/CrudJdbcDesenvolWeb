package aluno.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AlunoDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluno");

	public static void inclui(String idade, String nome, String sobrenome) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Aluno al = new Aluno();
		al.setIdade(idade);
		al.setNome(nome);
		al.setSobrenome(sobrenome);
		
		em.persist(al);
		em.getTransaction().commit();
		em.close();
	}

	public static void alterar(String idade, String nome, String sobrenome) {
	}

	public static void excluir(String idade, String nome, String sobrenome) {
	}

	public static List<Aluno> listar() {
		EntityManager em = emf.createEntityManager();
		
		String jpql = "from Aluno";
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		List<Aluno> result = query.getResultList();
		em.close();
		return result;
	}
}
