package modelFiltres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import entitie.Virement;
import manager.VirementManager;
import modelTableau.ModeleTableauJournalBudget;

public class FiltreJournalBudget implements ActionListener {
	private String filtreJournalBudgetSelect;
	private ModeleTableauJournalBudget modeleTableauJournalBudget = new ModeleTableauJournalBudget();
	private VirementManager virementManager = new VirementManager();
    private List<Virement> listeVirement = new ArrayList<Virement>();
    
	public JComboBox FiltreJournalBudget(ModeleTableauJournalBudget modeleTableauJournalBudget){
		this.modeleTableauJournalBudget = modeleTableauJournalBudget;
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Référence : Ordre alphabétique");
		comboBox.addItem("Référence : Ordre alphabétique inverse");
        comboBox.addActionListener(this);
		return comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
		filtreJournalBudgetSelect =  (String) comboBox.getSelectedItem();
		System.out.println(filtreJournalBudgetSelect);
		if(filtreJournalBudgetSelect != ""){
			modeleTableauJournalBudget.clear();
			listeVirement = virementManager.journalVirementFiltre(filtreJournalBudgetSelect);
			modeleTableauJournalBudget.setListeJournalVirement(listeVirement);
		}
	}

}
