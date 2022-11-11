import java.io.*;
import java.util.*;

public class SoldCatalogue {

		//ArrayList with the sold appliances.
		private ArrayList<Sold_Appliances> soldApps=new ArrayList<Sold_Appliances>();
		
		//Returns the size of the Sold Appliances Catalogue.
		public int size(){
			return soldApps.size();
		}
		
		//Method that returns the item at index i.		//<---
		public Sold_Appliances get(int i){
			return soldApps.get(i);
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
		
		///////////////////////////////////////////////////////////////////////////////////////
		public void createFile (String path) {
			
			//String path = "Sold_List.txt"		//<--
			File f = null;
			BufferedWriter writer = null;
			
			try {
				f = new File(path);
			}
			catch (NullPointerException e) {
				System.err.println("File Not Found.");
			}
			
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			}
			catch (FileNotFoundException e) {
				System.err.println("Error");
			}
			//String info = new String();
			try{
				writer.write("SALES_LIST"+ System.getProperty("line.separator") + "{");
				for (Sold_Appliances soldApp : soldApps) {
					if(soldApp.getSoldApp() instanceof Television) {
						writer.write(System.getProperty("line.separator") + "\t" + "SALE" + System.getProperty("line.separator") + "\t" + "{"
							+ System.getProperty("line.separator") + "\t" + "ITEM_TYPE "    + soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         + soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	    + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	+ soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " + soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        + soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       + soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "   + soldApp.getSoldApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "ANALYSIS "     + ((Television)soldApp.getSoldApp()).getAnal()
							+ System.getProperty("line.separator") + "\t" + "SCREENSIZE "   + ((Television)soldApp.getSoldApp()).getScrSize()
							+ System.getProperty("line.separator") + "\t" + "PORTS "        + ((Television)soldApp.getSoldApp()).getPorts()
							+ System.getProperty("line.separator") + "\t" + "NAME "         + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "         + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER " + soldApp.getBuyerPhone()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(soldApp.getSoldApp() instanceof Player) {
				        writer.write(System.getProperty("line.separator") + "\t" + "SALE "  + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "    + soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         + soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	    + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "   + soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " + soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        + soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       + soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "   + soldApp.getSoldApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "ANALYSIS "     + ((Player)soldApp.getSoldApp()).getAnal()
							+ System.getProperty("line.separator") + "\t" + "FORMAT_PLAY "  + ((Player)soldApp.getSoldApp()).getFormat()
							+ System.getProperty("line.separator") + "\t" + "NAME "         + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "         + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER " + soldApp.getBuyerPhone()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(soldApp.getSoldApp() instanceof Camera) {
				        writer.write(System.getProperty("line.separator") + "\t" + "SALE "  + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "	+ soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         + soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	    + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	+ soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " + soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        + soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       + soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "   + soldApp.getSoldApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "ANALYSIS "     + ((Camera)soldApp.getSoldApp()).getAnal()
							+ System.getProperty("line.separator") + "\t" + "SCREENSIZE "   + ((Camera)soldApp.getSoldApp()).getScrSize()
							+ System.getProperty("line.separator") + "\t" + "OPTICAL_ZOOM " + ((Camera)soldApp.getSoldApp()).getOptZoom()
							+ System.getProperty("line.separator") + "\t" + "DIGITAL_ZOOM " + ((Camera)soldApp.getSoldApp()).getDigZoom()
							+ System.getProperty("line.separator") + "\t" + "NAME "         + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "         + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER " + soldApp.getBuyerPhone()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(soldApp.getSoldApp() instanceof Gaming) {
				        writer.write(System.getProperty("line.separator") + "\t" + "SALE " + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "	+ soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         + soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	    + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	+ soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " + soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        + soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       + soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "   + soldApp.getSoldApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "PROCESSOR "    + ((Gaming)soldApp.getSoldApp()).getProc()
							+ System.getProperty("line.separator") + "\t" + "GRAPHICS "     + ((Gaming)soldApp.getSoldApp()).getGraph()
							+ System.getProperty("line.separator") + "\t" + "SOUND "        + ((Gaming)soldApp.getSoldApp()).getSound()
							+ System.getProperty("line.separator") + "\t" + "CAPACITY "     + ((Gaming)soldApp.getSoldApp()).getCap()
							+ System.getProperty("line.separator") + "\t" + "NAME "         + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "         + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER " + soldApp.getBuyerPhone()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else if(soldApp.getSoldApp() instanceof Fridge) {
				        writer.write(System.getProperty("line.separator") + "\t" + "SALE " + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "	    + soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         	+ soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	        + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	 	+ soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " 	+ soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        	+ soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       	+ soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "PANEL_TYPE "   	+ soldApp.getSoldApp().getPanelType()
							+ System.getProperty("line.separator") + "\t" + "ENERGY CLASS "     + ((Fridge)soldApp.getSoldApp()).getEnClass()
							+ System.getProperty("line.separator") + "\t" + "CAPACITY "     	+ ((Fridge)soldApp.getSoldApp()).getCap()
							+ System.getProperty("line.separator") + "\t" + "FREEZER CAPACITY " + ((Fridge)soldApp.getSoldApp()).getFreezCap()
							+ System.getProperty("line.separator") + "\t" + "NAME "             + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "             + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER "     + soldApp.getBuyerPhone()
							+ System.getProperty("line.separator") + "\t" + "}");
					}
					else {
				        writer.write(System.getProperty("line.separator") + "\t" + "SALE " + System.getProperty("line.separator") + "\t" + "{"
				            + System.getProperty("line.separator") + "\t" + "ITEM_TYPE "	+ soldApp.getSoldApp().getItemType()
							+ System.getProperty("line.separator") + "\t" + "CODE "         + soldApp.getSoldApp().getCode()
							+ System.getProperty("line.separator") + "\t" + "MODEL "	    + soldApp.getSoldApp().getName()
							+ System.getProperty("line.separator") + "\t" + "MODEL_YEAR "	+ soldApp.getSoldApp().getYear()
							+ System.getProperty("line.separator") + "\t" + "MANUFACTURER " + soldApp.getSoldApp().getFact()
							+ System.getProperty("line.separator") + "\t" + "PRICE "        + soldApp.getSoldApp().getValue()
							+ System.getProperty("line.separator") + "\t" + "COPIES "       + soldApp.getSoldApp().getCopies()
							+ System.getProperty("line.separator") + "\t" + "ENERGY CLASS " + ((Washing_Machine)soldApp.getSoldApp()).getEnClass()
							+ System.getProperty("line.separator") + "\t" + "CAPACITY "     + ((Washing_Machine)soldApp.getSoldApp()).getCap()
							+ System.getProperty("line.separator") + "\t" + "TURNS "        + ((Washing_Machine)soldApp.getSoldApp()).getTurns()
							+ System.getProperty("line.separator") + "\t" + "NAME "         + soldApp.getBuyerName()
							+ System.getProperty("line.separator") + "\t" + "DATE "         + soldApp.getSoldDate()
							+ System.getProperty("line.separator") + "\t" + "PHONE NUMBER " + soldApp.getBuyerPhone()
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
		
		/////////////////////////////////////////////////////////////////////////////////////////
	
}
