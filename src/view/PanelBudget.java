package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelCombo.ComboBoxDynamiqueBudget;
import modelFiltres.FiltreBudget;
import modelTableau.ModeleTableauEncaissement;
import modelTableau.ModeleTableauJournalBudget;
import modelTableau.ModeleTableauListeBudget;

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
	
	private JTextField champReferenceEncaissement;
	private JTextField champEmetteurEncaissement;
	private JTextField champRecepteurEncaissement;
	private JTextField champDateEncaissement;
	private JTextField champMontantEncaissement;
	
	private FiltreBudget filtreBudget = new FiltreBudget();
	
	JLabel labelErreurCreationBudget;
	JLabel labelErreurAjoutEncaissement ;
	
	private String html1 = "<html><body style = 'margin:0;padding-top:5px;padding-bottom:5px;padding-left:10px;font-size:1.4em;font-family:Verdana'>";
    private String html2 =  "</body></html>";

	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;
	

	public PanelBudget(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, (int) (16*adapty), (int) (1002*adaptx), (int) (665*adaptx));
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel panelBudget = new JPanel();
		panelBudget.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Budgets"+html2, new ImageIcon("../ApplicationGestion/src/image/budget.png"), panelBudget, null);
		panelBudget.setLayout(null);
		
		JPanel panelFiltres = new JPanel();
		panelFiltres.setBounds(0, 0, (int) (997*adaptx), (int) (50*adaptx));
		panelFiltres.setLayout(null);
		panelBudget.add(panelFiltres);
		
		JLabel labelFiltres = new JLabel("Filtres :");
		labelFiltres.setForeground(Color.BLACK);
		labelFiltres.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelFiltres.setBounds((int) (147*adaptx), (int) (15*adapty), (int) (67*adaptx), (int) (24*adaptx));
		panelFiltres.add(labelFiltres);
		
		JComboBox comboBoxFiltres = new JComboBox();
		comboBoxFiltres = filtreBudget.FiltreBudget(modeleListeBudget);
		comboBoxFiltres.setFont(new Font("Tahoma", Font.PLAIN, (int) (12*adaptx)));
		comboBoxFiltres.setBounds((int) (233*adaptx), (int) (16*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelFiltres.add(comboBoxFiltres);
		
		JPanel panelListeBudget = new JPanel();
		panelListeBudget.setBounds(0, (int) (66*adapty), (int) (997*adaptx), (int) (527*adapty));
		panelBudget.add(panelListeBudget);
		panelListeBudget.setLayout(new BorderLayout(0, 0));
		
	
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES BUDGETS--------------------------------
------------------------------------------------------------------------------------------------*/
		
		tableauBudget = new JTable(modeleListeBudget);
		tableauBudget.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauBudget.getColumnModel().getColumn(5).setMinWidth(0);
		tableauBudget.getColumnModel().getColumn(5).setPreferredWidth(0);
		tableauBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauBudget.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauBudget.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneBudget = new JScrollPane(tableauBudget);
		panelListeBudget.add(scrollPaneBudget, BorderLayout.CENTER);
		
		boutonSupprimerBudget = new JButton("Supprimer");
		boutonSupprimerBudget.setFont(new Font("Tahoma", Font.PLAIN, (int)(16*adaptx)));
		boutonSupprimerBudget.setBounds((int) (441*adaptx), (int) (602*adapty), (int) (115*adaptx), (int) (29*adapty));
		panelBudget.add(boutonSupprimerBudget);
		
		
		
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/		
		
		
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Gestion"+html2, new ImageIcon("../ApplicationGestion/src/image/gestion.png"), panelGestion, null);
		panelGestion.setLayout(null);
		
		JPanel panelCreationBudget = new JPanel();
		panelCreationBudget.setLayout(null);
		panelCreationBudget.setBounds(0, 0, (int) (997*adaptx), (int) (232*adapty));
		panelGestion.add(panelCreationBudget);
		
		JLabel labelCreationBudget = new JLabel("Cr\u00E9ation d'un budget");
		labelCreationBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelCreationBudget.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (280*adaptx), (int) (37*adaptx));
		panelCreationBudget.add(labelCreationBudget);
		
		JLabel labelReferenceBudget = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceBudget.setForeground(Color.BLACK);
		labelReferenceBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelReferenceBudget.setBounds((int) (37*adaptx), (int) (69*adapty), (int) (102*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelReferenceBudget);
		
		champReferenceBudget = new JTextField();
		champReferenceBudget.setColumns(10);
		champReferenceBudget.setBounds((int) (154*adaptx), (int) (70*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champReferenceBudget);
		
		JLabel labelNomBudget = new JLabel("Nom :");
		labelNomBudget.setForeground(Color.BLACK);
		labelNomBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNomBudget.setBounds((int) (85*adaptx), (int) (109*adapty), (int) (54*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelNomBudget);
		
		champNomBudget = new JTextField();
		champNomBudget.setColumns(10);
		champNomBudget.setBounds((int) (154*adaptx), (int) (110*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champNomBudget);
		
		JLabel labelBudgetFixe = new JLabel("Budget fix\u00E9 :");
		labelBudgetFixe.setForeground(Color.BLACK);
		labelBudgetFixe.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelBudgetFixe.setBounds((int) (25*adaptx), (int) (149*adapty), (int) (114*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelBudgetFixe);
		
		champBudgetFixe = new JTextField();
		champBudgetFixe.setColumns(10);
		champBudgetFixe.setBounds((int) (154*adaptx), (int) (150*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champBudgetFixe);
		
		boutonCreerBudget = new JButton("Cr\u00E9er");
		boutonCreerBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonCreerBudget.setBounds((int) (200*adaptx), (int) (192*adapty), (int) (170*adaptx), (int) (30*adapty));
		panelCreationBudget.add(boutonCreerBudget);
		
		JLabel labelAjoutEncaissement = new JLabel("Ajout d'un encaissement");
		labelAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelAjoutEncaissement.setBounds((int) (388*adaptx), (int) (16*adapty), (int) (331*adaptx), (int) (37*adaptx));
		panelCreationBudget.add(labelAjoutEncaissement);
		
		JLabel labelReferenceEncaissement = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceEncaissement.setForeground(Color.BLACK);
		labelReferenceEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelReferenceEncaissement.setBounds((int) (398*adaptx), (int) (69*adapty), (int) (102*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelReferenceEncaissement);
		
		champReferenceEncaissement = new JTextField();
		champReferenceEncaissement.setColumns(10);
		champReferenceEncaissement.setBounds((int) (505*adaptx), (int) (70*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champReferenceEncaissement);
		
		JLabel labelEmetteurEncaissement = new JLabel("Emetteur :");
		labelEmetteurEncaissement.setForeground(Color.BLACK);
		labelEmetteurEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelEmetteurEncaissement.setBounds((int) (401*adaptx), (int) (109*adapty), (int) (99*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelEmetteurEncaissement);
		
		champEmetteurEncaissement = new JTextField();
		champEmetteurEncaissement.setColumns(10);
		champEmetteurEncaissement.setBounds((int) (505*adaptx), (int) (110*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champEmetteurEncaissement);
		
		JLabel labelRecepteurEncaissement = new JLabel("R\u00E9cepteur :");
		labelRecepteurEncaissement.setForeground(Color.BLACK);
		labelRecepteurEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelRecepteurEncaissement.setBounds((int) (393*adaptx), (int) (149*adapty), (int) (103*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelRecepteurEncaissement);
		
		champRecepteurEncaissement = new JTextField();
		champRecepteurEncaissement.setColumns(10);
		champRecepteurEncaissement.setBounds((int) (505*adaptx), (int) (150*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champRecepteurEncaissement);
		
		JLabel labelDateEncaissement = new JLabel("Date :");
		labelDateEncaissement.setForeground(Color.BLACK);
		labelDateEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelDateEncaissement.setBounds((int) (741*adaptx), (int) (69*adapty), (int) (56*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelDateEncaissement);
		
		champDateEncaissement = new JTextField();
		champDateEncaissement.setColumns(10);
		champDateEncaissement.setBounds((int) (802*adaptx), (int) (70*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champDateEncaissement);
		
		JLabel labelMontantEncaissement = new JLabel("Montant :");
		labelMontantEncaissement.setForeground(Color.BLACK);
		labelMontantEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelMontantEncaissement.setBounds((int) (711*adaptx), (int) (109*adapty), (int) (86*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelMontantEncaissement);
		
		champMontantEncaissement = new JTextField();
		champMontantEncaissement.setColumns(10);
		champMontantEncaissement.setBounds((int) (802*adaptx), (int) (110*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(champMontantEncaissement);
		
		boutonAjoutEncaissement = new JButton("Ajouter");
		boutonAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonAjoutEncaissement.setBounds((int) (866*adaptx), (int) (192*adapty), (int) (116*adaptx), (int) (30*adapty));
		panelCreationBudget.add(boutonAjoutEncaissement);
		
		JLabel labelVirement = new JLabel("Budget :");
		labelVirement.setForeground(Color.BLACK);
		labelVirement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelVirement.setBounds((int) (700*adaptx), (int) (149*adapty), (int) (97*adaptx), (int) (24*adaptx));
		panelCreationBudget.add(labelVirement);
		
		JComboBox comboBoxVirement = new JComboBox();
		comboBoxVirement = comboBoxDynamiqueBudget.ComboBoxDynamiqueBudget();
		comboBoxVirement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		comboBoxVirement.setBounds((int) (802*adaptx), (int) (148*adapty), (int) (180*adaptx), (int) (26*adaptx));
		panelCreationBudget.add(comboBoxVirement);
		
		labelErreurAjoutEncaissement = new JLabel("");
		labelErreurAjoutEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (22*adaptx)));
		labelErreurAjoutEncaissement.setForeground(Color.RED);
		labelErreurAjoutEncaissement.setBounds((int) (534*adaptx), (int) (201*adapty), (int) (69*adaptx), (int) (20*adaptx));
		panelCreationBudget.add(labelErreurAjoutEncaissement);
		
		labelErreurCreationBudget = new JLabel("");
		labelErreurCreationBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (22*adaptx)));
		labelErreurCreationBudget.setForeground(Color.RED);
		labelErreurCreationBudget.setBounds((int) (15*adaptx), (int) (201*adapty), (int) (69*adaptx), (int) (20*adaptx));
		panelCreationBudget.add(labelErreurCreationBudget);
		
		JPanel panelEncaissement = new JPanel();
		panelEncaissement.setBounds(0, (int) (248*adapty), (int) (997*adaptx), (int) (66*adapty));
		panelGestion.add(panelEncaissement);
		panelEncaissement.setLayout(null);
		
		JLabel labelEncaissement = new JLabel("Encaissement \u00E0 traiter");
		labelEncaissement.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (296*adaptx), (int) (37*adaptx));
		panelEncaissement.add(labelEncaissement);
		labelEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		
		JPanel panelListeEncaissement = new JPanel();
		panelListeEncaissement.setBounds(0, (int) (313*adapty), (int) (997*adaptx), (int) (284*adapty));
		panelGestion.add(panelListeEncaissement);
	

/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES ENCAISSEMENTS--------------------------
------------------------------------------------------------------------------------------------*/
		
		panelListeEncaissement.setLayout(new BorderLayout(0, 0));
		
		tableauEncaissement = new JTable(modeleListeEncaissement);
		tableauEncaissement.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauEncaissement.getColumnModel().getColumn(5).setMinWidth(0);
		tableauEncaissement.getColumnModel().getColumn(5).setPreferredWidth(0);
		tableauEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauEncaissement.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauEncaissement.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneEncaissement = new JScrollPane(tableauEncaissement);
		panelListeEncaissement.add(scrollPaneEncaissement);
		
		boutonEncaisser = new JButton("Encaisser");
		boutonEncaisser.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonEncaisser.setBounds((int) (341*adaptx), (int) (602*adapty), (int) (115*adaptx), (int) (29*adapty));
		panelGestion.add(boutonEncaisser);
		
		boutonSupprimerEncaissement = new JButton("Supprimer");
		boutonSupprimerEncaissement.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonSupprimerEncaissement.setBounds((int) (514*adaptx), (int) (602*adapty), (int) (115*adaptx), (int) (29*adapty));
		panelGestion.add(boutonSupprimerEncaissement);
					
			
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/	
		
		JPanel panelJournal = new JPanel();
		panelJournal.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Journal"+html2, new ImageIcon("../ApplicationGestion/src/image/journal.png"), panelJournal, null);
		panelJournal.setLayout(null);
		
		JPanel panelFiltresJournalBudget = new JPanel();
		panelFiltresJournalBudget.setLayout(null);
		panelFiltresJournalBudget.setBounds(0, 0, (int) (997*adaptx), (int) (50*adaptx));
		panelJournal.add(panelFiltresJournalBudget);
		
		JLabel label_1 = new JLabel("Filtres :");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		label_1.setBounds((int) (147*adaptx), (int) (15*adapty), (int) (67*adaptx), (int) (24*adaptx));
		panelFiltresJournalBudget.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds((int) (233*adaptx), (int) (16*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelFiltresJournalBudget.add(comboBox_2);
		
		JPanel panelJournalBudget = new JPanel();
		panelJournalBudget.setBounds(0, (int) (66*adapty), (int) (997*adaptx), (int) (532*adapty));
		panelJournal.add(panelJournalBudget);
		panelJournalBudget.setLayout(new BorderLayout(0, 0));
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DU JOURNAL DES BUDGETS--------------------------
------------------------------------------------------------------------------------------------*/
				
		tableauJournalBudget = new JTable(modeleTableauJournalBudget);
		tableauJournalBudget.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauJournalBudget.getColumnModel().getColumn(5).setMinWidth(0);
		tableauJournalBudget.getColumnModel().getColumn(5).setPreferredWidth(0);
		tableauJournalBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauJournalBudget.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauJournalBudget.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneJournalBudget = new JScrollPane(tableauJournalBudget);
		panelJournalBudget.add(scrollPaneJournalBudget);
		
		boutonSupprimerJournalBudget = new JButton("Supprimer");
		boutonSupprimerJournalBudget.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonSupprimerJournalBudget.setBounds((int) (439*adaptx), (int) (602*adapty), (int) (115*adaptx), (int) (29*adapty));
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
