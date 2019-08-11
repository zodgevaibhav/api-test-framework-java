package com.openvz.api_test.template_holder;

public abstract class TemplateUpdator {

	public abstract String getTemplateDirectory();
	{
		System.out.println("Updating templateFiles from directory "+getTemplateDirectory());
	}
}
