package died.lab01.problema03;
import died.lab01.problema02.Escala;
import died.lab01.problema02.Temperatura;



public class Registro {

	private String ciudad;
	private Temperatura[] historico;
	private static int MAX=30;
	private Integer indice_actual;
	private Integer capacidad_disponible;
	private Integer cantidad_insertados;
	
	public Registro() {
		ciudad = "-";
		historico = new Temperatura[MAX];
		indice_actual= 0;
		cantidad_insertados= indice_actual +1;
		capacidad_disponible= MAX - cantidad_insertados; 
		
	}
	
	public Registro(String ciudad) {
		this.ciudad = ciudad;
		historico = new Temperatura[MAX];
		indice_actual= -1;
		cantidad_insertados= indice_actual +1;
		capacidad_disponible= MAX - cantidad_insertados; 
		
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public void imprimir() {
		System.out.println("TEMPERATURAS REGISTRADAS EN : "+this.ciudad.toUpperCase());
		
		for(int i = 0; i<=indice_actual;i++) {
			System.out.println((i+1)+" "+this.historico[i].toString());
		}
	}
	
	public void agregar(Temperatura t) {
		if(capacidad_disponible > 0) {
			indice_actual++;
			historico[indice_actual]= t;
			cantidad_insertados= indice_actual +1;
			capacidad_disponible= MAX - cantidad_insertados; 
		}
	}
	
	public Double mediaAsCelcius() {
		Double suma = 0.0, media=0.0;
		
		for(int i=0;i<=indice_actual;i++) {
			suma+= historico[i].asCelcius();
		}
		
		media= suma/cantidad_insertados;
		
		return media;
	}
	public Double mediaAsFahrenheit() {
		Double suma = 0.0, media=0.0;
		
		for(int i=0;i<=indice_actual;i++) {
			suma+= historico[i].asFahrenheit();
		}
		
		media= suma/cantidad_insertados;
		
		return media;
	}
	public Temperatura maximo() {
		Integer maximo = this.max(0);
		return this.historico[maximo];		
	}
	
	private Integer max(Integer indice) {
		//caso base
		if(indice==this.indice_actual)	return indice;
		//caso recursivo
		Integer maximo=this.max(indice+1);
		if(this.historico[indice].asCelcius() > this.historico[maximo].asCelcius()) return indice;
		else return maximo;
		
	}
	
}
