import java.io.*;
import java.util.*;

public class AvailableCatalogue {

	//ArrayList with the available appliances.
		private ArrayList<Electrical_Appliance> availableApps=new ArrayList<Electrical_Appliance>();
		
		//Method that returns the number of the available appliances.
		public int size(){
			return availableApps.size();
		}
		
		//Method that shows all the available appliances.
		public void list(){
			for(int i=0;i<availableApps.size();i++){
				System.out.println(availableApps.get(i));
			}
		}
		
		//Method that adds an appliance to the AvailableCatalogue.
		public void add(Electrical_Appliance elApp){
			availableApps.add(elApp);
		}
		
		//Method that removes an available appliance.
		public void remove(Electrical_Appliance elApp){
			for(int i=0;i<=availableApps.size();i++){
				if(availableApps.get(i)==elApp){
					availableApps.remove(i);
				}
			}
		}
		
		//Method that prints the appliance with the specific code.			
		public void lookFor(String code){
			for(int i=0;i<availableApps.size();i++){
				if(availableApps.get(i).getCode().equals(code)){
					System.out.println(availableApps.get(i));
				}
			}
		}
		
		//Returns the appliance with the specific code.
		public Electrical_Appliance returnApp(String code){
			for(int i=0;i<availableApps.size();i++){
				if(availableApps.get(i).getCode().equals(code)){
					return availableApps.get(i);
				}
			}
			return null;
		}

