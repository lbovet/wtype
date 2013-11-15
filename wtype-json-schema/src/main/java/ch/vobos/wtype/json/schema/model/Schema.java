package ch.vobos.wtype.json.schema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Laurent Bovet (laurent.bovet@windmaster.ch)
 */
public class Schema {
    public String id;
    public String title;
    public final List<Schema> schemas = new ArrayList<Schema>();
    public Type type;
}
