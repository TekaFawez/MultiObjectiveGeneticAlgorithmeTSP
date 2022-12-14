package pag;
import java.util.ArrayList;
public class Population {
	ArrayList<Circuit> circuits=new ArrayList<Circuit>();
public Population(GestionnaireCircuit gc, int taillePopulation) {
	
	for(int i=0;i<taillePopulation;i++) {
	  Circuit C=new Circuit(gc);
	  C.genererIndividu();
	  this.sauvegarderCircuit(i,C);}
}
public void sauvegarderCircuit(int index ,Circuit c) {
	this.circuits.add(index, c);
}
public void setitem(int i, Circuit c) {
	this.circuits.set(i, c);
}
public Circuit getcircuit(int i) {
	return this.circuits.get(i);
}
public int taillePopulation() {
	return this.circuits.size();
}
public Circuit getFittest() {
	Circuit fittest=this.circuits.get(0);
	for(int i=0;i<taillePopulation();i++) {
		if (fittest.getFitness()<= this.getcircuit(i).getFitness()){
			fittest=this.getcircuit(i);
		}
		
	}
	return fittest;
	
}

}
