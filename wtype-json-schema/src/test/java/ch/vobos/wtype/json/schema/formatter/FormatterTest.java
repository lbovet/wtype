package ch.vobos.wtype.json.schema.formatter;

import org.junit.Test;

import ch.vobos.wtype.json.schema.model.NumberType;
import ch.vobos.wtype.json.schema.model.ObjectType;
import ch.vobos.wtype.json.schema.model.Property;
import ch.vobos.wtype.json.schema.model.Schema;
import ch.vobos.wtype.json.schema.model.StringType;

public class FormatterTest {
	
	@Test
	public void testSimpleFormat() {
		Formatter formatter = new Formatter();
		Schema schema = new Schema();
		schema.id="test";
		schema.title="Test Schema";
		schema.type = new ObjectType();
		Property prop = new Property();
		prop.name = "hello";
		prop.type = new StringType();
		((ObjectType)schema.type).properties.add(prop);
		Property prop2 = new Property();
		prop2.name = "world";
		prop2.type = new NumberType();
		((ObjectType)schema.type).properties.add(prop2);
		
		System.out.println(formatter.format(schema));
	}	
	
}
