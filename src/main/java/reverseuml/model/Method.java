package reverseuml.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Method {
    private String name;
    private String visibility; 
    private boolean isStatic;
    private boolean immutable;
    private boolean isAbstract;
    private String returnType; 
    private ArrayList<Argument> arguments = new ArrayList<Argument>();

    public Method() {}

    public void addArgument(Argument argument) {
        arguments.add(argument);
    }
}
