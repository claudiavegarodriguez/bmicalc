/* Copyright [yyyy] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class IMCHospitalAdapter {
	

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
	
	public Map<Double, String> imc2(double altura, double peso) {
		Double bmi_valor = bmi(altura, peso);
		String categoria = category(bmi_valor);
		Map<Double, String> res= new HashMap<Double, String>(); 
		res.put(bmi_valor, categoria);
		return res;
	}


	public boolean tieneObesidadAbdominal2(char genero, double circunferencia) {
		boolean tieneObe = abdominalObesity(circunferencia, genero);
		return tieneObe;
	}

	

}
