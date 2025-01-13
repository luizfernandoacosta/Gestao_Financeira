public interface DAO {
    void adicionarConta(Conta conta);
    Usuario buscarUsuario(String login, String senha);
}
