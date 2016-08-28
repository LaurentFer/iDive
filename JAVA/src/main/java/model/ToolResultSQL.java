package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Classe d'utilitaires dédiée au remaniement de requêtes SQL
 * 
 * @author Laurent FERRER
 * @version 1.0
 *
 */
public class ToolResultSQL {
	
	/**
	 * Classe permettant de renvoyer un Hashtable Entier / Chaine a partir du résultat d'une requête SQL
	 * @param pConnect Nom de la connection instanciée à utiliser.
	 * @param pRequete Chaîne correspondant à la requête SQL à traiter
	 * @return Hashtable Clé : Entier et Valeur : Chaîne
	 */
	public static Hashtable<Integer,String> getHIntStr(Connection pConnect,String pRequete){

		Statement  					myStatement=null;
		Hashtable<Integer,String>	monTableau = new Hashtable<Integer,String>();
		
		try {
			myStatement = pConnect.createStatement();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		ResultSet	myResultSet = null;
		
		//Execution de la requête
		try {
			myResultSet = myStatement.executeQuery(pRequete);
			System.out.println("Requete effectuée");
		} catch (SQLException e) {
			System.out.println("Echec de la requête.");
			e.printStackTrace();
		}
		
		//Affectation des données reçus à une HashTable
		try {
			while(myResultSet.next()){
				monTableau.put(myResultSet.getInt(1), myResultSet.getString(2));
			}
		} catch (SQLException e1) {
			System.out.println("Erreur dans la lecture du résultat de la requête.");
			e1.printStackTrace();
		}
		
		
		//Fermeture du statement
		try {
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la fermeture du Statment");
			e.printStackTrace();
		}
		
		return monTableau;
		
	}
/*
	public static void CreaClient(Connection pConnect,String pId,String pNom, String pPrenom){
		
		Statement  					myStatement=null;
		
		try {
			myStatement = pConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery("INSERT INTO CLIENT(CLID,CLNO,CLPR) VALUES ('"+pId+"','"+pNom+"','"+pPrenom+"')");
			pConnect.commit();
			myStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
	}*/
	
	public static ArrayList retourReqAL(Connection pConnect,String maRequeteSimple){
		
		Statement  			myStatement 	= null;
		ArrayList<String>	monTableau 		= new ArrayList<String>();
		
		try {
			myStatement = pConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery(maRequeteSimple);
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
	
	public static String retourReqASt(Connection pConnect,String maRequeteSimple){
		
		Statement  			myStatement 	= null;
		String				monRetourSt 	= "";
		
		try {
			myStatement = pConnect.createStatement();
			ResultSet	myResultSet = null;
			myResultSet = myStatement.executeQuery(maRequeteSimple);
			while(myResultSet.next()){
				monRetourSt=myResultSet.getString(1);
			}
			myStatement.close();
		} catch (SQLException e) {
			System.out.println("Echec de la création du Statment");
			e.printStackTrace();
		}
		
		return monRetourSt;
			
	}

}
