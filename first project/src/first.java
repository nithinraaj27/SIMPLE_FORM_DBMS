import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class first extends Frame{
	
	Checkbox c1,c2;
	CheckboxGroup cbg;
	Label l1,l2,l3,l4,l5;
	TextField t1,t2,t3,t4;
	Button b1;
	
	first()
	{
		setLayout(null);
		
		l1 = new Label("Name");
		l2 = new Label("Address");
		l3 = new Label("city");
		l4 = new Label("Pincode");
		l5 = new Label("Sex");
		
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		t4 = new TextField();
		
		cbg = new CheckboxGroup();
		
		c1 = new Checkbox("Male",cbg,false);
		c2 = new Checkbox("Female",cbg,false);
		
		b1 = new Button("Submit");
		
		String st;
		c1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Checkbox ch = cbg.getSelectedCheckbox();
				String st1 = ch.getLabel();
			}
		});

		
		c2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Checkbox ch = cbg.getSelectedCheckbox();
				String st2 = ch.getLabel();
			}
		});

		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = t1.getText();
				String address = t2.getText();
				String city = t3.getText();
				String pincode = t4.getText();
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
				dbinsert(name,address,city,pincode,cbg.getSelectedCheckbox().getLabel().toString());
			}
		});
		
		
		l1.setBounds(100, 100, 100, 25);
		l2.setBounds(100, 150, 100, 25);
		l3.setBounds(100, 200, 100, 25);
		l4.setBounds(100, 250, 100, 25);
		l5.setBounds(100, 300, 100, 25);
		
		t1.setBounds(230, 100, 100, 25);
		t2.setBounds(230, 150, 100, 25);
		t3.setBounds(230, 200, 100, 25);
		t4.setBounds(230, 250, 100, 25);
		
		
		c1.setBounds(230, 300, 35, 25);
		c2.setBounds(300, 300, 50, 25);
		
		b1.setBounds(200, 350, 80, 25);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		
		add(c1);
		add(c2);
		
		add(b1);
		
		setSize(500,500);
		
		setBackground(Color.YELLOW.brighter());
		
		setResizable(false);
		
		setVisible(true);
		
		}
	public static void main(String[] args) {
		new first();
	}
	
	void dbinsert(String uname,String adress,String city,String pincode,String sex) 
	{
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
				Statement st = conn.createStatement();
				
				String sq1 = "insert into first values('"+uname+"','"+adress+"','"+city+"','"+pincode+"','"+sex+"')";
				
				st.executeUpdate(sq1);
				conn.close();
				
				System.out.println("success");			
			}
			catch (Exception e) {
				System.out.println("Error "+ e);
				// TODO: handle exception
			}
	}
}
