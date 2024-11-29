package figuras;

public class Rectangulo extends Figura {
	protected double ancho;
	protected double alto;

	public Rectangulo() {
		super();
		ancho = 1.0;
		alto = 1.0;
	};
	
	public Rectangulo(Rectangulo c) {
		super();
		this.ancho = c.ancho;
		this.alto = c.alto;
	};
	
	public Rectangulo(double ancho, double alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public Rectangulo (int x, int y, double ancho, double alto) {
		super(x,y);
		this.ancho = ancho;
		this.alto = alto;
	}
	
	

	@Override
	public double calcularArea() {
		return ancho * alto;
	}
	
	@Override
	public String toString() {
		return "Cordenada de la Figura[Rectangulo]: " + "(" + x + "," + y + ")\n"+
				"Ancho: " + ancho + "\n"+
				"Alto: " + alto + "\n"
				+ "Area: " + calcularArea() + "\n"
				;
	}
}


