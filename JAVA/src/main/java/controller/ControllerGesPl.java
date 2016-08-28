package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import model.ModelGesPl;
import view.GestionPlongee;


public class ControllerGesPl implements ActionListener, WindowListener {
	
	private ModelGesPl 		monModele;
	private GestionPlongee 	maVue;
	
	public ControllerGesPl(){
		monModele	=	null;
		maVue		=	null;
	}
	
	 public void setModele(ModelGesPl pModele) {
		 monModele = pModele;
	 }

	 public void setVue(GestionPlongee pVue) {
		 maVue = pVue;
	 }
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			monModele.getConnect().rollback();
		} catch (SQLException e1) {
			System.out.println("Bouton Fermer la fenêtre - Erreur lors du rollback");
			e1.printStackTrace();
		}
		maVue.fermer();
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="annuler"){
			try {
				monModele.getConnect().rollback();
			} catch (SQLException e1) {
				System.out.println("Bouton Annuler - Erreur lors du rollback");
				e1.printStackTrace();
			}
			maVue.fermer();
		}
		
	}

}
