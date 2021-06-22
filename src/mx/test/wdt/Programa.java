package mx.test.wdt;

/**
 * Boot class
 * @author anver
 *
 */
public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Manejador manejador = new Manejador();
		Ventana ventana = new Ventana(manejador);
	
		ventana.setVisible(true);
	}

}
