package MVVM.Model.Networking;

import com.google.gson.Gson;
import shared.Request;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ServerConnection implements ConnectionInterface{

    private final int PORT = 6789;
    private final String HOST = "localhost";

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ServerConnection(){

    }

    @Override
    public String Send(Request request) {
        try {
            connectToServer();

            //Sends json to the server
            Gson gson= new Gson();
            byte[] byteLen = new byte[4];
            String json = gson.toJson(request);
            int requestLen = json.length();
            byteLen = ByteBuffer.allocate(4).putInt(requestLen).array();
            out.write(byteLen, 0, 4);
            out.flush();
            byte[] requestByte = new byte[requestLen];
            requestByte = json.getBytes();
            out.write(requestByte, 0, requestLen);
            out.flush();

            //Receive response from the java server
            in.read(byteLen);
            int length = ByteBuffer.wrap(byteLen).getInt();
            byte[] resultByte = new byte[length];
            in.read(resultByte);
            String result = new String(resultByte, 0, length);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    private void connectToServer() {
        try {
            clientSocket = new Socket(HOST, PORT);
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
