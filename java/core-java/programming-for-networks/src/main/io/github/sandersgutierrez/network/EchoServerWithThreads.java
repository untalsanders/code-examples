package io.github.sandersgutierrez.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a simple server multithreading that listens on port 8189 and replay all client inputs.
 */
public class EchoServerWithThreads {
    /**
     * This class handles the client inputs for a connection.
     */
    protected static class EchoServerWithThreadsHandler implements Runnable {
        /**
         * @hidden
         */
        private final Socket socket;
        private final int counter;

        /**
         * Construct a handler.
         * @param socket the connection incoming
         * @param counter counter of handlers
         */
        public EchoServerWithThreadsHandler(Socket socket, int counter) {
            this.socket = socket;
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                var is = socket.getInputStream();
                var os = socket.getOutputStream();

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

                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    /**
     * Start a socket server to serve connections of clients.
     */
    public static void startServer() throws IOException {
        try (var ss = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                var s = ss.accept();
                Runnable r = new EchoServerWithThreadsHandler(s, i);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }
    }
}
