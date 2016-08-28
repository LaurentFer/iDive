package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import model.ModelGesPl;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GestionPlongee implements Observer {
	
	private		ModelGesPl		monModele;
	
	private		JFrame 			gesPlon;
	private 	JTextField 		plongeur;
	private 	JTextField 		phs;
	private 	JTextField 		ppro;
	private 	JTextField 		pdur;
	private 	JTextField 		pobs;
	private 	JTextField 		pnum;
	private 	JTextField 		pal1p;
	private 	JTextField 		pal1t;
	private 	JTextField 		pal1o;
	private 	JTextField 		pal2p;
	private 	JTextField 		pal2t;
	private 	JTextField 		pal2o;
	private 	JTextField 		pal3p;
	private 	JTextField 		pal3t;
	private 	JTextField 		pal3o;
	private 	JComboBox 		ples;
	private 	JLabel 			lblLestage;
	private 	JComboBox 		ppd;
	private 	JLabel 			lblPressionDpart;
	private 	JTextField 		ppa;
	private 	JLabel 			lblPressionArrive;
	private 	JTextField 		pcb;
	private 	JLabel 			lblCapacitDuBloc;
	private 	JComboBox 		pnot;
	private 	JLabel 			lblNote;
	private 	JComboBox 		pvisi;
	private 	JLabel 			lblVisibilit;
	private 	JComboBox 		pdif;
	private 	JLabel 			lblDifficult;
	private 	JTextField 		ptes;
	private 	JLabel 			lblTempratureSurface;
	private 	JTextField 		ptep;
	private 	JLabel 			lblTempratureProfond;
	private 	JComboBox 		dnom;
	private 	JLabel 			lblDco;
	private 	JComboBox 		idsite;
	private 	JLabel 			lblNomDuSite;
	private 	JComboBox 		idcentre;
	private 	JLabel 			lblCentreOrganisateur;
	private 	JTextField 		acco1;
	private 	JTextField 		acco2;
	private 	JTextField 		acco3;
	private 	JCheckBox 		chckbxExploration;
	private 	JCheckBox 		chckbxEnseignement;
	private 	JCheckBox 		chckbxPlongeDeNuit;
	private 	JCheckBox 		chckbxEpave;
	private 	JCheckBox 		chckbxNitrox;
	private 	JCheckBox 		chckbxTrimix;
	private 	JComboBox 		rnom;
	private 	JComboBox 		acco1role;
	private  	JComboBox 		acco2role;
	private 	JComboBox 		acco3role;
	private 	JButton 		valider;
	private 	JButton 		annuler;
	
	public GestionPlongee(){
	
		 try { 		
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());		
		 } catch(Exception e) {
			 System.out.println("Erreur : "+e);
		 }
		 
		 gesPlon		=	new JFrame();
		 gesPlon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 gesPlon.setSize(680, 655);
		 gesPlon.getContentPane().setBackground(new Color(51, 153, 204));
		 gesPlon.setResizable(false);
		 gesPlon.setTitle("Gestion Plongée");
		 gesPlon.getContentPane().setLayout(null);
		 
		 plongeur = new JTextField();
		 plongeur.setEditable(false);
		 plongeur.setBounds(222, 22, 340, 20);
		 gesPlon.getContentPane().add(plongeur);
		 plongeur.setColumns(10);
		 
		 JLabel lblPlongeur = new JLabel("Plongeur");
		 lblPlongeur.setBounds(119, 25, 79, 14);
		 gesPlon.getContentPane().add(lblPlongeur);
		 
		 phs = new JTextField();
		 phs.setBounds(131, 96, 86, 20);
		 gesPlon.getContentPane().add(phs);
		 phs.setColumns(10);
		 
		 JLabel lblHeureDeSortie = new JLabel("Heure de sortie");
		 lblHeureDeSortie.setBounds(15, 99, 106, 14);
		 gesPlon.getContentPane().add(lblHeureDeSortie);
		 
		 ppro = new JTextField();
		 ppro.setBackground(new Color(255, 255, 204));
		 ppro.setBounds(131, 127, 86, 20);
		 gesPlon.getContentPane().add(ppro);
		 ppro.setColumns(10);
		 
		 JLabel lblProfondeur = new JLabel("Profondeur");
		 lblProfondeur.setBounds(15, 130, 79, 17);
		 gesPlon.getContentPane().add(lblProfondeur);
		 
		 pdur = new JTextField();
		 pdur.setBackground(new Color(255, 255, 204));
		 pdur.setBounds(131, 158, 86, 20);
		 gesPlon.getContentPane().add(pdur);
		 pdur.setColumns(10);
		 
		 JLabel lblDure = new JLabel("Durée");
		 lblDure.setBounds(15, 161, 79, 14);
		 gesPlon.getContentPane().add(lblDure);
		 
		 pobs = new JTextField();
		 pobs.setBounds(349, 158, 244, 20);
		 gesPlon.getContentPane().add(pobs);
		 pobs.setColumns(10);
		 
		 JLabel lblObservation = new JLabel("Observations");
		 lblObservation.setBounds(233, 161, 112, 14);
		 gesPlon.getContentPane().add(lblObservation);
		 
		 pnum = new JTextField();
		 pnum.setEditable(false);
		 pnum.setBounds(131, 65, 86, 20);
		 gesPlon.getContentPane().add(pnum);
		 pnum.setColumns(10);
		 
		 JLabel lblNumro = new JLabel("Numéro");
		 lblNumro.setBounds(15, 68, 57, 14);
		 gesPlon.getContentPane().add(lblNumro);
		 
		 pal1p = new JTextField();
		 pal1p.setBounds(131, 203, 86, 20);
		 gesPlon.getContentPane().add(pal1p);
		 pal1p.setColumns(10);
		 
		 JLabel lblProfondeurPalier = new JLabel("Profondeur Palier 1");
		 lblProfondeurPalier.setBounds(15, 206, 106, 14);
		 gesPlon.getContentPane().add(lblProfondeurPalier);
		 
		 pal1t = new JTextField();
		 pal1t.setBounds(131, 234, 86, 20);
		 gesPlon.getContentPane().add(pal1t);
		 pal1t.setColumns(10);
		 
		 JLabel lblDurePalier = new JLabel("Durée Palier 1");
		 lblDurePalier.setBounds(15, 237, 106, 14);
		 gesPlon.getContentPane().add(lblDurePalier);
		 
		 pal1o = new JTextField();
		 pal1o.setBounds(130, 265, 86, 20);
		 gesPlon.getContentPane().add(pal1o);
		 pal1o.setColumns(10);
		 
		 JLabel lblOPalier = new JLabel("% O2 Palier 1");
		 lblOPalier.setBounds(15, 268, 106, 14);
		 gesPlon.getContentPane().add(lblOPalier);
		 
		 JLabel lblProfondeurPalier_1 = new JLabel("Profondeur Palier 2");
		 lblProfondeurPalier_1.setBounds(233, 206, 106, 14);
		 gesPlon.getContentPane().add(lblProfondeurPalier_1);
		 
		 JLabel lblDurePalier_1 = new JLabel("Durée Palier 2");
		 lblDurePalier_1.setBounds(233, 237, 106, 14);
		 gesPlon.getContentPane().add(lblDurePalier_1);
		 
		 JLabel lblOPalier_1 = new JLabel("% O2 Palier 2");
		 lblOPalier_1.setBounds(233, 268, 106, 14);
		 gesPlon.getContentPane().add(lblOPalier_1);
		 
		 pal2p = new JTextField();
		 pal2p.setBounds(349, 203, 86, 20);
		 gesPlon.getContentPane().add(pal2p);
		 pal2p.setColumns(10);
		 
		 pal2t = new JTextField();
		 pal2t.setBounds(349, 234, 86, 20);
		 gesPlon.getContentPane().add(pal2t);
		 pal2t.setColumns(10);
		 
		 pal2o = new JTextField();
		 pal2o.setBounds(349, 265, 86, 20);
		 gesPlon.getContentPane().add(pal2o);
		 pal2o.setColumns(10);
		 
		 JLabel lblProfondeurPalier_2 = new JLabel("Profondeur Palier 3");
		 lblProfondeurPalier_2.setBounds(456, 206, 106, 14);
		 gesPlon.getContentPane().add(lblProfondeurPalier_2);
		 
		 JLabel lblDurePalier_2 = new JLabel("Durée Palier 3");
		 lblDurePalier_2.setBounds(456, 237, 106, 14);
		 gesPlon.getContentPane().add(lblDurePalier_2);
		 
		 JLabel lblOPalier_2 = new JLabel("% O2 Palier 3");
		 lblOPalier_2.setBounds(456, 268, 106, 14);
		 gesPlon.getContentPane().add(lblOPalier_2);
		 
		 pal3p = new JTextField();
		 pal3p.setBounds(572, 203, 86, 20);
		 gesPlon.getContentPane().add(pal3p);
		 pal3p.setColumns(10);
		 
		 pal3t = new JTextField();
		 pal3t.setBounds(572, 234, 86, 20);
		 gesPlon.getContentPane().add(pal3t);
		 pal3t.setColumns(10);
		 
		 pal3o = new JTextField();
		 pal3o.setBounds(572, 265, 86, 20);
		 gesPlon.getContentPane().add(pal3o);
		 pal3o.setColumns(10);
		 
		 ples = new JComboBox();
		 ples.setBounds(131, 310, 86, 20);
		 gesPlon.getContentPane().add(ples);
		 
		 lblLestage = new JLabel("Lestage");
		 lblLestage.setBounds(15, 313, 106, 14);
		 gesPlon.getContentPane().add(lblLestage);
		 
		 ppd = new JComboBox();
		 ppd.setBounds(131, 341, 86, 20);
		 gesPlon.getContentPane().add(ppd);
		 
		 lblPressionDpart = new JLabel("Pression Départ");
		 lblPressionDpart.setBounds(15, 344, 109, 14);
		 gesPlon.getContentPane().add(lblPressionDpart);
		 
		 ppa = new JTextField();
		 ppa.setBounds(349, 341, 86, 20);
		 gesPlon.getContentPane().add(ppa);
		 ppa.setColumns(10);
		 
		 lblPressionArrive = new JLabel("Pression Arrivée");
		 lblPressionArrive.setBounds(233, 344, 106, 14);
		 gesPlon.getContentPane().add(lblPressionArrive);
		 
		 pcb = new JTextField();
		 pcb.setBounds(572, 341, 86, 20);
		 gesPlon.getContentPane().add(pcb);
		 pcb.setColumns(10);
		 
		 lblCapacitDuBloc = new JLabel("Capacité du bloc");
		 lblCapacitDuBloc.setBounds(456, 344, 106, 14);
		 gesPlon.getContentPane().add(lblCapacitDuBloc);
		 
		 pnot = new JComboBox();
		 pnot.setBounds(131, 384, 86, 20);
		 gesPlon.getContentPane().add(pnot);
		 
		 lblNote = new JLabel("Note");
		 lblNote.setBounds(15, 387, 46, 14);
		 gesPlon.getContentPane().add(lblNote);
		 
		 pvisi = new JComboBox();
		 pvisi.setBounds(349, 384, 86, 20);
		 gesPlon.getContentPane().add(pvisi);
		 
		 lblVisibilit = new JLabel("Visibilité");
		 lblVisibilit.setBounds(233, 387, 56, 14);
		 gesPlon.getContentPane().add(lblVisibilit);
		 
		 pdif = new JComboBox();
		 pdif.setBounds(572, 384, 86, 20);
		 gesPlon.getContentPane().add(pdif);
		 
		 lblDifficult = new JLabel("Difficulté");
		 lblDifficult.setBounds(456, 387, 106, 14);
		 gesPlon.getContentPane().add(lblDifficult);
		 
		 ptes = new JTextField();
		 ptes.setBounds(131, 415, 86, 20);
		 gesPlon.getContentPane().add(ptes);
		 ptes.setColumns(10);
		 
		 lblTempratureSurface = new JLabel("Température Surface");
		 lblTempratureSurface.setBounds(15, 418, 106, 14);
		 gesPlon.getContentPane().add(lblTempratureSurface);
		 
		 ptep = new JTextField();
		 ptep.setBounds(349, 415, 86, 20);
		 gesPlon.getContentPane().add(ptep);
		 ptep.setColumns(10);
		 
		 lblTempratureProfond = new JLabel("Température Profond");
		 lblTempratureProfond.setBounds(233, 418, 106, 14);
		 gesPlon.getContentPane().add(lblTempratureProfond);
		 
		 dnom = new JComboBox();
		 dnom.setBounds(503, 415, 155, 20);
		 gesPlon.getContentPane().add(dnom);
		 
		 lblDco = new JLabel("Déco");
		 lblDco.setBounds(456, 418, 46, 14);
		 gesPlon.getContentPane().add(lblDco);
		 
		 idsite = new JComboBox();
		 idsite.setEditable(true);
		 idsite.setBounds(349, 127, 244, 20);
		 gesPlon.getContentPane().add(idsite);
		 
		 lblNomDuSite = new JLabel("Nom du Site");
		 lblNomDuSite.setBounds(233, 130, 100, 14);
		 gesPlon.getContentPane().add(lblNomDuSite);
		 
		 idcentre = new JComboBox();
		 idcentre.setEditable(true);
		 idcentre.setBounds(349, 96, 244, 20);
		 gesPlon.getContentPane().add(idcentre);
		 
		 lblCentreOrganisateur = new JLabel("Centre organisateur");
		 lblCentreOrganisateur.setBounds(232, 99, 113, 14);
		 gesPlon.getContentPane().add(lblCentreOrganisateur);
		 
		 chckbxExploration = new JCheckBox("Exploration");
		 chckbxExploration.setBackground(new Color(51, 153, 204));
		 chckbxExploration.setBounds(131, 464, 97, 23);
		 gesPlon.getContentPane().add(chckbxExploration);
		 
		 chckbxEnseignement = new JCheckBox("Enseignement");
		 chckbxEnseignement.setBackground(new Color(51, 153, 204));
		 chckbxEnseignement.setBounds(131, 490, 97, 23);
		 gesPlon.getContentPane().add(chckbxEnseignement);
		 
		 chckbxPlongeDeNuit = new JCheckBox("Plongée de nuit");
		 chckbxPlongeDeNuit.setBackground(new Color(51, 153, 204));
		 chckbxPlongeDeNuit.setBounds(131, 516, 113, 23);
		 gesPlon.getContentPane().add(chckbxPlongeDeNuit);
		 
		 JLabel lblType = new JLabel("Type");
		 lblType.setBounds(15, 468, 46, 14);
		 gesPlon.getContentPane().add(lblType);
		 
		 chckbxEpave = new JCheckBox("Epave");
		 chckbxEpave.setBackground(new Color(51, 153, 204));
		 chckbxEpave.setBounds(246, 464, 97, 23);
		 gesPlon.getContentPane().add(chckbxEpave);
		 
		 chckbxNitrox = new JCheckBox("Nitrox");
		 chckbxNitrox.setBackground(new Color(51, 153, 204));
		 chckbxNitrox.setBounds(246, 490, 97, 23);
		 gesPlon.getContentPane().add(chckbxNitrox);
		 
		 chckbxTrimix = new JCheckBox("Trimix");
		 chckbxTrimix.setBackground(new Color(51, 153, 204));
		 chckbxTrimix.setBounds(246, 516, 97, 23);
		 gesPlon.getContentPane().add(chckbxTrimix);
		 
		 rnom = new JComboBox();
		 rnom.setBounds(349, 65, 244, 20);
		 gesPlon.getContentPane().add(rnom);
		 
		 JLabel lblRle = new JLabel("Rôle");
		 lblRle.setBounds(233, 68, 46, 14);
		 gesPlon.getContentPane().add(lblRle);
		 
		 acco1 = new JTextField();
		 acco1.setBounds(456, 446, 202, 20);
		 gesPlon.getContentPane().add(acco1);
		 acco1.setColumns(10);
		 
		 JLabel lblAccompagnant = new JLabel("Accompagnant(s)");
		 lblAccompagnant.setBounds(349, 449, 97, 14);
		 gesPlon.getContentPane().add(lblAccompagnant);
		 
		 acco1role = new JComboBox();
		 acco1role.setBounds(456, 472, 202, 20);
		 gesPlon.getContentPane().add(acco1role);
		 
		 acco2 = new JTextField();
		 acco2.setBounds(456, 498, 202, 20);
		 gesPlon.getContentPane().add(acco2);
		 acco2.setColumns(10);
		 
		 acco2role = new JComboBox();
		 acco2role.setBounds(456, 524, 202, 20);
		 gesPlon.getContentPane().add(acco2role);
		 
		 valider = new JButton("Valider");
		 valider.setBounds(62, 560, 155, 50);
		 gesPlon.getContentPane().add(valider);
		 
		 annuler = new JButton("Annuler");
		 annuler.setActionCommand("annuler");
		 annuler.setBounds(250, 560, 155, 50);
		 gesPlon.getContentPane().add(annuler);
		 
		 acco3 = new JTextField();
		 acco3.setBounds(456, 550, 202, 20);
		 gesPlon.getContentPane().add(acco3);
		 acco3.setColumns(10);
		 
		 acco3role = new JComboBox();
		 acco3role.setBounds(456, 575, 202, 20);
		 gesPlon.getContentPane().add(acco3role);
		 
	}
	
	
	
	//Procédure appellé lors de la mise a jour, elle a pour but de remplir la combobox avec l'arraylist renvoyé par la requête du modele
	public void setListeRole(ArrayList<String> pList){
		for (int i=0; i<pList.size();i++){
			rnom.addItem(pList.get(i));
			acco1role.addItem(pList.get(i));
			acco2role.addItem(pList.get(i));
			acco3role.addItem(pList.get(i));
		}
	}
	
	//idem combobox type de calcul décompression
	public void setListeDnom(ArrayList<String> pList){
		for (int i=0; i<pList.size();i++){
			dnom.addItem(pList.get(i));
		}
		
	}
	
	//idem combobox nom du centre
	public void setListeIdCentre(ArrayList<String> pList){
		for (int i=0; i<pList.size();i++){
			idcentre.addItem(pList.get(i));
		}
		
	}
	
	//idem combobox nom du site
	public void setListeIdSite(ArrayList<String> pList){
		for (int i=0; i<pList.size();i++){
			idsite.addItem(pList.get(i));
		}
		
	}
	
	//Remplissage combox niveau de difficulté (de 1 a 5)
	public void setListePdif(){
		for (int i=1; i<=5;i++){
			(pdif).addItem(i);
			(pnot).addItem(i); //même amplitude pour les notes donc j'utilise la même méthode
			(pvisi).addItem(i); //idem pour la visibilité
		}
		
	}
	
	//idem combox lestage (de 1 a 15)
	public void setListePles(){
		for (int i=1; i<=15;i++){
			(ples).addItem(i);
		}
		
	}
	
	//idem combox pression de départ (entre 150 et 250 par pas de 10)
	public void setListePpd(){
		for (int i=150; i<=250;i+=10){
			(ppd).addItem(i);
		}
		
	}
	
	public void afficher() {
		gesPlon.setVisible(true);
	}
	
	public void fermer() {
		gesPlon.dispose();
	}
	
	public void setListener(EventListener al) { 
		gesPlon.addWindowListener((WindowListener)al);
		annuler.addActionListener((ActionListener)al);
	}
	
	public void setModele(ModelGesPl pModele) { 
		monModele = pModele;
		miseAJour();
	}

	public void miseAJour() { 
		
		if(monModele != null) {
			setListeRole(monModele.getListeRole());
			setListeDnom(monModele.getDnom());
			setListeIdCentre(monModele.getIdCentre());
			setListeIdSite(monModele.getIdSite());
			setListePdif();
			setListePles();
			setListePpd();
			plongeur.setText(monModele.getPmail());
			pnum.setText(monModele.getPnum());			
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		miseAJour();		
	}
	
}
