package Main;

import java.io.IOException;
import java.util.Scanner;

import Core.Denon;
import Core.DenonProtocol;
import Core.DenonScanner;
import Exception.DenonNotFoundException;


public class Main {
	public static void main(String [] args) throws IOException {
		
		
		Denon d = null; 
		
		try{
			d = new Denon();
			if(d!=null){
				System.out.println("Connection established.");
			}
		}catch(DenonNotFoundException dnfe){
			
			System.out.println("Denon not found.");
			System.out.print("Write denon ip: ");
			Scanner c = new Scanner(System.in);
			d = new Denon(c.nextLine());
		}
		
		
		
		String [] args1 = new String[2];
		Scanner scanner = new Scanner(System.in);
		
		
		while(scanner.hasNextLine()){
			args1 = scanner.nextLine().split(" ");
			
			
			//System.out.println(cmd);
			if(args1[0].equals("1")){
				System.out.println(d.volumUp());
				
			}else if(args1[0].equals("2")){
				System.out.println(d.volumDown());
				
			}else if(args1[0].equals("3")){
				System.out.println(d.standby());
				
			}else if(args1[0].equals("4")){
				System.out.println(d.on());
				
			}else if(args1[0].equals("5")){
				d.mute();
			}else if(args1[0].equals("6")){
				int i = new Integer(args1[1]);
				d.soundMode(DenonProtocol.SoundMode.SOUND_MODE_ARRAY[i]);
				
			}else if(args1[0].equals("7")){
				int i = new Integer(args1[1]);
				d.source(DenonProtocol.INPUT_ARRAY[i]);
			}else if(args1[0].equals("8")){
				System.out.println(d.getSoundModeStatus());
			}else if(args1[0].equals("9")){
				System.out.println(d.getCurrentSource());
			}
		}
		
		d.close();
	
		
		  
	}
}
