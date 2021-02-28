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
    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();               // выходной поток (ответ сервера)
                     //in входной поток (отправленный клиентом)
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    StringBuilder sb = new StringBuilder();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); !str.isEmpty(); str = in.readLine()) {
                        sb.append(str);
                    }
                    if (sb.toString().contains("Hello")) {
                        out.write("Hello\r\n\r\n".getBytes());
                    } else if (sb.toString().contains("Exit")) {
                        socket.close();
                        break;
                    } else {
                        out.write("What?\r\n\r\n".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}
