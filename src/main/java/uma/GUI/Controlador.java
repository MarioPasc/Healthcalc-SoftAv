package uma.GUI;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import uma.Gender;
import uma.HealthCalcImpl;


public class Controlador implements ActionListener{

	private Gender gender = null;
	private int height = 0;
	private int age = 0;
	private float weight = 0;
	private HealthCalcImpl calculadora = HealthCalcImpl.getInstance();
	private HealthCalcVista vista;
	
	public Controlador(HealthCalcImpl calc, HealthCalcVista gui) {
		this.calculadora = calc;
		this.vista = gui;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
			case "maleButton":
				vista.getMaleButton().setBackground(new Color(244, 182, 194));
				vista.getFemaleButton().setBackground(Color.WHITE);
				gender = Gender.MALE;
				break;
			case "femaleButton":
				vista.getFemaleButton().setBackground(new Color(244, 182, 194));
				vista.getMaleButton().setBackground(Color.WHITE);
				gender = Gender.FEMALE;
				break;
			case "getBMR":
				try {
					height = Integer.parseInt(vista.getHeightValue().getText());
					weight = Float.parseFloat(vista.getWeightValue().getText());
					age = (Integer) vista.getAgeValue().getValue();
					
					try {
						float bmr = this.calculadora.basalMetabolicRate(weight, height, gender, age);
			            vista.setBMRResults(bmr);
					} catch (Exception e1) {
						vista.invalidInputsBMR(e1.getMessage());
					}
				} catch (Exception e0) {
					vista.noInputsErr();
				}
				break;
			case "getIdealW":	
				try {
					height = Integer.parseInt(vista.getHeightValue().getText());
					
					try {
						float idealWeight = this.calculadora.idealWeight(height, gender);
			            vista.setIdealWResults(idealWeight);
					} catch (Exception e1) {
						vista.invalidInputsIdealWError(e1.getMessage());
					} 
					
				} catch (Exception e0) {
					vista.noInputsErr();
				}
				break;
				
		}
	}

}
