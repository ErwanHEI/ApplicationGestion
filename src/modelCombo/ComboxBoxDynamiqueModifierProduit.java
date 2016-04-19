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
import entitie.ModificationProduit;
import entitie.Produit;
import manager.ProduitManager;
import modelCombo.ComboBoxDynamiqueBudget.ItemRenderer;

public class ComboxBoxDynamiqueModifierProduit implements ActionListener{
	
	private List<Produit> liste = new ArrayList<Produit>();
	private Produit pdtSelec;
	
	public JComboBox ComboxBoxDynamiqueModifierProduit(){
		liste=ProduitManager.getInstance().listerProduits();
		Vector model = new Vector<>();
		model.add(new Produit(0, "", "", 0, 0, null, null, null));
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
        pdtSelec = (Produit) comboBox.getSelectedItem();
        System.out.println( pdtSelec.getIdProduit() + " : " + pdtSelec.getNomProduit() );
		
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
                Produit item = (Produit) value;
                setText( item.getNomProduit());
            }

            


            return this;
        }
    }


	public Produit getPdtSelec() {
		return pdtSelec;
	}


	public void setPdtSelec(Produit pdtSelec) {
		this.pdtSelec = pdtSelec;
	}
}
