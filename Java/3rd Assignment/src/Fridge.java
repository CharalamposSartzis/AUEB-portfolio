
public class Fridge extends Home_Appliance {

		//Instance variables
		private double freezerCapacity;
		
		//Default constructor
		public Fridge(){
			super();
		}
		
		//Constructor
		public Fridge(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,String enClass,double cap,double freezCap){
			super(item_type,code,name,year,fact,value,copies,panel_type,enClass,cap);
			freezerCapacity=freezCap;
		}
		
		//Getter
		public double getFreezCap(){
			return freezerCapacity;
		}
		
		//Setter		//<--
		public void setFreezCap(String input){
			freezerCapacity=Double.parseDouble(input);
		}
		
		//Method toString.
		public String toString(){
			return(homeAppDetails_1()+"| Freezer capacity(liters): "+getFreezCap()+"\n"+
				   "\n");
		}

	
}
