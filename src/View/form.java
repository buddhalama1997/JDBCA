package View;
import javax.swing.*;

import Controller.ControllerStudent;

import java.awt.*;
import java.awt.event.*; 
public class form extends JFrame implements ActionListener{
	private JLabel idLabel, nameLabel,courseLabel;
	private JTextField idTxt, nameTxt, courseTxt;
	private JButton submitBtn, updateBtn, deleteBtn, cancelBtn;
	
	public form() {
		idLabel = new JLabel("id");
		idLabel.setBounds(10, 10, 100, 30);
		add(idLabel);
		idTxt = new JTextField();
		idTxt.setBounds(150, 10, 100, 30);
		add(idTxt);
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 40, 100, 30);
		add(nameLabel);
		nameTxt = new JTextField();
		nameTxt.setBounds(150, 40, 100, 30);
		add(nameTxt);
		courseLabel = new JLabel("Course");
		courseLabel.setBounds(10, 70, 100, 30);
		add(courseLabel);
		courseTxt = new JTextField();
		courseTxt.setBounds(150, 70, 100, 30);
		add(courseTxt);
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(10, 100, 100, 30);
		submitBtn.addActionListener(this);
		add(submitBtn);
		updateBtn = new JButton("Update");
		updateBtn.setBounds(150,100,100,30);
		add(updateBtn);
		deleteBtn = new JButton("Submit");
		deleteBtn.setBounds(10, 130, 100, 30);
		add(deleteBtn);
		cancelBtn = new JButton("Update");
		cancelBtn.setBounds(150,130,100,30);
		add(cancelBtn);
		setTitle("Manage Student");
		setSize(700, 500);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new form();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitBtn) {
			//save
			int sid=Integer.parseInt(idTxt.getText());
			String name = nameTxt.getText();
			String course =courseTxt.getText();
			ControllerStudent cs = new ControllerStudent();
			boolean result = cs.save(sid, name,course);
			if(result==true) {
				JOptionPane.showMessageDialog(this, "Save record");
				idTxt.setText("");
				nameTxt.setText("");
				courseTxt.setText("");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error to save record");
			}
		}
	}

}
