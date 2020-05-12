import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ClientHandler implements Runnable{

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    private Request request;

    public ClientHandler(Socket socket) {
        this.socket = socket;

        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Gson gson= new Gson();
            byte[] byteLen = new byte[4];
            in.read(byteLen);

            int length = ByteBuffer.wrap(byteLen).getInt();
            byte[] requestByte = new byte[length];
            in.read(requestByte);
            String req = new String(requestByte, 0, length);
            request = gson.fromJson(req, Request.class);

            System.out.println("Request got from " + socket.getInetAddress().getHostAddress());

            String result = request.CallTier3();
            int resultLen = result.length();
            byteLen = ByteBuffer.allocate(4).putInt(resultLen).array();
            out.write(byteLen, 0, 4);
            out.flush();
            byte[] resultByte = new byte[resultLen];
            resultByte = result.getBytes();
            out.write(resultByte, 0, resultLen);
            out.flush();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
