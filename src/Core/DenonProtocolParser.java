package Core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DenonProtocolParser {
	
	private static Pattern pattern     = null;
	private static String regex 	   = "";
	private static Matcher m           = null;
	
	public static String parsePowerStatus(String toParse){
		regex = "(^PW.*)";
		return parse(toParse, regex);
	}
	public static String parseVolumStatus(String toParse){
		regex = "(^MV[0-9]+)";
		return parse(toParse, regex);		
	}
	public static String parseSourceStatus(String toParse){
		regex = "(^SI.*)";
		return parse(toParse, regex);
	}
	public static String parseSoundModeStatus(String toParse){
		regex = "(^MS.*)";
		return parse(toParse, regex);
	}
	
	private static String parse(String toParse, String regex){
		String parsedString = "";
		pattern = Pattern.compile(regex);
		
		m = pattern.matcher(toParse);
		
		if(m.find()) parsedString =  m.group();

		return parsedString;
	}
	
	
	public static void main(String [] args){
		
		
		DenonProtocolParser.parsePowerStatus("PWON");
		DenonProtocolParser.parsePowerStatus("PWSTANDBY");
		DenonProtocolParser.parsePowerStatus("MVMK");
		DenonProtocolParser.parsePowerStatus("SIBD");
		DenonProtocolParser.parseSourceStatus("SIBD");
		DenonProtocolParser.parseSourceStatus("SVSOURCE");
		DenonProtocolParser.parseVolumStatus("MVMAX 60");
		DenonProtocolParser.parseVolumStatus("MV275");
		DenonProtocolParser.parseVolumStatus("MV27");
		DenonProtocolParser.parseSourceStatus("MV27");
		System.out.println(DenonProtocolParser.parseSoundModeStatus("MSOLBY DIGITAL"));
		System.out.println(DenonProtocolParser.parseSoundModeStatus("MSLOL MULTI CHAN"));
		System.out.println(DenonProtocolParser.parseSoundModeStatus("MSCINEMA 6"));
		System.out.println(DenonProtocolParser.parseSoundModeStatus("MSSTEREO"));
		
	}
}
