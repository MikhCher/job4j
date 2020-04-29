package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String message = getText(str);
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    switch (message) {
                        case "Hello": {
                            out.write("Hello".getBytes());
                            break;
                        }
                        case "Exit": {
                            server.close();
                            break;
                        }
                        default: {
                            out.write(message.getBytes());
                            break;
                        }
                    }
                }
            }
        }
    }

    private static String getText(String message) {
        return message.substring(message.indexOf("msg=") + 4, message.indexOf(" HTTP/1.1"));
    }
}
