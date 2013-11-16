package ch.vobos.wtype.json.schema.formatter;

import org.junit.Test;

import ch.vobos.wtype.json.schema.model.ObjectType;
import ch.vobos.wtype.json.schema.model.Schema;

public class FormatterTest {

	@Test
	public void testSimpleFormat() {
		Formatter formatter = new Formatter();
		Schema schema = new Schema();
		schema.id="test";
		schema.title="Test Schema";
		schema.type = new ObjectType();
		
		System.out.println(formatter.format(schema));
	}	
	
}
