import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class DisplayForm  extends JPanel{
	
	DBHelper db = new DBHelper();
	JButton btnBack = new JButton("Back");
	
	DisplayForm()
	{
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.setDefaultFrame();
			}
			
		});
		display();
	}
	
	void display()
	{
		this.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		String header[] = {"RepNo","RepName"};
		
		model.setColumnIdentifiers(header);
		
		db.getReps(model);
		
		JTable tbl = new JTable(model);
		tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());
		add(new JScrollPane(tbl));
		add(btnBack);
		
	}

}
