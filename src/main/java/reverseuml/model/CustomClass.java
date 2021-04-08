package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomClass {
    private String name;
    private Attribute[] attributes;
    private Method[] methods;
    private CustomClass parentClass;
    private CustomClass interfaceClass;
    private boolean isInterface;
    private boolean isStatic;
    private String visibility;

    public CustomClass() {}
}
