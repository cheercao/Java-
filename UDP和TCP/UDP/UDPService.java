package src.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPService {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            socket.receive(packet);

            byte[] datas = packet.getData();
            String receiveData = new String(datas,0,datas.length);
            System.out.println(receiveData);

            if(receiveData.equals("bye")){
                break;
            }
        }
        socket.close();

    }
}
