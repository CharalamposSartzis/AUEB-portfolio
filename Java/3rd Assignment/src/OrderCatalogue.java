import java.io.*;
import java.util.*;

public class OrderCatalogue {

		//ArrayList with the ordered appliances.
		private ArrayList<Ordered_Appliances> orderedApps=new ArrayList<Ordered_Appliances>();
		
		//Returns the size of the Ordered Appliances Catalogue.
		public int size(){
			return orderedApps.size();
		}
		
		//Method that returns the item at index i.		//<---
		public Ordered_Appliances get(int i){
			return orderedApps.get(i);
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

		//////////////////////////////////////////////////////////////////////
		
		public void createFile (String pathtwo) {
			
			//String pathtwo = "Order_List.txt"		//<--
			File j = null;
			BufferedWriter writer = null;
			
			try {
				j = new File(pathtwo);
			}
			catch (NullPointerException e) {
				System.err.println("File Not Found.");
			}
			
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(j)));
			}
			catch (FileNotFoundException e) {
				System.err.println("Error");
			}
			try{
				writer.write("ORDER_LIST"+ System.getProperty("line.separator") + "{");
				for (Ordered_Appliances ordApp : orderedApps) {	 
					if(ordApp.getOrdApp() instanceof Television) {
						writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "      + ordApp.getOrdApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "           + ordApp.getOrdApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	      + ordApp.getOrdApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	  + ordApp.getOrdApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "   + ordApp.getOrdApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "          + ordApp.getOrdApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "         + ordApp.getOrdApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "     + ordApp.getOrdApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "ANALYSIS "       + ((Television)ordApp.getOrdApp()).getAnal()
							+ System.getProperty("line.separator") + "\t" + "SCREENSIZE "     + ((Television)ordApp.getOrdApp()).getScrSize()
							+ System.getProperty("line.separator") + "\t" + "PORTS "          + ((Television)ordApp.getOrdApp()).getPorts()
							+ System.getProperty("line.separator") + "\t" + "NAME "           + ordApp.getOrdName()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "   + ordApp.getOrdPhone()
							+ System.getProperty("line.separator") + "\t" + "ORDER DATE "     + ordApp.getOrdDate()
							+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "   + ordApp.getArrDate()
							+ System.getProperty("line.separator") + "\t" + "STATUS "         + ordApp.isExecuted()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(ordApp.getOrdApp() instanceof Player) {
				            writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				                + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "  	  + ordApp.getOrdApp().getItemType()
								+ System.getProperty("line.separator") + "\t" + "CODE "           + ordApp.getOrdApp().getCode()
								+ System.getProperty("line.separator") + "\t" + "MODEL "	      + ordApp.getOrdApp().getName()
								+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	  + ordApp.getOrdApp().getYear()
								+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "   + ordApp.getOrdApp().getFact()
								+ System.getProperty("line.separator") + "\t" + "PRICE "          + ordApp.getOrdApp().getValue()
								+ System.getProperty("line.separator") + "\t" + "COPIES "         + ordApp.getOrdApp().getCopies()
								+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "     + ordApp.getOrdApp().getPanelType()
								+ System.getProperty("line.separator") + "\t" + "ANALYSIS "       + ((Player)ordApp.getOrdApp()).getAnal()
								+ System.getProperty("line.separator") + "\t" + "FORMAT_PLAY "    + ((Player)ordApp.getOrdApp()).getFormat()
								+ System.getProperty("line.separator") + "\t" + "NAME "           + ordApp.getOrdName()
								+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "   + ordApp.getOrdPhone()
								+ System.getProperty("line.separator") + "\t" + "ORDER DATE "     + ordApp.getOrdDate()
								+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "   + ordApp.getArrDate()
								+ System.getProperty("line.separator") + "\t" + "STATUS "         + ordApp.isExecuted()
								+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(ordApp.getOrdApp() instanceof Camera) {
				            writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				                + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "  	  + ordApp.getOrdApp().getItemType()
								+ System.getProperty("line.separator") + "\t" + "CODE "           + ordApp.getOrdApp().getCode()
								+ System.getProperty("line.separator") + "\t" + "MODEL "	      + ordApp.getOrdApp().getName()
								+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	  + ordApp.getOrdApp().getYear()
								+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "   + ordApp.getOrdApp().getFact()
								+ System.getProperty("line.separator") + "\t" + "PRICE "          + ordApp.getOrdApp().getValue()
								+ System.getProperty("line.separator") + "\t" + "COPIES "         + ordApp.getOrdApp().getCopies()
								+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "     + ordApp.getOrdApp().getPanelType()
								+ System.getProperty("line.separator") + "\t" + "ANALYSIS "       + ((Camera)ordApp.getOrdApp()).getAnal()
								+ System.getProperty("line.separator") + "\t" + "SCREENSIZE "     + ((Camera)ordApp.getOrdApp()).getScrSize()
								+ System.getProperty("line.separator") + "\t" + "OPTICAL_ZOOM "   + ((Camera)ordApp.getOrdApp()).getOptZoom()
								+ System.getProperty("line.separator") + "\t" + "DIGITAL_ZOOM "   + ((Camera)ordApp.getOrdApp()).getDigZoom()
								+ System.getProperty("line.separator") + "\t" + "NAME "           + ordApp.getOrdName()
								+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "   + ordApp.getOrdPhone()
								+ System.getProperty("line.separator") + "\t" + "ORDER DATE "     + ordApp.getOrdDate()
								+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "   + ordApp.getArrDate()
								+ System.getProperty("line.separator") + "\t" + "STATUS "         + ordApp.isExecuted()
								+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(ordApp.getOrdApp() instanceof Gaming) {
				            writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				                + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "      + ordApp.getOrdApp().getItemType()
								+ System.getProperty("line.separator") + "\t" + "CODE "           + ordApp.getOrdApp().getCode()
								+ System.getProperty("line.separator") + "\t" + "MODEL "	      + ordApp.getOrdApp().getName()
								+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	  + ordApp.getOrdApp().getYear()
								+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "   + ordApp.getOrdApp().getFact()
								+ System.getProperty("line.separator") + "\t" + "PRICE "          + ordApp.getOrdApp().getValue()
								+ System.getProperty("line.separator") + "\t" + "COPIES "         + ordApp.getOrdApp().getCopies()
								+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "     + ordApp.getOrdApp().getPanelType()
								+ System.getProperty("line.separator") + "\t" + "PROCESSOR "      + ((Gaming)ordApp.getOrdApp()).getProc()
								+ System.getProperty("line.separator") + "\t" + "GRAPHICS "       + ((Gaming)ordApp.getOrdApp()).getGraph()
								+ System.getProperty("line.separator") + "\t" + "SOUND "          + ((Gaming)ordApp.getOrdApp()).getSound()
								+ System.getProperty("line.separator") + "\t" + "CAPACITY "       + ((Gaming)ordApp.getOrdApp()).getCap()
								+ System.getProperty("line.separator") + "\t" + "NAME "           + ordApp.getOrdName()
								+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "   + ordApp.getOrdPhone()
								+ System.getProperty("line.separator") + "\t" + "ORDER DATE "     + ordApp.getOrdDate()
								+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "   + ordApp.getArrDate()
								+ System.getProperty("line.separator") + "\t" + "STATUS "         + ordApp.isExecuted()
								+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(ordApp.getOrdApp() instanceof Fridge) {
				            writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				                + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "           + ordApp.getOrdApp().getItemType()
								+ System.getProperty("line.separator") + "\t" + "CODE "                + ordApp.getOrdApp().getCode()
								+ System.getProperty("line.separator") + "\t" + "MODEL "	           + ordApp.getOrdApp().getName()
								+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	       + ordApp.getOrdApp().getYear()
								+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "        + ordApp.getOrdApp().getFact()
								+ System.getProperty("line.separator") + "\t" + "PRICE "               + ordApp.getOrdApp().getValue()
								+ System.getProperty("line.separator") + "\t" + "COPIES "              + ordApp.getOrdApp().getCopies()
								+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "          + ordApp.getOrdApp().getPanelType()
								+ System.getProperty("line.separator") + "\t" + "ENERGY CLASS "        + ((Fridge)ordApp.getOrdApp()).getEnClass()
								+ System.getProperty("line.separator") + "\t" + "CAPACITY "            + ((Fridge)ordApp.getOrdApp()).getCap()
								+ System.getProperty("line.separator") + "\t" + "FREEZER CAPACITY "    + ((Fridge)ordApp.getOrdApp()).getFreezCap()
								+ System.getProperty("line.separator") + "\t" + "NAME "                + ordApp.getOrdName()
								+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "        + ordApp.getOrdPhone()
								+ System.getProperty("line.separator") + "\t" + "ORDER DATE "          + ordApp.getOrdDate()
								+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "        + ordApp.getArrDate()
								+ System.getProperty("line.separator") + "\t" + "STATUS "              + ordApp.isExecuted()
								+ System.getProperty("line.separator") + "\t" + "}");
					}
					else {
				            writer.write(System.getProperty("line.separator") + "\t" + "ORDER " + System.getProperty("line.separator") + "\t" + "{"
				                + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "    	+ ordApp.getOrdApp().getItemType()
								+ System.getProperty("line.separator") + "\t" + "CODE "             + ordApp.getOrdApp().getCode()
								+ System.getProperty("line.separator") + "\t" + "MODEL "	        + ordApp.getOrdApp().getName()
								+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	    + ordApp.getOrdApp().getYear()
								+ System.getProperty("line.separator") + "\t" + "MANUFACTURER "     + ordApp.getOrdApp().getFact()
								+ System.getProperty("line.separator") + "\t" + "PRICE "            + ordApp.getOrdApp().getValue()
								+ System.getProperty("line.separator") + "\t" + "COPIES "           + ordApp.getOrdApp().getCopies()
								+ System.getProperty("line.separator") + "\t" + "ENERGY CLASS "     + ((Washing_Machine)ordApp.getOrdApp()).getEnClass()
								+ System.getProperty("line.separator") + "\t" + "CAPACITY "         + ((Washing_Machine)ordApp.getOrdApp()).getCap()
								+ System.getProperty("line.separator") + "\t" + "TURNS "            + ((Washing_Machine)ordApp.getOrdApp()).getTurns()
								+ System.getProperty("line.separator") + "\t" + "NAME "             + ordApp.getOrdName()
								+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "     + ordApp.getOrdPhone()
								+ System.getProperty("line.separator") + "\t" + "ORDER DATE "       + ordApp.getOrdDate()
								+ System.getProperty("line.separator") + "\t" + "ARRIVAL DATE "     + ordApp.getArrDate()
								+ System.getProperty("line.separator") + "\t" + "STATUS "           + ordApp.isExecuted()
								+ System.getProperty("line.separator") + "\t" + "}");
					}	
				}//for
				writer.write(System.getProperty("line.separator")+"}");
			}//try
			catch (IOException e) {
				System.err.println("Write error! ");
			}

			try {
			  writer.close();
			}
			catch (IOException e) {
				System.err.println("Error closing file.");
		    }
		}//create
		
		/////////////////////////////////////////////////////////////////////
	
}
