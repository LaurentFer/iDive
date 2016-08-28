package view;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;
import model.Model;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;


public class View implements Observer {
	
	private			Model						monModele;
	
	private			JFrame 						FDive;
	private			JComboBox<String>			comboPlongeur;
	
	//Partie JTable
	private 		String 						nomColonne[]	= {"Numero","Observation","Lieu"};;
	private			JTable						maTable			= new JTable();
	private 		DefaultTableModel 			dtm 			= new DefaultTableModel(0,0); // il faut définir un modèle, c'est sur lui que se feront les modifications (ajout/suppression de row)
	private 		JTextField					profMoy;
	private 		JLabel 						lblProfondeurMoyenne;
	private 		JTextField 					durMoy;
	private 		JLabel 						lblDureMoyenne;
	private 		JTextField 					consoMoy;
	private 		JLabel 						lblConsoMoyenne;
	private 		JTextField 					niveau;
	private 		JLabel 						lblNiveauActuel;
	private 		JTextField 					nbPlongee;
	private 		JMenu 						mnAPropos;
	private 		JMenuItem 					mntmInformations;
	private 		JMenuItem 					mntmAjout;
	private 		JMenuItem 					mntmSuppression;
	private 		JMenuItem 					mntmModification;
	
	public View() {
		
		 try { 		
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());		
		 } catch(Exception e) {
			 System.out.println("Erreur : "+e);
		 }
		
		monModele 	= 	null;
		
		//Fenêtr principale
		FDive = new JFrame();
		FDive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FDive.setResizable(false);
		FDive.setForeground(Color.LIGHT_GRAY);
		FDive.getContentPane().setBackground(Color.LIGHT_GRAY);
		FDive.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/view/ico.png")));
		FDive.setTitle("Dive - Carnet numérique de plongée");
		FDive.setBackground(Color.WHITE);
		FDive.setSize(749, 584);
		FDive.getContentPane().setLayout(null);
		
		//ComboBox Choix du plongeur
		comboPlongeur = new JComboBox<String>();
		comboPlongeur.setBounds(203, 66, 437, 20);
		comboPlongeur.setActionCommand("choixplongeur");
		FDive.getContentPane().add(comboPlongeur);
		//Texte / Label pour la combobox
		JLabel lblPlongeur = new JLabel("Plongeur");
		lblPlongeur.setBackground(Color.WHITE);
		lblPlongeur.setFont(lblPlongeur.getFont().deriveFont(lblPlongeur.getFont().getStyle() | Font.BOLD, lblPlongeur.getFont().getSize() + 5f));
		lblPlongeur.setForeground(Color.WHITE);
		lblPlongeur.setBounds(114, 69, 99, 14);
		FDive.getContentPane().add(lblPlongeur);
		
		//Partie du bas : JTable
		dtm.setColumnIdentifiers(nomColonne);
		maTable.setBackground(new Color(255, 255, 204));
		maTable.setRowSelectionAllowed(false);
		maTable.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		maTable.setModel(dtm);					//On lie la JTable à son modele
		maTable.setBounds(10,229, 705, 200);
		
		//On crée un panel pour pouvoir lui lier une barre de défilement
		JPanel topPanel = new JPanel();
		topPanel.setLocation(10, 344);
		topPanel.setSize(725, 200);
		topPanel.setLayout( new BorderLayout() );
			
		//On crée un panneau de défilement
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(maTable);
		//On lie ce panneau de défilement au JPanel
		topPanel.add(scrollPane);;
		
		//Et on lie notre JPanel à la JFrame
		FDive.getContentPane().add( topPanel );
		
		
		//JTextfield Affiche Profondeur Moyenne
		profMoy = new JTextField();
		profMoy.setHorizontalAlignment(SwingConstants.CENTER);
		profMoy.setEditable(false);
		profMoy.setBounds(180, 150, 86, 20);
		FDive.getContentPane().add(profMoy);
		profMoy.setColumns(10);	
		lblProfondeurMoyenne = new JLabel("Profondeur moyenne");
		lblProfondeurMoyenne.setForeground(Color.WHITE);
		lblProfondeurMoyenne.setFont(lblProfondeurMoyenne.getFont().deriveFont(lblProfondeurMoyenne.getFont().getStyle() | Font.BOLD, lblProfondeurMoyenne.getFont().getSize() + 3f));
		lblProfondeurMoyenne.setBounds(20, 153, 150, 14);
		FDive.getContentPane().add(lblProfondeurMoyenne);
		
		
		//JTextfield Affiche Durée Moyenne
		durMoy = new JTextField();
		durMoy.setHorizontalAlignment(SwingConstants.CENTER);
		durMoy.setEditable(false);
		durMoy.setBounds(407, 150, 86, 20);
		FDive.getContentPane().add(durMoy);
		durMoy.setColumns(10);	
		lblDureMoyenne = new JLabel("Durée moyenne");
		lblDureMoyenne.setForeground(Color.WHITE);
		lblDureMoyenne.setFont(lblDureMoyenne.getFont().deriveFont(lblDureMoyenne.getFont().getStyle() | Font.BOLD, lblDureMoyenne.getFont().getSize() + 3f));
		lblDureMoyenne.setBounds(276, 153, 121, 14);
		FDive.getContentPane().add(lblDureMoyenne);
		
