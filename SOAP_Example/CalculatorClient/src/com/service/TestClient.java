package com.service;

public class TestClient {
	public static void main(String[] args) throws Exception {
		
		java.net.URL eod = new	java.net.URL("http://localhost:8081/CalculatorService/services/CalService");
		
		org.apache.axis.client.Service service  = new org.apache.axis.client.Service();
		
		CalServiceSoapBindingStub stub = new CalServiceSoapBindingStub(eod,service);
		
		int result = stub.add(9, 9);
		System.out.println(result);
		
		
		
	}
}
