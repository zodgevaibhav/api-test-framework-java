package com.openvz.api_test.request_manupulations;

public interface IRequestManupulation {
	public String getNodeValue(String request, String path);
	public String updateNodeValue(String request, String path, String valueToUpdate);
	public String formatRequest(String request);

}
