package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Evenement;
import entitie.Produit;
import entitie.Virement;
import manager.VirementManager;

public class ModeleTableauVirementEvenement extends AbstractTableModel{
	
	private VirementManager virementManager = new VirementManager();
    private Evenement evenement;
    private int idE;
    private List<Virement> listeVirementEvenement = new ArrayList<Virement>();

 
    private final String[] entetes = {"Budget associé", "Montant du virement"};
 
    public ModeleTableauVirementEvenement(Evenement evenement) {
        super();
        this.evenement = evenement;
        idE = evenement.getIdEvenement();
        listeVirementEvenement = virementManager.listerParEvent(idE);
        System.out.println("taille "+listeVirementEvenement.size());
        }

    
    public int getRowCount() {
        return listeVirementEvenement.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }   
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listeVirementEvenement.get(rowIndex).getBudgetAssocie().getNomBudget();
            case 1:
                return listeVirementEvenement.get(rowIndex).getMontant();
            default:
                return null;
        }
    }
}
