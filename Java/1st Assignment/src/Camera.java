public class Camera extends Sound_Vision{
	
	//Instance variables
	private int opticalZoom;
	private int digitalZoom;	
	
	//Default constructor
	public Camera(){
		super();
	}
	
	//Constructor
	public Camera(String type,String code,String name,int year,String fact,double value,int copies,double analysis,double screenSize,int optZoom,int digZoom){
		super(type,code,name,year,fact,value,copies,analysis,screenSize);
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
	
	//Method toString.
	public String toString(){
		return(soundVisionDetails_1()+"(Megapixel)"+"| Optical zoom: "+getOptZoom()+"*"+"| Digital zoom: "+getDigZoom()+"*");
	}
	
}