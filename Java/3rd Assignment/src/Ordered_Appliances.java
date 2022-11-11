
public class Ordered_Appliances{		

		//Instance variables
		private int orderIndex;							
		private Electrical_Appliance orderedAppliance;
		private String ordererName;
		private String ordererPhone;
		private String orderDate;
		private String arrivalDate;
		//SimpleDateFormat dt=new SimpleDateFormat("dd/mm/yyyy"); 
		/*private double finalCost;*/
		private boolean isExecuted;
		
		
		//Default constructor
		public Ordered_Appliances(){
			
		}
		
		//Constructor
		public Ordered_Appliances(int orderIndex,Electrical_Appliance ordApp,String ordName,String ordPhone,String ordDate,String arrDate,boolean isExec){
			this.orderIndex=orderIndex; 
			this.orderedAppliance=ordApp;	//works either with "this." or without it at the begining	
			this.ordererName=ordName; //works either with "this." or without it at the begining
			ordererPhone=ordPhone; //works either with "this." or without it at the begining
			orderDate=ordDate; //works either with "this." or without it at the begining
			arrivalDate=arrDate; //works either with "this." or without it at the begining
			isExecuted=isExec; //works either with "this." or without it at the begining
		}
		
		//Getters
		public int getOrderIndex(){
			return orderIndex;
		}
		
		/*Setter for orderIndex.Increases the index for the orders by 1.*/
		public void setOrderIndex(){
			orderIndex+=1;
		}
		
		public Electrical_Appliance getOrdApp(){
			return orderedAppliance;
		}
		
		public String getOrdName(){
			return ordererName;
		}
		
		public String getOrdPhone(){
			return ordererPhone;
		}

		public String getOrdDate(){
			return orderDate;
		}
		
		public String getArrDate(){
			return arrivalDate;
		}
			
		public boolean isExecuted(){
			return isExecuted;
		}
		
		/*Setter for isExecuted. Gives the value true to the boolean variable isExecuted.*/
		public void setExecuted(){
			isExecuted=true; 
		}
		
		//Method that returns the order's details.
		public String toString(){
			return("Order Index: "+getOrderIndex()+"| Ordered Appliance: \n"+getOrdApp()+"\n"+"| Orderer Name: "+getOrdName()+
			"| Orderer Phone: "+getOrdPhone()+"| Date of order: "+getOrdDate()+"\n"+"| Expected date of arrival: "+getArrDate()+
			"| Order executed: "+isExecuted()+"| Final cost: "+Calculate_Discount.calculateCost(orderedAppliance)+" $\n");
		}
	
}
