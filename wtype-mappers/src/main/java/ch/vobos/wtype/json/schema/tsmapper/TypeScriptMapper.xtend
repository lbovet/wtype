package ch.vobos.wtype.json.schema.tsmapper;

import ch.vobos.typescript.Typescript;
import ch.vobos.wtype.json.schema.model.Schema;

/**
 * Maps ch.vobos.typescript.model to ch.vobos.wtype.json.schema.model. 
 *  
 * @author Michael Vorburger
 */
public class TypeScriptMapper {

	def Schema map(Typescript typeScript) {
		val Schema schema = new Schema();
		
		return schema;
	}
	
}
