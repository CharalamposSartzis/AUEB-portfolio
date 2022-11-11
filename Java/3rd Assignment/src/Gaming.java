
public class Gaming extends Electrical_Appliance{

		//Instance variables
		private String processor;
		private String graphics;
		private String sound;
		
		//Default constructor
		public Gaming(){
			super();
		}
		
		//Constructor
		public Gaming(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,String processor,String graphics,String sound,double cap){
			super(item_type,code,name,year,fact,value,copies,panel_type,cap);
			this.processor=processor;
			this.graphics=graphics;
			this.sound=sound;
		}
		
		//Getters
		public String getProc(){
			return processor;
		}
		
		public String getGraph(){
			return graphics;
		}
		
		public String getSound(){
			return sound;
		}
		
		//Setters		//<--
		public void setProc(String input){
			processor=input;
		}
		
		public void setGraph(String input){
			graphics=input;
		}
		
		public void setSound(String input){
			sound=input;
		}
		
		//Method that returns String depending on the Constructor.
		public String toString(){
			return(applianceDetails_2()+"(GB)"+" (of Hard Disk)"+"\n"+"| Processor: "+getProc()+"\n"+"| Graphics: "+getGraph()+"\n"+"| Sound: "+getSound()+"\n"+
				   "\n");
		}

	
}
