package example;

public class Dog extends Animal{
    
    private String color;

	public Dog(boolean veg, String food, int legs) {
		super(veg, food, legs);
		this.color="Brown";
	}

	public Dog(boolean veg, String food, int legs, String color){
		super(veg, food, legs);
		this.color=color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
}
