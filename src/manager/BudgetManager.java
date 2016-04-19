package manager;

import java.util.List;

import dao.BudgetDao;
import daoImpl.BudgetDaoImpl;
import entitie.Budget;
import entitie.Virement;

public class BudgetManager {
	
	private static BudgetManager instance;
	private BudgetDao budgetDao = new BudgetDaoImpl();

	public static BudgetManager getInstance() {

		if (instance == null) {
			instance = new BudgetManager();
		}
		return instance;
	}
	
	public Budget ajoutBudget( Budget budget){
		return budgetDao.ajoutBudget(budget);
	}
	
	public List<Budget> listerBudget (){
		return budgetDao.listerBudget();
	}
	
	public void majMontant(Virement virement, Integer id){
		budgetDao.majMontant(virement, id);
	}
	
	public void suppressionBudget(Integer id){
		budgetDao.suppressionBudget(id);
	}

}
