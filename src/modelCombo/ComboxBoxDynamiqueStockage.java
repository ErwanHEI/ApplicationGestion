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
import entitie.Produit;
import entitie.Stockage;
import manager.ProduitManager;
import manager.StockageManager;
import modelCombo.ComboBoxDynamiqueBudget.ItemRenderer;

public class ComboxBoxDynamiqueStockage implements ActionListener{
	

	private List<Stockage> liste = new ArrayList<Stockage>();
	private Stockage stockageSelec;
	
	
	public JComboBox ComboxBoxDynamiqueLieuStockage(){
		liste=StockageManager.getInstance().listerStockage();
		Vector model = new Vector<>();
		model.add(new Stockage(0, "", "Sélectionner un lieu de stockage", 0));
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
		stockageSelec = (Stockage) comboBox.getSelectedItem();
        System.out.println( stockageSelec.getIdStockage() + " : " + stockageSelec.getLocalisation() );
		
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
                Stockage item = (Stockage) value;
                setText( item.getNomStockage());
            }

            


            return this;
        }
    }


	public Stockage getBudgetSelect() {
		return stockageSelec;
	}


	public void setBudgetSelect(Stockage stockageSelec) {
		this.stockageSelec = stockageSelec;
	}

}
