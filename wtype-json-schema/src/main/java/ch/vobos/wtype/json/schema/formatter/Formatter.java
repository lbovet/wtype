package ch.vobos.wtype.json.schema.formatter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import ch.vobos.wtype.json.schema.model.Schema;

import com.floreysoft.jmte.Engine;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class Formatter {

	public String format(Schema schema) {
		
		Engine engine = new Engine();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("schema", schema);
		URL url = Resources.getResource("json-schema.jmte");
		String template;
		try {
			template = Resources.toString(url, Charsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return engine.transform(template, model);
	}
	
}
