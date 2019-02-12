package com.gov.ssn.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WsConfig extends WsConfigurerAdapter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/service/*");
	}

	@Bean(name = "federalSsnDetails")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ssnSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("IndvDetailsPort");
		wsdl11Definition.setLocationUri("/service/ssn-details");
		wsdl11Definition.setTargetNamespace("http://www.usa.gov/ssn/types");
		wsdl11Definition.setSchema(ssnSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema ssnSchema() {
		return new SimpleXsdSchema(new ClassPathResource("federal-ssn.xsd"));
	}

}
