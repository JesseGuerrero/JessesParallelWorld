import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    static class Echoer2 extends Thread {
        private Socket socket;

        public Echoer2(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream input = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                while(true) {
                    String echoString = input.readUTF();
                    System.out.println("Recieved client info " + echoString);
                    if(echoString.equalsIgnoreCase("exit"))
                        break;
                    output.println("Server response: " + echoString);
                }
            } catch(IOException e) {
                System.out.println("Threaded: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch(IOException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true)
                new Echoer2(serverSocket.accept()).start();
        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
