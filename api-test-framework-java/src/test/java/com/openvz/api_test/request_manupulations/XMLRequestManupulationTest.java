package com.openvz.api_test.request_manupulations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XMLRequestManupulationTest {
	
	@Test
	public void verifyFormatingFunction()
	{
		String formatedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note>\r\n" + 
				"  <to>Tove</to>\r\n" + 
				"  <from>Jani</from>\r\n" + 
				"  <heading>Reminder</heading>\r\n" + 
				"  <body>Don'tforgetmethisweekend!</body>\r\n" + 
				"</note>";
		XMLRequestManupulation reqManupulation = new XMLRequestManupulation();
		System.out.println(reqManupulation.formatRequest("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don'tforgetmethisweekend!</body></note>"));
	}
	
//	@Test
	public void verifyFormatingFunctionForIncorrectXML()
	{
		XMLRequestManupulation reqManupulation = new XMLRequestManupulation();
		try {
		reqManupulation.formatRequest("note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don'tforgetmethisweekend!</body></note>");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void verifygGetNodeFunctionReturnNodeValue()
	{
		String formatedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note>\r\n" + 
				"  <to>Tove</to>\r\n" + 
				"  <from>Jani</from>\r\n" +
				"  <from>Jani1</from>\r\n" + 
				"  <heading>Reminder</heading>\r\n" + 
				"  <body>Don'tforgetmethisweekend!</body>\r\n" + 
				"</note>";
		XMLRequestManupulation reqManupulation = new XMLRequestManupulation();
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"/note/from"),"Jani");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"//from"),"Jani");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"//from[2]"),"Jani1");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"*//from"),"Jani");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"//*[text()='Jani']"),"Jani");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"//*[contains(text(),'Jan')]"),"Jani");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"//*[contains(text(),'Jan')][2]"),"Jani1");
	}

	//@Test
	public void verifygGetNodeFunctionReturnNodeValueIncorrectXpath()
	{
		String formatedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note>\r\n" + 
				"  <to>Tove</to>\r\n" + 
				"  <from>Jani</from>\r\n" +
				"  <from>Jani1</from>\r\n" + 
				"  <heading>Reminder</heading>\r\n" + 
				"  <body>Don'tforgetmethisweekend!</body>\r\n" + 
				"</note>";
		XMLRequestManupulation reqManupulation = new XMLRequestManupulation();
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"/notefrom"),"Jani");
	}
	
	@Test
	public void verifygUpdateNodeFunctionReturnNodeValue()
	{
		String formatedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note>\r\n" + 
				"  <to>Tove</to>\r\n" + 
				"  <from>Jani</from>\r\n" +
				"  <from>Jani1</from>\r\n" + 
				"  <heading>Reminder</heading>\r\n" + 
				"  <body>Don'tforgetmethisweekend!</body>\r\n" + 
				"</note>";
		
		XMLRequestManupulation reqManupulation = new XMLRequestManupulation();
		formatedXml = reqManupulation.updateNodeValue(formatedXml, "/note/from", "VaibhavZodge");
		Assert.assertEquals(reqManupulation.getNodeValue(formatedXml,"/note/from"),"VaibhavZodge");
	}
}
