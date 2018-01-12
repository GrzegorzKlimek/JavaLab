package wwsis.wypozyczalnia.model;

public class Car {
	private static int globalID = 0;
	String model;
	int yearOfProcution;
	int course;
	int cariD;
	
	public Car() {
		cariD = globalID;
		globalID ++;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearOfProcution() {
		return yearOfProcution;
	}
	public void setYearOfProcution(int yearOfProcution) {
		this.yearOfProcution = yearOfProcution;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	public int getCariD() {
		return cariD;
	}
	public void setCariD(int cariD) {
		this.cariD = cariD;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Car ").append("id=").append(cariD);
		stringBuilder.append(" model= ").append(model);
		stringBuilder.append(" produced in ").append(yearOfProcution);
		stringBuilder.append(" with course ").append(course);
		return stringBuilder.toString();
		
	}

}
