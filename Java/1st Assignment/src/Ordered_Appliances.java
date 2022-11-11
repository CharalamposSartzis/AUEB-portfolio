//import java.text.SimpleDateFormat;
//import java.util.Date;

public class Ordered_Appliances extends Electrical_Appliance{
	
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
		orderedAppliance=ordApp;		
		ordererName=ordName;
		ordererPhone=ordPhone;
		orderDate=ordDate;
		arrivalDate=arrDate;
		isExecuted=isExec;
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
	
	/*Setter for isExecuted. Gives the value trueto the boolean variable isExecuted.*/
	public void setExecuted(){
		isExecuted=true; 
	}
	
	//Method that returns the order's details.
	public String toString(){
		return("Order Index: "+getOrderIndex()+"| Ordered Appliance: ["+getOrdApp()+"]"+"| Name: "+getOrdName()+"| Phone: "+getOrdPhone()+"| Date of order: "+getOrdDate()+"| Expected date of arrival: "+getArrDate()+"| Order executed: "+isExecuted()+"| Final cost: "+Calculate_Discount.calculateCost(orderedAppliance)+" $");
	}
	
}