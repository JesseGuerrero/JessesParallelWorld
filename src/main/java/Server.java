import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true)
                new Echoer(serverSocket.accept()).start();
        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }

    }
}
