package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Method {
    private String name;
    private String access; // Replace with enum
    private boolean isStatic;
    private String returnType; // Replace with enum
    private Argument[] arguments;

    public Method() {}
}
