
public class Sound_Vision extends Electrical_Appliance{

		//Instance variables
		private double analysis;
		private double screenSize;
			
		//Default constructor
		public Sound_Vision(){
			super();
		}
		
		//1st Constructor
		public Sound_Vision(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double analysis,double screenSize){
			super(item_type,code,name,year,fact,value,copies,panel_type);
			this.analysis=analysis;
			this.screenSize=screenSize;
		}
		
		//2nd Constructor
		public Sound_Vision(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double analysis){
			super(item_type,code,name,year,fact,value,copies,panel_type);
			this.analysis=analysis;
		}
		
		//Getters
		public double getAnal(){
			return analysis;
		}
		
		public double getScrSize(){
			return screenSize;
		}
		
		//Setters		//<--
		public void setAnal(String input){
			analysis=Double.parseDouble(input);
		}
		
		public void setScrSize(String input){
			screenSize=Double.parseDouble(input);
		}
		
		//Methods that return String depending on the 2 Constructors.
		public String soundVisionDetails_1(){
			return(applianceDetails_1()+"| Screensize(inches): "+getScrSize()+"\n"+"| Analysis: "+getAnal());
		}
		
		public String soundVisionDetails_2(){
			return(applianceDetails_1()+"| Analysis(pixels): "+getAnal()+"\n");
		}
	
}
