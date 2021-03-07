package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();               // выходной поток (ответ сервера)
                     //in входной поток (отправленный клиентом)
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (str != null && !str.isEmpty()) {
                        if (str.contains("Hello")) {
                            out.write("Hello\r\n\r\n".getBytes());
                        } else if (str.contains("Exit")) {
                            out.write("Exit\r\r\r\n".getBytes());
                            out.flush();
                            socket.close();
                            break;
                        } else {
                            out.write("What?\r\n\r\n".getBytes());
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}
