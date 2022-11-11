public class Washing_Machine extends Home_Appliance {
	
	//Instance variables
	private int turns;
	
	//Default constructor
	public Washing_Machine(){
		super();
	}
	
	//Constructor
	public Washing_Machine(String code,String name,int year,String fact,double value,int copies,String enClass,double cap,int turns){
		super(code,name,year,fact,value,copies,enClass,cap);
		this.turns=turns;
	}
	
	//Getter
	public int getTurns(){
		return turns;
	}
	
	//Method toString.
	public String toString(){
		return(homeAppDetails_2()+"| Turns(per second): "+getTurns());
	}
}