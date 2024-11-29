package figuras;

public class Rectangulo extends Figura {
	protected double ancho;
	protected double alto;

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
		return x * y;
	}
}


