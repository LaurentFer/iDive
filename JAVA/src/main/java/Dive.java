import view.View;
import model.*;

import controller.Controller;

public class Dive {

	public static void main(String[] args){
		
		 View 		maVue			= new View();
		 Model  	monModele 		= new Model();
		 Controller monControleur 	= new Controller();

		 monControleur.setModele(monModele);
		 monControleur.setVue(maVue);

		 maVue.setModele(monModele);
		 maVue.setListener(monControleur);

		 monModele.addObserver(maVue);
		 		 
		 maVue.afficher();
		 
	}

}
