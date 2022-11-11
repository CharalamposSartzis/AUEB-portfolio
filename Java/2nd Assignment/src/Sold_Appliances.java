
public class Sold_Appliances{		

		//Instance variables
		private int soldIndex;						
		private Electrical_Appliance soldAppliance;
		private String buyerName;
		private String buyerPhone;
		private String soldDate;
		//private Date soldDate;
		//SimpleDateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
		
		//Default constructor
		public Sold_Appliances(){
			
		}
		
		//Constructor
		public Sold_Appliances(int soldIndex,Electrical_Appliance soldApp,String buyerName,String buyerPhone,String soldDate){
			this.soldIndex=soldIndex;
			soldAppliance=soldApp;
			this.buyerName=buyerName;
			this.buyerPhone=buyerPhone;
			this.soldDate=soldDate;
		}
		
		//Getters
		public int getSoldIndex(){
			return soldIndex;
		}
		
		/*Setter for soldIndex.Increases the index for the sales by 1.*/
		public void setSoldIndex(){
			soldIndex+=1;
		}
		
		public Electrical_Appliance getSoldApp(){
			return soldAppliance;
		}
		
		public String getBuyerName(){
			return buyerName;
		}
		
		public String getBuyerPhone(){
			return buyerPhone;
		}
		
		public String getSoldDate(){
			return soldDate;
		}
			
		//Method that returns the sale's details.
		public String toString(){
			return("Sale Index: "+getSoldIndex()+"| Sold Appliance: \n"+getSoldApp()+"\n"+"| Buyer Name: "+getBuyerName()+"| Buyer Phone: "+getBuyerPhone()+"| Date of sale: "+getSoldDate()+"| Final cost: "+Calculate_Discount.calculateCost(soldAppliance)+" $\n");
		}
	
}
