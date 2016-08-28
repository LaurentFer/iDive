package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;

import view.GestionPlongee;

public class Model extends Observable {

	private 			Connection 				myConnect 		= ConnectDB.CreateConnectOracle(DONNEESCONFIDENTIELLES);
	private				ArrayList<String>		ListePlongee	= new ArrayList<String>();
	private				String					premierAff 		= "Choisir un plongeur dans la combobox";
	private				String 					profMoy;
	private				String 					durMoy;
	private				String					consoMoy;
	private				String					niveau;
	private				String					nbPlongee;
	private				GestionPlongee			fenAjout;
	private				String					plongeur; //variable pour transmettre le nom du plongeur au 2nd MVC
	
	public Model(){
		
		ListePlongee.add(premierAff);
		profMoy		=	"";
		durMoy		=	"";
		consoMoy	=	"";
		niveau		=	"";
		nbPlongee	=	"";
	}
	
	public void showAjout(){
		Transition.Transition(myConnect,plongeur,nbPlongee);
	}
	
	public void ShowInformation(){
		JOptionPane.showMessageDialog(null,"Dive version 1.0 by Laurent FERRER","Information: Dive",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setNbPlongee(String pPlongeur){
		
		Statement  				myStatement 			= null;
		nbPlongee = "";
		
		try {
			myStatement = myConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery(" SELECT MAX(PNUM) FROM PLONGER WHERE PMAIL='"+pPlongeur+"'");
			while(myResultSet.next()){
				nbPlongee = myResultSet.getString(1);
			}
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		 setChanged();
		 notifyObservers();
	}
	
	public String getNbPlongee(){
		return nbPlongee;	
	}
	
	public void setNiveau(String pPlongeur){
		
		Statement  				myStatement 			= null;
		niveau = "";
		
		try {
			myStatement = myConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery(" SELECT CNOM FROM OBTENIR WHERE PMAIL='"+pPlongeur+"'");
			while(myResultSet.next()){
				niveau = myResultSet.getString(1);
			}
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		 setChanged();
		 notifyObservers();
	}
	
	public String getNiveau(){
		return niveau;	
	}
	
	public void setConsoMoy(String pPlongeur){
		
		Statement  				myStatement 			= null;
		consoMoy="";
		
		try {
			myStatement = myConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery(" SELECT avg(ConsoPl) FROM (SELECT ((((PCB*PPD)-(PCB*PPA))/((PPRO/10)+1))/PDUR) AS ConsoPL FROM PLONGER WHERE PMAIL='"+pPlongeur+"')");
			while(myResultSet.next()){
				float  maConsoMoy = myResultSet.getFloat(1);
				consoMoy = maConsoMoy+ " l/h";
			}
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		 setChanged();
		 notifyObservers();
	}
	
	public String getConsoMoy(){
		return consoMoy;	
	}
	
	public void setDurMoy(String pPlongeur){
		
		 Statement  				myStatement 			= null;
		 durMoy= ToolResultSQL.retourReqASt(myConnect, "SELECT avg(PDUR) FROM PLONGER WHERE PMAIL='"+pPlongeur+"'");
			
		 setChanged();
		 notifyObservers();
	}
	
	public String getDurMoy(){
		return durMoy;	
	}
	
	public void setProfMoy(String pPlongeur){
		
		 Statement  				myStatement 			= null;
		 profMoy = ToolResultSQL.retourReqASt(myConnect, "SELECT avg(PPRO) FROM PLONGER WHERE PMAIL='"+pPlongeur+"'");
				
		 setChanged();
		 notifyObservers();
	}
	
	public String getProfMoy(){
		return profMoy;	
	}
	
	public void setListePlongee(String pPlongeur)  {
		
		Statement  				myStatement 			= null;

		try {
			myStatement = myConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery("SELECT PLONGER.PNUM,PLONGER.POBS,SITE.SNOM FROM ((PLONGER INNER JOIN ACCOMPAGNER ON PLONGER.IDPLON = ACCOMPAGNER.IDPLON) INNER JOIN SITE ON ACCOMPAGNER.IDSITE=SITE.IDSITE) WHERE PMAIL='"+pPlongeur+"'");
			System.out.println("Requete effectuée");
			
			ListePlongee.clear();
			
			while(myResultSet.next()){
				ListePlongee.add(myResultSet.getString(1));
				ListePlongee.add(myResultSet.getString(2));
				ListePlongee.add(myResultSet.getString(3));
				ListePlongee.add("\n");
			}
			
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		 setChanged();
		 notifyObservers();
		
	}
	
	public ArrayList<String> getListePlongee(){

			return ListePlongee;

	}
		
	public ArrayList<String> getListePlongeur(){
		
		Statement  			myStatement 	= null;
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		
		try {
			myStatement = myConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery("SELECT PMAIL FROM PERSONNE");
			while(myResultSet.next()){
				monTableau.add(myResultSet.getString(1));
			}
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		return monTableau;
	}
	
	//Pour le controlleur (fermeture de connection) et pour le 2nd MVC pour faire passer la connection
	public Connection getConnect(){
		return myConnect;
	}
	
	// Partie pour le 2nd MVC
	
	public void setPlongeur(String pPlongeur){
		plongeur = pPlongeur;
	}
	

}






