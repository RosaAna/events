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
import java.awt.MenuBar;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JTextField;

//public class Vista<PanelSpliPane> extends JFrame {
public class Vista extends JFrame {
public Image imagenFondo1, imagenFondo2, imagenFondo3, imagenFondo4, imagenFondo5;
public URL fondo, fondo2, fondo3, fondo4, fondo5;
private JFrame frame;
private JMenu mnAbout;
private JMenuItem mntmSobreNosotros;
private JMenuItem mntmSalir;
private JMenuItem mntmProductos;
private JMenuItem mntmClientes;
private JMenuItem mntmParticipantes;
private JMenu mnCargarDatos;
private PanelProductos panelProductos;
private PanelDevoluciones panelDevoluciones;
private SplitPan splitPan;
private PanelLogin panelLogin;
private PanelParticipantes panelParticipantes;
private PanelFans panelFans;
private JTabbedPane pestanas;
private PanelB panelB;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);//centrarla en la ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Vista() {
		
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
		

		fondo4=this.getClass().getResource("fondod.PNG");
		imagenFondo4=new ImageIcon(fondo4).getImage();
		

		fondo5=this.getClass().getResource("fondo.PNG");
		imagenFondo5=new ImageIcon(fondo5).getImage();
		
		
		  JPanel panel = new JPanel()
		  {
		  public void paintComponent(Graphics g) {
	      g.drawImage(imagenFondo1, 0, 0, getWidth() , getHeight(), this);
		  }	
		  }
		  ;
		
		   getContentPane().add(panel, BorderLayout.NORTH);
		   panel.setBorder(new EmptyBorder(140, 5, 5, 5));
		
		   PanelLogin panelL =new PanelLogin() {
		   public void paintComponent(Graphics g) {
		   g.drawImage(imagenFondo5, 0, 0, getWidth() , getHeight(), this);
		   }	
		   }
		   ;		
		   getContentPane().add(panelL, BorderLayout.CENTER);
		   
		   
			
		
	        pestanas=new JTabbedPane();
	
		    JPanel panel0 =new JPanel() {
		    public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo2, 0, 0, getWidth() , getHeight(), this);
		    }	
		    }
		    ;		
	        pestanas.addTab("INFORMACION", panel0);
	 
	    
	        panelB= new  PanelB() {
	        public void paintComponent(Graphics g) {
	        g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	      //  panel1.setBackground(Color.BLUE);
	        pestanas.addTab("VENTAS", panelB);
	      
	        
	        panelDevoluciones=new PanelDevoluciones() {
	        public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo4, 0, 0, getWidth() , getHeight(), this);
			}
		    }
			;
	        
	        pestanas.addTab("DEVOLUCIONES", panelDevoluciones);
	       
	        
	        panelFans= new  PanelFans() {
	        public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	        pestanas.addTab("FANS", panelFans);
	        
	        panelProductos=new PanelProductos() {
	        public void paintComponent(Graphics g) {
			g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
		    ;	
	        pestanas.addTab("PRODUCTOS", panelProductos);
	        
	        panelParticipantes=new PanelParticipantes() {
		    public void paintComponent(Graphics g) {
			g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
		    }
			;	
		    pestanas.addTab("PARTICIPANTES", panelParticipantes);
	  
		    splitPan=new SplitPan() {	
		    public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
		 	}	
		    }
		    ;
		    pestanas.add("ADMINISTRACION", splitPan);
			getContentPane().add(pestanas, BorderLayout.CENTER);
		
        
       JMenuBar menuBar = new JMenuBar();
	   setJMenuBar(menuBar);
	     mnCargarDatos = new JMenu("CARGAR DATOS");
	     menuBar.add(mnCargarDatos);
	        mntmClientes = new JMenuItem("Fans");
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
	
	/**
	 * @return the mb
	 */
	public PanelB getPanelB() {
		return panelB;
	}


	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
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


	/**
	 * @return the mntmParticipantes
	 */
	public JMenuItem getMntmParticipantes() {
		return mntmParticipantes;
	}


	/**
	 * @return the mnCargarDatos
	 */
	public JMenu getMnCargarDatos() {
		return mnCargarDatos;
	}


	/**
	 * @return the panelProductos
	 */
	public PanelProductos getPanelProductos() {
		return panelProductos;
	}


	/**
	 * @return the panelDevoluciones
	 */
	public PanelDevoluciones getPanelDevoluciones() {
		return panelDevoluciones;
	}


	/**
	 * @return the splitPan
	 */
	public SplitPan getSplitPan() {
		return splitPan;
	}



	/**
	 * @return the panelLogin
	 */
	public PanelLogin getPanelLogin() {
		return panelLogin;
	}


	/**
	 * @return the panelParticipantes
	 */
	public PanelParticipantes getPanelParticipantes() {
		return panelParticipantes;
	}


	/**
	 * @return the panelFans
	 */
	public PanelFans getPanelFans() {
		return panelFans;
	}


	/**
	 * @return the pestanas
	 */
	public JTabbedPane getPestanas() {
		return pestanas;
	}


	
	}


