package died.lab01.problema01;

public class Recta {
	
	private Punto p1,p2;

	public Recta(Punto p1, Punto p2) {
		this.p1=p1;
		this.p2=p2;
	}
	
	public Recta() {
		Punto p11 = new Punto(1,1);
		Punto p22 = new Punto(2,2);
		
		this.p1=p11;
		this.p2=p22;
	}
	
	
	
	public Punto getP1() {
		return p1;
	}

	public Punto getP2() {
		return p2;
	}

	public float pendiente() {
		float m;
		m = (p2.getY()-p1.getY()) / (p2.getX()-p1.getX());
		
		return m;
	}
	
	public boolean paralelas(Recta otraRecta) {
		boolean rta;
		rta = (this.pendiente() == otraRecta.pendiente());
		return rta;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Recta otra = new Recta(this.p1, ((Recta) obj).getP2());
		if(this.pendiente() == otra.pendiente())
			return true;
		otra = new Recta(this.p2, ((Recta) obj).getP1());
		if(this.pendiente() == otra.pendiente())
			return true;
		if(((Recta) obj).getP2()== this.p1 && ((Recta) obj).getP1() == this.p2)
			return true;
		
		return false;
		
		
	}
	
	
	
	

}
