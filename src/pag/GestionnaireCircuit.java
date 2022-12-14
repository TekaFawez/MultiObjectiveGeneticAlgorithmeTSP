package pag;
import java.util.ArrayList;
import java.util.List;
public class GestionnaireCircuit {
	List<Ville> VD;
	 public GestionnaireCircuit() {
		 this.VD=new ArrayList<>();
	 }
	 public void ajouterVille(Ville v) {
		 VD.add(v);
	 }
	 public Ville getVille(int index) {
		 return VD.get(index);
	 }
	 public int nbrVilles() {
		 return VD.size();
	 }
}
