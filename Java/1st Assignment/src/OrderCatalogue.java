import java.util.*;

public class OrderCatalogue {
	
	//ArrayList with the ordered appliances.
	private ArrayList<Ordered_Appliances> orderedApps=new ArrayList<Ordered_Appliances>();
	
	//Returns the size of the Ordered Appliances Catalogue.
	public int size(){
		return orderedApps.size();
	}
	
	//Method that shows all the ordered appliances.
	public void list(){
		for(int i=0;i<orderedApps.size();i++){
			System.out.println(orderedApps.get(i).toString());
		}
	}
	
	//Method that adds an ordered appliance to the catalogue.
	public void add(Ordered_Appliances sApp){
		orderedApps.add(sApp);
	}
	
	//Method that removes an ordered appliance.
	public void remove(Ordered_Appliances elApp){
		for(int i=0;i<=orderedApps.size();i++){
			if(orderedApps.get(i)==elApp){
				orderedApps.remove(i);
			}
		}
	}
	
	//Prints the ordered appliance with the specific orderIndex.
	public void lookForOrdApp(int ordIndex){
		for(int i=0;i<orderedApps.size();i++){
			if(orderedApps.get(i).getOrderIndex()==ordIndex){
				 System.out.println(orderedApps.get(i));
			}
		}
	}
	
	//Returns the ordered appliance with the specific orderIndex.
	public Ordered_Appliances returnOrdApp(int ordIndex){
		for(int i=0;i<orderedApps.size();i++){
			if(orderedApps.get(i).getOrderIndex()==ordIndex){
				return orderedApps.get(i);
			}
		}
		return null;
	}
	
	
}