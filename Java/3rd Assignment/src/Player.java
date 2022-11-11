
public class Player extends Sound_Vision{

		//Protected constants
		protected static final String DVD="DVD";
		protected static final String BLU_RAY="Blu Ray";
		
		//Instance variables
		private String formatPlay;
		
		//Default constructor
		public Player(){
			super();
		}
		
		//Constructor
		public Player(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double analysis,String format){
			super(item_type,code,name,year,fact,value,copies,panel_type,analysis);
			formatPlay=format;
		}
		
		//Getter
		public String getFormat(){
			return formatPlay;
		}
		
		//Setter		//<--
		public void setFormat(String input){
			this.formatPlay=input;
		}
		
		//Method toString.		//<--
		public String toString(){
			return(soundVisionDetails_2()+"| Format play: "+getFormat()+"\n"+
				   "\n");
		}

	
}
