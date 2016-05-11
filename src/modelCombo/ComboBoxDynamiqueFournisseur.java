package modelCombo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import controler.ControlerAjoutFournisseur;
import entitie.Fournisseur;
import entitie.Stockage;
import manager.FournisseurManager;
import manager.StockageManager;
import modelCombo.ComboxBoxDynamiqueStockage.ItemRenderer;
import view.AjoutFournisseur;

public class ComboBoxDynamiqueFournisseur implements ActionListener{
	
	private JPanel panelProduit = new JPanel();
	private List<Fournisseur> liste = new ArrayList<Fournisseur>();
	private Fournisseur fournisseurSelec;
	private FournisseurManager fournisseurManager = new FournisseurManager();
	private AjoutFournisseur fenAjoutFournisseur;
	
	public JComboBox ComboxBoxDynamiqueFournisseur(){
		liste=FournisseurManager.getInstance().listerFournisseur();
		Vector model = new Vector<>();
		model.add(new Fournisseur(1000000000, "Sélectionner un fournisseur", ""));
		model.add(new Fournisseur(0, "AJOUTER UN NOUVEAU FOURNISSEUR", ""));
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
		fournisseurSelec = (Fournisseur) comboBox.getSelectedItem();
        System.out.println( fournisseurSelec.getIdFournisseur() + " : " + fournisseurSelec.getNomFournisseur());
		
        if(fournisseurSelec.getIdFournisseur()==0){
        	fenAjoutFournisseur = new AjoutFournisseur();
        	fenAjoutFournisseur.getBoutonAjouterNouveauFournisseur().addActionListener(new ControlerAjoutFournisseur(fenAjoutFournisseur));
        }
	}
	
	
	class ItemRenderer extends BasicComboBoxRenderer{
        public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        	
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
            
            if (value != null){
                Fournisseur item = (Fournisseur) value;
                setText( item.getNomFournisseur());
            }
            return this;
        }
    }

	public Fournisseur getFournisseurSelec() {
		return fournisseurSelec;
	}


	public void setFournisseurSelec(Fournisseur fournisseurSelec) {
		this.fournisseurSelec = fournisseurSelec;
	}


}