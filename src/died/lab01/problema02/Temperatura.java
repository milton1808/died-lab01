package died.lab01.problema02;

public class Temperatura {
	private Double grados;
	private Escala escala;
	
	public Temperatura() {
		super();
		this.grados = 0.0;
		this.escala = Escala.CELCIUS;
	}

	public Temperatura(Double grados, Escala escala) {
		super();
		this.grados = grados;
		this.escala = escala;
	}
	
	public String toString() {
		String a = new String();
		
		switch(this.escala) {
		case CELCIUS:
			a= this.grados + " C°";
			break;
		case FAHRENHEIT:
			a= this.grados + " F°";
			break;
		}
		return a;
	}
	public Double asCelcius(){
		Double respuesta = 0.0;
		switch(this.escala) {
		case CELCIUS:
			respuesta = this.grados;
			break;
		case FAHRENHEIT:
			respuesta = (((this.grados - 32.0)*5.0)/9);
			break;
		}
		return respuesta;
	}
	
	public Double asFahrenheit() {
		Double respuesta = 0.0;
		
		switch(this.escala) {
		case CELCIUS:
			respuesta = ((this.grados*9)/5)+ 32.0;
			break;
		case FAHRENHEIT:
			respuesta = this.grados;
			break;
		}
		
		return respuesta;
	}
	
	public void aumentar(Temperatura temperatura) {
		if(temperatura.grados < 0) {
			System.out.println("No se pudo aumentar temperatura. Ingresar numero mayor a 0.");
			return;
		}
				
		switch(this.escala) {
		case CELCIUS:
			switch(temperatura.escala) {
				case CELCIUS:
					this.grados += temperatura.grados;
					break;
				case FAHRENHEIT:
					this.grados += temperatura.asCelcius();
					break;
			}
			break;
		case FAHRENHEIT:
			switch(temperatura.escala) {
				case CELCIUS:
					this.grados += temperatura.asFahrenheit();
					break;
				case FAHRENHEIT:
					this.grados += temperatura.grados;
				break;
		}
			break;
		}
	}

	public void disminuir(Temperatura temperatura) {
		if(temperatura.grados < 0) {
			System.out.println("No se pudo aumentar temperatura. Ingresar numero mayor a 0.");
			return;
		}
				
		switch(this.escala) {
		case CELCIUS:
			switch(temperatura.escala) {
				case CELCIUS:
					this.grados -= temperatura.grados;
					break;
				case FAHRENHEIT:
					this.grados -= temperatura.asCelcius();
					break;
			}
			break;
		case FAHRENHEIT:
			switch(temperatura.escala) {
				case CELCIUS:
					this.grados -= temperatura.asFahrenheit();
					break;
				case FAHRENHEIT:
					this.grados -= temperatura.grados;
				break;
		}
			break;
		}
		
	}
	
}
