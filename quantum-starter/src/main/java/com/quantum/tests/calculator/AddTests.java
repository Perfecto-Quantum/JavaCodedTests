package com.quantum.tests.calculator;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.CalculatorPage;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

public class AddTests extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "src/main/resources/data/testData.csv")
	@Test(groups = { "regression" })
	public void addTest(Map<String, String> data) {
		CalculatorPage cp = new CalculatorPage();

		cp.startApp("Calculator");
		cp.clearCalculator();
		cp.addInto(Integer.parseInt(data.get("int1")), Integer.parseInt(data.get("int2")));
		cp.resultShouldBe(Integer.parseInt(data.get("result")));
	}

}
