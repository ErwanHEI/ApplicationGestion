package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelCombo.ComboBoxDynamiqueBudget;
import modelTableau.ModeleTableauEncaissement;
import modelTableau.ModeleTableauJournalBudget;
import modelTableau.ModeleTableauListeBudget;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class PanelBudget extends JPanel{

	private JTextField champReferenceBudget;
	private JTextField champNomBudget;
	private JTextField champBudgetFixe;
	

	JButton boutonCreerBudget ;
	JButton boutonAjoutEncaissement ;
	
	private ComboBoxDynamiqueBudget comboBoxDynamiqueBudget = new ComboBoxDynamiqueBudget();
	
	private ModeleTableauListeBudget modeleListeBudget = new ModeleTableauListeBudget();
	private ModeleTableauEncaissement modeleListeEncaissement = new ModeleTableauEncaissement();
	private ModeleTableauJournalBudget modeleTableauJournalBudget = new ModeleTableauJournalBudget();
	
	private JButton boutonSupprimerBudget;
	private JButton boutonEncaisser;
	private JButton boutonSupprimerEncaissement;
	private JButton boutonSupprimerJournalBudget;
	
	private JTable tableauBudget;
	private JTable tableauEncaissement;
	private JTable tableauJournalBudget;
	private String supp = "Supprimer la ligne";
	private JTextField champReferenceEncaissement;
	private JTextField champEmetteurEncaissement;
	private JTextField champRecepteurEncaissement;
	private JTextField champDateEncaissement;
	private JTextField champMontantEncaissement;
	

	
	JLabel labelErreurCreationBudget;
	JLabel labelErreurAjoutEncaissement ;

	public PanelBudget(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 1002, 665);
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel panelBudget = new JPanel();
		panelBudget.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Budgets", null, panelBudget, null);
		panelBudget.setLayout(null);
		
		JPanel panelFiltres = new JPanel();
		panelFiltres.setBounds(0, 0, 997, 50);
		panelFiltres.setLayout(null);
		panelBudget.add(panelFiltres);
		
		JLabel labelFiltres = new JLabel("Filtres :");
		labelFiltres.setForeground(Color.BLACK);
		labelFiltres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelFiltres.setBounds(147, 15, 67, 24);
		panelFiltres.add(labelFiltres);
		
		JComboBox comboBoxFiltres = new JComboBox();
		comboBoxFiltres.setBounds(233, 16, 400, 26);
		panelFiltres.add(comboBoxFiltres);
		
		JPanel panelListeBudget = new JPanel();
		panelListeBudget.setBounds(0, 66, 997, 527);
		panelBudget.add(panelListeBudget);
		panelListeBudget.setLayout(new BorderLayout(0, 0));
		
	
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES BUDGETS--------------------------------
------------------------------------------------------------------------------------------------*/
		
		tableauBudget = new JTable(modeleListeBudget);
		tableauBudget.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauBudget.getColumnModel().getColumn(5).setMinWidth(0);
		tableauBudget.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		JScrollPane scrollPaneBudget = new JScrollPane(tableauBudget);
		panelListeBudget.add(scrollPaneBudget, BorderLayout.CENTER);
		
		boutonSupprimerBudget = new JButton("Supprimer");
		boutonSupprimerBudget.setBounds(441, 602, 115, 29);
		panelBudget.add(boutonSupprimerBudget);
		
		
		
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/		
		
		
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Gestion", null, panelGestion, null);
		panelGestion.setLayout(null);
		
		JPanel panelCreationBudget = new JPanel();
		panelCreationBudget.setLayout(null);
		panelCreationBudget.setBounds(0, 0, 997, 232);
		panelGestion.add(panelCreationBudget);
		
		JLabel labelCreationBudget = new JLabel("Cr\u00E9ation d'un budget");
		labelCreationBudget.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelCreationBudget.setBounds(15, 16, 280, 37);
		panelCreationBudget.add(labelCreationBudget);
		
		JLabel labelReferenceBudget = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceBudget.setForeground(Color.BLACK);
		labelReferenceBudget.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReferenceBudget.setBounds(37, 69, 102, 24);
		panelCreationBudget.add(labelReferenceBudget);
		
		champReferenceBudget = new JTextField();
		champReferenceBudget.setColumns(10);
		champReferenceBudget.setBounds(154, 70, 180, 26);
		panelCreationBudget.add(champReferenceBudget);
		
		JLabel labelNomBudget = new JLabel("Nom :");
		labelNomBudget.setForeground(Color.BLACK);
		labelNomBudget.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomBudget.setBounds(85, 109, 54, 24);
		panelCreationBudget.add(labelNomBudget);
		
		champNomBudget = new JTextField();
		champNomBudget.setColumns(10);
		champNomBudget.setBounds(154, 110, 180, 26);
		panelCreationBudget.add(champNomBudget);
		
		JLabel labelBudgetFixe = new JLabel("Budget fix\u00E9 :");
		labelBudgetFixe.setForeground(Color.BLACK);
		labelBudgetFixe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelBudgetFixe.setBounds(25, 149, 114, 24);
		panelCreationBudget.add(labelBudgetFixe);
		
		champBudgetFixe = new JTextField();
		champBudgetFixe.setColumns(10);
		champBudgetFixe.setBounds(154, 150, 180, 26);
		panelCreationBudget.add(champBudgetFixe);
		
		boutonCreerBudget = new JButton("Cr\u00E9er");
		boutonCreerBudget.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonCreerBudget.setBounds(200, 192, 170, 30);
		panelCreationBudget.add(boutonCreerBudget);
		
		JLabel labelAjoutEncaissement = new JLabel("Ajout d'un encaissement");
		labelAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelAjoutEncaissement.setBounds(388, 16, 331, 37);
		panelCreationBudget.add(labelAjoutEncaissement);
		
		JLabel labelReferenceEncaissement = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceEncaissement.setForeground(Color.BLACK);
		labelReferenceEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReferenceEncaissement.setBounds(398, 69, 102, 24);
		panelCreationBudget.add(labelReferenceEncaissement);
		
		champReferenceEncaissement = new JTextField();
		champReferenceEncaissement.setColumns(10);
		champReferenceEncaissement.setBounds(505, 70, 180, 26);
		panelCreationBudget.add(champReferenceEncaissement);
		
		JLabel labelEmetteurEncaissement = new JLabel("Emetteur :");
		labelEmetteurEncaissement.setForeground(Color.BLACK);
		labelEmetteurEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEmetteurEncaissement.setBounds(401, 109, 99, 24);
		panelCreationBudget.add(labelEmetteurEncaissement);
		
		champEmetteurEncaissement = new JTextField();
		champEmetteurEncaissement.setColumns(10);
		champEmetteurEncaissement.setBounds(505, 110, 180, 26);
		panelCreationBudget.add(champEmetteurEncaissement);
		
		JLabel labelRecepteurEncaissement = new JLabel("R\u00E9cepteur :");
		labelRecepteurEncaissement.setForeground(Color.BLACK);
		labelRecepteurEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelRecepteurEncaissement.setBounds(393, 149, 103, 24);
		panelCreationBudget.add(labelRecepteurEncaissement);
		
		champRecepteurEncaissement = new JTextField();
		champRecepteurEncaissement.setColumns(10);
		champRecepteurEncaissement.setBounds(505, 150, 180, 26);
		panelCreationBudget.add(champRecepteurEncaissement);
		
		JLabel labelDateEncaissement = new JLabel("Date :");
		labelDateEncaissement.setForeground(Color.BLACK);
		labelDateEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDateEncaissement.setBounds(741, 69, 56, 24);
		panelCreationBudget.add(labelDateEncaissement);
		
		champDateEncaissement = new JTextField();
		champDateEncaissement.setColumns(10);
		champDateEncaissement.setBounds(802, 70, 180, 26);
		panelCreationBudget.add(champDateEncaissement);
		
		JLabel labelMontantEncaissement = new JLabel("Montant :");
		labelMontantEncaissement.setForeground(Color.BLACK);
		labelMontantEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMontantEncaissement.setBounds(711, 109, 86, 24);
		panelCreationBudget.add(labelMontantEncaissement);
		
		champMontantEncaissement = new JTextField();
		champMontantEncaissement.setColumns(10);
		champMontantEncaissement.setBounds(802, 110, 180, 26);
		panelCreationBudget.add(champMontantEncaissement);
		
		boutonAjoutEncaissement = new JButton("Ajouter");
		boutonAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonAjoutEncaissement.setBounds(866, 192, 116, 30);
		panelCreationBudget.add(boutonAjoutEncaissement);
		
		JLabel labelVirement = new JLabel("Budget :");
		labelVirement.setForeground(Color.BLACK);
		labelVirement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelVirement.setBounds(700, 149, 97, 24);
		panelCreationBudget.add(labelVirement);
		
		JComboBox comboBoxVirement = new JComboBox();
		comboBoxVirement = comboBoxDynamiqueBudget.ComboBoxDynamiqueBudget();
		comboBoxVirement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxVirement.setBounds(802, 148, 180, 26);
		panelCreationBudget.add(comboBoxVirement);
		
		labelErreurAjoutEncaissement = new JLabel("");
		labelErreurAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN,22));
		labelErreurAjoutEncaissement.setForeground(Color.RED);
		labelErreurAjoutEncaissement.setBounds(534, 201, 69, 20);
		panelCreationBudget.add(labelErreurAjoutEncaissement);
		
		labelErreurCreationBudget = new JLabel("");
		labelErreurCreationBudget.setFont(new Font("Tahoma", Font.PLAIN,22));
		labelErreurCreationBudget.setForeground(Color.RED);
		labelErreurCreationBudget.setBounds(15, 201, 69, 20);
		panelCreationBudget.add(labelErreurCreationBudget);
		
		JPanel panelEncaissement = new JPanel();
		panelEncaissement.setBounds(0, 248, 997, 66);
		panelGestion.add(panelEncaissement);
		panelEncaissement.setLayout(null);
		
		JLabel labelEncaissement = new JLabel("Encaissement \u00E0 traiter");
		labelEncaissement.setBounds(15, 16, 296, 37);
		panelEncaissement.add(labelEncaissement);
		labelEncaissement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panelListeEncaissement = new JPanel();
		panelListeEncaissement.setBounds(0, 313, 997, 284);
		panelGestion.add(panelListeEncaissement);
	

