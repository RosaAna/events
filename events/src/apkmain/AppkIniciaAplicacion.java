package apkmain;

import java.awt.EventQueue;
import controlador.Controlador;
import modeloDAO.FansDAO;
import modeloDAO.ParticipanteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import vista.Vista;


public class AppkIniciaAplicacion {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					new Controlador(frame, new FansDAO(), new ProductoDAO(), new VentaDAO(), new DevolucionDAO(),new ParticipanteDAO(),new PerdidasDAO());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
