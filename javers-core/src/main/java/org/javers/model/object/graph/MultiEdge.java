package org.javers.model.object.graph;

import org.javers.model.mapping.Property;
import org.javers.model.visitors.Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * OneToMany or ManyToMany relation
 * @author bartosz walacik
 */
public class MultiEdge extends Edge {
    protected List<ObjectNode> references;

    public MultiEdge(Property property) {
        super(property);
        references = new ArrayList<>();
    }

    public List<ObjectNode> getReferences(){
        return Collections.unmodifiableList(references);
    }

    public void addReferenceNode(ObjectNode objectNode) {
        references.add(objectNode);
    }


    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);

        for(ObjectNode objectNode : references) {
            objectNode.accept(visitor);
        }

    }
}
