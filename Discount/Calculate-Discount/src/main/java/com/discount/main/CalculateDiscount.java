package com.discount.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.discount.model.FinalBillCalculation;

public class CalculateDiscount {

	public double DiscountCalculation(double amt, String customerType) throws DroolsParserException, IOException {
		CalculateDiscount droolsTest = new CalculateDiscount();
		FinalBillCalculation fb;
		fb = droolsTest.executeDrools(amt, customerType);
		double finalPrice = (fb.getAmount() - fb.getDiscountAmount());
		return (finalPrice);
	}

	public FinalBillCalculation executeDrools(double amt, String customerType)
			throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);

		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);
		FinalBillCalculation finalbill = new FinalBillCalculation();
		finalbill.setAmount(amt);
		finalbill.setCustomerType(customerType);
		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		workingMemory.insert(finalbill);
		workingMemory.fireAllRules();
		return finalbill;

	}

}
