package Core;

public class DenonProtocol {
	
	//CR 
	public static String CARRIAGE_RETURN = "\r";
	
	//power
	public static String POWER_ON = "PWON" + CARRIAGE_RETURN;
	public static String POWER_OFF = "PWSTANDBY" + CARRIAGE_RETURN;
	public static String REQUEST_POWER_STATUS = "PW?" + CARRIAGE_RETURN;
	
	//volum
	public static String VOLUM_UP = "MVUP" + CARRIAGE_RETURN;
	public static String VOLUM_DOWN = "MVDOWN" + CARRIAGE_RETURN;
	public static String REQUEST_VOLUM_STATUS = "MV?" + CARRIAGE_RETURN;
	
	//mute
	public static String MUTE_ON = "MUON" + CARRIAGE_RETURN;
	public static String MUTE_OFF = "MUOFF" + CARRIAGE_RETURN;
	public static String REQUEST_MUTE_STATUS = "MU?" + CARRIAGE_RETURN;
	
	//input 
	public static String SOURCE_PHONO = "SIPHONO" + CARRIAGE_RETURN; 
	public static String SOURCE_CD	 = "SICD" + CARRIAGE_RETURN;
	public static String SOURCE_DVD = "SIDVD" + CARRIAGE_RETURN;
	public static String SOURCE_BD = "SIBD" + CARRIAGE_RETURN;
	public static String SOURCE_TV = "SITV" + CARRIAGE_RETURN;
	public static String SOURCE_SATCBL = "SISAT/CBL" + CARRIAGE_RETURN;
	public static String SOURCE_GAME = "SIGAME" + CARRIAGE_RETURN;
	public static String REQUEST_SOURCE_STATUS = "SI?" + CARRIAGE_RETURN;
	public static String INPUT_ARRAY [] = {SOURCE_PHONO, SOURCE_CD, SOURCE_DVD, SOURCE_BD, SOURCE_TV, SOURCE_SATCBL, SOURCE_GAME};
	
	//sleep timer 
	public static String SLEEP_OFF = "SLPOFF" + CARRIAGE_RETURN;
	public static String SLEEP_IN = "SLP";
	public static String REQUEST_SLEEP_STATUS = "SLP?" + CARRIAGE_RETURN;
	
	public static class SoundMode{
	//Sound mode
	public static String MOVIE = "MSMOVIE" + CARRIAGE_RETURN; 
	public static String MUSIC = "MSMUSIC" + CARRIAGE_RETURN;
	public static String GAME =  "MSGAME"   + CARRIAGE_RETURN; 
	public static String DIRECT = "MSDIRECT" + CARRIAGE_RETURN; 
	public static String STEREO = "MSSTEREO" + CARRIAGE_RETURN; 
	public static String STANDARD = "MSSTANDARD" + CARRIAGE_RETURN;
	public static String DOLBY_DIGITAL = "MSDOLBY DIGITAL" + CARRIAGE_RETURN;
	public static String DTS_SURROND = "MSDTS SURROND" + CARRIAGE_RETURN;
	public static String MCH_STEREO  = "MSMCH STEREO" + CARRIAGE_RETURN;
	public static String REQUEST_SOUND_MODE_STATUS = "MS?" + CARRIAGE_RETURN;
	public static String SOUND_MODE_ARRAY [] = {MOVIE, MUSIC, GAME, DIRECT, STEREO, STANDARD, DOLBY_DIGITAL, DTS_SURROND, MCH_STEREO};
	}
}
