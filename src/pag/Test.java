package pag;

public class Test {
	public static void main(String args[]) {
		 GestionnaireCircuit gc=new GestionnaireCircuit();
		 Ville v1 =new Ville(3.002556,45.846117, "Sousse",50);
		 gc.ajouterVille(v1);
		 Ville v2 =new Ville(-0.644905,44.896839, "Gebes",20);
		 gc.ajouterVille(v2);
		 Ville v3 = new Ville(-1.380989,43.470961, "Gafsa",60);
		 gc.ajouterVille(v3);
         Ville v4 = new Ville(1.376579, 43.662010, "sfax ",90);
			
         gc.ajouterVille(v4);
				
         Ville  v5 = new Ville(5.337151, 43.327276, "mednin",30);
		
         gc.ajouterVille(v5);
				   
		Population pop=new Population(gc,4);
		System.out.println("Distance finale"+" "+pop.getFittest().getDistance());
		System.out.println("Temps final"+" "+pop.getFittest().time);
		Circuit meilleureCircuit  =pop.getFittest();
		
		for(int i=0;i<meilleureCircuit.circuit.size()-1;i++){
			System.out.println(meilleureCircuit.getVille(i).nom+" -----> "+meilleureCircuit.getVille(i).time((meilleureCircuit.getVille(i+1)))*+meilleureCircuit.getVille(i).getVitess() + " to "+meilleureCircuit.getVille(i+1).nom);
		}
		System.out.println(meilleureCircuit.getVille(meilleureCircuit.circuit.size()-1).nom+" -----> "+meilleureCircuit.getVille(meilleureCircuit.circuit.size()-1).time((meilleureCircuit.getVille(0)))*+meilleureCircuit.getVille(meilleureCircuit.circuit.size()-1).getVitess());
	}
			
		
}
