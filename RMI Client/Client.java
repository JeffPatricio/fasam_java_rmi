import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    try {

      String[] opcoes = { "Criptografar", "Descriptografar", "Sair" };
      String escolha = "";
      String mensagem = "";
      Criptografia objRmi = (Criptografia) Naming.lookup("rmi://localhost:2020/cripto");
      objRmi.log("Nova conexão");

      JTextArea textArea = new JTextArea(2, 2);
      textArea.setWrapStyleWord(true);
      textArea.setLineWrap(true);
      textArea.setCaretPosition(0);
      textArea.setEditable(false);
      textArea.setBackground(new Color(238, 238, 238));

      do {

        escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma das opções", "Java RMI",
            JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == "Criptografar") {

          mensagem = JOptionPane.showInputDialog("Informe a mensagem a ser criptografada:");
          if (mensagem != null) {
            textArea.setText(("Hash:\n" + objRmi.criptografar(mensagem)));
            JOptionPane.showMessageDialog(null, textArea, "Mensagem Criptografada: ", JOptionPane.INFORMATION_MESSAGE);
          }

        } else if (escolha == "Descriptografar") {

          mensagem = JOptionPane.showInputDialog("Informe a mensagem a ser descriptografada:");
          if (mensagem != null) {
            textArea.setText(("Mensagem:\n" + objRmi.descriptografar(mensagem)));
            JOptionPane.showMessageDialog(null, textArea, "Mensagem Descriptografada: ",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }

      } while (escolha != "Sair" && escolha != null);

      objRmi.log("Cliente Desconectado");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro durante a execução", 0);
    }
  }
}
