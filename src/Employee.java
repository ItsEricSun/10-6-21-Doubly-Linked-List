
public class Employee {
	String name;
	String department;
	int salary;
	
	public Employee(String n, String d, int s) {
		name = n;
		department = d;
		salary = s;
	}
	
	public String toString() {
		return ("Name: " + name + "\nDepartment: " + department + "\nSalary: $" + salary + "\n\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
