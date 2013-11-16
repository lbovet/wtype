package ch.vobos.wtype.json.schema.model;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class ArrayType extends Type {
    Schema elementSchema;
	
    @Override
	public String getName() {
		return "array";
	}
}
