import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
	
	public Set<Class<?>> getClasses() {
		return getRestResourceClasses();
	}

	private Set<Class<?>> getRestResourceClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(ProdutoRest.class);
		return resources;
	}
}
