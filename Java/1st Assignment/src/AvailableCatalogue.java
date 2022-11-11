import java.util.*;

public class AvailableCatalogue {
	
	//ArrayList with the available appliances.
	private ArrayList<Electrical_Appliance> availableApps=new ArrayList<Electrical_Appliance>();
	
	//Method that returns the number of the available appliances.
	public int size(){
		return availableApps.size();
	}
	
	//Method that shows all the available appliances.
	public void list(){
		for(int i=0;i<availableApps.size();i++){
			System.out.println(availableApps.get(i));
		}
	}
	
	//Method that adds an appliance to the AvailableCatalogue.
	public void add(Electrical_Appliance elApp){
		availableApps.add(elApp);
	}
	
	//Method that removes an available appliance.
	public void remove(Electrical_Appliance elApp){
		for(int i=0;i<=availableApps.size();i++){
			if(availableApps.get(i)==elApp){
				availableApps.remove(i);
			}
		}
	}
	
	//Method that prints the appliance with the specific code.
	public void lookFor(String code){
		for(int i=0;i<availableApps.size();i++){
			if(availableApps.get(i).getCode().equals(code)){
				System.out.println(availableApps.get(i));
			}
		}
	}
	
	//Returns the appliance with the specific code.
	public Electrical_Appliance returnApp(String code){
		for(int i=0;i<availableApps.size();i++){
			if(availableApps.get(i).getCode().equals(code)){
				return availableApps.get(i);
			}
		}
		return null;
	}
	
}