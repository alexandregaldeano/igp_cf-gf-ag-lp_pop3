package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.FenetrePrincipale;
import base.Client;
import base.ClientObservable;
import base.ClientThrowable;
//dans cette classe le controleur va contenir le modele et la vue
//afin d'avoir un acces a ces 2 classe en direct
//ainsi qu'un simulateur qui va nous permettre d'avoir le temps d'execution ainsi que les fontions pause et play
public class Controleur {
	ClientThrowable client;
	ClientObservable clientObs;
	FenetrePrincipale fp;	
	//-------------
	//constructeur
	//-------------
	public Controleur()
	{
		client=new ClientThrowable();
		clientObs = new ClientObservable(client);
		fp = new FenetrePrincipale(clientObs);
		clientObs.addObserver(fp);
		client.start();
		//evenement pour l'evenement du bouton connexion
		fp.getConnexion().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String username=fp.getIdentifiant().getText();
				String password=fp.getMotDePasse().getText();
				String nomServeur=fp.getNomServeur().getText();
				if(fp.connexionServeur(nomServeur))
				{
					if(fp.connexionClient(username,password))
					{
						clientObs.notifierObserver();
					}
				}
			}
		});
		//evenement pour l'evenement du bouton activer
//		fp.getActiver().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				sim.play();
//			}
//		});
//		//evenement pour l'evenement du bouton desactiver
//		fp.getDesactiver().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				sim.pause();
//			}
//		});
//		//evenement pour l'evenement du bouton initialiser qui appel la methode du modele initialiser et demande au nombre de cellule d'afficher le bon nombre 
//		fp.getInitialiser().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				modele.initialiser();
//				fp.update_nombre();
//				sim.pause();
//			}
//		});
//		//evenement pour l'evenement du bouton canon qui appel la methode du modele canon
//		fp.getCanon().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				modele.canon();
//				fp.update_nombre();
//				sim.pause();
//			}
//		});
//		//evenement pour l'evenement du bouton vider qui appel la methode du modele vider qui reinitialise la table de hash avec des cellules mortes
//		fp.getVider().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				modele.vider();
//				fp.update_nombre();
//				sim.pause();
//			}
//		});
//		//evenement pour l'evenement de la liste deroulante qui va modifier le temps en exec de la boucle
//		fp.getListSpeed().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				String valeur=fp.getListSpeed().getSelectedItem().toString();
//				sim.setTempsPause(Integer.parseInt(valeur));
//				sim.pause();
//			}
//		});
//		//evenement pour l'evenement du bouton rechercher qui appel la methode de la fenetre rechercher
//		fp.getRechercher().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent evt){
//				fp.rechercher();
//				sim.pause();
//			}
//		});
	}
	//programme principale qui instancie juste le controleur qui va generer tout le reste
	public static void main(String[] args){
		new Controleur();
	}
}
