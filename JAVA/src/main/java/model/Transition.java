package model;

import java.sql.Connection;

import controller.ControllerGesPl;
import view.GestionPlongee;

public class Transition {

	private static 	Connection 	tmyConnect;
	private static	String		tplongeur;
	private static	String 		tnbplongee;
	
	public static void Transition(Connection pConnect,String pPlongeur,String pNbPlongee){
	
	//On fait transiter les variables qui deviennent des constantes de notre ajout
	tmyConnect 		= pConnect;
	tplongeur 	 	= pPlongeur;
	tnbplongee 		= pNbPlongee;
		
	 GestionPlongee 		maVue			= new GestionPlongee();
	 ModelGesPl			  	monModele 		= new ModelGesPl();
	 ControllerGesPl		monControleur 	= new ControllerGesPl();

	 monControleur.setModele(monModele);
	 monControleur.setVue(maVue);

	 maVue.setModele(monModele);
	 maVue.setListener(monControleur);

	 monModele.addObserver(maVue);
	 		 
	 maVue.afficher();
	 
	}
	
	public static Connection getConnect(){
		return tmyConnect;
	}
	
	public static String getPlongeur(){
		return tplongeur;
	}
	
	public static String getPlongeeSuivante(){
		return tnbplongee;
	}

	
}
