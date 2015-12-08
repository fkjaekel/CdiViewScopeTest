package com.testcase.cdiviewscopetest;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.apache.myfaces.test.base.AbstractViewControllerTestCase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


/**
 * @author fjaekel
 */
public class EjbContainerTest extends AbstractViewControllerTestCase
{
	protected EJBContainer		container;

	public EjbContainerTest()
	{
		super(EjbContainerTest.class.getSimpleName());
	}

	public EjbContainerTest(final String name)
	{
		super(name);
	}

	@Override
	@BeforeClass
	public void setUp() throws Exception
	{
		super.setUp();

		container = createEjbContainer();
	}

	private EJBContainer createEjbContainer()
	{
		final Properties properties = new Properties();
		properties.setProperty("openejb.embedded.remotable", "true");
		properties.setProperty("openejb.autocreate.jta-datasource-from-non-jta-one", "false");
		properties.setProperty("openejb.validation.output.level", "VERBOSE");
		properties.setProperty("log4j.category.OpenEJB.options", "DEBUG");

		return EJBContainer.createEJBContainer(properties);
	}

	@BeforeMethod
	public void inject() throws NamingException
	{
		if(container != null)
		{
			container.getContext().bind("inject", this);
		}
	}

	@AfterClass
	public void close() throws Exception
	{
		super.tearDown();

		if(container != null)
		{
			container.close();
			container = null;
		}
	}
}
