package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class StringSchemaType extends PrimitiveSchemaType {

	public static final PrimitiveSchemaType INSTANCE = new StringSchemaType();
	
	private StringSchemaType() {
	}
	
	@Override
	public String getName() {
		return "string";
	}
	
}
