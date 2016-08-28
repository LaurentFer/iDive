package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe d'utilitaires dédiée à la gestion de connection SQL
 * 
 * @author Laurent FERRER
 * @version 1.0
 *
 */
public class ConnectDB {
	
	private static Connection myConnect = null;
	
	
	/**
	 * Classe créant une connection vers un serveur SQL Oracle.
	 * 
	 * @param ip Adresse IP du serveur SQL
	 * @param instance Instance sur laquelle se connecter
	 * @param user identifiant de l'utilisateur SQL
	 * @param password mot de passe de l'utilisateur SQL
	 * @return Connection
	 */
	public static Connection CreateConnectOracle(String ip, String instance, String user,String password){
		
		String mesParam = "jdbc:oracle:thin:@//"+ip+":1521/"+instance;
		//System.out.println(mesParam);
		try {		
			//Chargement de la classe du Driver désiré
			Class.forName ("oracle.jdbc.OracleDriver");
			System.out.println("Driver chargé");
					
			try {
				//Préparation de la connection
				myConnect = DriverManager.getConnection(mesParam,user,password);
				System.out.println("Connexion effectuée");
				
				//Désactivation de l'autocommit
				myConnect.setAutoCommit(false);
				
			} catch (SQLException e) {
				System.out.println("Echec de la connexion");
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur lors du chargement du driver.");
			e.printStackTrace();
		}
		
		return myConnect;
	}
	
	/**
	 * Classe destiner à fermer une connexion SQL.
	 * @param pConnect Nom de la connexion à fermer
	 */
	public static void Disconnect(Connection pConnect){
		myConnect = pConnect;
		
		try {
			myConnect.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la fermeture de la connection.");
			e.printStackTrace();
		}
	}

}