		//JTextfield Affiche Consommation Moyenne		
		consoMoy = new JTextField();
		consoMoy.setHorizontalAlignment(SwingConstants.CENTER);
		consoMoy.setEditable(false);
		consoMoy.setBounds(620, 150, 86, 20);
		FDive.getContentPane().add(consoMoy);
		consoMoy.setColumns(10);
		lblConsoMoyenne = new JLabel("Conso moyenne");
		lblConsoMoyenne.setForeground(Color.WHITE);
		lblConsoMoyenne.setFont(lblConsoMoyenne.getFont().deriveFont(lblConsoMoyenne.getFont().getStyle() | Font.BOLD, lblConsoMoyenne.getFont().getSize() + 3f));
		lblConsoMoyenne.setBounds(503, 153, 133, 14);
		FDive.getContentPane().add(lblConsoMoyenne);	
		
		//JTextfield Affiche Niveau
		niveau = new JTextField();
		niveau.setHorizontalAlignment(SwingConstants.CENTER);
		niveau.setEditable(false);
		niveau.setBounds(141, 109, 125, 20);
		FDive.getContentPane().add(niveau);
		niveau.setColumns(10);
		lblNiveauActuel = new JLabel("Niveau actuel");
		lblNiveauActuel.setForeground(Color.WHITE);
		lblNiveauActuel.setFont(lblNiveauActuel.getFont().deriveFont(lblNiveauActuel.getFont().getStyle() | Font.BOLD, lblNiveauActuel.getFont().getSize() + 3f));
		lblNiveauActuel.setBounds(37, 112, 118, 14);
		FDive.getContentPane().add(lblNiveauActuel);
		
		//JTextField Affiche Nombre de plongée
		nbPlongee = new JTextField();
		nbPlongee.setHorizontalAlignment(SwingConstants.CENTER);
		nbPlongee.setEditable(false);
		nbPlongee.setBounds(441, 109, 52, 20);
		FDive.getContentPane().add(nbPlongee);
		nbPlongee.setColumns(10);
		JLabel lblNombreDePlonges = new JLabel("Nombre de plongées");
		lblNombreDePlonges.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDePlonges.setForeground(Color.WHITE);
		lblNombreDePlonges.setBounds(288, 112, 143, 14);
		FDive.getContentPane().add(lblNombreDePlonges);		
		
		//Barre de Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 743, 21);
		FDive.getContentPane().add(menuBar);
		
		JMenu mnPlonges = new JMenu("Plongées");
		menuBar.add(mnPlonges);
		
		mntmAjout = new JMenuItem("Ajout");
		mntmAjout.setActionCommand("ajout");
		mnPlonges.add(mntmAjout);
		
		mntmSuppression = new JMenuItem("Suppression");
		mnPlonges.add(mntmSuppression);
		
		mntmModification = new JMenuItem("Modification");
		mnPlonges.add(mntmModification);
		
		mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		
		mntmInformations = new JMenuItem("Informations");
		mntmInformations.setActionCommand("informations");
		mnAPropos.add(mntmInformations);
		
		
		//Ajout de l'image
		JLabel Image = new JLabel("");
		Image.setBounds(0, 0, 743, 555);
		Image.setIcon(new ImageIcon(View.class.getResource("/view/Diving-Courses.jpg")));
		FDive.getContentPane().add(Image);
		
		
		FDive.setVisible (true);
		
	}
	
	public void setLabel(String pProfMoy){
		profMoy.setText(monModele.getProfMoy());
	}
	
	//Procédure appellé lors de la mise a jour, elle a pour but de remplir la combobox avec l'arraylist renvoyé par la requête du modele
	public void setListePlongeur(ArrayList<String> pList){
		for (int i=0; i<pList.size();i++){
			comboPlongeur.addItem(pList.get(i));
		}
		
	}
	
	//Retour de l'item selectionné dans la combobox du choix de plongeur (pour dire au controlleur ce qu'il devra transmettre au modele)
	public String getPlongeur(){
		return comboPlongeur.getSelectedItem().toString().toLowerCase();
	}
	
	//procédure d'affichage de la fenêtre
	public void afficher() {
		FDive.setVisible(true);
	}
	
	public void setListener(EventListener al) { 	
		FDive.addWindowListener((WindowListener)al);
		comboPlongeur.addActionListener((ActionListener)al);
		mntmInformations.addActionListener((ActionListener)al);
		mntmAjout.addActionListener((ActionListener)al);
	}
	
	public void setModele(Model pModele) { 
		monModele = pModele;
		miseAJour();
	}
	
	public void miseAJour() { 
		
		if(monModele != null) {
			//Alimentation de la combobox
			setListePlongeur(monModele.getListePlongeur());
			
			//Alimentation de la zone de texte Profondeur Moyenne
			profMoy.setText(monModele.getProfMoy());
			//Alimentation de la zone de texte Durée Moyenne
			durMoy.setText(monModele.getDurMoy());
			//Alimentation de la zone de texte Conso Moyenne
			consoMoy.setText(monModele.getConsoMoy());
			//Alimentation de la zone de texte niveau
			niveau.setText(monModele.getNiveau());
			//Alimentation de la zone de texte nombre de plongée
			nbPlongee.setText(monModele.getNbPlongee());
			
			//Mise a jour de la jtable par rajout sur le datatablemodel
			//TODO : Virer le Try Catch suspect
			try{
					//On part de la dernière ligne de la JTable et on les supprime une à une en remontant
					//Suppression en passant par le data table model
					for (int i= dtm.getRowCount()-1;i>=0;i--){
						dtm.removeRow(i);
					}
					//On part de la 1ère valeur de la arraylist renvoyé par le modèle
					//et on ajoute les lignes ....
					for (int i=0;i<monModele.getListePlongee().size();i+=4)
						dtm.addRow(new Object[] {	monModele.getListePlongee().get(i),
													monModele.getListePlongee().get(i+1),
													monModele.getListePlongee().get(i+2)});


				
			}catch (Exception e){
				System.out.println("Oui mais non");
			}
			

		}
	}
	
	
	public void update(Observable o, Object arg){
		 miseAJour();
	}
}