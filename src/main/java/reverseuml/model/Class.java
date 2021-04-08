package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Class {
    private String name;
    private Attribute[] attributes;
    private Method[] methods;
    private Class parentClass;
    private Class interfaceClass;
    private boolean isInterface;
    private boolean isStatic;
    private String visibility;

    public Class() {}
}
