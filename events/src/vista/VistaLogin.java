package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VistaLogin extends JFrame{
public Image imagenFondo1, imagenFondo2, imagenFondo3, imagenFondo4, imagenFondo5;
public URL fondo, fondo2, fondo3, fondo4, fondo5;
private JTextField textField_login;
private JTextField textField_pass;
private JFrame frame;
private JPanel panelI;
private JPanel panelL;
private JTabbedPane pestanas;
private JMenu mnAbout;
private JMenuItem mntmSobreNosotros;
private JMenuItem mntmSalir;
private JMenu mnDatos;
private JMenu mnCargarDatos;
private JMenuItem mntmProductos;
private JMenuItem mntmClientes;
private JMenuItem mntmParticipantes;
/*

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

*/


	public VistaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1050, 820);
		getContentPane().setLayout(new BorderLayout(0, 0));
		//this.setSize(new Dimension(1200, 800));
		
		fondo=this.getClass().getResource("barner.PNG");
		imagenFondo1=new ImageIcon(fondo).getImage();
		
		
		fondo2=this.getClass().getResource("fondoInformac.PNG");
		imagenFondo2=new ImageIcon(fondo2).getImage();
		
		fondo3=this.getClass().getResource("fondo.PNG");
		imagenFondo3=new ImageIcon(fondo3).getImage();
		

		fondo5=this.getClass().getResource("login.PNG");
		imagenFondo5=new ImageIcon(fondo5).getImage();
		
		
		fondo4=this.getClass().getResource("fondod.PNG");
		imagenFondo4=new ImageIcon(fondo4).getImage();
		
		JPanel panel = new JPanel()
		{
		public void paintComponent(Graphics g) {
	    g.drawImage(imagenFondo1, 0, 0, getWidth() , getHeight(), this);
		}	
		}
		;
		
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(140, 5, 5, 5));
		
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
	    JTabbedPane pestanas=new JTabbedPane();
		
		    PanelInformacion panelI =new PanelInformacion() {
			public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo2, 0, 0, getWidth() , getHeight(), this);
			}	
			}
			;		
	        pestanas.addTab("INFORMACION", panelI);
	
	        
	        
	        PanelLogin panelL= new  PanelLogin() {
	        public void paintComponent(Graphics g) {
	        g.drawImage(imagenFondo5, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	        pestanas.addTab("LOGIN", panelL);
	 
	        
	        PanelParticipantes panelPA= new  PanelParticipantes() {
	        public void paintComponent(Graphics g) {
	        g.drawImage(imagenFondo4, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	        pestanas.addTab("RELACION DE PARTICIPANTES", panelPA);
	        
		    getContentPane().add(pestanas, BorderLayout.CENTER);
		  */  
	    JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		    mnCargarDatos = new JMenu("CARGAR DATOS");
		    menuBar.add(mnCargarDatos);
		       mntmClientes = new JMenuItem("Clientes");
		       mnCargarDatos.add(mntmClientes);
		       mntmParticipantes = new JMenuItem("Participantes");
		       mnCargarDatos.add(mntmParticipantes);
		       mntmProductos = new JMenuItem("Productos");
		       mnCargarDatos.add(mntmProductos);
		    mnAbout = new JMenu("About");
		    menuBar.add(mnAbout); 
		       mntmSobreNosotros = new JMenuItem("Sobre nosotros");
		       mnAbout.add(mntmSobreNosotros);
			   mntmSalir = new JMenuItem("Salir");
			   mnAbout.add(mntmSalir);
	
		}

	public static Component getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * @return the textField_login
	 */
	public JTextField getTextField_login() {
		return textField_login;
	}

	/**
	 * @return the textField_pass
	 */
	public JTextField getTextField_pass() {
		return textField_pass;
	}


	public JTabbedPane getPestanas() {
		return pestanas;
	}

	/**
	 * @return the mnAbout
	 */
	public JMenu getMnAbout() {
		return mnAbout;
	}

	/**
	 * @return the mntmSobreNosotros
	 */
	public JMenuItem getMntmSobreNosotros() {
		return mntmSobreNosotros;
	}

	/**
	 * @return the mnDatos
	 */
	public JMenu getMnDatos() {
		return mnDatos;
	}

	/**
	 * @return the mnCargarDatos
	 */
	public JMenu getMnCargarDatos() {
		return mnCargarDatos;
	}

	/**
	 * @return the mntmParticipantes
	 */
	public JMenuItem getMntmParticipantes() {
		return mntmParticipantes;
	}

	/**
	 * @return the mntmSalir
	 */
	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}


	/**
	 * @return the mntmProductos
	 */
	public JMenuItem getMntmProductos() {
		return mntmProductos;
	}

	/**
	 * @return the mntmClientes
	 */
	public JMenuItem getMntmClientes() {
		return mntmClientes;
	}

	}


