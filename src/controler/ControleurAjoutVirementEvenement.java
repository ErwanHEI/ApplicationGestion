package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AjoutVirementEvenement;
import view.Fenetre;
import view.PanelEvenement;

public class ControleurAjoutVirementEvenement implements ActionListener{

	private PanelEvenement pan;
	private Fenetre fen;
	
	public ControleurAjoutVirementEvenement(PanelEvenement pan){
		this.pan = pan;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AjoutVirementEvenement fenAjoutVirementEvenement = new AjoutVirementEvenement();
		fenAjoutVirementEvenement.getBoutonValider().addActionListener(new ControleurVirementEvenement(pan,fen, fenAjoutVirementEvenement));
	}
	
}
