package com.openvz.api_test.step_defs;

import com.openvz.api_test.template_holder.TemplateUpdator;

public class StudentTemplates extends TemplateUpdator {
	
public final static String basicTemplate= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note>\r\n" + 
		"  <to>Tove</to>\r\n" + 
		"  <from>Jani</from>\r\n" +
		"  <heading>Reminder</heading>\r\n" + 
		"  <body>Don'tforgetmethisweekend!</body>\r\n" + 
		"</note>";

@Override
public String getTemplateDirectory() {
	return "c:\\vaibhav\\zodge\\xml";
}
}
