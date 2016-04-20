package modelFiltres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import entitie.Budget;
import manager.BudgetManager;
import modelTableau.ModeleTableauListeBudget;


public class FiltreBudget implements ActionListener {
	private String filtreBudgetSelect;
	private ModeleTableauListeBudget modeleTableauListeBudget = new ModeleTableauListeBudget();
	private BudgetManager budgetManager = new BudgetManager();
    private List<Budget> listeBudget = new ArrayList<Budget>();
    
	public JComboBox FiltreBudget(ModeleTableauListeBudget modeleTableauListeBudget){
		this.modeleTableauListeBudget = modeleTableauListeBudget;
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("R�f�rence : Ordre alphab�tique");
		comboBox.addItem("R�f�rence : Ordre alphab�tique inverse");
		comboBox.addItem("Nom : Ordre alphab�tique");
		comboBox.addItem("Nom : Ordre alphab�tique inverse");
		comboBox.addItem("Budget fix� : Ordre croissant");
		comboBox.addItem("Budget fix� : Ordre d�croissant");
        comboBox.addActionListener(this);
		return comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
		filtreBudgetSelect =  (String) comboBox.getSelectedItem();
		System.out.println(filtreBudgetSelect);
		if(filtreBudgetSelect != ""){
			modeleTableauListeBudget.clear();
			listeBudget = budgetManager.listerBudgetFiltre(filtreBudgetSelect);
			modeleTableauListeBudget.setListeBudget(listeBudget);
		}
	}
}
