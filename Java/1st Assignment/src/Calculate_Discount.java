public class Calculate_Discount {
	
	//This static method calculates the final cost of the appliance depending on the discount for each category.
	public static double calculateCost(Electrical_Appliance elApp){
		if(elApp instanceof Sound_Vision){
			return elApp.calculateValue(0.25);
		}
		else if(elApp instanceof Gaming){
			return elApp.calculateValue(0.1);
		}
		else if(elApp instanceof Home_Appliance){
			return elApp.calculateValue(0.2);
		}
		else{
			return -1;
		}
	}
	
}