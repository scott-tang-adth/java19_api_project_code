package homeworkday09_2;
import java.util.ArrayList;
import java.util.List;

public class Country {
	private String name;
	private List<Province> provinces = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", provinces=" + provinces + "]";
	}

	public static class ChinnaPlace {

		private String name;
		private String capital;

	 /*   public ChinnaPlace(String name, String capital) {
			this.name = name;
			this.capital = capital;
		}*/

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
			return "ChinnaPlace{" +
					"name='" + name + '\'' +
					", capital='" + capital + '\'' +
					'}';
		}
	}
}
