package com.company.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket();
            System.out.println("[클라이언트] 연결 요청");
            socket.connect(new InetSocketAddress("localhost", 5001));
            System.out.println("[클라이언트] 연결 성공");

            byte[] bytes = null;
            String mesaage = null;

            OutputStream os = socket.getOutputStream();
            mesaage = "Hello Server";
            bytes = mesaage.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("[클라이언트] 데이터 보내기 성공");

            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            int readByteCount = is.read(bytes);
            mesaage = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("[클라이언트] 데이터 받기 성공 : " + mesaage);

            os.close();
            is.close();

        } catch (Exception e) {

        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }
}
