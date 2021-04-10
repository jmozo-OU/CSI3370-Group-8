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
    private String parentClass;
    private ArrayList<String> interfaceClasses = new ArrayList<String>();
    private boolean isInterface;
    private boolean isStatic;
    private String visibility;
    private boolean immutable;
    private boolean isAbstract;
    private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    private ArrayList<Method> methods = new ArrayList<Method>();

    public CustomClass() {}

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void addMethod(Method method) {
        methods.add(method);
    }

    public void addInterface(String interfaceName) {
        interfaceClasses.add(interfaceName);
    }
}
