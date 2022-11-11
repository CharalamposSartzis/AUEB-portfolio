
public class Camera extends Sound_Vision{

		//Instance variables
		private int opticalZoom;
		private int digitalZoom;	
		
		//Default constructor
		public Camera(){
			super();
		}
		
		//Constructor
		public Camera(String item_type,String code,String name,int year,String fact,double value,int copies,String panel_type,double analysis,double screenSize,int optZoom,int digZoom){
			super(item_type,code,name,year,fact,value,copies,panel_type,analysis,screenSize);
			opticalZoom=optZoom;
			digitalZoom=digZoom;
		}
		
		//Getters
		public int getOptZoom(){
			return opticalZoom;
		}
		
		public int getDigZoom(){
			return digitalZoom;
		}
		
		//Setters		//<--
		public void setOptZoom(String input){
			opticalZoom=Integer.parseInt(input);
		}
		
		public void setDigZoom(String input){
			digitalZoom=Integer.parseInt(input);
		}
		
		//Method toString.
		public String toString(){
			return(soundVisionDetails_1()+"(Megapixel)"+"\n"+"| Optical zoom: "+getOptZoom()+"*"+"\n"+"| Digital zoom: "+getDigZoom()+"*"+"\n"+
				   "\n");
		}

	
}
