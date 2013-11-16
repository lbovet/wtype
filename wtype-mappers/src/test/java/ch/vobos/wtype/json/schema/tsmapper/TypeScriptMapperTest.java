package ch.vobos.wtype.json.schema.tsmapper;

import java.io.IOException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import ch.vobos.typescript.Typescript;
import ch.vobos.typescript.standalone.TypeScriptStandalone;
import ch.vobos.wtype.json.schema.formatter.Formatter;
import ch.vobos.wtype.json.schema.model.Schema;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class TypeScriptMapperTest {

	private static TypeScriptStandalone typeScript;
	private TypeScriptMapper mapper = new TypeScriptMapper();
	
	@BeforeClass public static void beforeClass() {
		typeScript = TypeScriptStandalone.getInstance();
	}
	
	@Test
	public void testSimpleMapping() throws Exception {
		Typescript ts = typeScript.parseAndValidate(getResource("simple.ts"));
		Schema schema = mapper.map(ts);
		
		System.out.println(new Formatter().format(schema));
		// TODO use SchemaSerializer to stringify schema
		// TODO assertEquals(getResource("/simple.schema.json"), jsonSchemaString);
	}

	protected String getResource(String resourceName) throws IOException {
		URL url = Resources.getResource(resourceName);
		String ts = Resources.toString(url, Charsets.UTF_8);
		return ts;
	}

}
