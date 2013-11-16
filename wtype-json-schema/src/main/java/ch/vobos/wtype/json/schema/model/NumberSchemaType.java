package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class NumberSchemaType extends PrimitiveSchemaType {
	public static final PrimitiveSchemaType INSTANCE = new NumberSchemaType();
	
	private NumberSchemaType() {
	}	
	@Override
	public String getName() {
		return "number";
	}
}
