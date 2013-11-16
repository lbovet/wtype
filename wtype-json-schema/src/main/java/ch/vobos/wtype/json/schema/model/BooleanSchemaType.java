package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class BooleanSchemaType extends PrimitiveSchemaType {
	public static final PrimitiveSchemaType INSTANCE = new BooleanSchemaType();
	
	private BooleanSchemaType() {
	}

	@Override
	public String getName() {
		return "boolean";
	}
}
