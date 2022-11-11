
public class Television extends Sound_Vision{

		//Instance variables
		private String ports;
		
		//Default constructor
		public Television(){
			super();
		}
		
		//Constructor
		public Television(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double analysis,double screenSize,String ports){
			super(item_type,code,name,year,fact,value,copies,panel_type,analysis,screenSize);
			this.ports=ports;
		}
		
		//Getter
		public String getPorts(){
			return ports;
		}
		
		//Setter		//<--
		public void setPorts(String input){
			ports=input;
		}
		
		//Method toString.
		public String toString(){
			return(soundVisionDetails_1()+"(pixels)"+"\n"+"| Ports: "+getPorts()+"\n"+
				   "***************************************************************");
		}
	
}
