package uma.GUI;

import java.awt.EventQueue;

import uma.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();
					HealthCalcVista vista = new HealthCalcVista();
					Controlador controlador = new Controlador(healthCalc, vista);
					vista.registrarControlador(controlador);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}