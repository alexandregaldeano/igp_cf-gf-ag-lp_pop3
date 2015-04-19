package controleur.smtp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vue.smtp.FenetrePrincipale;
import base.client.impl.SmtpClient;

//dans cette classe le controleur va contenir le modele et la vue
//afin d'avoir un acces a ces 2 classe en direct
//ainsi qu'un simulateur qui va nous permettre d'avoir le temps d'execution ainsi que les fontions pause et play
public class ControleurSmtp {
	private final static String[] hostname = {"localhost", "Laura_PC",
        "PC_COCO", "smtp.orange.fr"};
	SmtpClient smtpClient;
	FenetrePrincipale fp;

	//-------------
	//constructeur
	//-------------
	public ControleurSmtp() {
		smtpClient = new SmtpClient();
		fp = new FenetrePrincipale(smtpClient);
		//evenement pour l'evenement du bouton envoie
		fp.getEnvoie().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fp.ouvertureConnexion(hostname[3], 25);
				fp.sendMail();
//				String port = fp.getPort().getText();
//				if (fp.connexionServeur(nomServeur, port)) {
//					fp.connecterServeur();
//				}
			}
		});
	}

	//programme principale qui instancie juste le controleur qui va generer tout le reste
	public static void main(String[] args) {
		new ControleurSmtp();
	}
}
