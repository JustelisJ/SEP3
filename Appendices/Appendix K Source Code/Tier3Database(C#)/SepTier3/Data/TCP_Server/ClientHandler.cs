using Newtonsoft.Json;
using SepTier3.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace SepTier3.Data.TCP_Server
{
    public class ClientHandler
    {
        private static int PORT = 6666;

        public void Run()
        {
            IPAddress ipAddr = IPAddress.Parse("127.0.0.1");
            IPEndPoint localEndPoint = new IPEndPoint(ipAddr, PORT);

            Socket listener = new Socket(ipAddr.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            try
            {

                // Using Bind() method we associate a 
                // network address to the Server Socket 
                // All client that will connect to this  
                // Server Socket must know this network 
                // Address 
                listener.Bind(localEndPoint);

                // Using Listen() method we create  
                // the Client list that will want 
                // to connect to Server 
                listener.Listen(10);

                while (true)
                {
                    Console.WriteLine("Waiting connection ... ");

                    // Suspend while waiting for 
                    // incoming connection Using  
                    // Accept() method the server  
                    // will accept connection of client 
                    Socket clientSocket = listener.Accept();

                    // Data buffer 
                    byte[] bytes = new Byte[1024];
                    string data = null;

                    int numByte = clientSocket.Receive(bytes);
                    data += Encoding.ASCII.GetString(bytes, 0, numByte);

                    Console.WriteLine("Text received -> {0} ", data);

                    //Create a response message
                    string fetchedData = fetchData(data).Result;
                    byte[] response = Encoding.ASCII.GetBytes(fetchedData);

                    // Send a message to Client  
                    // using Send() method 
                    clientSocket.Send(response);

                    // Close client Socket using the 
                    // Close() method. After closing, 
                    // we can use the closed Socket  
                    // for a new Client Connection 
                    clientSocket.Shutdown(SocketShutdown.Both);
                    clientSocket.Close();
                }
            }

            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }

        private async Task<string> fetchData(string data)
        {
            HttpClient client = new HttpClient();
            string[] request = data.Split("|");
            if(request[0].Equals("GET"))
            {
                string uri = "https://localhost:44397/" + request[1];
                HttpResponseMessage response = await client.GetAsync(uri);
                response.EnsureSuccessStatusCode();
                string responseBody = await response.Content.ReadAsStringAsync();
                return responseBody;
            }
            if(request[0].Equals("POST"))
            {
                string uri = "https://localhost:44397/" + request[1];

                client.BaseAddress = new Uri(uri);
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));//ACCEPT header

                Customer customer = JsonConvert.DeserializeObject<Customer>(request[2]);

                HttpRequestMessage request1 = new HttpRequestMessage(HttpMethod.Post, "Customers");
                request1.Content = new StringContent(JsonConvert.SerializeObject(customer),
                                                    Encoding.UTF8,
                                                    "application/json");//CONTENT-TYPE header


                HttpResponseMessage response = await client.SendAsync(request1);
                response.EnsureSuccessStatusCode();
                string responseBody = await response.Content.ReadAsStringAsync();
                return responseBody;
            }
            return "Wrong format";
        }
    }
}
