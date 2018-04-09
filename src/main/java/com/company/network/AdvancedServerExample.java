package com.company.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvancedServerExample {
    ExecutorService executorService; // 스레드풀
    ServerSocket serverSocket; // 클라이언트의 연결 수락
    List<Client> connections = new Vector<>();

    // ExecutorService 생성, ServerSocket 생성 및 포트 바인딩, 연결 수락 코드
    void startServer() {
        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() // CPU 코어의 수만큼 스레드를 생성
        );

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
        } catch (Exception e) {
            if(!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }

        // 수락 작업 생성
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Socket socket = serverSocket.accept();
                        String message = "[연결 수락 : " + socket.getRemoteSocketAddress() +
                                " : " + Thread.currentThread().getName() + "]";
                        System.out.println(message);

                        connections.add(new Client(socket));
                        System.out.println("[연결 개수] " + connections.size());
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                            stopServer();
                        }
                        break;
                    }
                }
            }
        };

        executorService.submit(runnable);
    }

    void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();

            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }

            if (null != serverSocket && !serverSocket.isClosed()) {
                serverSocket.close();
            }

            if(null != executorService && !executorService.isShutdown()) {
                executorService.shutdown();
            }

            System.out.println("[서버 멈춤]");


        } catch (Exception e) {

        }

    }


    class Client {
        Socket socket;
        Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        void receive() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            byte[] byteArr = new byte[100];
                            InputStream is = socket.getInputStream();

                            int readByteCount = is.read(byteArr);

                            if (-1 == readByteCount) {
                                throw new IOException();
                            }

                            System.out.println("[요청 처리] " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
                            String data = new String(byteArr, 0, readByteCount, "UTF-8");

                            for (Client client : connections) {
                                client.send(data); // 모든 클라이언트에게 보냄
                            }

                        }

                    } catch (Exception e) {
                        try {
                            connections.remove(Client.this);
                            System.out.println("[클라이언트 통신 안됨] " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
                            socket.close();

                        } catch (IOException e1) {

                        }

                    }

                }
            };

            executorService.submit(runnable); // 스레드 풀에서 처리

        }

        void send(String data) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] byteArr = data.getBytes("UTF-8");
                        OutputStream os = socket.getOutputStream();
                        os.write(byteArr);
                        os.flush();
                    } catch (Exception e) {
                        try {
                            System.out.println("[클라이언트 통신 안됨] " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
                            socket.close();
                        } catch (IOException e2) {

                        }

                    }
                }
            };
            executorService.submit(runnable);

        }

    }

}
