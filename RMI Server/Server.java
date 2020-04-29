import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Classe que configura o servidor RMI e instancia um objeto de processamento e
 * expõe para ser acessado remotamente
 */
public class Server {
  public Server() {
    try {

      // registra o objeto no registry do rmi
      LocateRegistry.createRegistry(2020);

      // instanciaçãod e um novo objeto com os métodos implementados
      Criptografia objRmi = new CriptografiaImpl();

      // disponibiliza o objeto instanciado no endereço
      Naming.rebind("rmi://localhost:2020/cripto", objRmi);

      System.out.println("Servidor rodando em rmi://localhost:2020/cripto");
    } catch (Exception ex) {
      System.out.println("Erro: " + ex.getMessage());
    }
  }

  public static void main(String args[]) {
    new Server();
  }
}