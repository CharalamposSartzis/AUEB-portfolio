public class Sound_Vision extends Electrical_Appliance{
	
	//Instance variables
	private double analysis;
	private double screenSize;
		
	//Default constructor
	public Sound_Vision(){
		super();
	}
	
	//1st Constructor
	public Sound_Vision(String type,String code,String name,int year,String fact,double value,int copies,double analysis,double screenSize){
		super(type,code,name,year,fact,value,copies);
		this.analysis=analysis;
		this.screenSize=screenSize;
	}
	
	//2nd Constructor
	public Sound_Vision(String type,String code,String name,int year,String fact,double value,int copies,double analysis){
		super(type,code,name,year,fact,value,copies);
		this.analysis=analysis;
	}
	
	//Getters
	public double getAnal(){
		return analysis;
	}
	
	public double getScrSize(){
		return screenSize;
	}
	
	//Methods that return String depending on the 2 Constructors.
	public String soundVisionDetails_1(){
		return(applianceDetails_1()+"| Screensize(inches): "+getScrSize()+"| Analysis: "+getAnal());
	}
	
	public String soundVisionDetails_2(){
		return(applianceDetails_1()+"| Analysis(pixels): "+getAnal());
	}	
}