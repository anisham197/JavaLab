import javax.swing.*;
import java.awt.event.*;

public class AddForm extends JPanel{
		
	JTextField txtCustName, txtCustState, txtCreditLimit, txtCustRepNo;
	JLabel lblCustName, lblCustState, lblCreditLimit, lblCustRepNo;
	
	JTextField txtRepName, txtRepState, txtComm, txtRepRate;
	JLabel lblRepName, lblRepState, lblComm, lblRepRate;

	JButton btnAddCust, btnAddRep, btnBack;
	DBHelper db;
	
	AddForm()
	{
		db = new DBHelper();
		prepareGUI();
		setActions();
	}
		
	void prepareGUI(){
		
		lblRepName = new JLabel("Representative Name: ");
		lblRepState = new JLabel("Representative State: ");
		lblComm = new JLabel("Commission: ");
		lblRepRate = new JLabel("Representative Rate: ");
		
		txtRepName = new JTextField(10);
		txtRepState = new JTextField(10);
		txtComm = new JTextField(10);
		txtRepRate = new JTextField(10);
		btnAddRep = new JButton("Add Representative");		
		
		add(lblRepName);add(txtRepName);
		add(lblRepState);add(txtRepState);
		add(lblComm);add(txtComm);
		add(lblRepRate);add(txtRepRate);
		add(btnAddRep);
		
		lblCustName = new JLabel("Customer Name: ");
		lblCustState = new JLabel("Customer State: ");
		lblCreditLimit = new JLabel("Customer Credit Limit: ");
		lblCustRepNo = new JLabel("Representative Number: ");
		
		txtCustName = new JTextField(10);
		txtCustState = new JTextField(10);
		txtCreditLimit = new JTextField(10);
		txtCustRepNo = new JTextField(10);
		btnAddCust = new JButton("Add Customer");		
		
		add(lblCustName);add(txtCustName);
		add(lblCustState);add(txtCustState);
		add(lblCreditLimit);add(txtCreditLimit);
		add(lblCustRepNo);add(txtCustRepNo);
		add(btnAddCust);
		
		btnBack = new JButton("Back");
		add(btnBack);
		
	}
		
	void setActions(){
		
		btnAddRep.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = txtRepName.getText();
				String state = txtRepState.getText();
				int comm = Integer.parseInt(txtComm.getText());
				int rate = Integer.parseInt(txtRepRate.getText());
				
				db.insertRep(name, state, comm, rate);
			}
		});
		
		btnAddCust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = txtCustName.getText();
				String state = txtCustState.getText();
				int creditLimit = Integer.parseInt(txtCreditLimit.getText());
				int repNo = Integer.parseInt(txtCustRepNo.getText());
				
				db.insertCustomer(name, state, creditLimit, repNo);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.setDefaultFrame();
			}
			
		});
	}

}
