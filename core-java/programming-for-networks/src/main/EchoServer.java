import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a simple server that listens on port 8189 and replay all client inputs.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (var ss = new ServerSocket(8189)) {
            var s = ss.accept();
            var is = s.getInputStream();
            var os = s.getOutputStream();

            var in = new Scanner(is);
            var out = new PrintWriter(os, true);

            out.println("!Hello¡ type BYE to exit");

            var finished = false;
            while (!finished && in.hasNextLine()) {
                var line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) {
                    finished = true;
                }
            }
        }
    }
}
