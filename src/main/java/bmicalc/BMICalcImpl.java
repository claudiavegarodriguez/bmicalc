package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class BMICalcImpl implements BMICalc, IMCHospital, IMCStats, IMCHospitalStrategy {
	
	private double alturaMedia, pesoMedio, imcMedio;
	private int numPacientes;
	private static BMICalcImpl bmicalcimpl;
	
	private BMICalcImpl() {
		this.bmicalcimpl = new BMICalcImpl();
	}
	
	public static BMICalcImpl getSingletonInstance() {
		if(bmicalcimpl == null) {
			bmicalcimpl = new BMICalcImpl();
		} else {
			System.out.println("No se puede crear el objeto " + bmicalcimpl + "Porque ya existe un objeto de la clase BMICalcImpl");
		}
		return bmicalcimpl;
	}

	public double bmi(double mass, double height) {
		if (mass <= 0 || height <= 0) {
			throw new ArithmeticException("Values cannot be a zero or a negative number");
		}
		double bmi = mass / (Math.pow(height, 2));
		return bmi;
	}

	public String category(double bmi){
		if (bmi == 0 || bmi < 0) {
			throw new RuntimeException("BMI cannot be a zero or a negative number");
		}
		if (bmi < 18.5) {
			return "UNDERWEIGHT";
		} else if(bmi > 18.5 && bmi < 24.9) {
			return "NORMAL";
		} else if(bmi > 25.0 && bmi < 29.9) {
			return "OVERWEIGHT";
		} else {
			return "OBESE";
		}
	}

	public boolean abdominalObesity(double waistCircumference, char gender) {
		if (gender != 'F' && gender != 'M') {
			throw new IllegalArgumentException("That value is not possible");
		}
		if (waistCircumference > 80 && gender == 'F') {
			return true;
		} else if (waistCircumference > 90 && gender == 'M'){
			return true;
		} else {
			return false;
		}
		
	}

	
	@Override 
	public BMICalcImpl clone() {
		try {
			throw new CloneNotSupportedException();
		} catch (CloneNotSupportedException ex) {
			System.out.println("No se puede clonar un objeto de la clase BMICalcImpl");
		}
		return null;
	}

	@Override
	public double alturaMedia() {
		return alturaMedia;
	}

	@Override
	public double pesoMedio() {
		return pesoMedio;
	}

	@Override
	public double imcMedio() {
		return imcMedio;
	}

	@Override
	public int numPacientes() {
		return numPacientes;
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Double bmi_valor = bmi(altura, peso);
		String categoria = category(bmi_valor);
		Map<Double, String> res= new HashMap<Double, String>(); 
		res.put(bmi_valor, categoria);
		return res;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		boolean tieneObe = abdominalObesity(circunferencia, genero);
		return tieneObe;
	}

	@Override
	public String VersionStrategy(double peso, double altura) {
		if (peso <= 0 || altura <= 0) {
			throw new ArithmeticException("Los valores no pueden ser ceros  o un número negativo");
		}
		double bmi = peso / (Math.pow(altura, 2));
		return "El resultado del BMI es: " +bmi;
	}

}
