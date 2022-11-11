/* 
TEAM:
CHARALAMPOS SARTZIS, 3140179
LOUKAS KARATHANASOPOULOS, 3140070
DIMITRIOS KREMMYDAS, 3140255
*/





//import java.text.SimpleDateFormat;
import java.util.*;

public class mainApp {

	public static void main(String[] args){
		
		//Scanner for reading from the command line.
		Scanner in=new Scanner(System.in);
		
		//Initialize catalogues.
		AvailableCatalogue availCat=new AvailableCatalogue();
		SoldCatalogue soldCat=new SoldCatalogue();
		OrderCatalogue orderCat=new OrderCatalogue();
		
		/*Two appliances for Television*/
		Television tv1=new Television("LCD","1224a","SUHD",2014,"Samsung",300,2,720,32,"HDMI");
		Television tv2=new Television("LED","1326b","FullHD",2015,"LG",400,3,1080,42,"HDMI");	
		
		/*Two appliances for Player*/
		Player pl1=new Player(Player.DVD,"1428c","DVP2800",2014,"Philips",30,2,720,"BD-R");	
		Player pl2=new Player(Player.BLU_RAY,"1530d","BD-J5500",2015,"Samsung",66,1,1080,"BD-RD");	  
		
		/*Two appliances for Camera*/
		Camera cm1=new Camera("compact","1632e","Cyber-shot W800",2015,"Sony",78,2,14.0,2.7,5,6);	   
		Camera cm2=new Camera("compact","1734f","Easyshare M531",2015,"Kodak",119,2,20.1,2.7,3,4);	
		
		/*Three appliances for Gaming*/
		Gaming gm1=new Gaming("PS4","1836g","C Chassis",2015,"Sony",312,3,"APU","GPU","audio",500);	
		Gaming gm2=new Gaming("Xbox","1938h","360 E",2014,"Microsoft",189,2,"Xenon","GPU","audio",500);	
		Gaming gm3=new Gaming("Wii","2040i","U Basic Pack",2013,"Nintendo",300,1,"Broadway","GPU","audio",8);	  
		
		/*Two appliances for Fridge*/
		Fridge fr1=new Fridge("Onedoor","2244j","WME 36652 W",2013,"Whirlpool",420,1,"A++",363,0);	
		Fridge fr2=new Fridge("Twodoor","2346k","K5885X4",2014,"NEFF",1014.4,2,"A+",223,94);	 
		
		/*Two appliances for Washing_Machine*/
		Washing_Machine wm1=new Washing_Machine("2448l","L68281VFL",2014,"AEG",340,2,"A+++",8,1200);	 
		Washing_Machine wm2=new Washing_Machine("2550m","WAK20160GR",2014,"Bosch",350,2,"A+++",8,1000);	
		
		//Add the appliances to the AvailableCatalogue.
		availCat.add(tv1); availCat.add(tv2); 
		availCat.add(pl1); availCat.add(pl2); 
		availCat.add(cm1); availCat.add(cm2);
		availCat.add(gm1); availCat.add(gm2); availCat.add(gm3);
		availCat.add(fr1); availCat.add(fr2);
		availCat.add(wm1); availCat.add(wm2);
		
		boolean done=false;
		String answer1,answer2,answer3,answer4;
		String code,codePl,codeCm,codeGm,codeFr,codeWm, buy,buyPl,buyCm,buyGm,buyFr,buyWm, order,orderPl,orderCm,orderGm,orderFr,orderWm;
		
		/*Initialize the index for the sales. The index increases by 1 every time the user buys a product beginning from 111. */
		int saleIndex=111;
		String name,phone,date;
		
		/*Initialize the index for the orders. The index increases by one every time the user orders a product. */
		int ordIndex=111;
		String ordName,ordPhone,ordDate,arrDate;
		String ordAppIndex,ordExec;
		
		while(!done){
			System.out.println("\n1. Show available appliances");
			System.out.println("2. Show orders");
			System.out.println("3. Show sales");
			System.out.println("0. Exit");
			System.out.print("> ");
			answer1=in.nextLine();
			if(answer1.equals("1")){
				//Available appliances
				System.out.println();
				availCat.list();
				System.out.println("\n1. Select Sound-Vision appliances");
				System.out.println("2. Select Gaming appliances");
				System.out.println("3. Select Home appliances");
				System.out.print("> ");
				answer2=in.nextLine();
					if(answer2.equals("1")){
						//Sound-Vision
						System.out.println("\n1. Select from Television");
						System.out.println("2. Select from Player");
						System.out.println("3. Select from Camera");
						System.out.print("> ");
						answer3=in.nextLine();
							if(answer3.equals("1")){
								//Television
								System.out.println();
								System.out.println(tv1.toString());
								System.out.println(tv2.toString());
								System.out.println();
								System.out.print("You select the TV with code: ");
								code=in.nextLine();
								if(availCat.returnApp(code)!=null){
									availCat.lookFor(code);
									/*Sale*/
									if(availCat.returnApp(code).getCopies()!=0){
										System.out.println("\nDo you want to buy it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										buy=in.nextLine();
										if(buy.equals("1")){
											availCat.returnApp(code).OneLessCopie();
											System.out.println("Enter your name: ");
											name=in.nextLine();
											System.out.println("Enter your phone: ");
											phone=in.nextLine();
											System.out.println("Enter date of sale: ");
											date=in.nextLine();
											Sold_Appliances soldApp1=new Sold_Appliances(saleIndex,availCat.returnApp(code),name,phone,date);
											soldCat.add(soldApp1);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(code))+" $");
											saleIndex+=1;
										}
										else if(buy.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}
									/*Order*/
									else{
										System.out.println("\nThere are no more available copies of this appliance.");
										System.out.println("Do you want to order it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										order=in.nextLine();
										if(order.equals("1")){
											System.out.println("Enter your name: ");
											ordName=in.nextLine();
											System.out.println("Enter your phone: ");
											ordPhone=in.nextLine();
											System.out.println("Enter date of order: ");
											ordDate=in.nextLine();
											System.out.println("Enter expected date of arrival: ");
											arrDate=in.nextLine();
											Ordered_Appliances ordApp1=new Ordered_Appliances(ordIndex,availCat.returnApp(code),ordName,ordPhone,ordDate,arrDate,false);
											orderCat.add(ordApp1);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(code))+" $");
											ordIndex+=1;
										}
										else if(order.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}	
								}
								else{
									System.out.println("There's not TV with this code!!");
								}	
							}
							else if(answer3.equals("2")){
								//Players
								System.out.println(pl1.toString());
								System.out.println(pl2.toString());
								System.out.println();
								System.out.print("You select the Player with code: ");
								codePl=in.nextLine();
								if(availCat.returnApp(codePl)!=null){
									availCat.lookFor(codePl);
									/*Sale*/
									if(availCat.returnApp(codePl).getCopies()!=0){
										System.out.println("\nDo you want to buy it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										buyPl=in.nextLine();
										if(buyPl.equals("1")){
											availCat.returnApp(codePl).OneLessCopie();
											System.out.println("Enter your name: ");
											name=in.nextLine();
											System.out.println("Enter your phone: ");
											phone=in.nextLine();
											System.out.println("Enter date of sale: ");
											date=in.nextLine();
											Sold_Appliances soldApp2=new Sold_Appliances(saleIndex,availCat.returnApp(codePl),name,phone,date);
											soldCat.add(soldApp2);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codePl))+" $");
											saleIndex+=1;
										}
										else if(buyPl.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}
									/*Order*/
									else{
										System.out.println("\nThere are no more available copies of this appliance.");
										System.out.println("Do you want to order it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										orderPl=in.nextLine();
										if(orderPl.equals("1")){
											System.out.println("Enter your name: ");
											ordName=in.nextLine();
											System.out.println("Enter your phone: ");
											ordPhone=in.nextLine();
											System.out.println("Enter date of order: ");
											ordDate=in.nextLine();
											System.out.println("Enter expected date of arrival: ");
											arrDate=in.nextLine();
											Ordered_Appliances ordApp2=new Ordered_Appliances(ordIndex,availCat.returnApp(codePl),ordName,ordPhone,ordDate,arrDate,false);
											orderCat.add(ordApp2);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codePl))+" $");
											ordIndex+=1;
										}
										else if(orderPl.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}	
								}
								else{
									System.out.println("There's not Player with this code!!");
								}
							}
							else if(answer3.equals("3")){
								//Cameras
								System.out.println(cm1.toString());
								System.out.println(cm2.toString());
								System.out.println();
								System.out.print("You select the Camera with code: ");
								codeCm=in.nextLine();
								if(availCat.returnApp(codeCm)!=null){
									availCat.lookFor(codeCm);
									/*Sale*/
									if(availCat.returnApp(codeCm).getCopies()!=0){
										System.out.println("\nDo you want to buy it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										buyCm=in.nextLine();
										if(buyCm.equals("1")){
											availCat.returnApp(codeCm).OneLessCopie();
											System.out.println("Enter your name: ");
											name=in.nextLine();
											System.out.println("Enter your phone: ");
											phone=in.nextLine();
											System.out.println("Enter date of sale: ");
											date=in.nextLine();
											Sold_Appliances soldApp3=new Sold_Appliances(saleIndex,availCat.returnApp(codeCm),name,phone,date);
											soldCat.add(soldApp3);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeCm))+" $");
											saleIndex+=1;
										}
										else if(buyCm.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}
									/*Order*/
									else{
										System.out.println("\nThere are no more available copies of this appliance.");
										System.out.println("Do you want to order it?");
										System.out.println("1. Yes");
										System.out.println("0. No");
										System.out.print("> ");
										orderCm=in.nextLine();
										if(orderCm.equals("1")){
											System.out.println("Enter your name: ");
											ordName=in.nextLine();
											System.out.println("Enter your phone: ");
											ordPhone=in.nextLine();
											System.out.println("Enter date of order: ");
											ordDate=in.nextLine();
											System.out.println("Enter expected date of arrival: ");
											arrDate=in.nextLine();
											Ordered_Appliances ordApp3=new Ordered_Appliances(ordIndex,availCat.returnApp(codeCm),ordName,ordPhone,ordDate,arrDate,false);
											orderCat.add(ordApp3);
											System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeCm))+" $");
											ordIndex+=1;
										}
										else if(orderCm.equals("0")){
											System.out.println("So we go back to the main menu.");
										}
									}	
								}
								else{
									System.out.println("There's not Camera with this code!!");
								}
							}
					}
					else if(answer2.equals("2")){
						//Gaming
						System.out.println(gm1.toString());
						System.out.println(gm2.toString());
						System.out.println(gm3.toString());
						System.out.println();
						System.out.print("You select the Gaming console with code: ");
						codeGm=in.nextLine();
						if(availCat.returnApp(codeGm)!=null){
							availCat.lookFor(codeGm);
							/*Sale*/
							if(availCat.returnApp(codeGm).getCopies()!=0){
								System.out.println("\nDo you want to buy it?");
								System.out.println("1. Yes");
								System.out.println("0. No");
								System.out.print("> ");
								buyGm=in.nextLine();
								if(buyGm.equals("1")){
									availCat.returnApp(codeGm).OneLessCopie();
									System.out.println("Enter your name: ");
									name=in.nextLine();
									System.out.println("Enter your phone: ");
									phone=in.nextLine();
									System.out.println("Enter date of sale: ");
									date=in.nextLine();
									Sold_Appliances soldApp4=new Sold_Appliances(saleIndex,availCat.returnApp(codeGm),name,phone,date);
									soldCat.add(soldApp4);
									System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeGm))+" $");
									saleIndex+=1;
								}
								else if(buyGm.equals("0")){
									System.out.println("So we go back to the main menu.");
								}
							}
							/*Order*/
							else{
								System.out.println("\nThere are no more available copies of this appliance.");
								System.out.println("Do you want to order it?");
								System.out.println("1. Yes");
								System.out.println("0. No");
								System.out.print("> ");
								orderGm=in.nextLine();
								if(orderGm.equals("1")){
									System.out.println("Enter your name: ");
									ordName=in.nextLine();
									System.out.println("Enter your phone: ");
									ordPhone=in.nextLine();
									System.out.println("Enter date of order: ");
									ordDate=in.nextLine();
									System.out.println("Enter expected date of arrival: ");
									arrDate=in.nextLine();
									Ordered_Appliances ordApp4=new Ordered_Appliances(ordIndex,availCat.returnApp(codeGm),ordName,ordPhone,ordDate,arrDate,false);
									orderCat.add(ordApp4);
									System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeGm))+" $");
									ordIndex+=1;
								}
								else if(orderGm.equals("0")){
									System.out.println("So we go back to the main menu.");
								}
							}	
						}
						else{
							System.out.println("There's not Gaming console with this code!!");
						}
						
					}
					else if(answer2.equals("3")){
						//Home appliances
						System.out.println("\n1. Select Fridge");
						System.out.println("2. Select Washing Machine");
						System.out.print("> ");
						answer4=in.nextLine();
						
						if(answer4.equals("1")){
							//Fridges
							System.out.println(fr1.toString());
							System.out.println(fr2.toString());
							System.out.println();
							System.out.print("You select the Gaming console with code: ");
							codeFr=in.nextLine();
							if(availCat.returnApp(codeFr)!=null){
								availCat.lookFor(codeFr);
								/*Sale*/
								if(availCat.returnApp(codeFr).getCopies()!=0){
									System.out.println("\nDo you want to buy it?");
									System.out.println("1. Yes");
									System.out.println("0. No");
									System.out.print("> ");
									buyFr=in.nextLine();
									if(buyFr.equals("1")){
										availCat.returnApp(codeFr).OneLessCopie();
										System.out.println("Enter your name: ");
										name=in.nextLine();
										System.out.println("Enter your phone: ");
										phone=in.nextLine();
										System.out.println("Enter date of sale: ");
										date=in.nextLine();
										Sold_Appliances soldApp5=new Sold_Appliances(saleIndex,availCat.returnApp(codeFr),name,phone,date);
										soldCat.add(soldApp5);
										System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeFr))+" $");
										saleIndex+=1;
									}
									else if(buyFr.equals("0")){
										System.out.println("So we go back to the main menu.");
									}
								}
								/*Order*/
								else{
									System.out.println("\nThere are no more available copies of this appliance.");
									System.out.println("Do you want to order it?");
									System.out.println("1. Yes");
									System.out.println("0. No");
									System.out.print("> ");
									orderFr=in.nextLine();
									if(orderFr.equals("1")){
										System.out.println("Enter your name: ");
										ordName=in.nextLine();
										System.out.println("Enter your phone: ");
										ordPhone=in.nextLine();
										System.out.println("Enter date of order: ");
										ordDate=in.nextLine();
										System.out.println("Enter expected date of arrival: ");
										arrDate=in.nextLine();
										Ordered_Appliances ordApp5=new Ordered_Appliances(ordIndex,availCat.returnApp(codeFr),ordName,ordPhone,ordDate,arrDate,false);
										orderCat.add(ordApp5);
										System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeFr))+" $");
										ordIndex+=1;
									}
									else if(orderFr.equals("0")){
										System.out.println("So we go back to the main menu.");
									}
								}	
							}
							else{
								System.out.println("There's not Fridge with this code!!");
							}
						}
						else if(answer4.equals("2")){
							//Washing machines
							System.out.println(wm1.toString());
							System.out.println(wm2.toString());
							System.out.println();
							System.out.print("You select the Gaming console with code: ");
							codeWm=in.nextLine();
							if(availCat.returnApp(codeWm)!=null){
								availCat.lookFor(codeWm);
								/*Sale*/
								if(availCat.returnApp(codeWm).getCopies()!=0){
									System.out.println("\nDo you want to buy it?");
									System.out.println("1. Yes");
									System.out.println("0. No");
									System.out.print("> ");
									buyWm=in.nextLine();
									if(buyWm.equals("1")){
										availCat.returnApp(codeWm).OneLessCopie();
										System.out.println("Enter your name: ");
										name=in.nextLine();
										System.out.println("Enter your phone: ");
										phone=in.nextLine();
										System.out.println("Enter date of sale: ");
										date=in.nextLine();
										Sold_Appliances soldApp6=new Sold_Appliances(saleIndex,availCat.returnApp(codeWm),name,phone,date);
										soldCat.add(soldApp6);
										System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeWm))+" $");
										saleIndex+=1;
									}
									else if(buyWm.equals("0")){
										System.out.println("So we go back to the main menu.");
									}
								}
								/*Order*/
								else{
									System.out.println("\nThere are no more available copies of this appliance.");
									System.out.println("Do you want to order it?");
									System.out.println("1. Yes");
									System.out.println("0. No");
									System.out.print("> ");
									orderWm=in.nextLine();
									if(orderWm.equals("1")){
										System.out.println("Enter your name: ");
										ordName=in.nextLine();
										System.out.println("Enter your phone: ");
										ordPhone=in.nextLine();
										System.out.println("Enter date of order: ");
										ordDate=in.nextLine();
										System.out.println("Enter expected date of arrival: ");
										arrDate=in.nextLine();
										Ordered_Appliances ordApp6=new Ordered_Appliances(ordIndex,availCat.returnApp(codeWm),ordName,ordPhone,ordDate,arrDate,false);
										orderCat.add(ordApp6);
										System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeWm))+" $");
										ordIndex+=1;
									}
									else if(orderWm.equals("0")){
										System.out.println("So we go back to the main menu.");
									}
								}	
							}
							else{
								System.out.println("There's not Washing Mashine with this code!!");
							}
						}
					}
			}
			else if(answer1.equals("2")){
				//Ordered appliances
				if(orderCat.size()!=0){
					orderCat.list();
					System.out.println("You select the ordered appliance with index: ");
					ordAppIndex=in.nextLine();
					if(orderCat.returnOrdApp(Integer.parseInt(ordAppIndex))!=null){
						if(orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).isExecuted()==false){
							orderCat.lookForOrdApp(Integer.parseInt(ordAppIndex));
							System.out.println("\nDo you want the order to be executed?");
							System.out.println("1. Yes");
							System.out.println("0. No");
							System.out.print("> ");
							ordExec=in.nextLine();
							if(ordExec.equals("1")){
								orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).setExecuted();
								Sold_Appliances soldOrdApp=new Sold_Appliances(saleIndex, orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdApp(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdName(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdPhone(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getArrDate());	//The date of the sale is the arrival date of the executed order.  
								soldCat.add(soldOrdApp);
								saleIndex+=1;
							}
							else if(ordExec.equals("0")){
								System.out.println("So we go back to the main menu.");
							}
						}
						else{
							System.out.println("This order has already been executed!");
						}
					}
					else{
						System.out.println("There's not order with this index!");
					}
				}
				else{
					System.out.println("The Ordered Appliances Catalogue is empty!");
				}
			}
			else if(answer1.equals("3")){
				//Sold appliances
				if(soldCat.size()!=0){
					soldCat.list();
				}
				else{
					System.out.println("The Sold Appliances Catalogue is empty!");
				}
			}
			else if(answer1.equals("0")){
				//Exit
				done=true;
			}
			
		}//while close
		
	}
}