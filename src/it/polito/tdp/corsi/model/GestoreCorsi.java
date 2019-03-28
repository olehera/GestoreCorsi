package it.polito.tdp.corsi.model;

import java.util.*;
import it.polito.tdp.corsi.db.CorsoDAO;

public class GestoreCorsi {
	
	public List<Corso> getCorsiByPeriodo(int periodo) {
		CorsoDAO dao = new CorsoDAO();
		
		/* Soluzione 1
		 * 
		List<Corso> corsi = dao.listAll();
		List<Corso> result = new ArrayList<Corso>();
		
		for (Corso c : corsi)
			if (c.getPd() == periodo)
				result.add(c);
				
		return result;
		*/ 
		
		// Soluzione 2
		return dao.listAll(periodo);
	}

}
