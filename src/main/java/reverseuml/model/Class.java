package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Class {
    private String name;
    private Attribute[] attributes;
    private Method[] methods;
    public Class parentClass;
    public Class interfaceClass;
    public boolean isInterface;
    public boolean isStatic;

    public Class() {}
}