		public void loadFile(String path){

					System.out.println("Loading Appliances.");

					int counter=0;	//<--
					File f=null;
					BufferedReader reader = null;

					Television tv;
					Player pl;
					Camera cm;
					Gaming gm;
					Fridge fr;
					Washing_Machine wm;

					String line;

					/*Find-error*/
					try {
						f = new File(path);
					} 
					catch (NullPointerException e) {
						System.err.println("File not found.");
					}

					/*Open-error*/
					try {
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
					} 
					catch (FileNotFoundException e) {
						System.err.println("Error opening file!");
					}

					/*Read-error*/
					try{
						line = reader.readLine();
						if (!line.trim().equals(" ")){
							if (line.trim().equals("ITEM_LIST")){

								//Adds		//<--
								/*availTV.add(tv);
								availPlayer.add(pl);
								availCamera.add(cm);
								availGaming.add(gm);
								availFridge.add(fr);
								availWash.add(wm);*/

								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("{")){

										while(line != null){

											line=reader.readLine();
											if (line != null){
												if (line.trim().startsWith("ITEM")){

													line = reader.readLine();
													if (line != null){
														if(line.trim().equals("{")){

															line = reader.readLine();
															if (line != null){
																if (line.trim().startsWith("ITEM_TYPE")){

																	if (line.trim().substring(10).trim().equals("tv")){
																		
																		tv=new Television();
																		tv.setItemType(line.substring(11).trim());
																		
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				tv.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				tv.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				tv.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				tv.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				tv.setValue(line.substring(7).trim());
																			}
																		}//PRICE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				tv.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of TV begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PANEL_TYPE")){
																				tv.setPanelType(line.substring(12).trim());
																			}
																		}//PANEL_TYPE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("ANALYSIS")){
																				tv.setAnal(line.substring(10).trim());
																			}
																		}//ANALYSIS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("SCREENSIZE")){
																				tv.setScrSize(line.substring(12).trim());
																			}
																		}//SCREENSIZE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PORTS")){
																				tv.setPorts(line.substring(7).trim());
																			}
																		}//PORTS
																		/*Caracteristics of TV end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(tv);		//<--
																			}
																		}

																	}//else if tv
																	else if(line.trim().substring(10).trim().equals("player")){
	
																		pl=new Player();
																		pl.setItemType(line.substring(11).trim());
	
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				pl.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				pl.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				pl.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				pl.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				pl.setValue(line.substring(7).trim());
																			}
																		}//PRICE
																		
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				pl.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of Player begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PANEL_TYPE")){
																				pl.setPanelType(line.substring(12).trim());
																			}
																		}//PANEL_TYPE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("ANALYSIS")){
																				pl.setAnal(line.substring(10).trim());
																			}
																		}//ANALYSIS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("FORMAT_PLAY")){
																				pl.setFormat(line.substring(13).trim());
																			}
																		}//FORMAT_PLAY
																		/*Caracteristics of Player end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(pl);		//<--
																			}
																		}
	
																	}//else if player
																	else if(line.trim().substring(10).trim().equals("camera")){
	
																		cm=new Camera();
																		cm.setItemType(line.substring(11).trim());
	
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				cm.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				cm.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				cm.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				cm.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				cm.setValue(line.substring(7).trim());
																			}
																		}//PRICE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				cm.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of Camera begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PANEL_TYPE")){
																				cm.setPanelType(line.substring(12).trim());
																			}
																		}//PANEL_TYPE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("ANALYSIS")){
																				cm.setAnal(line.substring(10).trim());
																			}
																		}//ANALYSIS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("SCREENSIZE")){
																				cm.setScrSize(line.substring(12).trim());
																			}
																		}//SCREENSIZE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("OPTICAL_ZOOM")){
																				cm.setOptZoom(line.substring(14).trim());
																			}
																		}//OPTICAL_ZOOM
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("DIGITAL_ZOOM")){
																				cm.setDigZoom(line.substring(14).trim());
																			}
																		}//DIGITAL_ZOOM
																		/*Caracteristics of Camera end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(cm);		//<--
																			}
																		}
	
																	}//else if camera
																	else if(line.trim().substring(10).trim().equals("gaming console")){
	
																		gm=new Gaming();
																		gm.setItemType(line.substring(11).trim());
	
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				gm.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				gm.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				gm.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				gm.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				gm.setValue(line.substring(7).trim());
																			}
																		}//PRICE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				gm.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of Gaming begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PANEL_TYPE")){
																				gm.setPanelType(line.substring(12).trim());
																			}
																		}//PANEL_TYPE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PROCESSOR")){
																				gm.setProc(line.substring(11).trim());
																			}
																		}//PROCESSOR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("GRAPHICS")){
																				gm.setGraph(line.substring(10).trim());
																			}
																		}//GRAPHICS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("SOUND")){
																				gm.setSound(line.substring(7).trim());
																			}
																		}//SOUND
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CAPACITY")){
																				gm.setCap(line.substring(10).trim());
																			}
																		}//CAPACITY
																		/*Caracteristics of Gaming end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(gm);		//<--
																			}
																		}
	
																	}//else if gaming
																	else if(line.trim().substring(10).trim().equals("refrigerator")){
	
																		fr=new Fridge();
																		fr.setItemType(line.substring(11).trim());
	
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				fr.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				fr.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				fr.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				fr.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				fr.setValue(line.substring(7).trim());
																			}
																		}//PRICE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				fr.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of Fridge begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PANEL_TYPE")){
																				fr.setPanelType(line.substring(12).trim());
																			}
																		}//PANEL_TYPE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("ENERGY_CLASS")){
																				fr.setEnClass(line.substring(14).trim());
																			}
																		}//ENERGY_CLASS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CAPACITY")){
																				fr.setCap(line.substring(10).trim());
																			}
																		}//CAPACITY
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("FREEZER_CAPACITY")){
																				fr.setFreezCap(line.substring(18).trim());
																			}
																		}//FREEZER_CAPACITY
																		/*Caracteristics of Fridge end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(fr);		//<--
																			}
																		}
	
																	}//else if refrigerator
																	else if(line.trim().substring(10).trim().equals("washing machine")){
	
																		wm=new Washing_Machine();
																		wm.setItemType(line.substring(11).trim());
	
																		/*Common caracteristics begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CODE")){		//<--
																				wm.setCode(line.substring(6).trim());
																			}
																		}//CODE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL")){
																				wm.setName(line.substring(7).trim());
																			}
																		}//MODEL
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MODEL_YEAR")){
																				wm.setYear(line.substring(12).trim());
																			}
																		}//MODEL_YEAR
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("MANUFACTURER")){
																				wm.setFact(line.substring(14).trim());
																			}
																		}//MANUFACTURER
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("PRICE")){
																				wm.setValue(line.substring(7).trim());
																			}
																		}//PRICE
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("COPIES")){
																				wm.setCopies(line.substring(8).trim());
																			}
																		}//COPIES
																		/*Common caracteristics end*/
	
																		/*Caracteristics of Washing Machine begin*/
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("ENERGY_CLASS")){
																				wm.setEnClass(line.substring(14).trim());
																			}
																		}//ENERGY_CLASS
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("CAPACITY")){
																				wm.setCap(line.substring(10).trim());
																			}
																		}//CAPACITY
	
																		line = reader.readLine();
																		if(line!=null){
																			if(line.trim().startsWith("TURNS")){
																				wm.setTurns(line.substring(7).trim());
																			}
																		}//TURNS
																		/*Caracteristics of Washing Machine end*/
	
																		line = reader.readLine();
																		if (line != null){ 
																			if (line.trim().startsWith("}")) {
																				availableApps.add(wm);		//<--
																			}
																		}
	
																	}//else if washing machine

																}//if ITEM_TYPE
															}////if line !null

														}//if line "{"
													}//if line !null

												}//if line ITEM
											}//if line !null

										}//while

									}//if line "{"
								}//if line !null

							}//if ITEM_LIST
						}//if !equals(" ")
					}//try
					catch (IOException e) {
						System.out.println("Line " + counter + ": Sudden end.");
					}

					/*Close-error*/
					try {
						reader.close();
					} 
					catch (IOException e) {
						System.err.println("Error closing file.");
					}

					System.out.println("Loading Appliances Successful!");

		}
	
}
