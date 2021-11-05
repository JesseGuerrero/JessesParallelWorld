import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)) {
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed");
                echoString = scanner.nextLine();

                output.writeUTF(echoString);
                output.flush();
                if (!echoString.equalsIgnoreCase("exit")) {
                    response = echoes.readLine();//waits for response
                    System.out.println(response);
                }
            } while (!echoString.equalsIgnoreCase("exit"));
        } catch(SocketTimeoutException e) {
            System.out.println("Socket timed out");
        } catch(IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
