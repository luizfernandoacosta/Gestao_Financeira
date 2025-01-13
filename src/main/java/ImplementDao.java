import javax.persistence.*;

public class ImplementDao implements DAO {
    private EntityManagerFactory emf;

    public ImplementDao() {
        // Inicializa o EntityManagerFactory
        this.emf = Persistence.createEntityManagerFactory("teste");

    }

    @Override
    public void adicionarConta(Conta conta) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(conta);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Usuario buscarUsuario(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            // Criar uma consulta JPQL para buscar o usuário por login e senha
            return em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class)
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Nenhum resultado encontrado
            return null;
        } finally {
            em.close();
        }
    }

}