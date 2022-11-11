public class Gaming extends Electrical_Appliance{
	
	//Instance variables
	private String processor;
	private String graphics;
	private String sound;
	
	//Default constructor
	public Gaming(){
		super();
	}
	
	//Constructor
	public Gaming(String type,String code,String name,int year,String fact,double value,int copies,String processor,String graphics,String sound,double cap){
		super(type,code,name,year,fact,value,copies,cap);
		this.processor=processor;
		this.graphics=graphics;
		this.sound=sound;
	}
	
	//Getters
	public String getProc(){
		return processor;
	}
	
	public String getGraph(){
		return graphics;
	}
	
	public String getSound(){
		return sound;
	}
	
	//Method that returns String depending on the Constructor.
	public String toString(){
		return(applianceDetails_2()+"(GB)"+" (of Hard Disk)"+"| Processor: "+getProc()+"| Graphics: "+getGraph()+"| Sound: "+getSound());
	}
	
}