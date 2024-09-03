package engine.core.services.output;

/**
 * @author o.le
 * @version 1.0
 * @since 2.0.0
 */
public class JsonPathHolder {

	private static boolean CHANGED = false;

	String path;

	JsonPathHolder(String path) {

		this.path = path;
	}

	public void setPath(String path) { 
		
		if (!CHANGED) {

			this.path = path;
			CHANGED = true;
		} 
	}
}
