package com.zwort.matahata.ws.client;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;

public class DupaPortFactoryBean extends JaxWsProxyFactoryBean {
	
	private TLSClientParameters tlsClientParameters;
	
	private boolean ignoreCn;
	
	private boolean https;

	@Override
	public Object create() {
		final Object proxy = super.create();
		
		if (ignoreCn && https) {
			final Client client = ClientProxy.getClient(proxy);
			final HTTPConduit http = (HTTPConduit) client.getConduit();
			http.setTlsClientParameters(tlsClientParameters);
		}
		return proxy;
	}
	
	//Spring setters
	
	public void setTlsClientParameters(TLSClientParameters tlsClientParameters) {
		this.tlsClientParameters = tlsClientParameters;
	}

	public void setIgnoreCn(boolean ignoreCn) {
		this.ignoreCn = ignoreCn;
	}

	public void setHttps(boolean https) {
		this.https = https;
	}

}
