import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true) {
                String echoString = input.readLine();
                System.out.println("Recieved client info " + echoString);
                if(echoString.equalsIgnoreCase("exit"))
                    break;

                try {
                    Thread.sleep(5000);
                } catch(InterruptedException e) {
                    System.out.println("Threaded interrupt error: " + e.getMessage());
                }

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
