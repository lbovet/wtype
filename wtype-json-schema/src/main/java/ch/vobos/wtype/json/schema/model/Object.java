package ch.vobos.wtype.json.schema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class Object extends Type {
    public final List<Property> properties = new ArrayList<Property>();
}
