public class Electrical_Appliance {
	
	//Instance variables.
	private String type;
	private String code;
	private String modelName;
	private int modelYear;
	private String manufacturer;
	private double value;
	private int copies;
	private double capacity;

	//Default constructor
	public Electrical_Appliance(){
		
	}
	
	//1st Constructor
	public Electrical_Appliance(String type,String code,String name,int year,String fact,double value,int copies){
		this.type=type;	//
		this.code=code;
		modelName=name;
		modelYear=year;
		manufacturer=fact;
		this.value=value;
		this.copies=copies;
	}
	
	//2nd Constructor
	public Electrical_Appliance(String type,String code,String name,int year,String fact,double value,int copies,double cap){
		this.type=type;	//
		this.code=code;
		modelName=name;
		modelYear=year;
		manufacturer=fact;
		this.value=value;
		this.copies=copies;
		capacity=cap;  //
	}
	
	//3rd Constructor
	public Electrical_Appliance(String code,String name,int year,String fact,double value,int copies,double cap){
		this.code=code;
		modelName=name;
		modelYear=year;
		manufacturer=fact;
		this.value=value;
		this.copies=copies;
		capacity=cap;  //
	}
	
	//Getters
	public String getType(){
		return type;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getName(){
		return modelName;
	}
	
	public int getYear(){
		return modelYear;
	}
	
	public String getFact(){
		return manufacturer;
	}
	
	public double getValue(){
		return value;
	}
	
	public int getCopies(){
		return copies;
	}
	
	/*Reduces the available copies.*/
	public void OneLessCopie(){
		copies-=1;
	}
	
	public double getCap(){
		return capacity;
	}

	//Method that calculates value with the discount.
	public double calculateValue(double discount){
		double cost=value;
		return cost-=discount*cost;
	}
	
	
	//Methods that return String depending on the 4 Constructors.
	public String applianceDetails_1(){
		return("Type: "+getType()+"| Code: "+getCode()+"| Model name: "+getName()+"| Production year: "+getYear()+"| Manufacturer: "+getFact()+"| Value(without discount): "+getValue()+" $"+"| Available copies: "+getCopies());
	}
	
	public String applianceDetails_2(){
		return("Type: "+getType()+"| Code: "+getCode()+"| Model name: "+getName()+"| Production year: "+getYear()+"| Manufacturer: "+getFact()+"| Value(without discount): "+getValue()+" $"+"| Available copies: "+getCopies()+"| Capacity: "+getCap());
	}

	public String applianceDetails_3(){
		return("Code: "+getCode()+"| Model name: "+getName()+"| Production year: "+getYear()+"| Manufacturer: "+getFact()+"| Value(without discount): "+getValue()+" $"+"| Available copies: "+getCopies()+"| Capacity(kg): "+getCap());
	}

	
}