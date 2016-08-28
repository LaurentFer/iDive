package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

public class ModelGesPl  extends Observable {

	private			Connection		myConnect;
	private			String 			pmail;
	private			String			pnum;
	
	public ModelGesPl(){
		myConnect 	= Transition.getConnect();
		pmail		= Transition.getPlongeur();
		pnum		= Transition.getPlongeeSuivante();	
	}
	
	public String getPmail(){
		return pmail;
	}
	
	public String getPnum(){
		//on déclare une variable comme étant la premiere plongée
		int castpnum=1;
		//si le getter du modele l'a déclaré ni vide ni null, on la transforme en entier pour lui ajouter 1
		if (pnum !=null && pnum !=""){
			castpnum = Integer.parseInt(pnum)+1;
		}
		//on reconvertit en string pour que la vue puisse l'afficher comme une string
		pnum = Integer.toString(castpnum);
		
		return pnum;
	}
	
	public ArrayList<String> getListeRole(){
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		return monTableau = ToolResultSQL.retourReqAL(myConnect, "SELECT RNOM FROM ROLE");
	}
	
	public ArrayList<String> getDnom(){		
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		return monTableau = ToolResultSQL.retourReqAL(myConnect, "SELECT DNOM FROM DECO");
	}
	
	public ArrayList<String> getIdCentre(){
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		return monTableau = ToolResultSQL.retourReqAL(myConnect, "SELECT CNOM FROM CENTRE");
	}
	
	public ArrayList<String> getIdSite(){
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		return monTableau = ToolResultSQL.retourReqAL(myConnect, "SELECT SNOM FROM SITE");
	}
	
	public Connection getConnect(){
		return myConnect;
	}
}
