import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program to create a socket connection to the atomic clock located in Boulder,
 * Colorado and print the time that send the server.
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        var remoteAddress = "time-A.timefreq.bldrdoc.gov";
        var remotePort = 13;

        try (Socket s = new Socket(remoteAddress, remotePort)) {
            var is = s.getInputStream();
            var in = new Scanner(is);

            while (in.hasNextLine()) {
                var line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
