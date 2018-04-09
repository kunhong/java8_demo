package com.company.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
            while(true) {
                System.out.println("[서버] 연결 기다림");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
                System.out.println("[서버] 연결 수락함 : " + isa.getHostName());

                byte[] bytes = null;
                String message = null;

                InputStream is = socket.getInputStream();
                bytes = new byte[100];

                // read 메소드 블로킹 해제되는 경우
                // 1) 상대방이 데이터를 보냄
                // 2) 상대방이 정상적으로 Socket의 close를 호출 (-1 리턴)
                // 3) 상대방이 비정상적으로 종료 (IOException 발생)
                int readByteCount = is.read(bytes);

                if (-1 == readByteCount) {
                    throw new IOException();
                }

                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[서버] 데이터 받기 성공 : " + message);

                OutputStream os = socket.getOutputStream();
                message = "Hello Client";
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("[서버] 데이터 보내기 성공");

                is.close();
                is.close();
                socket.close();

            }

        }catch (Exception e) {

        }

        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {

            }
        }
    }
}
