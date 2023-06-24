import com.mycompany.cajeroautomatico.CajeroAutomatico;
import java.util.Scanner;
public class Cajero2 {
    private static CajeroAutomatico[] cuentas;
	private static Scanner teclado = new Scanner(System.in);
        
        //Programa principal
	public static void main (String[] args) {
		inicializarCuentas();
		int opcion = 0;
 
		while (opcion != 4) {
			System.out.println("\n\t\tCAJERO AUTOMATICO");
			System.out.println("\t\t------ ----------\n");
                        CajeroAutomatico usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nNo existe Cuenta asociada a ese PIN");
		else {
			System.out.println("[1] Retirar saldo");
			System.out.println("[2] Depositar saldo");
			System.out.println("[3] Consultar saldo");
			System.out.println("[4] SALIR");
			System.out.print("Elija opcion: ");
			opcion = Integer.parseInt(teclado.nextLine());
 
			switch(opcion) {
			case 1:
				retirar();
				break;
			case 2:
				ingresar();
				break;
			case 3:
				consultarSaldo();
				break;
			case 4:
				System.out.println("\n\n\t\tFIN DE PROGRAMA");
				break;
			default:
				System.out.println("\nOpción equivocada");
			}}
		}
	}
        
        private static void inicializarCuentas() {
		cuentas = new CajeroAutomatico[5];
		cuentas[0] = new CajeroAutomatico("Raúl Ramirez", "1234", 450.55);
		cuentas[1] = new CajeroAutomatico("Sara Pelaez", "0101", 350.80);
		cuentas[2] = new CajeroAutomatico("Pedro Vega", "9876", 200d);
		cuentas[3] = new CajeroAutomatico("Laura Juan", "2020", 0d);
		cuentas[4] = new CajeroAutomatico("Javier Quesada", "5665", 125d);
 
	}
        
        private static CajeroAutomatico buscarPorPIN() {
		System.out.println("\nIntroduzca su PIN de 4 digitos");
		String PIN = teclado.nextLine();
 
		//Buscamos la cuenta con el PIN indicado
		for (int i = 0; i < cuentas.length; i++)
			if (cuentas[i].getPIN().equals(PIN))
				return cuentas[i]; //Si la encontramos, la retornamos
 
		//Si el bucle FOR no ha retornado nada, es que el PIN es incorrecto y retornamos null
		return null;
	}
        
        private static void retirar() {
 
		CajeroAutomatico usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nNo existe Cuenta asociada a ese PIN");
		else {
			System.out.print("\nCantidad a retirar: ");
			double cantidad = Double.parseDouble(teclado.nextLine());
			usuario.retirar(cantidad);
		}
	}
        
        private static void ingresar() {
 
		CajeroAutomatico usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nNo existe Cuenta asociada a ese PIN");
		else {
			System.out.print("\nCantidad a ingresar: ");
			double cantidad = Double.parseDouble(teclado.nextLine());
			usuario.ingresar(cantidad);
		}
	}
 
	/**
	 * Permite consultar saldo de una Cuenta, previamente identificada
	 * mediante PIN de acceso
	 */
	private static void consultarSaldo() {
 
		CajeroAutomatico usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nNo existe Cuenta asociada a ese PIN");
		else
			System.out.println("\nSaldo actual: " + usuario.getSaldo());
	}
}
