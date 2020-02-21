package UDP_code;
import java.net.*;
import java.util.*;
import java.io.*;
class Sender implements Runnable{ 
	String GROUP_IP="228.5.6.7";
    int port=6789;
    MulticastSocket ms=null;
    DatagramPacket p=null;
    InetAddress address=null;
    byte[] buf=new byte[256];
	public  Sender(){	
		try {
			ms=new MulticastSocket(port);
			InetAddress group=InetAddress.getByName(GROUP_IP);
			ms.joinGroup(group);
		}catch(IOException e) {
			System.err.println(e.toString());
		}
	}
	public void run(){
		try {
			int i=0;
			address=InetAddress.getByName(GROUP_IP);
			while(true) {
				buf=("第"+i+"次从发送端送出到组播信息").getBytes();
			    p=new DatagramPacket(buf,buf.length,address,port);
			    ms.send(p);
			    Thread.sleep(2000);
			  i++;
			}
		
	    }catch(Exception e) { 
	    	ms.close();
	    	
	    	System.err.println(e.toString());
	    }
		}
	
  public static void main(String args[])throws IOException{
	Sender ds=new Sender();
	Thread tds=new Thread(ds);
	tds.start();
}
}



