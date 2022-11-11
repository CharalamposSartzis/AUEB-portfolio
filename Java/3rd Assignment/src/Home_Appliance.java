
public class Home_Appliance extends Electrical_Appliance{

		//Instance variables
		private String energyClass;
			
		//Default constructor
		public Home_Appliance(){
			super();
		}
		
		//1st Constructor
		public Home_Appliance(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,String enClass,double cap){
			super(item_type,code,name,year,fact,value,copies,panel_type,cap);
			energyClass=enClass;
		}
		
		//2nd Constructor
		public Home_Appliance(String item_type,String code,String name,int year,String fact,double value,int copies,String enClass,double cap){
			super(item_type,code,name,year,fact,value,copies,cap);
			energyClass=enClass;
		}
		
		//Getter
		public String getEnClass(){
			return energyClass;
		}
		
		//Setter		//<--
		public void setEnClass(String input){
			energyClass=input;
		}
		
		//Methods that return String depending on the 2 Constructors.		//<--
		public String homeAppDetails_1(){
			return(applianceDetails_2()+"(liters)"+" (of refrigerator)"+"\n"+"| Energy class: "+getEnClass()+"\n");
		}
		
		public String homeAppDetails_2(){
			return(applianceDetails_3()+"| Energy class: "+getEnClass()+"\n");
		}

	
}