/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES ENCAISSEMENTS--------------------------
------------------------------------------------------------------------------------------------*/
		
panelListeEncaissement.setLayout(new BorderLayout(0, 0));
		
		tableauEncaissement = new JTable(modeleListeEncaissement);
		tableauEncaissement.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauEncaissement.getColumnModel().getColumn(5).setMinWidth(0);
		tableauEncaissement.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		JScrollPane scrollPaneEncaissement = new JScrollPane(tableauEncaissement);
		panelListeEncaissement.add(scrollPaneEncaissement);
		
		boutonEncaisser = new JButton("Encaisser");
		boutonEncaisser.setBounds(341, 602, 115, 29);
		panelGestion.add(boutonEncaisser);
		
		boutonSupprimerEncaissement = new JButton("Supprimer");
		boutonSupprimerEncaissement.setBounds(514, 602, 115, 29);
		panelGestion.add(boutonSupprimerEncaissement);
					
			
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/	
		
		JPanel panelJournal = new JPanel();
		panelJournal.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Journal", null, panelJournal, null);
		panelJournal.setLayout(null);
		
		JPanel panelFiltresJournalBudget = new JPanel();
		panelFiltresJournalBudget.setLayout(null);
		panelFiltresJournalBudget.setBounds(0, 0, 997, 50);
		panelJournal.add(panelFiltresJournalBudget);
		
		JLabel label_1 = new JLabel("Filtres :");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(147, 15, 67, 24);
		panelFiltresJournalBudget.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(233, 16, 400, 26);
		panelFiltresJournalBudget.add(comboBox_2);
		
		JPanel panelJournalBudget = new JPanel();
		panelJournalBudget.setBounds(0, 66, 997, 532);
		panelJournal.add(panelJournalBudget);
		panelJournalBudget.setLayout(new BorderLayout(0, 0));
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DU JOURNAL DES BUDGETS--------------------------
------------------------------------------------------------------------------------------------*/
				
		tableauJournalBudget = new JTable(modeleTableauJournalBudget);
		tableauJournalBudget.getColumnModel().getColumn(6).setMaxWidth(0);
		tableauJournalBudget.getColumnModel().getColumn(6).setMinWidth(0);
		tableauJournalBudget.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		JScrollPane scrollPaneJournalBudget = new JScrollPane(tableauJournalBudget);
		panelJournalBudget.add(scrollPaneJournalBudget);
		
		boutonSupprimerJournalBudget = new JButton("Supprimer");
		boutonSupprimerJournalBudget.setBounds(439, 602, 115, 29);
		panelJournal.add(boutonSupprimerJournalBudget);
		

