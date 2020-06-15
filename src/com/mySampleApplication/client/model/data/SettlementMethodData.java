package com.mySampleApplication.client.model.data;

import com.mySampleApplication.client.model.SettlementMethod;

import java.util.ArrayList;
import java.util.List;


public class SettlementMethodData {
	public static List<SettlementMethod> getSettlementMethods(){
		List<SettlementMethod> settlementMethods = new ArrayList<>();
		settlementMethods.add(new SettlementMethod("临时指定"));
		settlementMethods.add(new SettlementMethod("指定账期"));
		settlementMethods.add(new SettlementMethod("指定日期"));
		settlementMethods.add(new SettlementMethod("货到付款"));
		return settlementMethods;
	}
}
