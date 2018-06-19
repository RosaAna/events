package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelLogin extends JPanel {
	private JLabel lblLogin;
	private JButton btnEntrar;
	private JPasswordField passwordField;
	private JTextField textFLogin;
 
	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setLayout(null);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//String user="rosa";
				//String pase="1234";
				String pass=new String(passwordField.getPassword());
				
			    	
	    	   
	    	       
				if((textFLogin.getText().equalsIgnoreCase("rosa")) &&( pass.equalsIgnoreCase("1234"))){
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Has ingresado correctamente", JOptionPane.INFORMATION_MESSAGE);   
					PanelLogin l= new PanelLogin();
				//	PanelBase p= new PanelBase();
					Vista v = new Vista();
					v.remove(l);
					//v.add(p, BorderLayout.CENTER);
					 
				}
				else {
			         System.out.println(" nnn---------No---ff---------gg");
			         System.exit(0);
				}
				
			}
		});
		
		btnEntrar.setForeground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEntrar.setBounds(428, 372, 114, 31);
		add(btnEntrar);
		
		JLabel lblFPass = new JLabel("Pass");
		lblFPass.setForeground(Color.DARK_GRAY);
		lblFPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFPass.setBounds(385, 324, 46, 14);
		add(lblFPass);
		

		
		passwordField = new JPasswordField();
		passwordField.setBounds(456, 323, 86, 20);
		add(passwordField);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setBounds(385, 299, 46, 14);
		add(lblLogin);
		
		textFLogin = new JTextField();
		textFLogin.setBounds(456, 292, 86, 20);
		add(textFLogin);
		textFLogin.setColumns(10);

	}

	/**
	 * @return the btnEntrar
	 */
	public JButton getBtnEntrar() {
		return btnEntrar;
	}
	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	/**
	 * @return the textFLogin
	 */
	public JTextField getTextFLogin() {
		return textFLogin;
	}

}
