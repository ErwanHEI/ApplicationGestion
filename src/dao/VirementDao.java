package dao;

import java.util.List;

import entitie.Virement;

public interface VirementDao {
	
	public Virement ajoutVirement(Virement virement);
	public List<Virement> listerVirementNonEncaisse();
	public List<Virement> journalVirement();
	public void passerEncaissement(Integer idVirement);
	public void suppressionVirement(Integer id);
	public void suppressionJournalBudget(Integer id);
	public List<Virement> listerParEvent(Integer idE);

}
