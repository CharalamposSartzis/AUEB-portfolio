public class Player extends Sound_Vision{
	
	//Protected constants
	protected static final String DVD="DVD";
	protected static final String BLU_RAY="Blu Ray";
	
	//Instance variables
	private String formatPlay;
	
	//Default constructor
	public Player(){
		super();
	}
	
	//Constructor
	public Player(String type,String code,String name,int year,String fact,double value,int copies,double analysis,String format){
		super(type,code,name,year,fact,value,copies,analysis);
		formatPlay=format;
	}
	
	//Getter
	public String getFormat(){
		return formatPlay;
	}
	
	//Method toString.
	public String toString(){
		return(soundVisionDetails_2()+"| Format play: "+getFormat());
	}
}