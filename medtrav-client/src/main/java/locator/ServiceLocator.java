package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
	private Context context;
	private Map<String, Object> map;

	private static ServiceLocator instance;

	public ServiceLocator() {
		try {
			context = new InitialContext();
			map = new HashMap<String, Object>();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public Object getProxy(String jndiNam) {
		Object proxy = null;
		proxy = map.get(jndiNam);
		if (proxy == null) {
			try {
				proxy = context.lookup(jndiNam);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			map.put(jndiNam, proxy);
		}

		return proxy;

	}

}
