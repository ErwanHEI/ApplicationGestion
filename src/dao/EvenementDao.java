package dao;

import java.util.List;

import entitie.Evenement;

public interface EvenementDao {
	
	public Evenement ajoutEvent(Evenement event);
	public List<Evenement> listerEvent();
	public void supprimerEvenement(Integer idEvent);
	 
}
