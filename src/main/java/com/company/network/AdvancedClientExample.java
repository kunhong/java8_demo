package com.company.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class AdvancedClientExample {
    Socket socket;

    void startClient() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress("localhost", 5001));
                    System.out.println("[연결 완료] " + socket.getRemoteSocketAddress());

                } catch (Exception e) {
                    if(!socket.isConnected()) {
                        stopClient();

                    }
                    return;

                }

                receive();
            }
        };

        thread.start();

    }

    void stopClient() {
        try {
            System.out.println("클라이언트 연결 끊음");
            if (socket != null && !socket.isConnected()) {
                socket.close();
            }

        } catch (Exception e) {

        }

    }

    void receive() {
        while (true) {
            try {
                byte[] byteArr = new byte[100];
                InputStream inputStream = socket.getInputStream();
                int readByteCount = inputStream.read(byteArr);
                if (-1 == readByteCount) {
                    throw new IOException();
                }
                String data = new String(byteArr, 0, readByteCount, "UTF-8");
                System.out.println("[클라이언트] 데이터 받기 성공 : " + data);
            } catch (Exception e) {
                stopClient();
                break;

            }

        }

    }

    void send(String data) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    byte[] byteArr = data.getBytes("UTF-8");

                    OutputStream os = socket.getOutputStream();
                    os.write(byteArr);
                    os.flush();
                    System.out.println("[클라이언트] 데이터 보내기 성공");
                } catch (Exception e) {
                    System.out.println("클라이언트 서버 통신 안됨");
                    stopClient();

                }

            }
        };

        thread.start();

    }
}
