public class Home_Appliance extends Electrical_Appliance{
	
	//Instance variables
	private String energyClass;
		
	//Default constructor
	public Home_Appliance(){
		super();
	}
	
	//1st Constructor
	public Home_Appliance(String type,String code,String name,int year,String fact,double value,int copies,String enClass,double cap){
		super(type,code,name,year,fact,value,copies,cap);
		energyClass=enClass;
	}
	
	//2nd Constructor
	public Home_Appliance(String code,String name,int year,String fact,double value,int copies,String enClass,double cap){
		super(code,name,year,fact,value,copies,cap);
		energyClass=enClass;
	}
	
	//Getter
	public String getEnClass(){
		return energyClass;
	}
	
	//Methods that return String depending on the 2 Constructors.
	public String homeAppDetails_1(){
		return(applianceDetails_2()+"(liters)"+" (of refrigerator)"+"| Energy class: "+getEnClass());
	}
	
	public String homeAppDetails_2(){
		return(applianceDetails_3()+"| Energy class: "+getEnClass());
	}
}