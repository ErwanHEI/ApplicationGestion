package dao;

import java.util.List;

import entitie.Budget;
import entitie.Virement;

public interface BudgetDao {

	public Budget ajoutBudget(Budget budget);
	public List<Budget> listerBudget();
	public void majMontant(Virement virement, Integer id);
	public void suppressionBudget(Integer id);
}
