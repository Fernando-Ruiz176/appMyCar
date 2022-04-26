package SolucionMyCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMyCar {

		private static ArrayList<Auto> autos 				= new ArrayList<Auto>();
		private static ArrayList<Mantencion> mantenciones 	= new ArrayList<Mantencion>();
		private static ArrayList<Cliente> clientes 			= new ArrayList<Cliente>();
		
		public final static int OPCION_MENU_AGREGAR_CLIENTE 		= 1;
		public final static int OPCION_MENU_ELIMINAR_CLIENTE 		= 2;
		public final static int OPCION_MENU_AGREGAR_MANTENCIONES 	= 3;
		public final static int OPCION_MENU_DETALLE_MANTENCIONES 	= 4;
		public final static int OPCION_MENU_RECAUDACIONES 			= 5;
		private final static int OPCION_MENU_VER_CLIENTES 			= 6;
		public final static int OPCION_MENU_SALIR 					= 7;
		static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcionSeleccionada;
		do {
			opcionSeleccionada = menu();
			System.out.printf("\n", opcionSeleccionada);
			switch(opcionSeleccionada) {
 			case OPCION_MENU_AGREGAR_CLIENTE:
 					agregarCliente();
 					break;
 			case OPCION_MENU_ELIMINAR_CLIENTE:
 					eliminarCliente();
 					break;
 			case OPCION_MENU_DETALLE_MANTENCIONES:
 					detalleMantenciones();
 					break;
 			case OPCION_MENU_RECAUDACIONES:
 					verRecaudacion();
 					break;
 			case OPCION_MENU_AGREGAR_MANTENCIONES:
 					agregarMantencion();
 					break;
 			case OPCION_MENU_VER_CLIENTES:
					verClientes();
					break;
			}
			
		}while(opcionSeleccionada != OPCION_MENU_SALIR);
		System.out.printf("Selecciono la opcion %d", opcionSeleccionada);

	}

	private static void agregarCliente() {
		
		scanner.nextLine(); 
		System.out.println("Ingrese RUT del cliente");
		String rutCliente = scanner.nextLine();
		
			for(Cliente cliente : clientes) {
				if (cliente.getRut().equalsIgnoreCase(rutCliente)) {
					agregarAutos(cliente);	
					break;
				}
			}
			
			System.out.println("Cliente no registrado. \n Favor ingrese datos del nuevo cliente.\n");
			
			System.out.println("Ingrese nombre del cliente");
			String nombreCliente = scanner.nextLine();
			
			System.out.println("Ingrese apellido del cliente");
			String apellidoCliente = scanner.nextLine();
				
			System.out.println("Ingrese correo del cliente");
			String correoCliente = scanner.nextLine();

			System.out.println("Ingrese telefono del cliente");
			String fonoCliente = scanner.nextLine();
	
			Cliente cliente = new Cliente( nombreCliente, apellidoCliente, rutCliente, correoCliente, fonoCliente);
			clientes.add(cliente);
			agregarAutos(cliente);
	}
		
	private static void agregarAutos(Cliente cliente) {
		boolean agregarAutos = true;
		try {
			do {
				System.out.println("Ingrese la patente del auto");
				String ppuAuto = scanner.nextLine().toUpperCase();
				
				System.out.println("Ingrese marca del auto");
				String marcaAuto = scanner.nextLine();
				
				System.out.println("Ingrese modelo del auto");
				String modeloAuto = scanner.nextLine();
				
				System.out.println("Ingrese año fabricacion del auto");
				int yearAuto = scanner.nextInt();
				if (yearAuto < 1960 || String.valueOf(yearAuto).length() > 4) {
					throw new Exception("PARAMETROS INVALIDOS. INTENTE DE NUEVO");
				}
							
				Auto auto = new Auto( ppuAuto, marcaAuto, modeloAuto, yearAuto, agregarAutos, cliente);
				autos.add(auto); 
				cliente.addAuto(auto); 
				
				scanner.nextLine(); 
				
				System.out.println("¿Desea seguir añadiendo autos? (si/no)");
				String decision = scanner.nextLine();
				
				if(decision.equalsIgnoreCase("NO")) {
					agregarAutos = false;
					break;
				}	
			}while(agregarAutos);
			
		}catch ( Exception exception ) {
			System.out.println("Parametros invalidos. Intente de nuevo");
		}
	}
	
	private static void eliminarCliente() {
		
	   scanner.nextLine();
	   System.out.println("Escriba el rut del cliente a eliminar: ");
	   String rut = scanner.nextLine();
	
	   for (Cliente cli : clientes) {
		   if(rut.equalsIgnoreCase(cli.getRut())) {
			
			   for (Auto auto : autos) {
				   if(auto.getResponsable().getRut().equalsIgnoreCase(rut) && auto.isConMantenimiento() == false) {
					System.out.println("Se ha eliminado el auto (PPU): "+auto.getPpu());
					autos.remove( auto );
				   }
			   }
			   System.out.printf("Se ha eliminado el cliente: %s %n%n", cli.getNombre()+" "+cli.getApellido());
			   clientes.remove(cli);
			   break;
		   }
	   }		
	}
	
	private static void agregarMantencion() {
		
		System.out.println("AUTOS REGISTRADOS: \n================================================================================");
		System.out.println("Patente  ||   Dueño         ||   Marca      ||   Modelo        ||   Año        ||");
		System.out.println("================================================================================");
		
		for (Auto auto : autos){
			System.out.print(""+auto.getPpu()+"   ||");
			System.out.print("  "+auto.getResponsable().getNombre()+" "+auto.getResponsable().getApellido()+"  ||");
			System.out.print("  "+auto.getMarca()+"     ||");
			System.out.print("  "+auto.getModelo()+"    ||");
			System.out.print("  "+auto.getAñoFabricacion()+"      ||\n");
			
		}
		System.out.println("================================================================================\n");
		
		scanner.nextLine(); 
		System.out.println("Ingrese patente del auto en mantencion");
		String patenteMantencion = scanner.nextLine();
		
		Auto autoMantencion = null;
		for(Auto auto : autos) {
			if(patenteMantencion.equalsIgnoreCase(auto.getPpu())) {
				autoMantencion = auto;
			}
		}
		
		System.out.println("Ingrese tipo de mantencion realizada");
		String tipoMantencion = scanner.nextLine();
		
		System.out.println("Ingrese observaciones");
		String observacionesMantencion = scanner.nextLine();
		
		System.out.println("Escriba monto cobrado");
		int montoMantencion = scanner.nextInt(); 
		
		Mantencion mantencion = new Mantencion( tipoMantencion, observacionesMantencion, montoMantencion, autoMantencion );
		mantenciones.add(mantencion);
			
	}

	private static void detalleMantenciones() {
		System.out.println("DETALLE DE MANTENCIONES: \n================================================================================");
		System.out.println("Patente  ||   Dueño        ||   Mantencion  ||    Observaciones    ||   Monto  ||");
		System.out.println("================================================================================\n");
	
	
		for(Mantencion mantencion : mantenciones) {
			System.out.print(""+mantencion.getAuto().getPpu()+"   ||");
			System.out.print("  "+mantencion.getAuto().getResponsable().getNombre()+" "+mantencion.getAuto().getResponsable().getApellido()+"    ||");
			System.out.print("  "+mantencion.getMantencionRealizada()+"   ||");
			System.out.print("  "+mantencion.getObservaciones()+"  ||");
			System.out.print("  "+mantencion.getMontoServicio()+"   ||\n");
		}
		System.out.println("================================================================================\n");
	}
	
	private static void verRecaudacion() {
		int recaudaciones   = 0;
		int autosMantenidos = 0;
			
			for(Mantencion mantencion : mantenciones) {
				recaudaciones = recaudaciones + mantencion.getMontoServicio();
				autosMantenidos++;
			}
			System.out.printf("Recaudaciones totales: $ %d%n"
							+ "N° de autos atendidos:   %d %n%n",recaudaciones,autosMantenidos);		
	}
	
	private static void verClientes() {
		System.out.println("\nInforme de Clientes\n=======================================");
		
		for (Cliente cliente : clientes) {		
			System.out.printf("NOMBRE CLIENTE   : %s %s%n"
							+ "RUT CLIENTE      : %s%n"
							+ "FONO CLIENTE     : %s%n"
							+ "CORREO CLIENTE   : %s%n"
							+ "FECHA INGRESO    : %s%n"
							+ "AUTOS REGISTRADOS: %n=======================================",
							cliente.getNombre(), cliente.getApellido(),
							cliente.getRut(),
							cliente.getFono(),
							cliente.getCorreo(),
							cliente.getFecha());
			
			System.out.println(cliente.autosCliente());
		}	
	}
	
	private static int menu() {
		
		System.out.println("\nMENU APP MYCAR \n======================================");
		System.out.println("1. AGREGAR CLIENTE ");
		System.out.println("2. ELIMINAR CLIENTE ");
		System.out.println("3. AGREGAR MANTENCION ");
		System.out.println("4. DETALLE DE MANTENCIONES ");
		System.out.println("5. VENTAS RECAUDADAS");
		System.out.println("6. VER CLIENTES");
		System.out.println("7. SALIR ");
		System.out.println("======================================\n");
		System.out.println("Seleccione su opción");
				        
		try {	
 			int opcionSeleccionada = scanner.nextInt();
 			return opcionSeleccionada;
		} catch( InputMismatchException ime ) {
			System.out.println("Debe ingresar los datos solicitados!!!");
		}
 		return 0;				
				
	}
	

}
