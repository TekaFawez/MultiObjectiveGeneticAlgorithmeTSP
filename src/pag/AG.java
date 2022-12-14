package pag;
import java.util.Random;
public class AG {
	public GestionnaireCircuit gc;
	public double tauxMutation;
	public int tailleTournoi;
	public boolean elitisme;
public AG(GestionnaireCircuit gc) {
	this.gc=gc;
	this.tauxMutation=0.015;
	this.tailleTournoi=5;
	this.elitisme=true;
	
}
public Circuit selectionTournoi(Population pop) {
	Population tournoi=new Population( gc,this.tailleTournoi);
    for(int i=0;i<this.tailleTournoi;i++) {
    	Random rand=new Random();
    	int randomId=(int) (rand.nextDouble()*pop.taillePopulation());
    	tournoi.sauvegarderCircuit(i, pop.getcircuit(randomId));
}
    Circuit fittest=tournoi.getFittest();
    return fittest;}
public Circuit crossover(Circuit parent1, Circuit parent2) {
	GestionnaireCircuit gc=new GestionnaireCircuit();
	Circuit enfant =new Circuit(gc);
	Random rand=new Random();
	int startpos=(int)(rand.nextDouble()*parent1.taillecircuit());
	int endpos=(int)(rand.nextDouble()*parent2.taillecircuit());
	for(int i=0;i<enfant.taillecircuit();i++) {
		if(startpos<endpos && i>startpos && i<endpos) {
			enfant.setVille(i, parent1.getVille(i));
		
		}
		else if (startpos>endpos) {
			if (!(i<startpos && i>endpos)) {
				enfant.setVille(i, parent1.getVille(i));
			}
		}}
	for(int j=0;j<parent2.taillecircuit();j++) {
			if(! enfant.contientVille(parent2.getVille(j))) {
				for(int k=0;k<enfant.taillecircuit();k++) {
					if(enfant.getVille(k)==null) {
						enfant.setVille(k, parent2.getVille(j));
						break;
					}
				}
			}
		}
	return enfant;
	}

public void muter(Circuit c) {
	Random rand =new Random();
	for(int pos1=0;pos1<c.taillecircuit();pos1++) {
		if(rand.nextDouble()<this.tauxMutation) {
			int pos2=(int)(c.taillecircuit()*rand.nextDouble());
			Ville v1=c.getVille(pos1);
			Ville v2=c.getVille(pos2);
			c.setVille(pos2, v1);
			c.setVille(pos1, v2);
		}
	}
}
public Population evoluerPopulation(Population pop) {
	Population  nouvellePopulation=new Population (this.gc,pop.taillePopulation());
	int elitismeOffset=0;
	if (this.elitisme) {
		nouvellePopulation.sauvegarderCircuit(0, pop.getFittest());
		elitismeOffset=1;
	}
	for(int i=elitismeOffset;i<nouvellePopulation.taillePopulation();i++) {
		Circuit parent1=this.selectionTournoi(pop);
		Circuit parent2=this.selectionTournoi(pop);
		Circuit enfant=this.crossover(parent1, parent2);
		nouvellePopulation.sauvegarderCircuit(i, enfant);
	}
	for(int j=elitismeOffset;j<nouvellePopulation.taillePopulation();j++) {
		this.muter(nouvellePopulation.getcircuit(j));
	}
	return nouvellePopulation;
	
}
}
