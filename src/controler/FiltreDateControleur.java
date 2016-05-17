package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entitie.Evenement;
import entitie.Virement;
import manager.EvenementManager;
import manager.VirementManager;
import view.Fenetre;
import view.PanelEvenement;
import view.Recapitulatif;

public class FiltreDateControleur implements ActionListener{
	
	private PanelEvenement pan;
	private Fenetre fen;
	
	
	
	public FiltreDateControleur(Fenetre fen,PanelEvenement pan) {
		super();
		this.pan = pan;
		this.fen=fen;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		HashMap <String,Integer> tableQuantite=new HashMap();
		HashMap <String,Double> tableMontant=new HashMap();
		List<Evenement> listeEvent=new ArrayList<Evenement>();
		String dateFutur=pan.getChampRecherche().getText();
		Double newMontant;
			// TODO Auto-generated method stub
			List<Evenement> listeEventFiltre=new ArrayList<Evenement>();
			listeEvent=EvenementManager.getInstance().listerEvent();
			for(int i=0;i<listeEvent.size();i++){
				if(testDateToday(listeEvent.get(i).getDateEvent())&& testDateFutur(listeEvent.get(i).getDateEvent(), dateFutur)){
					listeEventFiltre.add(listeEvent.get(i));
				}
			}
			System.out.println(listeEventFiltre.size());
			//somme des quantités pour chaque produit 
		
		
		
			for(int i=0;i<listeEventFiltre.size();i++){
				
				
				for(int e=0;e<listeEventFiltre.get(i).getListePdts().size();e++){
					if(tableQuantite.containsKey(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit())){
						tableQuantite.put(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit(), tableQuantite.get(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit())+listeEventFiltre.get(i).getListePdts().get(e).getQuantite());
					}else{
						tableQuantite.put(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit(),listeEventFiltre.get(i).getListePdts().get(e).getQuantite());
					}
				}
				

				
				List<Virement> listeVirement=VirementManager.getInstance().listerParEvent(listeEventFiltre.get(i).getIdEvenement());
				for(int e=0;e<listeVirement.size();e++){
					
					if(tableMontant.containsKey(listeVirement.get(e).getBudgetAssocie().getNomBudget())){
						Double montantA=tableMontant.get(listeVirement.get(e).getBudgetAssocie().getNomBudget());
						if(listeVirement.get(e).getEmetteur().equals("BDE")){
							newMontant=montantA-listeVirement.get(e).getMontant();
							tableMontant.put(listeVirement.get(e).getBudgetAssocie().getNomBudget(), newMontant);
						}else {
							newMontant=montantA+listeVirement.get(e).getMontant();
							tableMontant.put(listeVirement.get(e).getBudgetAssocie().getNomBudget(), newMontant);
						}
					}else{
						if(listeVirement.get(e).getEmetteur().equals("BDE")){
							tableMontant.put(listeVirement.get(e).getBudgetAssocie().getNomBudget(), -listeVirement.get(e).getMontant());
						}else {
							tableMontant.put(listeVirement.get(e).getBudgetAssocie().getNomBudget(), +listeVirement.get(e).getMontant());
						}
					}
				}
			}
			
			Recapitulatif recap=new Recapitulatif( tableQuantite,tableMontant);
			recap.setTableMontant(tableMontant);
			recap.setTableQuantite(tableQuantite);
			fen.changerPanelRecap(recap);
			
}

		
		public static boolean testDateToday(String dateEvent){
			boolean resultat=false;
			List<String> dateA1=new ArrayList<String>();
			List<String> listeC1=new ArrayList<String>();
			
			List<String> listeC2=new ArrayList<String>();
			Date aujourdhui = new Date();
			
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String date=shortDateFormat.format(aujourdhui);
			
			
			 for (String retval: date.split(" ")){
		         dateA1.add(retval);
		      }
			 
			 for (String retval: dateA1.get(0).split("/")){
		         listeC1.add(retval);
		      }
		
			 for (String retval: dateEvent.split("/")){
		         listeC2.add(retval);
		      }
			 
			 if(Integer.parseInt(listeC2.get(2))>Integer.parseInt(listeC1.get(2))){
				 resultat=true;
			 }else if(Integer.parseInt(listeC2.get(2))==Integer.parseInt(listeC1.get(2))){
				 if(Integer.parseInt(listeC2.get(1))>Integer.parseInt(listeC1.get(1))){
					 resultat=true;
				 }else if(Integer.parseInt(listeC2.get(1))==Integer.parseInt(listeC1.get(1))){
					 if(Integer.parseInt(listeC2.get(0))>Integer.parseInt(listeC1.get(0))){
						 resultat=true;
					 }
				 }
			 }
			 
			 
			return resultat;
		}
		
		
		public static boolean testDateFutur(String dateEvent, String dateFutur){
			boolean resultat=false;
			
			List<String> listeC1=new ArrayList<String>();
			
			List<String> listeC2=new ArrayList<String>();
			
			
			
			 
			 
			 for (String retval: dateEvent.split("/")){
		         listeC1.add(retval);
		      }
		
			 for (String retval: dateFutur.split("/")){
		         listeC2.add(retval);
		      }
			 
			 if(Integer.parseInt(listeC2.get(2))>Integer.parseInt(listeC1.get(2))){
				 resultat=true;
			 }else if(Integer.parseInt(listeC2.get(2))==Integer.parseInt(listeC1.get(2))){
				 if(Integer.parseInt(listeC2.get(1))>Integer.parseInt(listeC1.get(1))){
					 resultat=true;
				 }else if(Integer.parseInt(listeC2.get(1))==Integer.parseInt(listeC1.get(1))){
					 if(Integer.parseInt(listeC2.get(0))>Integer.parseInt(listeC1.get(0))){
						 resultat=true;
					 }
				 }
			 }
			 
			 
			return resultat;
		}
	
	
}
