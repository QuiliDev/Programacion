package figuras;

public class Circulo extends Figura {
	protected double radio;
	
	
	public Circulo() {
		super();
		radio = 1.0;
	};
	
	public Circulo(Circulo c) {
		super(c);
		radio = c.radio;
	};
	
	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(radio, 2);
	}
}
