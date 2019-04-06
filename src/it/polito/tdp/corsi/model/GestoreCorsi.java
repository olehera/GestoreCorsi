package it.polito.tdp.corsi.model;

import java.util.*;
import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class GestoreCorsi {
	
	CorsoDAO cdao = new CorsoDAO();
	StudenteDAO sdao = new StudenteDAO();
	
	public List<Corso> getCorsiByPeriodo(int periodo) {
		
		/* Soluzione 1
		 * 
		List<Corso> corsi = dao.listAll();
		List<Corso> result = new ArrayList<Corso>();
		
		for (Corso c : corsi)
			if (c.getPd() == periodo)
				result.add(
				
		return result;
		*/ 
		
		// Soluzione 2
		return cdao.listCorsiByPD(periodo);
	}
	
	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {
		return cdao.getIscrittiCorsi(periodo);
	}
	
	public List<Studente> elencaStudenti(String codins) {
		return sdao.getElencoStudenti(codins);
	}

}
