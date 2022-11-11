
public class Electrical_Appliance {

		//Instance variables.
		private String item_type;		//Common
		private String code;
		private String modelName;
		private int modelYear;
		private String manufacturer;
		private double value;
		private int copies;
		private String panel_type;		//<---
		private double capacity;
		
		private String imagePath;

		//Default constructor
		public Electrical_Appliance(){
			
		}
		
		//1st Constructor
		public Electrical_Appliance(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type){
			this.item_type=item_type;	
			this.code=code;
			modelName=name;
			modelYear=year;
			manufacturer=fact;
			this.value=value;
			this.copies=copies;
			this.panel_type=panel_type;		//
		}
		
		//2nd Constructor
		public Electrical_Appliance(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double cap){
			this.item_type=item_type;	
			this.code=code;
			modelName=name;
			modelYear=year;
			manufacturer=fact;
			this.value=value;
			this.copies=copies;
			this.panel_type=panel_type;		//
			capacity=cap;  //
		}
		
		//3rd Constructor	--> without panel_type
		public Electrical_Appliance(String item_type,String code,String name,int year,String fact,double value,int copies,double cap){
			this.item_type=item_type;	
			this.code=code;
			modelName=name;
			modelYear=year;
			manufacturer=fact;
			this.value=value;
			this.copies=copies;
			capacity=cap;  //
		}
		
		//Getters
		public String getItemType(){
			return item_type;
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
		
		public String getPanelType(){
			return panel_type;
		}
		
		public double getCap(){
			return capacity;
		}
		
		//Setters		//<--
		public void setItemType(String input){
			item_type=input;
		}
		
		public void setCode(String input){
			code=input;
		}
		
		public void setName(String input){
			modelName=input;
		}
		
		public void setYear(String input){
			modelYear=Integer.parseInt(input);
		}
		
		public void setFact(String input){
			manufacturer=input;
		}
		
		public void setValue(String input){
			value=Double.parseDouble(input);
		}
		
		public void setCopies(String input){
			copies=Integer.parseInt(input);
		}
		
		public void setPanelType(String input){
			panel_type=input;
		}
		
		public void setCap(String input){
			capacity=Double.parseDouble(input);
		}
		
		/*Setter and Getter for path.*/
		public void setImagePath(String path){
			imagePath = path;
		}
		
		public String getImagePath(){
			return imagePath;
		}
			
		/*Reduces the available copies.*/
		public void OneLessCopie(){
			copies-=1;
		}
		
		//Method that calculates value with the discount.
		public double calculateValue(double discount){
			double cost=value;
			return cost-=discount*cost;
		}
		
		//Prints the common characteristics of the Available appliances.
		public String applianceDetails(){
			return("Item type: "+getItemType()+"\n"+"| Code: "+getCode()+"\n"+"| Model name: "+getName()+"\n"+"| Production year: "+getYear()+"\n"+"| Manufacturer: "+getFact()+"\n"+"| Value(without discount): "+getValue()+" $"+"\n"+"| Available copies: "+getCopies()+"\n");
		}
		
		//Methods that return String depending on the 3 Constructors.		//<--
		public String applianceDetails_1(){
			return("Item type: "+getItemType()+"\n"+"| Code: "+getCode()+"\n"+"| Model name: "+getName()+"\n"+"| Production year: "+getYear()+"\n"+"| Manufacturer: "+getFact()+"\n"+"| Value(without discount): "+getValue()+" $"+"\n"+"| Available copies: "+getCopies()+"\n"+"| Panel type: "+getPanelType()+"\n");
		}
		
		public String applianceDetails_2(){
			return("Item type: "+getItemType()+"\n"+"| Code: "+getCode()+"\n"+"| Model name: "+getName()+"\n"+"| Production year: "+getYear()+"\n"+"| Manufacturer: "+getFact()+"\n"+"| Value(without discount): "+getValue()+" $"+"\n"+"| Available copies: "+getCopies()+"\n"+"| Panel type: "+getPanelType()+"\n"+"| Capacity: "+getCap());
		}

		public String applianceDetails_3(){
			return("Item type: "+getItemType()+"\n"+"| Code: "+getCode()+"\n"+"| Model name: "+getName()+"\n"+"| Production year: "+getYear()+"\n"+"| Manufacturer: "+getFact()+"\n"+"| Value(without discount): "+getValue()+" $"+"\n"+"| Available copies: "+getCopies()+"\n"+"| Capacity(kg): "+getCap()+"\n");
		}
	
}
