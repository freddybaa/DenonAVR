package Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import Exception.DenonNotFoundException;


public class Denon {
	
	private String 		   	ip  			= ""; 
	private int    		   	port          	= 23; 
	private BufferedWriter 	out			 	= null;
	private BufferedReader 	in           	= null; 
	private Socket         	s             	= null;
	private boolean         mute            = false;
	private int             delay           = 200; 
	private int             delay_startup   = 3000; 
	private DenonScanner    denonScanner    = null;
	
	public Denon() throws IOException, DenonNotFoundException{
		findDenon();
		startClient();
	}

	public Denon(String ip){
		this.ip = ip;
		startClient();
	}
	
	private void findDenon() throws IOException, DenonNotFoundException{
		denonScanner = new DenonScanner();
		InetAddress denon = denonScanner.getDenon();
		
		if(denon!=null){
			this.ip = denonScanner.getDenon().getCanonicalHostName();
		}else{
			throw new DenonNotFoundException("Could not find the denon device. Are you sure it is connected to the internet?");
		}
	}
	
	private void startClient(){
		 s = new Socket();
		 try {
			s.connect(new InetSocketAddress(ip, port), 500);
		} catch (IOException e) {

		}
		 
		 try {
			out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			delay(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	private void delay(int delay){
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isOn() throws IOException{
		
		write(DenonProtocol.REQUEST_POWER_STATUS, delay);
		if(in.readLine()=="PWON") return true;
		else return false;
		
	}
	
	private void write(String protocol, int delay) throws IOException{
		if(in.ready())in.readLine();
		delay(delay);
		out.write(protocol);
		out.flush();
	}
	
	public String on() throws IOException{
		
		write(DenonProtocol.POWER_ON, delay_startup);
		return DenonProtocolParser.parsePowerStatus(in.readLine());
	}
	
	
	public String standby() throws IOException{
		write(DenonProtocol.POWER_OFF, delay_startup);
		return DenonProtocolParser.parsePowerStatus(in.readLine());
	}
	
	public void mute() throws IOException{
		if(mute==true){
			write(DenonProtocol.MUTE_OFF, delay);
			mute = false;
		}else{
			mute = true;
			write(DenonProtocol.MUTE_ON, delay);
		}
	}
	
	public String volumUp() throws IOException{
		write(DenonProtocol.VOLUM_UP, delay);
		return DenonProtocolParser.parseVolumStatus(in.readLine());
	}
	public String volumDown() throws IOException{
		write(DenonProtocol.VOLUM_DOWN, delay);
		return DenonProtocolParser.parseVolumStatus(in.readLine());
	}
	public String getPowerStatus() throws IOException{
		write(DenonProtocol.REQUEST_POWER_STATUS, delay);
		return DenonProtocolParser.parsePowerStatus(in.readLine());
	}
	public String getCurrentSource() throws IOException{
		write(DenonProtocol.REQUEST_SOURCE_STATUS,delay);
		return DenonProtocolParser.parseSourceStatus(in.readLine());
	}
	public String getSoundModeStatus() throws IOException{
		write(DenonProtocol.SoundMode.REQUEST_SOUND_MODE_STATUS, delay);
		return DenonProtocolParser.parseSoundModeStatus(in.readLine());
	}
	public void source(String source) throws IOException{
		write(source, delay);
		//return DenonProtocolParser.parseSourceStatus(in.readLine());
	}
	public void soundMode(String mode) throws IOException{
		write(mode, delay);
		//return DenonProtocolParser.parseSoundModeStatus(in.readLine());
	}
	public void close() throws IOException{
		out.close();
		s.close();
		in.close();
		
	}
	
}