/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/	
}



	public JTextField getChampReferenceBudget() {
		return champReferenceBudget;
	}

	public void setChampReferenceBudget(JTextField champReferenceBudget) {
		this.champReferenceBudget = champReferenceBudget;
	}

	public JTextField getChampNomBudget() {
		return champNomBudget;
	}

	public void setChampNomBudget(JTextField champNomBudget) {
		this.champNomBudget = champNomBudget;
	}

	public JTextField getChampBudgetFixe() {
		return champBudgetFixe;
	}

	public void setChampBudgetFixe(JTextField champBudgetFixe) {
		this.champBudgetFixe = champBudgetFixe;
	}

	public JTable getTableauBudget() {
		return tableauBudget;
	}

	public void setTableauBudget(JTable tableauBudget) {
		this.tableauBudget = tableauBudget;
	}

	public JTable getTableauEncaissement() {
		return tableauEncaissement;
	}

	public void setTableauEncaissement(JTable tableauEncaissement) {
		this.tableauEncaissement = tableauEncaissement;
	}

	public JTable getTableauJournalBudget() {
		return tableauJournalBudget;
	}

	public void setTableauJournalBudget(JTable tableauJournalBudget) {
		this.tableauJournalBudget = tableauJournalBudget;
	}

	public String getSupp() {
		return supp;
	}

	public void setSupp(String supp) {
		this.supp = supp;
	}

	public JTextField getChampReferenceEncaissement() {
		return champReferenceEncaissement;
	}

	public void setChampReferenceEncaissement(JTextField champReferenceEncaissement) {
		this.champReferenceEncaissement = champReferenceEncaissement;
	}

	public JTextField getChampEmetteurEncaissement() {
		return champEmetteurEncaissement;
	}

	public void setChampEmetteurEncaissement(JTextField champEmetteurEncaissement) {
		this.champEmetteurEncaissement = champEmetteurEncaissement;
	}

	public JTextField getChampRecepteurEncaissement() {
		return champRecepteurEncaissement;
	}

	public void setChampRecepteurEncaissement(JTextField champRecepteurEncaissement) {
		this.champRecepteurEncaissement = champRecepteurEncaissement;
	}

	public JTextField getChampDateEncaissement() {
		return champDateEncaissement;
	}

	public void setChampDateEncaissement(JTextField champDateEncaissement) {
		this.champDateEncaissement = champDateEncaissement;
	}

	public JTextField getChampMontantEncaissement() {
		return champMontantEncaissement;
	}

	public void setChampMontantEncaissement(JTextField champMontantEncaissement) {
		this.champMontantEncaissement = champMontantEncaissement;
	}

	public JLabel getLabelErreurCreationBudget() {
		return labelErreurCreationBudget;
	}

	public void setLabelErreurCreationBudget(JLabel labelErreurCreationBudget) {
		this.labelErreurCreationBudget = labelErreurCreationBudget;
	}

	public JLabel getLabelErreurAjoutEncaissement() {
		return labelErreurAjoutEncaissement;
	}

	public void setLabelErreurAjoutEncaissement(JLabel labelErreurAjoutEncaissement) {
		this.labelErreurAjoutEncaissement = labelErreurAjoutEncaissement;
	}

	public ComboBoxDynamiqueBudget getComboBoxDynamiqueBudget() {
		return comboBoxDynamiqueBudget;
	}

	public void setComboBoxDynamiqueBudget(ComboBoxDynamiqueBudget comboBoxDynamiqueBudget) {
		this.comboBoxDynamiqueBudget = comboBoxDynamiqueBudget;
	}

	public JButton getBoutonCreerBudget() {
		return boutonCreerBudget;
	}

	public void setBoutonCreerBudget(JButton boutonCreerBudget) {
		this.boutonCreerBudget = boutonCreerBudget;
	}

	public JButton getBoutonAjoutEncaissement() {
		return boutonAjoutEncaissement;
	}

	public void setBoutonAjoutEncaissement(JButton boutonAjoutEncaissement) {
		this.boutonAjoutEncaissement = boutonAjoutEncaissement;
	}
	
	public JButton getBoutonSupprimerBudget() {
		return boutonSupprimerBudget;
	}

	public void setBoutonSupprimerBudget(JButton boutonSupprimerBudget) {
		this.boutonSupprimerBudget = boutonSupprimerBudget;
	}

	public JButton getBoutonSupprimerEncaissement() {
		return boutonSupprimerEncaissement;
	}

	public void setBoutonSupprimerEncaissement(JButton boutonSupprimerEncaissement) {
		this.boutonSupprimerEncaissement = boutonSupprimerEncaissement;
	}

	public JButton getBoutonSupprimerJournalBudget() {
		return boutonSupprimerJournalBudget;
	}

	public void setBoutonSupprimerJournalBudget(JButton boutonSupprimerJournalBudget) {
		this.boutonSupprimerJournalBudget = boutonSupprimerJournalBudget;
	}

	public JButton getBoutonEncaisser() {
		return boutonEncaisser;
	}

	public void setBoutonEncaisser(JButton boutonEncaisser) {
		this.boutonEncaisser = boutonEncaisser;
	}

	public ModeleTableauListeBudget getModeleListeBudget() {
		return modeleListeBudget;
	}

	public void setModeleListeBudget(ModeleTableauListeBudget modeleListeBudget) {
		this.modeleListeBudget = modeleListeBudget;
	}

	public ModeleTableauEncaissement getModeleListeEncaissement() {
		return modeleListeEncaissement;
	}

	public void setModeleListeEncaissement(ModeleTableauEncaissement modeleListeEncaissement) {
		this.modeleListeEncaissement = modeleListeEncaissement;
	}

	public ModeleTableauJournalBudget getModeleTableauJournalBudget() {
		return modeleTableauJournalBudget;
	}

	public void setModeleTableauJournalBudget(ModeleTableauJournalBudget modeleTableauJournalBudget) {
		this.modeleTableauJournalBudget = modeleTableauJournalBudget;
	}
	
	
	
	
	
}
