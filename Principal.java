import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Principal {
public static void main(String[] args) {
String endereco = JOptionPane.showInputDialog(null, "Informe o endereço a ser consultado:");
int porta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a porta a ser utilizada:"));

    try {
        Socket sock = new Socket(endereco, porta);
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String linha = "";
        out.println("GET / HTTP/1.0\n");
        while ((linha = in.readLine()) != null) {
            System.out.println("echo: " + linha);
        }
        out.close();
        in.close();
        sock.close();
    } catch (UnknownHostException e) {
        System.err.println("Não foi possível conectar ao host");
    } catch (IOException e) {
        System.err.println("Problemas de IO");
    }
}
}