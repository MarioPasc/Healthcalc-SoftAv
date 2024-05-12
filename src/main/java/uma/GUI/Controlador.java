package uma.GUI;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import uma.Gender;
import uma.Person;
import uma.HealthCalcImpl;
import uma.PersonaEspecifica;


public class Controlador implements ActionListener{

	private Gender gender = null;
	private int height = 1;
	private int age = 1;
	private float weight = 1;
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
						Person persona = new PersonaEspecifica(weight, height, age, gender);
						double bmr = this.calculadora.basalMetabolicRate(persona);
			            vista.setBMRResults(bmr);
					} catch (NullPointerException e1) {
						vista.noInputGender();
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
						Person persona = new PersonaEspecifica(height, gender);
						double idealWeight = this.calculadora.getIdealBodyWeight(persona);
			            vista.setIdealWResults(idealWeight);
					} catch (NullPointerException e1) {
						vista.noInputGender();
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
