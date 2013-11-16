package ch.vobos.wtype.json.schema.tsmapper;

import ch.vobos.typescript.InterfaceDeclaration
import ch.vobos.typescript.PredefinedType
import ch.vobos.typescript.PredefinedTypeEnum
import ch.vobos.typescript.PropertySignature
import ch.vobos.typescript.TypeMember
import ch.vobos.typescript.TypeReference
import ch.vobos.typescript.Typescript
import ch.vobos.wtype.json.schema.model.ObjectSchemaType
import ch.vobos.wtype.json.schema.model.Property
import ch.vobos.wtype.json.schema.model.Schema
import ch.vobos.wtype.json.schema.model.SchemaType
import ch.vobos.wtype.json.schema.model.StringSchemaType
import java.util.Map

/**
 * Maps ch.vobos.typescript.model to ch.vobos.wtype.json.schema.model. 
 *  
 * @author Michael Vorburger
 */
public class TypeScriptMapper {

	val Map<InterfaceDeclaration, ObjectSchemaType> map = newHashMap

	def Schema map(Typescript typeScript) {
		val InterfaceDeclaration rootInterface = typeScript.interfaces.head
		new Schema() => [
			id = rootInterface.name
			type = map(rootInterface)
		]		
	}
	
	def ObjectSchemaType map(InterfaceDeclaration tsInterface) {
		if (!map.containsKey(tsInterface)) {
			val newObjectType = new ObjectSchemaType
			for (TypeMember member : tsInterface.objectType.members) {
				val property = mapPropertyToTypeMember(member as PropertySignature) // TODO later, when there are other subclasses of TypeMember than only PropertySignature, take off the "as" cast  
				if (property != null)
					newObjectType.properties.add(property)
			}
			map.put(tsInterface, newObjectType)
		}
		map.get(tsInterface)
	}
	
	def dispatch Property mapPropertyToTypeMember(PropertySignature propertySignature) {
		val schemaType = mapTypeToSchemaType(propertySignature.type)
		if (schemaType == null)
			null
		else
			new Property() => [
				name = propertySignature.name
				// TODO optional = ???
				type = schemaType
			]
	}
	
	// TODO use new PrimitiveSchemaType instead of just SchemaType
	def dispatch SchemaType mapTypeToSchemaType(PredefinedType predefinedType) {
		switch predefinedType.predefinedType {
			case PredefinedTypeEnum.STRING : StringSchemaType.INSTANCE
			// TODO case PredefinedTypeEnum.BOOLEAN : BooleanSchemaType.INSTANCE
			// TODO case PredefinedTypeEnum.NUMBER : NumberSchemaType.INSTANCE
			default : null // means this will be skipped (see above)
		}
	}
	
	def dispatch SchemaType mapTypeToSchemaType(TypeReference predefinedType) {
		map(predefinedType.reference)
	}

//	def dispatch SchemaType mapTypeToSchemaType(TypeLiteral predefinedType) {
//		
//	}
	
}
