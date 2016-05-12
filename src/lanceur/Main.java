package lanceur;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import controler.AjoutBudgetControler;
import controler.AjoutVirementControleur;
import controler.AuthentificationControler;
import controler.BarreMenuControle;
import controler.ChangementMdpControleur;
import controler.CompteAdministrateurControleur;
import controler.ControlerAjoutStockage;
import controler.ControleurAjoutProduit;
import controler.ControleurModificationProduit;
import controler.MdpOublieControleur;
import entitie.Evenement;
import entitie.User;
import manager.EvenementManager;
import manager.LancementManager;
import view.Authentification;
import view.Fenetre;
import view.FirstLaunch;

public class Main {

	public static void main(String[] args) {
		
		Integer compteur=LancementManager.getInstance().testLancement();
		if(compteur==0){
			FirstLaunch fi=new FirstLaunch();
			fi.getBoutonCreerCompteAdministrateur().addActionListener(new CompteAdministrateurControleur(fi));
			
			fi.execute();
			System.out.println("FL");
			LancementManager.getInstance().updateCompteur();
		}else{
			Authentification authe=new Authentification();
			authe.getBoutonMotDePasseOublie().addActionListener(new MdpOublieControleur(authe));
			authe.execute();
			System.out.println("AU");
		}
		
		HashMap <String,Integer> tableQuantite=new HashMap();
		HashMap <String,Double> tableMontant=new HashMap();
		Double newMontant;
			// TODO Auto-generated method stub
			List<Evenement> listeEventFiltre=new ArrayList<Evenement>();
			List<Evenement> listeEvent=EvenementManager.getInstance().listerEvent();
			for(int i=0;i<listeEvent.size();i++){
				System.out.println("Date event "+i+" : "+listeEvent.get(i).getDateEvent());
				System.out.println(testDate(listeEvent.get(i).getDateEvent()));

				if(testDate(listeEvent.get(i).getDateEvent())){
					listeEventFiltre.add(listeEvent.get(i));
				}
			}
			System.out.println(listeEventFiltre.size());
			//somme des quantités pour chaque produit 
			/*for(int i=0;i<listeEventFiltre.size();i++){
				for(int e=0;e<listeEventFiltre.get(i).getListePdts().size();e++){
					if(tableQuantite.containsKey(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit())){
						tableQuantite.put(listeEventFiltre.get(i).getListePdts().get(e).getNomProduit(), tableQuantite.get("Lait")+listeEventFiltre.get(i).getListePdts().get(e).getQuantite());
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
						
					}
				}
			}*/
			
			
			
		}
		
		
		public static boolean testDate(String dateEvent){
			boolean resultat=false;
			List<String> dateToday=new ArrayList<String>();
			List<String> listeC1=new ArrayList<String>();
			List<String> listeC2=new ArrayList<String>();
			Date aujourdhui = new Date();
			
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String date=shortDateFormat.format(aujourdhui);
			System.out.println(date);
			
			 for (String retval: date.split(" ")){
				 dateToday.add(retval);
		      }
			 System.out.println("dateToday : "+dateToday.get(0));
			 
			 for (String retval: dateToday.get(0).split("/")){
		         listeC1.add(retval);
		      }
			 System.out.println("Jour : "+listeC1.get(0));
			 System.out.println("Mois : "+listeC1.get(1));
			 System.out.println("Année : "+listeC1.get(2));
			 
			 for (String retval: dateEvent.split("/")){
		         listeC2.add(retval);
		      }
			 System.out.println("Jour event : "+listeC2.get(0));
			 System.out.println("Mois event : "+listeC2.get(1));
			 System.out.println("Année event : "+listeC2.get(2));
			 
			 if(Integer.parseInt(listeC2.get(2))>Integer.parseInt(listeC1.get(2))){
				 resultat=true;
			 }
			 else if(Integer.parseInt(listeC2.get(2))==Integer.parseInt(listeC1.get(2))){
				 if(Integer.parseInt(listeC2.get(1))>Integer.parseInt(listeC1.get(1))){
					 resultat=true;
				 }
				 else if(Integer.parseInt(listeC2.get(1))==Integer.parseInt(listeC1.get(1))){
					 if(Integer.parseInt(listeC2.get(0))>Integer.parseInt(listeC1.get(0))){
						 resultat=true;
					 }
				 }
			 }
			 
			 
			return resultat;
		}

		
	}


