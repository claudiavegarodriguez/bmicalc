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

public class IMCHospitalPROXY implements IMCStats{
	
	private final BMICalcImpl bmicalc = BMICalcImpl.getSingletonInstance();
	

	public IMCHospitalPROXY() {
		
	}
	@Override
	public double alturaMedia() {
		return bmicalc.alturaMedia();
	}

	@Override
	public double pesoMedio() {
		return bmicalc.pesoMedio();
	}

	@Override
	public double imcMedio() {
		return bmicalc.imcMedio();
	}

	@Override
	public int numPacientes() {
		return bmicalc.numPacientes();
	}

}
