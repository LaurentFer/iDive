package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import model.Model;
import view.View;

public class Controller implements ActionListener, WindowListener {

	 private Model 	monModele;
	 private View 	maVue;
	
	 public Controller() {
		 monModele	=	null;
		 maVue		=	null;
	 }
	 
	 public void setModele(Model pModele) {
		 monModele = pModele;
	 }

	 public void setVue(View pVue) {
		 maVue = pVue;
	 }
	 
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		 try {
			monModele.getConnect().close();
			System.out.println("Deconnexion de la BDD : OK");
		} catch (SQLException e) {
			System.out.print("Erreur lors de la fermeture de la connexion.");
			e.printStackTrace();
		}
		 System.exit(0);		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			monModele.setPlongeur(maVue.getPlongeur());
			
		if (e.getActionCommand()=="choixplongeur"){
			monModele.setListePlongee(maVue.getPlongeur());
			monModele.setProfMoy(maVue.getPlongeur());
			monModele.setDurMoy(maVue.getPlongeur());
			monModele.setConsoMoy(maVue.getPlongeur());
			monModele.setNiveau(maVue.getPlongeur());
			monModele.setNbPlongee(maVue.getPlongeur());
		}
		
		if (e.getActionCommand()=="informations"){
			monModele.ShowInformation();
		}
		
		if (e.getActionCommand()=="ajout"){
			monModele.showAjout();
		}
	}

}
