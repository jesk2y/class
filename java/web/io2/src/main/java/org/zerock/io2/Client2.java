package org.zerock.io2;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws Exception{

        Scanner keyScanner = new Scanner(System.in);

        System.out.println("Input Your Message");

        String msg = keyScanner.next() + "\n";

        Socket socket = new Socket("10.10.10.83",7777);

        OutputStream out = socket.getOutputStream();
        Scanner inScanner = new Scanner(socket.getInputStream());

        out.write(msg.getBytes());
        out.flush();

        String receiveMsg = inScanner.nextLine();
        System.out.println("RECEIVE: " + receiveMsg);
        out.close();
        socket.close();

    }
}
