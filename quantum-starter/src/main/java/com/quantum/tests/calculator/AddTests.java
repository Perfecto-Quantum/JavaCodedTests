package com.quantum.tests.calculator;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.CalculatorPage;

public class AddTests extends WebDriverTestCase {

	@SuppressWarnings("unlikely-arg-type")
	@QAFDataProvider(dataFile = "src/main/resources/data/testData.csv")
	@Test(groups = { "regression" })
	public void addTest(Map<Integer, Integer> data) {
		CalculatorPage cp = new CalculatorPage();

		cp.startApp("Calculator");
		cp.clearCalculator();
		cp.addInto(data.get("int1"), data.get("int2"));
		cp.resultShouldBe(data.get("result"));
	}

}
