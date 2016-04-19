package modelCombo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import entitie.Budget;
import entitie.Stockage;
import entitie.User;
import entitie.Virement;
import manager.BudgetManager;
import manager.VirementManager;

public class ComboBoxDynamiqueBudget implements ActionListener{
	
	List<Budget> liste=new ArrayList<Budget>();
	Budget budgetSelect;

	
	public JComboBox ComboBoxDynamiqueBudget(){
		
		liste=BudgetManager.getInstance().listerBudget();
		Vector model = new Vector<>();
		model.add(new Budget(0, "", "", 0, 0, null));
		for(int i=0;i<liste.size();i++){
			model.addElement(liste.get(i));
		}
		JComboBox comboBox=null;
		
		comboBox = new JComboBox( model );
		comboBox.setRenderer(new ItemRenderer());
        comboBox.addActionListener( this );
		return comboBox;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
        budgetSelect = (Budget) comboBox.getSelectedItem();
        System.out.println( budgetSelect.getIdBudget() + " : " + budgetSelect.getNomBudget() );
		
	}
	
	
	class ItemRenderer extends BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

            if (value != null)
            {
                Budget item = (Budget) value;
                setText( item.getNomBudget());
            }

            


            return this;
        }
    }


	public Budget getBudgetSelect() {
		return budgetSelect;
	}


	public void setBudgetSelect(Budget budgetSelect) {
		this.budgetSelect = budgetSelect;
	}
	
	
		
		
	
	
}
