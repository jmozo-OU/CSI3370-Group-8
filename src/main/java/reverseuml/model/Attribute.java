package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Attribute {
    private String name;
    private String visibility; 
    private boolean immutable;
    private String type; 
    private boolean isStatic;
    
    public Attribute() {}
}
