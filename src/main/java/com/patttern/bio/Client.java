package com.patttern.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    final static int port = 777;

    static Socket soket = null;

    public static void send() {
        InputStream is = null;
        OutputStream os = null;
        try {
            soket = new Socket("127.0.0.1", port);

            //构建IO
            is = soket.getInputStream();
            os = soket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            while (true) {
                //向服务器端发送一条消息
                System.out.println("向服务器发送信息：");
                Scanner scan = new Scanner(System.in);
                String mess = scan.nextLine();
                if (mess != null) {
                    bw.write(mess + "\n");
                    bw.flush();

                    //读取服务器返回的消息
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String result = br.readLine();
                    System.out.println("服务器：" + result);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
