package ch.vobos.wtype.json.schema.tsmapper;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import ch.vobos.typescript.Typescript;
import ch.vobos.typescript.standalone.TypeScriptStandalone;
import ch.vobos.wtype.json.schema.model.Schema;

public class TypeScriptMapperTest {

	private TypeScriptStandalone typeScript;
	private TypeScriptMapper mapper = new TypeScriptMapper();
	
	@BeforeClass public void beforeClass() {
		typeScript = TypeScriptStandalone.getInstance();
	}
	
	@Test
	public void testSimpleMapping() throws Exception {
		Typescript ts = typeScript.parseAndValidate(getResource("/simple.ts"));
		Schema schema = mapper.map(ts);
		
		// TODO use SchemaSerializer to stringify schema
		// TODO assertEquals(getResource("/simple.schema.json"), jsonSchemaString);
	}

	protected String getResource(String resourceName) throws IOException {
		URL url = Resources.getResource(resourceName);
		String ts = Resources.toString(url, Charsets.UTF_8);
		return ts;
	}

}
