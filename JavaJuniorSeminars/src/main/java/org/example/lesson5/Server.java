package org.example.lesson5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class Server {
    public static final int PORT = 8181;
    private static long clientIdCounter = 1L;
    private static Map<Long, SocketWrapper> clients = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            while (true) {
                final Socket client = server.accept();
                final long clientId = clientIdCounter++;

                SocketWrapper wrapper = new SocketWrapper(clientId, client);
                System.out.println("Подключился новый клиент[" + wrapper + "]");
                clients.put(clientId, wrapper);

                new Thread(() -> {
                    try (Scanner input = wrapper.getInput(); PrintWriter output = wrapper.getOutput()) {
                        output.println("Подключение успешно. Список всех клиентов: " + clients);

                        while (true) {
                            String clientInput = input.nextLine();
                            if (Objects.equals("q", clientInput)) {
                                // todo разослать это сообщение всем остальным клиентам
                                clients.remove(clientId);
                                clients.values().forEach(it -> it.getOutput().println("Клиент [" + clientId + "] отключился"));
                                break;
                            } else {
                                int symbol = clientInput.indexOf("@");
                                if (symbol != -1) {
                                    long destinationId = Long.parseLong(clientInput.substring(1,2));
                                    if(clients.containsKey(destinationId)) {
                                        SocketWrapper destination = clients.get(destinationId);
                                        destination.getOutput().println("Сообщение от клиента [" + clientId + "]: " + clientInput);
                                    } else {
                                        output.println(("Клиент [" + destinationId + "] не подключен к серверу"));
                                    }
                                } else {
                                    clients.values().stream().
                                            forEach(t -> t.getOutput().println("Сообщение всем от клиента: ["
                                                    + clientId + "]: " + clientInput));
                                }
                            }
                        }
                    }
                }).start();
            }
        }
    }
}
