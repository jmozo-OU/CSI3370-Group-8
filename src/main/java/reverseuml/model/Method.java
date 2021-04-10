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
    private String visibility; // Replace with enum
    private boolean isStatic;
    private String returnType; // Replace with enum
    private ArrayList<Argument> arguments = new ArrayList<Argument>();

    public Method() {}

    public void addArgument(Argument argument) {
        arguments.add(argument);
    }
}
