package com.patttern.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int port = 777;

    static ServerSocket serverSocket = null;

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("启动服务器....");
        Socket socket = serverSocket.accept();
        //System.out.println("客户端已连接到服务器");
        new Thread(new ServerHandle(socket)).start();
    }
}
