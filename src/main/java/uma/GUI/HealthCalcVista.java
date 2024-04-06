package uma.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

import javax.swing.JTextField;

public class HealthCalcVista {

	private JFrame frame;
	private JTextField WeightValue;
	private JTextField HeightValue;
	private JTextField IdealWeightResults;
	private JTextField BMRResults;
	private JButton MaleButton;
	private JButton FemaleButton;
	private JSpinner AgeValue;
	private JButton CalcBMR;
	private JButton CalcIdealWeight;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcVista window = new HealthCalcVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HealthCalcVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 246, 247));
		frame.setBounds(100, 100, 745, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 73, 84));
		panel.setBounds(10, 11, 248, 548);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Health Calculator");
		lblNewLabel.setForeground(new Color(249, 246, 247));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
		lblNewLabel.setBounds(24, 11, 202, 66);
		panel.add(lblNewLabel);
		
		JLabel lblKeepYourBody = new JLabel("Keep your body at glance");
		lblKeepYourBody.setForeground(new Color(249, 246, 247));
		lblKeepYourBody.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblKeepYourBody.setBounds(34, 63, 180, 66);
		panel.add(lblKeepYourBody);
		
		JLabel GenderLabel = new JLabel("Gender");
		GenderLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GenderLabel.setBounds(285, 31, 88, 29);
		frame.getContentPane().add(GenderLabel);
		
		// Botones de Género
		MaleButton = new JButton("Male");
		FemaleButton = new JButton("Female");
		
		MaleButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		MaleButton.setBounds(337, 76, 121, 36);
		frame.getContentPane().add(MaleButton);
		
		FemaleButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		FemaleButton.setBounds(532, 76, 121, 36);
		frame.getContentPane().add(FemaleButton);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblAge.setBounds(285, 123, 88, 29);
		frame.getContentPane().add(lblAge);
		
		AgeValue = new JSpinner();
		AgeValue.setFont(new Font("SansSerif", Font.PLAIN, 13));
		AgeValue.setBounds(427, 151, 135, 36);
		frame.getContentPane().add(AgeValue);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblWeight.setBounds(285, 204, 88, 29);
		frame.getContentPane().add(lblWeight);
		
		WeightValue = new JTextField();
		WeightValue.setBounds(427, 229, 135, 36);
		frame.getContentPane().add(WeightValue);
		WeightValue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(583, 234, 49, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblHeight.setBounds(285, 280, 88, 29);
		frame.getContentPane().add(lblHeight);
		
		HeightValue = new JTextField();
		HeightValue.setColumns(10);
		HeightValue.setBounds(427, 308, 135, 36);
		frame.getContentPane().add(HeightValue);
		
		JLabel lblNewLabel_1_1 = new JLabel("cm");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(583, 313, 49, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		// Botones Cálculo de IdealWeight y BasalMR
		CalcIdealWeight = new JButton("Calculate Ideal Weight");
		CalcBMR = new JButton("Calculate Basal MR");
		CalcBMR.setFont(new Font("SansSerif", Font.PLAIN, 13));
		CalcBMR.setBounds(532, 371, 173, 55);
		frame.getContentPane().add(CalcBMR);
		CalcIdealWeight.setFont(new Font("SansSerif", Font.PLAIN, 13));
		CalcIdealWeight.setBounds(285, 371, 173, 55);
		frame.getContentPane().add(CalcIdealWeight);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(158, 118, 143));
		panel_1.setBounds(268, 438, 453, 10);
		frame.getContentPane().add(panel_1);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblResults.setBounds(285, 457, 88, 29);
		frame.getContentPane().add(lblResults);
		
		IdealWeightResults = new JTextField();
		IdealWeightResults.setColumns(10);
		IdealWeightResults.setBounds(285, 497, 121, 36);
		frame.getContentPane().add(IdealWeightResults);
		
		BMRResults = new JTextField();
		BMRResults.setColumns(10);
		BMRResults.setBounds(532, 497, 121, 36);
		frame.getContentPane().add(BMRResults);
		
		JLabel lblNewLabel_1_2 = new JLabel("kg");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(416, 502, 49, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("kcal/day");
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(656, 502, 49, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	public JTextField getWeightValue() {
		return WeightValue;
	}

	public JTextField getHeightValue() {
		return HeightValue;
	}

	public JTextField getIdealWeightResults() {
		return IdealWeightResults;
	}

	public JTextField getBMRResults() {
		return BMRResults;
	}

	public JButton getMaleButton() {
		return MaleButton;
	}

	public JButton getFemaleButton() {
		return FemaleButton;
	}

	public JSpinner getAgeValue() {
		return AgeValue;
	}

	public JButton getCalcBMR() {
		return CalcBMR;
	}

	public JButton getCalcIdealWeight() {
		return CalcIdealWeight;
	}
	
	public void registrarControlador(ActionListener ctrl) {
		CalcBMR.addActionListener(ctrl);
		CalcBMR.setActionCommand("getBMR");
        
		CalcIdealWeight.addActionListener(ctrl);
		CalcIdealWeight.setActionCommand("getIdealW");
        
		MaleButton.addActionListener(ctrl);
		MaleButton.setActionCommand("maleButton");
        
		FemaleButton.addActionListener(ctrl);
		FemaleButton.setActionCommand("femaleButton");
	}
	
	public void setBMRResults(float res) {
		BMRResults.setText(String.valueOf(res));
	}
	
	public void setIdealWResults(float res) {
		IdealWeightResults.setText(String.valueOf(res));
	}
	
	public void invalidInputsIdealWError(String errCode) {
		JOptionPane.showMessageDialog(frame,
				errCode,
                "Ingrese números válidos para la altura y género",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void invalidInputsBMR(String errCode) {
		JOptionPane.showMessageDialog(frame,
                errCode,
                "Ingrese números válidos para la altura, peso, género y edad",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void noInputsErr() {
		JOptionPane.showMessageDialog(frame,
                "Debe rellenar los campos necesarios antes de calcular",
                "Ha sucedido un error",
                JOptionPane.ERROR_MESSAGE);
	}
	
	
}
