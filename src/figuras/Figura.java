package figuras;

public abstract class Figura {

	protected int x;
	protected int y;
	
	
	//Constructor por parametro
	public Figura() {
		this.x = 1;
		this.y = 1;
	}
	
	public Figura (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularArea() {
		return 0;
	};
	
	
}
