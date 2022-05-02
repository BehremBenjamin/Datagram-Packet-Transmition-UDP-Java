import java.io.IOException;
import java.net.*;

public class ClientSocket {
    public static void main(String[] args) throws UnknownHostException, IOException {
        DatagramSocket clientSocket = new DatagramSocket(2233);
        int packetLength = 1024;
        byte[] sendingPacket = new byte[packetLength];
        String messageToServer = "Hello Server. I'm sending you message!";
        sendingPacket = messageToServer.getBytes();
        DatagramPacket clientPacket = new DatagramPacket(sendingPacket, sendingPacket.length, InetAddress.getByName("localhost"), 2222);
        clientSocket.send(clientPacket);

        byte[] packetRecieve = new byte[packetLength];
        DatagramPacket recievingPacket = new DatagramPacket(packetRecieve, packetRecieve.length);
        clientSocket.receive(recievingPacket);
        String recievedMessage = new String(recievingPacket.getData()).trim();
        System.out.println(recievedMessage);
    }
}
