import java.io.IOException;
import java.net.*;

public class ServerSocket {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverDatagramSocket = new DatagramSocket(2222);
        int packetLength = 1024;
        byte[] packetRecieve = new byte[1024];
        DatagramPacket recievedPacket = new DatagramPacket(packetRecieve, packetRecieve.length);
        serverDatagramSocket.receive(recievedPacket);
        InetAddress clientAddress = recievedPacket.getAddress();
        int clientPort = recievedPacket.getPort();
        String message = new String(recievedPacket.getData()).trim();


        System.out.println("Packet recieved from " + clientAddress + " port " + clientPort
                + " message: " + message);

        String messageToClient = "Thank you, I`ve recieved your message!";
        byte[] packetSend = new byte[packetLength];
        packetSend = messageToClient.getBytes();
        DatagramPacket sendingPacket = new DatagramPacket(packetSend, packetSend.length, InetAddress.getByName("localhost"), 2233);
        serverDatagramSocket.send(sendingPacket);
    }
}
