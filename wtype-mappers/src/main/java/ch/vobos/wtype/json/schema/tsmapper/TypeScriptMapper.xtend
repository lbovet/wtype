package ch.vobos.wtype.json.schema.tsmapper;

import ch.vobos.typescript.Declaration
import ch.vobos.typescript.PredefinedType
import ch.vobos.typescript.PredefinedTypeEnum
import ch.vobos.typescript.PropertySignature
import ch.vobos.typescript.TypeMember
import ch.vobos.typescript.TypeReference
import ch.vobos.typescript.Typescript
import ch.vobos.wtype.json.schema.model.BooleanSchemaType
import ch.vobos.wtype.json.schema.model.NumberSchemaType
import ch.vobos.wtype.json.schema.model.ObjectSchemaType
import ch.vobos.wtype.json.schema.model.PrimitiveSchemaType
import ch.vobos.wtype.json.schema.model.Property
import ch.vobos.wtype.json.schema.model.Schema
import ch.vobos.wtype.json.schema.model.SchemaType
import ch.vobos.wtype.json.schema.model.StringSchemaType
import java.util.Map
import ch.vobos.typescript.InterfaceOrClassDeclaration

/**
 * Maps ch.vobos.typescript.model to ch.vobos.wtype.json.schema.model. 
 *  
 * @author Michael Vorburger
 */
public class TypeScriptMapper {

	val Map<InterfaceOrClassDeclaration, ObjectSchemaType> map = newHashMap

	def Schema map(Typescript typeScript) {
		val Declaration rootInterface = typeScript.interfacesAndClasses.head
		new Schema() => [
			id = rootInterface.declaration.name
			type = map(rootInterface.declaration)
		]		
	}
	
	def ObjectSchemaType map(InterfaceOrClassDeclaration tsDeclaration) {
		if (!map.containsKey(tsDeclaration)) {
			val newObjectType = new ObjectSchemaType
			for (TypeMember member : tsDeclaration.objectType.members) {
				val property = mapPropertyToTypeMember(member as PropertySignature) // TODO later, when there are other subclasses of TypeMember than only PropertySignature, take off the "as" cast  
				if (property != null)
					newObjectType.properties.add(property)
			}
			map.put(tsDeclaration, newObjectType)
		}
		map.get(tsDeclaration)
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
	
	def dispatch PrimitiveSchemaType mapTypeToSchemaType(PredefinedType predefinedType) {
		switch predefinedType.predefinedType {
			case PredefinedTypeEnum.STRING : StringSchemaType.INSTANCE
			case PredefinedTypeEnum.BOOLEAN : BooleanSchemaType.INSTANCE
			case PredefinedTypeEnum.NUMBER : NumberSchemaType.INSTANCE
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
