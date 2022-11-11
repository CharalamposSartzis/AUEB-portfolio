import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Tabbed_Store extends JFrame implements ActionListener, MouseListener{
	
	private JButton butBuy_Avail;
	private JButton butDet_Avail;
	private JButton butExec_Order;
	private JButton butDet_Order;	private JButton butSearch_Order;
	private JButton butDet_Sales;	private JButton butSearch_Sales;
	private JTextArea resultArea;
	private JTextArea OrderResultArea;
	private JTextArea SalesResultArea;
	private JList list;
	private JList OrderList;
	private JList SalesList;
	private JLabel label;
	private JLabel OrderLabel;
	private JLabel SalesLabel;
	private ImageIcon imIco1;
	private DefaultListModel listModel;
	private DefaultListModel OrderListModel;
	private DefaultListModel SalesListModel;
	
	private static Vector<Electrical_Appliance> elApp_list=new Vector<Electrical_Appliance>();
	private static Vector<Ordered_Appliances> ordApp_list=new Vector<Ordered_Appliances>();
	private static Vector<Sold_Appliances> soldApp_list=new Vector<Sold_Appliances>();

	//Constructor
	public Tabbed_Store(){
		
		setTitle("Appliance Store");	//Create the title you see in the upper left of the window.
		//setBounds(300, 300, 350, 150);	//Set the location and size of the window.
		setLocation(0,80);
		setSize(1350,600);
		
		JTabbedPane tabbedPane = new JTabbedPane();		//Create the object tabbedPane.
		
		getContentPane().add(tabbedPane);	//Create the template on the application.
		
		JPanel availablePanel = new JPanel();	//Create the tab with the availables.
		JPanel ordersPanel = new JPanel();		//Create the tab with the orders.
		JPanel salesPanel = new JPanel();		//Create the tab with the sales.
		
		tabbedPane.addTab("Availables",availablePanel);		//Add the 3 tabs to the tabbed pane with their names.
		tabbedPane.addTab("Orders",ordersPanel);
		tabbedPane.addTab("Sales",salesPanel);
		
		///////////////////Create Availables tab./////////////////////////////////////////////////////////////////////////////////////////////// 
		
		/*New sub-panel with 2 Buttons and a TextArea.*/
		
		JPanel paneButton = new JPanel();	//Create the sub-panel.  
		paneButton.setLayout(new FlowLayout());
		
		butBuy_Avail = new JButton("Buy Appliance");			//Create the 2 Buttons.
		butDet_Avail = new JButton("View Appliance details");	
		paneButton.add(butBuy_Avail);	//Add the buttons to the sub-panel.
		paneButton.add(butDet_Avail);
		
										//Create the TextArea.
		resultArea = new JTextArea("Appliance details: \n Please select an Appliance and \n press \"View Appliance details\"",10,20);
		resultArea.setFont(new Font("Serif", Font.ITALIC, 18));
		resultArea.setForeground(Color.BLUE);
		resultArea.setEditable(false);
		paneButton.add(resultArea);		//Add the text area to the sub-panel.
		
		//Add the sub-panel to the Availables tab.
		availablePanel.add(paneButton, BorderLayout.LINE_START);
		
		
		/*New List with the Availables.*/
		
		listModel = new DefaultListModel();
		for (Electrical_Appliance elApp : elApp_list)
		{
			listModel.addElement(elApp.getItemType());
		}
		list = new JList(listModel);	// A JList presents the user with a group of items (DefaultListModel)
		list.setSelectedIndex(0);
		
		JScrollPane listScroller = new JScrollPane(list);	// A JScrollPane provides a scrollable view of a component
		listScroller.setPreferredSize(new Dimension(150, 100));
		
		//Add the Scroll panel to the Availables tab.
		availablePanel.add(listScroller, BorderLayout.CENTER);
		
		
		/*New Label with the images of the Availables.*/
		
		label = new JLabel();	//Create the Label.
		label.setIcon(new ImageIcon(elApp_list.get(0).getImagePath()));
		
		//Add the Label to Availables tab.
		availablePanel.add(label, BorderLayout.LINE_END);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		///////////////////Create Orders tab.///////////////////////////////////////////////////////////////////////////////////////////////
		
		/*New sub-panel with 3 Buttons and a TextArea.*/
		
		JPanel orderPaneButton = new JPanel();	//Create the sub-panel.  
		orderPaneButton.setLayout(new FlowLayout());
		
		butExec_Order = new JButton("Execute Order");			//Create the 3 Buttons.
		butSearch_Order = new JButton("Order Search by name");
		butDet_Order = new JButton("View Order details");	
		orderPaneButton.add(butExec_Order);	//Add the buttons to the sub-panel.
		orderPaneButton.add(butSearch_Order);
		orderPaneButton.add(butDet_Order);
		
										//Create the TextArea.
		OrderResultArea = new JTextArea("Order details: \n Please select an Order and \n press \"View Order details\"",10,20);
		OrderResultArea.setFont(new Font("Serif", Font.ITALIC, 18));
		OrderResultArea.setForeground(Color.BLUE);
		OrderResultArea.setEditable(false);
		orderPaneButton.add(OrderResultArea);		//Add the text area to the sub-panel.
		
		//Add the sub-panel to the Orders tab.
		ordersPanel.add(orderPaneButton, BorderLayout.LINE_START);
		
		
		/*New List with the Orders.*/
		
		OrderListModel = new DefaultListModel();
		for (Ordered_Appliances ordApp : ordApp_list)
		{
			OrderListModel.addElement(ordApp.getOrdApp().getItemType());
		}
		OrderList = new JList(OrderListModel);	// A JList presents the user with a group of items (DefaultListModel)
		OrderList.setSelectedIndex(0);
		
		JScrollPane OrderListScroller = new JScrollPane(OrderList);	// A JScrollPane provides a scrollable view of a component
		OrderListScroller.setPreferredSize(new Dimension(150, 100));
		
		//Add the Scroll panel to the Orders tab.
		ordersPanel.add(OrderListScroller, BorderLayout.CENTER);
		
		
		/*New Label.*/
		
		OrderLabel = new JLabel();	//Create the Label.
		OrderLabel.setText("Ordered Appliances list");
		
		//Add the Label to Orders tab.
		ordersPanel.add(OrderLabel, BorderLayout.LINE_END);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		///////////////////Create Sales tab.///////////////////////////////////////////////////////////////////////////////////////////////
		
		/*New sub-panel with 2 Buttons and a TextArea.*/
		
		JPanel salesPaneButton = new JPanel();	//Create the sub-panel.  
		salesPaneButton.setLayout(new FlowLayout());
		
		butDet_Sales = new JButton("View Sale details");			//Create the 2 Buttons.	
		butSearch_Sales = new JButton("Sales Search by name");
		salesPaneButton.add(butSearch_Sales);	//Add the 2 buttons to the sub-panel.
		salesPaneButton.add(butDet_Sales);
		
										//Create the TextArea.
		SalesResultArea = new JTextArea("Sale details: \n Please select a Sale and \n press \"View Sale details\"",10,20);
		SalesResultArea.setFont(new Font("Serif", Font.ITALIC, 18));
		SalesResultArea.setForeground(Color.BLUE);
		SalesResultArea.setEditable(false);
		salesPaneButton.add(SalesResultArea);		//Add the text area to the sub-panel.
		
		//Add the sub-panel to the Sales tab.
		salesPanel.add(salesPaneButton, BorderLayout.LINE_START);
		
		
		/*New List with the Sales.*/
		
		SalesListModel = new DefaultListModel();
		for (Sold_Appliances soldApp : soldApp_list)
		{
			SalesListModel.addElement(soldApp.getSoldApp().getItemType());
		}
		SalesList = new JList(SalesListModel);	// A JList presents the user with a group of items (DefaultListModel)
		SalesList.setSelectedIndex(0);
		
		JScrollPane SalesListScroller = new JScrollPane(SalesList);	// A JScrollPane provides a scrollable view of a component
		SalesListScroller.setPreferredSize(new Dimension(150, 100));
		
		//Add the Scroll panel to the Sales tab.
		salesPanel.add(SalesListScroller, BorderLayout.CENTER);
		
		
		/*New Label.*/
		
		SalesLabel = new JLabel();	//Create the Label.
		SalesLabel.setText("Sold Appliances list");
		
		//Add the Label to Sales tab.
		salesPanel.add(SalesLabel, BorderLayout.LINE_END);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		butBuy_Avail.addActionListener(this);
		butDet_Avail.addActionListener(this);
		butExec_Order.addActionListener(this);
		butDet_Order.addActionListener(this);	butSearch_Order.addActionListener(this);
		butDet_Sales.addActionListener(this);	butSearch_Sales.addActionListener(this);
		list.addMouseListener(this);
		OrderList.addMouseListener(this);
		SalesList.addMouseListener(this);
		
		//pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	int saleIndex=111;
	int orderIndex=111;
		//actionPerformed
		public void actionPerformed(ActionEvent e){
			//int saleIndex=111;
			//int orderIndex=111;
			/*Buy/Order an Appliance*/
			if(e.getSource()==butBuy_Avail){
				int i = list.getSelectedIndex();
				if (i != -1) {
					//Sale
					if(elApp_list.get(i).getCopies()!=0){
						//int saleIndex=111;
						//String saleIndex=(String)JOptionPane.showInputDialog(this, "Please enter a sale index");
						String buyerName=(String)JOptionPane.showInputDialog(this, "Please enter your name");
						String buyerPhone=(String)JOptionPane.showInputDialog(this, "Please enter your phone");
						String soldDate=(String)JOptionPane.showInputDialog(this, "Please enter the date of the sale");
						
						JOptionPane.showMessageDialog(this,"The final cost (including the discount) is "+Calculate_Discount.calculateCost(elApp_list.get(i))+" $");
						
						Sold_Appliances soldApp=new Sold_Appliances(saleIndex,elApp_list.get(i),buyerName,buyerPhone,soldDate);
						soldApp_list.add(soldApp);	
						SalesListModel.addElement(soldApp.getSoldApp().getItemType());
						
						saleIndex++;
						elApp_list.get(i).OneLessCopie();
					}
					//Order
					else{
						//int orderIndex=111;
						//String orderIndex=(String)JOptionPane.showInputDialog(this, "Please enter an order index");
						String ordererName=(String)JOptionPane.showInputDialog(this, "There are no copies available, so you can order the Appliance.\nPlease enter your name");
						String ordererPhone=(String)JOptionPane.showInputDialog(this, "Please enter your phone");
						String ordDate=(String)JOptionPane.showInputDialog(this, "Please enter the date of the order");
						String arrDate=(String)JOptionPane.showInputDialog(this, "Please enter the expected date of the arrival");
						
						JOptionPane.showMessageDialog(this,"The final cost (including the discount) is "+Calculate_Discount.calculateCost(elApp_list.get(i))+" $");
						
						Ordered_Appliances ordApp=new Ordered_Appliances(orderIndex,elApp_list.get(i),ordererName,ordererPhone,ordDate,arrDate,false);
						ordApp_list.add(ordApp);	
						OrderListModel.addElement(ordApp.getOrdApp().getItemType());
						
						orderIndex++;
					}
				}
			}
			/*View Available details.*/
			else if(e.getSource()==butDet_Avail){
				int i = list.getSelectedIndex();
				String outputText = elApp_list.get(i).toString();	//Shows the characteristics of the Available appliances.
				resultArea.setText(outputText);
			}
			/*Execute the Order.*/
			else if(e.getSource()==butExec_Order){
				int i = OrderList.getSelectedIndex();
				if(i!=-1){
					if(ordApp_list.get(i).isExecuted()==false){
						ordApp_list.get(i).setExecuted();
						
						String execDate=(String)JOptionPane.showInputDialog(this,"Please enter the date of execution of the order");
						
						JOptionPane.showMessageDialog(this,"The order was executed successfully!");
					
						Sold_Appliances soldApp=new Sold_Appliances(saleIndex,ordApp_list.get(i).getOrdApp(),ordApp_list.get(i).getOrdName(),ordApp_list.get(i).getOrdPhone(),execDate);	//The date of the sale is the date of execution of the order.
						soldApp_list.add(soldApp);	
						SalesListModel.addElement(soldApp.getSoldApp().getItemType());
					
						saleIndex++;
					}
					else{
						JOptionPane.showMessageDialog(this,"The order you select has already been executed!!","Execution Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			/*Search the Orders by name*/
			else if(e.getSource()==butSearch_Order){
				String ordererName=(String)JOptionPane.showInputDialog(this,"Please enter the name of the customer");
				for (Ordered_Appliances ordApp : ordApp_list){
					if(ordApp.getOrdName().equals(ordererName)){
						String outputText = ordApp.toString();		//Shows the appliance ordered by the specific customer.
						//OrderResultArea.append(outputText);
						JOptionPane.showMessageDialog(this,"The customer "+ordererName+" has made the following order:"+"\n"+outputText);		//The characteristics of the appliance(s) that has(have) been ordered by this customer appear at one(or more) messages.
					}
					else{
						JOptionPane.showMessageDialog(this,"There is no customer that has made this order!!","Customer name Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			/*View Order details.*/
			else if(e.getSource()==butDet_Order){
				int i = OrderList.getSelectedIndex();
				String outputText = ordApp_list.get(i).toString();	//Shows the characteristics of the Ordered appliances.
				OrderResultArea.setText(outputText);
			}
			/*Search the Sales by name*/
			else if(e.getSource()==butSearch_Sales){
				String buyerName=(String)JOptionPane.showInputDialog(this,"Please enter the name of the customer");
				for (Sold_Appliances soldApp : soldApp_list){
					if(soldApp.getBuyerName().equals(buyerName)){
						String outputText = soldApp.toString();		//Shows the appliance sold to the specific customer.
						//SalesResultArea.append("\n"+outputText);
						JOptionPane.showMessageDialog(this,"The customer "+buyerName+" has made the following purchase:"+"\n"+outputText);		//The characteristics of the appliance(s) that has(have) been sold to this customer appear at one(or more) messages.
					}
					else{
						JOptionPane.showMessageDialog(this,"There is no customer that has made this sale!!","Customer name Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			/*View Sale details.*/
			else if(e.getSource()==butDet_Sales){
				int i = SalesList.getSelectedIndex();
				String outputText = soldApp_list.get(i).toString();	 //Shows the characteristics of the Sold appliances.
				SalesResultArea.setText(outputText);
			}
		}
	
			
		//Mouse methods
		public void mouseClicked(MouseEvent event) {
			int i = list.getSelectedIndex();
			if (list.getSelectedIndex() != -1) {
				String pathimage = elApp_list.get(i).getImagePath();
				if (pathimage != null) {
					label.setIcon(new ImageIcon(pathimage));
				}
				else {
						label.setIcon(new ImageIcon());
				}
			}
		}
		
		public void mouseExited(MouseEvent event){}
		
		public void mouseEntered(MouseEvent event){}
		
		public void mouseReleased(MouseEvent event){}
		
		public void mousePressed(MouseEvent event){}
		
				
		//Main
		public static void main(String[] args){
			Electrical_Appliance tv1=new Television("Samsung SUHD","1224a","SUHD",2014,"Samsung",300,2,"LCD",720,32,"HDMI");
			Electrical_Appliance tv2=new Television("LG FullHD","1326b","FullHD",2015,"LG",400,3,"LED",1080,42,"HDMI");
			Electrical_Appliance pl1=new Player("Phillips DVP2800","1428c","DVP2800",2014,"Philips",30,2,"DVD",720,"BD-R");
			Electrical_Appliance pl2=new Player("Samsung BD-J5500","1530d","BD-J5500",2015,"Samsung",66,1,"Blu ray",1080,"BD-RD");
			Electrical_Appliance cm1=new Camera("Sony W800","1632e","Cyber-shot W800",2015,"Sony",78,2,"compact",14.0,2.7,5,6);
			Electrical_Appliance cm2=new Camera("Kodak M531","1734f","Easyshare M531",2015,"Kodak",119,2,"compact",20.1,2.7,3,4);
			Electrical_Appliance gm1=new Gaming("Sony PS4","1836g","C Chassis",2015,"Sony",312,3,"PS4","APU","GPU","audio",500);	
			Electrical_Appliance gm2=new Gaming("Microsoft Xbox","1938h","360 E",2014,"Microsoft",189,2,"Xbox","Xenon","GPU","audio",500);	
			Electrical_Appliance gm3=new Gaming("Nintendo Wii","2040i","U Basic Pack",2013,"Nintendo",300,1,"Wii","Broadway","GPU","audio",8);	  
			Electrical_Appliance fr1=new Fridge("Whirlpool WME","2244j","WME 36652 W",2013,"Whirlpool",420,1,"Onedoor","A++",363,0);
			Electrical_Appliance fr2=new Fridge("NERF","2346k","K5885X4",2014,"NEFF",1014.4,2,"Twodoor","A+",223,94);
			Electrical_Appliance wm1=new Washing_Machine("AEG Washing Machine","2448l","L68281VFL",2014,"AEG",340,2,"A+++",8,1200);
			Electrical_Appliance wm2=new Washing_Machine("Bosch Washing Machine","2550m","WAK20160GR",2014,"Bosch",350,2,"A+++",8,1000);
			tv1.setImagePath("Images/tv1.jpg");
			tv2.setImagePath("Images/tv2.jpg");
			pl1.setImagePath("Images/pl1.jpg");
			pl2.setImagePath("Images/pl2.jpg");
			cm1.setImagePath("Images/cm1.jpg");
			cm2.setImagePath("Images/cm2.jpg");
			gm1.setImagePath("Images/gm1.jpg");
			gm2.setImagePath("Images/gm2.jpg");
			gm3.setImagePath("Images/gm3.jpg");
			fr1.setImagePath("Images/fr1.jpg");
			fr2.setImagePath("Images/fr2.jpg");
			wm1.setImagePath("Images/wm1.jpg");
			wm2.setImagePath("Images/wm2.jpg");
			elApp_list.add(tv1);
			elApp_list.add(tv2);
			elApp_list.add(pl1);
			elApp_list.add(pl2);
			elApp_list.add(cm1);
			elApp_list.add(cm2);
			elApp_list.add(gm1);
			elApp_list.add(gm2);
			elApp_list.add(gm3);
			elApp_list.add(fr1);
			elApp_list.add(fr2);
			elApp_list.add(wm1);
			elApp_list.add(wm2);
			Tabbed_Store tabs=new Tabbed_Store();
		}
			
}