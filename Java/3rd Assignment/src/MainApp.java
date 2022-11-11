import java.util.*;

public class MainApp {

	public static void main(String[] args) {
		
				//Scanner for reading from the command line.
				Scanner in=new Scanner(System.in);
						
				//Initialize catalogues.
				SoldCatalogue soldCat = new SoldCatalogue();
				OrderCatalogue orderCat = new OrderCatalogue();
				AvailableCatalogue availCat = new AvailableCatalogue();
				
				//Load the items form the txt to the Available Catalogue. 
				availCat.loadFile("Item_List.txt");

				boolean done=false;
				String answer1,answer2,answer3,answer4;
				String code,codePl,codeCm,codeGm,codeFr,codeWm, buy,buyPl,buyCm,buyGm,buyFr,buyWm, order,orderPl,orderCm,orderGm,orderFr,orderWm;
				
				/*Initialize the index for the sales.*/
				int saleIndex=111;
				String name,phone,date;
				
				/*Initialize the index for the orders*/
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
										availCat.lookFor("1224a");
										availCat.lookFor("1326b");
										
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
													//System.out.println("File writing...");
													soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
													
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
													orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
													
													System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(code))+" $");
													ordIndex+=1;
												}
												else if(order.equals("0")){
													System.out.println("So we go back to the main menu.");
												}
											}	
										}
										else{
											System.out.println("There's no TV with this code!!");
										}	
									}
									else if(answer3.equals("2")){
										//Players
										System.out.println();
										availCat.lookFor("1428c");
										availCat.lookFor("1530d");
										
										System.out.println();
										System.out.print("You have selected the Player with code: ");
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
													soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
													
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
													orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
													
													System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codePl))+" $");
													ordIndex+=1;
												}
												else if(orderPl.equals("0")){
													System.out.println("So we go back to the main menu.");
												}
											}	
										}
										else{
											System.out.println("There's no Player with this code!!");
										}
									}
									else if(answer3.equals("3")){
										//Cameras
										availCat.lookFor("1632e");
										availCat.lookFor("1734f");
										
										System.out.println();
										System.out.print("You have selected the Camera with code: ");
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
													soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
													
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
													orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
													
													System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeCm))+" $");
													ordIndex+=1;
												}
												else if(orderCm.equals("0")){
													System.out.println("So we go back to the main menu.");
												}
											}	
										}
										else{
											System.out.println("There's no Camera with this code!!");
										}
									}
							}
							else if(answer2.equals("2")){
								//Gaming
								availCat.lookFor("1836g");
								availCat.lookFor("1938h");
								availCat.lookFor("2040i");
								
								System.out.println();
								System.out.print("You have selected the Gaming console with code: ");
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
											soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
											
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
											orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
											
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
									availCat.lookFor("2244j");
									availCat.lookFor("2346k");
									
									System.out.println();
									System.out.print("You select the Fridge with code: ");
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
												soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
												
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
												orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
												
												System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeFr))+" $");
												ordIndex+=1;
											}
											else if(orderFr.equals("0")){
												System.out.println("So we go back to the main menu.");
											}
										}	
									}
									else{
										System.out.println("There's no Fridge with this code!!");
									}
								}
								else if(answer4.equals("2")){
									//Washing machines
									availCat.lookFor("2448l");
									availCat.lookFor("2550m");
									
									System.out.println();
									System.out.print("You have selected the Washing Machine with code: ");
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
												soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
												
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
												orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
												
												System.out.println("The final cost (including the discount) is: "+Calculate_Discount.calculateCost(availCat.returnApp(codeWm))+" $");
												ordIndex+=1;
											}
											else if(orderWm.equals("0")){
												System.out.println("So we go back to the main menu.");
											}
										}	
									}
									else{
										System.out.println("There's no Washing Mashine with this code!!");
									}
								}
							}
					}
					else if(answer1.equals("2")){
						//Ordered appliances
						if(orderCat.size()!=0){
							orderCat.list();
							System.out.println("You have selected the ordered appliance with index: ");
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
										orderCat.createFile("Order_List.txt");			//<----------------------------------------------------------
										
										Sold_Appliances soldOrdApp=new Sold_Appliances(saleIndex, orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdApp(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdName(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getOrdPhone(), orderCat.returnOrdApp(Integer.parseInt(ordAppIndex)).getArrDate());	//The date of the sale is the arrival date of the executed order.  
										
										soldCat.add(soldOrdApp);
										soldCat.createFile("Sold_List.txt");			//<----------------------------------------------------------
										
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