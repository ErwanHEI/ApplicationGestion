package controleurTable;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import entitie.Stockage;
import manager.StockageManager;
import modelTableau.ModeleTableauLieuStockage;
import view.PanelProduit;


public class ControleurModifierCapacite extends AbstractAction{
	
	private PanelProduit panelProduit;
	private JTable tableau;
	private ModeleTableauLieuStockage modeleListeStockage;
	private StockageManager stockageManager = new StockageManager();
    private List<Stockage> listeStockage = new ArrayList<Stockage>();
	
	public ControleurModifierCapacite(PanelProduit panelProduit){
		super();
		this.panelProduit = panelProduit;
		this.tableau = panelProduit.getTableauLieuStockage();
		this.modeleListeStockage = panelProduit.getModeleLieuStockage();
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int cellule = 0;
        int test = row.length;
        
        if(test != 0){
        	int newCapacite = Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer la nouvelle capacité libre de stockage :"));
        	
        	if(newCapacite >= 0 && newCapacite <= 100){
		        for(int i = row.length-1; i >= 0; i--){
		        	cellule = (int) tableau.getValueAt(row[i], 4);
		        	stockageManager.majModifierCapacite(newCapacite, cellule);
		        }
		        modeleListeStockage.clear();
		        listeStockage = stockageManager.listerStockage();
		        modeleListeStockage.setListeStockage(listeStockage);
	        }
        	else{
	        	JOptionPane.showMessageDialog(null,
	        			"Veuillez entrer une nouvelle capacité de stockage libre entre 0 et 100",
	        			"Message d'erreur",
	        			JOptionPane.ERROR_MESSAGE);        	
	        }
       }
	}

}
