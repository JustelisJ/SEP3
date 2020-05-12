using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Threading.Tasks;

using System.Text;
using System.Text.Json;
using System.Net;

namespace TruckDriveTier1.Data
{
    public class SClient
    {


        private IPEndPoint serverAddress;
        private Socket clientSocket;

        public SClient()
        {
            
        }

        public void Send(string toSend)
        {
            connect();
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(toSend);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(toSend);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);

            byte temp1 = toSendLenBytes[0];
            byte temp2 = toSendLenBytes[3];
            toSendLenBytes[0] = temp2;
            toSendLenBytes[3] = temp1;
            temp1 = toSendLenBytes[1];
            temp2 = toSendLenBytes[2];
            toSendLenBytes[1] = temp2;
            toSendLenBytes[2] = temp1;

            clientSocket.Send(toSendLenBytes);
            clientSocket.Send(toSendBytes);
        }

        public string Recive()
        {
            byte[] rcvLenBytes = new byte[4];
            clientSocket.Receive(rcvLenBytes);

            byte temp1 = rcvLenBytes[0];
            byte temp2 = rcvLenBytes[3];
            rcvLenBytes[0] = temp2;
            rcvLenBytes[3] = temp1;
            temp1 = rcvLenBytes[1];
            temp2 = rcvLenBytes[2];
            rcvLenBytes[1] = temp2;
            rcvLenBytes[2] = temp1;

            int rcvLen = System.BitConverter.ToInt32(rcvLenBytes, 0);
            byte[] rcvBytes = new byte[rcvLen];
            clientSocket.Receive(rcvBytes);

            string rcv = System.Text.Encoding.ASCII.GetString(rcvBytes);

            return rcv;


        }

        private void connect()
        {
            serverAddress = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 6789);

            clientSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            clientSocket.Connect(serverAddress);
        }
    }
}
