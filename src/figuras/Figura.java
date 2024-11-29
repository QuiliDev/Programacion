package figuras;

public abstract class Figura {

	protected int x;
	protected int y;
	
	
	//Constructor por parametro
	public Figura() {
		x = 1;
		y = 1;
	}
	
	public Figura(Figura c) {
		this.x = c.x;
		this.y = c.y;
	}
	
	public Figura (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularArea() {
		return 0;
	};
	
	public String toString() {
		return "Cordenada de la Figura: " + "(" + x + "," + y + ")\n";
	}
	
}
