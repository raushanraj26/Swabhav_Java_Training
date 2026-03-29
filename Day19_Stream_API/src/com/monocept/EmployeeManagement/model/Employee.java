package com.monocept.EmployeeManagement.model;

public class Employee {
private String empId;
private String name;
private String department;
private double salary;
private boolean activeStatus;

public Employee( String empId,String name, String department,double salary,Boolean activeStatus) {
	this.empId=empId;
	this.name=name;
	this.activeStatus=activeStatus;
	this.department=department;
	this.salary=salary;
	
	
}

public String getEmpId() {
    return empId;
}


public String getName() {
    return name;
}

public String getDepartment() {
    return department;
}


public double getSalary() {
    return salary;
}


public Boolean isActiveStatus() {
    return activeStatus;
}
@Override
public String toString() {
    return "Employee{" +
            "empId='" + empId + '\'' +
            ", name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", salary=" + salary +
            ", activeStatus=" + activeStatus +
            '}';
}

}
