
package stepDefinitions;

import pageObjects.LifeInsurance_PO;

public class LifeInsurance_StepDef extends LifeInsurance_PO {

	public static void main(String[] args) {
		LifeInsurance_PO.driver();

		LifeInsurance_PO.windowMax();

		LifeInsurance_PO.header();

		LifeInsurance_PO.subHeader();

		LifeInsurance_PO.browserClose();
	}

}
