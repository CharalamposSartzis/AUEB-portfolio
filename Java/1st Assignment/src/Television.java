public class Television extends Sound_Vision{
	
	//Instance variables
	private String ports;
	
	//Default constructor
	public Television(){
		super();
	}
	
	//Constructor
	public Television(String type,String code,String name,int year,String fact,double value,int copies,double analysis,double screenSize,String ports){
		super(type,code,name,year,fact,value,copies,analysis,screenSize);
		this.ports=ports;
	}
	
	//Getter
	public String getPorts(){
		return ports;
	}
	
	//Method toString.
	public String toString(){
		return(soundVisionDetails_1()+"(pixels)"+"| Ports: "+getPorts());
	}
}