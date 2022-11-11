public class Fridge extends Home_Appliance {
	
	//Instance variables
	private double freezerCapacity;
	
	//Default constructor
	public Fridge(){
		super();
	}
	
	//Constructor
	public Fridge(String type,String code,String name,int year,String fact,double value,int copies,String enClass,double cap,double freezCap){
		super(type,code,name,year,fact,value,copies,enClass,cap);
		freezerCapacity=freezCap;
	}
	
	//Getter
	public double getFreezCap(){
		return freezerCapacity;
	}
	
	//Method toString.
	public String toString(){
		return(homeAppDetails_1()+"| Freezer capacity(liters): "+getFreezCap());
	}
}