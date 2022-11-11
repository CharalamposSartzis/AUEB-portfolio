import java.util.*;

public class SoldCatalogue {
	
	//ArrayList with the sold appliances.
	private ArrayList<Sold_Appliances> soldApps=new ArrayList<Sold_Appliances>();
	
	//Returns the size of the Sold Appliances Catalogue.
	public int size(){
		return soldApps.size();
	}
	
	//Method that shows all the sold appliances.
	public void list(){
		for(int i=0;i<soldApps.size();i++){
			System.out.println(soldApps.get(i).toString());
		}
	}
	
	//Method that adds a sold appliance to the catalogue.
	public void add(Sold_Appliances sApp){
		soldApps.add(sApp);
	}
	
}