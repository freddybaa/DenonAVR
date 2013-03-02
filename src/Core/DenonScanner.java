package Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class DenonScanner {
	private String gateway 	  = "";
	private int    port   = 23; 
	private BufferedWriter out = null;
	private BufferedReader in  = null;
	private Socket socket      = null;
	private InetAddress denon  = null;
	
	public DenonScanner() throws IOException{
		this.gateway = getGateway();
		if(gateway!=""){
			performScan(); 
		}
	}
	
	private String getGateway() throws UnknownHostException{
		String gateway = InetAddress.getLocalHost().getHostAddress();
		gateway = gateway.substring(0, gateway.length()-3);
		return gateway;
	}
	
	private void performScan(){
		String ip = "";
		for(int i=0;i<255;i++){
			ip = String.format("%s%s", this.gateway, i);
			scan(ip, port);
		}
	}

	public InetAddress getDenon(){
		return denon;
	}
	
	private void scan(String ip, int port){
		
	         try {
	        	 
	        	 socket = new Socket();
				 socket.connect(new InetSocketAddress(ip, port), 10);
				 
				 if(socket.isConnected()){
					 out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			         
			         out.write(DenonProtocol.REQUEST_POWER_STATUS);
			         out.flush();
			         String response = in.readLine();
			        
			         if(response.length()==9 || response.length()==4){
			        	 denon = socket.getInetAddress();
			         }
				 }
		         socket.close();
			} catch (IOException e) {
				
			}  
	}
}

