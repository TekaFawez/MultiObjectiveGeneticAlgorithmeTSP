package pag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Circuit {
	   public GestionnaireCircuit gc;
	   public ArrayList<Ville> circuit;
	   public double fitness;
	   public double distance;
	   public double time;
	   public Circuit(GestionnaireCircuit gc) {
		   this.gc=gc;
		   this.circuit=new ArrayList<>();
		   this.fitness=0.0;
		   this.distance=0;
		   this.time=0;
		   if(circuit != null) {
			   this.circuit=circuit;
		   }
		   else {
			   for(int i=0;i<gc.nbrVilles();i++) {
				   this.circuit.add(null);
			   }
		   
	   }}
	   public int len() {
		   return this.circuit.size();}
	   
	   public Ville getitem(int index) {
		   return this.circuit.get(index);
		   
	   }
	   public void setitem(int i, Ville v) {
		   this.circuit.set(i, v);
	   }
	   public void setVille(int circuitPosition,Ville v) {
		   this.circuit.add(circuitPosition, v);
	   }
	   public Ville getVille(int circuitPosition) {
		   return this.circuit.get(circuitPosition);
	   }
	   public void genererIndividu() {
		   for(int i=0;i<this.gc.nbrVilles();i++) {
			   this.setVille(i, this.gc.getVille(i));
		   }
		  Collections.shuffle(circuit);
		  }
	   public int taillecircuit() {
		   return this.circuit.size();
	   }
	   public double getDistance() {
		   if (this.distance==0) {
			   double circuitDistance=0;
			   double circuitTemps = 0;
			   for(int indiceVille=0;indiceVille<taillecircuit();indiceVille++) {
				  Ville  villeOrigine=this.getVille(indiceVille);
				  Ville villeArrivee=null;
				  if(indiceVille+1<this.taillecircuit())
				  {
					  villeArrivee=this.getVille(indiceVille+1);
				  }
				  else {
					  villeArrivee=this.getVille(0);
				  }
				  circuitDistance += villeOrigine.distance(villeArrivee)/(villeOrigine.time(villeArrivee));
				  circuitTemps+=villeOrigine.time(villeArrivee)*villeOrigine.getVitess();
				   
			   }
			   this.distance=circuitDistance;
			   this.time = circuitTemps;
		   }
		   return this.distance;
	   } 
	   
	   public double getFitness() {
		   if (this.fitness==0.0) {
			   this.fitness=1/this.getDistance();
		   }
		   return this.fitness;
	   }
	   
	   
		   
	   
	   public boolean  contientVille(Ville v) {
		   if (this.circuit.contains(v)) {
			   return true;
		   }
		   else return false;
	   }
}
