package UDP_code;
import java.io.*;
	import java.net.*;
class Rceiver implements Runnable{
		String GROUP_IP="228.5.6.7";
	    int port=6789;
	    MulticastSocket mr=null;
	    DatagramPacket p=null;
	    byte[] buf=new byte[256];
		public Rceiver(){	 
			try {
				mr=new MulticastSocket(port);
				InetAddress group=InetAddress.getByName(GROUP_IP);
				mr.joinGroup(group);
			}catch(IOException e) {
				System.err.println(e.toString());
			}
			}
		public void run(){
			try {
				System.out.println("start:");
	            p=new DatagramPacket(buf,buf.length);
	            while(true) {
	            	mr.receive(p);
	            	System.out.println(new String(buf)+p.getAddress());
	            }
			}catch(Exception e) {
				System.err.println(e.toString());
			}
			}
		  public static void main(String args[])throws IOException{
				Rceiver ds=new Rceiver();
				Thread tds=new Thread(ds);
				tds.start();
		  }
	}

