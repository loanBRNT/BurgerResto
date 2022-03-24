package vueGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlVisualiserCommandeJour;
import modele.BDCommande;
import modele.Commande;
import modele.ProfilUtilisateur;
import modele.PropertyName;
import vueconsole.Fichier;

public class PanVisualiserCommandeJour extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;

	// controleurs du cas
	private ControlVisualiserCommandeJour controlVisualiserCommandeJour;

	// les attributs metiers
	private static Map<String, String> mapCommandeJour = new HashMap<>();

	// Les elements graphiques :
	// polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

	// Mise en page : les Box
	private Box boxMiseEnpage = Box.createVerticalBox();
	private Box boxCommandeJour = Box.createVerticalBox();
	private Box boxCommandes = Box.createVerticalBox();

	private FrameCuisinier frame;

	public PanVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
		this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
	}

	// Methode d'initialisation du panel
	public void initialisation(FrameCuisinier frame) {
		this.frame = frame;
		// mise en forme du panel (couleur, ...)
		this.setBackground(Color.WHITE);
		// creation des differents elements graphiques (JLabel, Combobox,
		// Button, TextAera ...)

		JLabel titre = new JLabel("Commande du Jour");
		titre.setFont(policeTitre);

		// mise en page : placements des differents elements graphiques dans des
		// Box
		this.boxCommandeJour.add(titre);
		this.boxCommandeJour.add(Box.createRigidArea(new Dimension(0, 15)));
		this.boxCommandeJour.add(boxCommandes);
		// mise en page : placements des differentes box dans une box principale
		this.boxMiseEnpage.add(boxCommandeJour);
		// mise en page : ajout de la box principale dans le panel
		this.add(boxMiseEnpage);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		String propertyName = arg0.getPropertyName();
		PropertyName choix = PropertyName.valueOf(propertyName);

		switch (choix){
			case ENREGISTRER_COMMANDE -> {
				Commande commande = (Commande) arg0.getNewValue();
				String texteCommandeJour = ("Commande n" + commande.getNumeroCommandeAttribuee() + " : " + commande.getHamburger().getNom() + ", "
						+ commande.getAccompagnement().getNom() + ", " + commande.getBoisson().getNom() + ".");
				System.out.println(texteCommandeJour);
				JLabel label = new JLabel(texteCommandeJour);
				label.setFont(policeParagraphe);
				PanVisualiserCommandeJour.mapCommandeJour.put("" + commande.getNumeroCommandeAttribuee(), texteCommandeJour);
				boxCommandes.add(label);
				actualiserPanel();
			}
			case VIDER_COMMANDE_JOUR -> {
				PanVisualiserCommandeJour.mapCommandeJour.clear();
				boxCommandes.removeAll();
				actualiserPanel();
			}
			default -> {
				System.out.println("ERREUR");
			}
		}
	}

	private void actualiserPanel() {
		frame.setVisible(true);
		frame.repaint();
	}

	private void initialiserPanel() {
		boxCommandes.removeAll();
		for (int i = 0; i < mapCommandeJour.size(); i++) {
			String numeroCommande = String.valueOf(i + 1);
			String texte = mapCommandeJour.get(numeroCommande);
			JLabel label = new JLabel(texte);
			label.setFont(policeParagraphe);
			boxCommandes.add(label);
		}
		actualiserPanel();
	}

	public void visualiserCommandeJour(int numCuisinier) {
		initialiserPanel();
		if (controlVisualiserCommandeJour.verifierIdentification(numCuisinier, ProfilUtilisateur.PERSONNEL)){
			this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
			controlVisualiserCommandeJour.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(), this);
		}
	}

}
