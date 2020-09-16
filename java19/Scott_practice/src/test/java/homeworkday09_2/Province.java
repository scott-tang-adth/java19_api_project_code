package homeworkday09_2;

public class Province {
	private String name;
	private String capital;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Province [name=" + name + ", capital=" + capital + "]";
	}

}
