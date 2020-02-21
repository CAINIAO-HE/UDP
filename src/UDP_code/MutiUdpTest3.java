package UDP_code;
import java.util.*;
import java.net.*;
import java.io.*;
public class MutiUdpTest3 {
	public static void main(String args[]) {
		String msg="hello";
		try {
		InetAddress grp=InetAddress.getByName("228.5.6.7");
		MulticastSocket s=new MulticastSocket(6789);
		s.joinGroup(grp);
		DatagramPacket hi=new DatagramPacket(msg.getBytes(),msg.length(),grp,6789);
		s.send(hi);
		byte[] buf=new byte[1000];
		DatagramPacket recv=new DatagramPacket(buf,buf.length);
		s.receive(recv);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
