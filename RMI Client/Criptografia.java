import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * interface com a assinatura dos métodos a serem implementados pelo server e
 * consumidos pelo client
 */
public interface Criptografia extends Remote {

  /**
   * @param text Texto a ser encriptografado
   * @return Hash em Base64
   * @throws RemoteException Exceção que pode ocorrer durante a chamada remota
   */
  String criptografar(String text) throws RemoteException;

  /**
   * @param hash Hash em Base64 a ser convertido para texto
   * @return Texto descriptografado
   * @throws RemoteException Exceção que pode ocorrer durante a chamada remota
   */
  String descriptografar(String hash) throws RemoteException;

  /**
   * @param message Mensagem a ser escrita no log do servidor
   * @throws RemoteException
   */
  void log(String message) throws RemoteException;
}