package it.polito.tdp.corsi.model;

import java.util.Map;
import java.util.Map.Entry;

public class TestModel {

	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();
	}
	
	public void run() {
		GestoreCorsi model = new GestoreCorsi();
		
		Map<Corso, Integer> res = model.getIscrittiCorsi(1);
		
		for (Entry<Corso, Integer> entry : res.entrySet()) 
			System.out.println(entry.getKey() + "=" + entry.getValue());
		
	}

}
