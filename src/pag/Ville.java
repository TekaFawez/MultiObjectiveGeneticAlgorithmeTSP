package pag;

public class Ville {
	public double  x;
	public double y;
	public String nom;
	public double vitess ;
	public Ville(double x,double y,String nom ,double vitess ) {
		this.x=x;
		this.y=y;
		this.nom=nom;
		this.vitess=vitess;

	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getVitess() {
		return vitess;
	}
	public double  distance(Ville v) {
		double deltaXSq = (v.getX() - getX())*40000*Math.cos((this.y+v.y)*Math.PI/360)/360;
	    double deltaYSq = (getY()-v.getY())*40000/360;
	    double distance = Math.sqrt(Math.pow(deltaXSq,2)+Math.pow(deltaYSq, 2));

	    return distance;

	}
	public double time (Ville v) {
		return this.distance(v)/this.getVitess();
	}
	}


