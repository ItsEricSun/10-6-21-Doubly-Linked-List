import java.util.ListIterator;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {

	static JFrame frm;
	DoublyLinkedList<Employee> employees = new DoublyLinkedList<>();
	ListIterator<Employee> it = employees.iterator();
	ListIterator<Employee> itEdit = employees.iterator();
	JTextArea outputArea;
	JButton addButton;
	JButton removeButton;
	JButton editButton;
	JButton addEmployeeButton;
	JButton removeEmployeeButton;
	JButton editInfoButton;
	JButton editEmployeeButton;
	JButton backButton;
	JButton backEditButton;
	JTextField nameField;
	JTextField departmentField;
	IntegerField salaryField;
	Employee temp;

	public void initMainMenu() {
		outputArea = addTextArea("", 1, 1, 1, 6);
		addButton = addButton("Add Employee", 7,1,1,1);
		removeButton = addButton("Remove Employee", 8,1,1,1);
		editButton = addButton("Edit Employee", 9,1,1,1);
	}

//
	public void mainMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 750);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 1, 6);
		addButton = addButton("Add Employee", 7,1,1,1);
		removeButton = addButton("Remove Employee", 8,1,1,1);
		editButton = addButton("Edit Employee", 9,1,1,1);
		frm.validate();
		updateList();
	}
//
	public void addMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 750);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		JLabel departmentLabel = addLabel("Department", 8,1,1,1);
		departmentField = addTextField("", 8,2,1,1);
		JLabel salaryLabel = addLabel("Salary", 9,1,1,1);
		salaryField = addIntegerField(0, 9,2,1,1);
		backButton = addButton("Back", 11,1,1,1);
		addEmployeeButton = addButton("Add Employee", 11,2,1,1);
		frm.validate();
		updateList();
	}
//
	public void removeMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 750);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backButton = addButton("Back", 8,1,1,1);
		removeEmployeeButton = addButton("Remove Employee", 8,2,1,1);
		frm.validate();
		updateList();
	}
//
	public void editMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 750);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backButton = addButton("Back", 8,1,1,1);
		editInfoButton = addButton("Edit Employee", 8,2,1,1);
		frm.validate();
		updateList();
	}
//
	public void editEmployeeMenu(Employee s) {
		frm.getContentPane().removeAll();
		frm.setSize(250, 750);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField(s.getName(), 7,2,1,1);
		JLabel departmentLabel = addLabel("Department", 8,1,1,1);
		departmentField = addTextField(s.getDepartment(), 8,2,1,1);
		JLabel salaryLabel = addLabel("Salary", 9,1,1,1);
		salaryField = addIntegerField(s.getSalary(), 9,2,1,1);
		backEditButton = addButton("Back", 11,1,1,1);
		editEmployeeButton = addButton("Edit Employee", 11,2,1,1);
		frm.validate();
		updateList();
	}

	public GUI() {
		employees.add(new Employee("e", "math", 20));
		employees.add(new Employee("a", "english", 200));
		employees.add(new Employee("n", "science", 60));
		initMainMenu();
		updateList();
		
	}

	public void buttonClicked(JButton buttonObj){
		if(buttonObj == backButton) {
			mainMenu();
			return;
		} 
		if(buttonObj == backEditButton) {
			editMenu();
			return;
		} else if(buttonObj == addButton) {
			addMenu();
			return;
		} else if(buttonObj == removeButton) {
			if(employees.getHead() == null) {
				messageBox("Error: No Employees");
				return;
			}
			removeMenu();
			return;
		} else if(buttonObj == editButton) {
			if(employees.getHead() == null) {
				messageBox("Error: No Employees");
				return;
			}
			editMenu();
			return;
		}
		else if (buttonObj == addEmployeeButton) {
			String name = nameField.getText();
			String department = departmentField.getText();
			int salary = salaryField.getNumber();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} else if(department.equals("")) {
				messageBox("Error: Please Enter Department");
				return;
			} else if(!salaryField.isValid()) {
				messageBox("Error: Please Make Sure Salary is Number");
				return;
			} 
			Employee s = new Employee(name, department, salary);
			employees.add(s);
			mainMenu();
			return;
		} else if (buttonObj == removeEmployeeButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			it = employees.iterator();
			while(it.hasNext()) {
				Employee s = it.next();
				if(s.getName().equals(name)) {
					it.remove();
					mainMenu();
					return;
				}
			}
			messageBox("Error: Employee Not Found");
			return;
		} else if (buttonObj == editInfoButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			itEdit = employees.iterator();
			while(itEdit.hasNext()) {
				Employee s = itEdit.next();
				if(s.getName().equals(name)) {
					editEmployeeMenu(s);
					return;
				}
			}
			messageBox("Error: Employee Not Found");
			return;
		} else if (buttonObj == editEmployeeButton) {
			String name = nameField.getText();
			String department = departmentField.getText();
			int salary = salaryField.getNumber();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} else if(department.equals("")) {
				messageBox("Error: Please Enter Department");
				return;
			} else if(!salaryField.isValid()) {
				messageBox("Error: Please Make Sure Salary is Number");
				return;
			} 
			Employee temp = new Employee(name, department, salary);
			itEdit.set(temp);
			mainMenu();
			return;
		}
	}

	public void updateList() {
		if(employees.getHead() == null) {
			outputArea.append ("No Employees");
		} else {
			it = employees.iterator();
			while(it.hasNext()) {
				outputArea.append(it.next().toString());
			}
		}
	}

	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Employees");
		frm.setSize(250, 750);
		frm.setVisible(true);
		
	}
}
