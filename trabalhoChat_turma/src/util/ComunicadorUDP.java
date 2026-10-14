package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ComunicadorUDP {

    public static DatagramPacket montaMensagem(String mensagem, String ip, int porta) throws UnknownHostException {
        try {
            byte[] buffer = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), porta);
            return pacote;
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public static void enviaMensagem(DatagramSocket s, DatagramPacket pacote) throws IOException {
        try {
            s.send(pacote);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static DatagramPacket recebeMensagem(DatagramSocket s) throws IOException {
        try {
            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);
            s.receive(pacote);
            return pacote;
        } catch (IOException e) {
            return null;
        }
    }
}