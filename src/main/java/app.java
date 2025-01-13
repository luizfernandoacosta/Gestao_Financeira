import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class app {
    public static void main(String[] args) throws ParseException {

        DAO dao = new ImplementDao();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dddd/MM/yy");


        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();


        Usuario usuario = dao.buscarUsuario(login, senha); // Busca o usuário no banco de dados
        if (usuario != null && usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
            // Código a ser executado se o usuário for encontrado e os dados forem válidos


        // Código a ser executado se o usuário não for nulo e os dados estiverem corretos


            System.out.println("Informe o Valor Da Conta: ");
            float valor = Float.parseFloat(sc.nextLine());

            System.out.println("Informe a Data Da Conta: ");
            Date datacompra = sdf.parse(sc.nextLine());

            System.out.println("Informe a Data Do Pagamento Da Conta: ");
            Date datapgmnto = sdf.parse(sc.nextLine());

            System.out.println("Informe o Meio De Pagamento Da Conta: ");
            String meiopgmnto = sc.nextLine();

            System.out.println("Informe a Descrição Da Conta: ");
            String descricao = sc.nextLine();

            Conta conta = new Conta();
            conta.setValor(valor);
            conta.setDatacompra(datacompra);
            conta.setDatapgmnto(datapgmnto);
            conta.setMeiopgmnto(meiopgmnto);
            conta.setDescricao(descricao);
            dao.adicionarConta(conta);

           System.out.println("A conta no valor de: " + valor + " realizada na data: " + datacompra + " deve ser paga no dia: " + datapgmnto + " esta compra foi feita no: " + meiopgmnto + " A compra trata-se de: " + descricao);
        }
    }
}