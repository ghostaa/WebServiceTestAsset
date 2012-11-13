package treateassimple.test;

public class BeanB {
	private String name = this.getClass().getSimpleName();

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
