package com.patttern.bio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandle implements Runnable {

    private Socket socket;

    public ServerHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        try {
            while (true) {
                in = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(in);
                if (in != null) {
                    //读取客户端发送来的消息
                    String result = br.readLine();
                    if (result != "") {
                        System.out.println("客户端：" + result);
                        //向服务器端发送一条消息
                        System.out.println("向客户端回复信息：");
                        Scanner scan = new Scanner(System.in);
                        String mess = scan.nextLine();
                        if (mess != null) {
                            out = new OutputStreamWriter(socket.getOutputStream());
                            BufferedWriter bw = new BufferedWriter(out);
                            bw.write(mess + "\n");
                            bw.flush();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
