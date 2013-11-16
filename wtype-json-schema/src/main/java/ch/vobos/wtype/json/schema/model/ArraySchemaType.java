package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class ArraySchemaType extends SchemaType {
    SchemaType elementType;
	
    @Override
	public String getName() {
		return "array";
	}
}
