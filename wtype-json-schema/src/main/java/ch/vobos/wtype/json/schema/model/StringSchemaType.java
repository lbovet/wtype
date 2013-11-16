package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class StringSchemaType extends SchemaType {

	public static final SchemaType INSTANCE = new StringSchemaType();
	
	private StringSchemaType() {
	}
	
	@Override
	public String getName() {
		return "string";
	}
	
}
