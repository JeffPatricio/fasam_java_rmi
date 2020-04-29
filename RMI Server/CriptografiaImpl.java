import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Base64;
import java.util.Calendar;

/**
 * Classe do servidor que realiza a implementação dos métodos da interface
 * Criptografia
 */
public class CriptografiaImpl extends UnicastRemoteObject implements Criptografia {

  private static final long serialVersionUID = 5311167496047815145L;

  public CriptografiaImpl() throws RemoteException {
    super();
  }

  @Override
  public String criptografar(String text) {
    this.log("========| Criptografia |=============================================================================");
    String cripto = new String(Base64.getEncoder().encode(text.getBytes()));
    this.log("Texto: " + text + " | Hash: " + cripto);
    return cripto;
  }

  @Override
  public String descriptografar(String hash) {
    this.log("========| Descriptografia |===========================================================================");
    String text = new String(Base64.getDecoder().decode(hash.getBytes()));
    this.log("Hash: " + hash + " | Texto: " + text);
    return text;
  }

  @Override
  public void log(String message) {
    System.out.println(Calendar.getInstance().getTime() + "| " + message);
  }
}