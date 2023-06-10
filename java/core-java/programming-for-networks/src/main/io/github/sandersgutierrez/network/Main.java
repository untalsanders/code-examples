package io.github.sandersgutierrez.network;

import java.io.*;

/**
 * @hidden
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TestSocket.start();
        // EchoServerWithThreads.startServer();
        // try (OutputStream fos = new FileOutputStream("data.txt")) {
        //     for (var i = 0x10; i <= 0x19; i++) {
        //         fos.write(i);
        //     }
        // }

        try (InputStream fis = new FileInputStream("data.txt")) {
            int val = fis.read();
            System.out.println(val);
        }
    }
}
