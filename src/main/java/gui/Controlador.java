
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;

public class Controlador implements ActionListener{
	
	private BMIcalculator vista;
	private BMICalcImpl modelo;
	
	public Controlador(BMICalcImpl modelo, BMIcalculator vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("Calculate BMI")) {
			// Calcular bmi
			double a = vista.getInputHeight();
			double b = vista.getInputMass();
			double resultado = modelo.bmi(b,a);	
			vista.setResultadoBMI(resultado);
			
		} else if(comando.equals("Determine Category")) {
			//determinar categoria
			double a = vista.getInputHeight();
			double b = vista.getInputMass();
			double resultado = modelo.bmi(b,a);
			String categoria = modelo.category(resultado);
			vista.setResultadoCategory(categoria);
			
		} else {
			double a = vista.getInputWaistCircunference();
			char b = vista.ValideRadios();
			boolean resultado = modelo.abdominalObesity(a, b);
			String res = "";
			if (resultado == false) {
				res = "You don't have abdominal obesity";
			} else if (resultado == true) {
				res = "You have abdominal obesity";
			} else {
				throw new RuntimeException("Error");
			}
			vista.setResultadoAbdominalObesity(res);
			
		}
	}
	
	// para generar el jar, click derecho en el proyecto y run as maven install, para ejecutar el bicho, abrir cmd en la carpeta target y ejecutar 
	// desde ahi el .jar (subir a repo).  


}
