package reverseuml.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CustomClass {
    private String name;
    private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    private ArrayList<Method> methods = new ArrayList<Method>();
    private CustomClass parentClass;
    private CustomClass interfaceClass;
    private boolean isInterface;
    private boolean isStatic;
    private String visibility;

    public CustomClass() {}

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void addMethod(Method method) {
        methods.add(method);
    }
}
