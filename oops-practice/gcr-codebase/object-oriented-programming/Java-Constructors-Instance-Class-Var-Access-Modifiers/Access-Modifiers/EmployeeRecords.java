// Section 3 – Problem 4: Employee Records
// Demonstrates: public employeeID, protected department, private salary

class Employee {
    public    int    employeeID;   // accessible everywhere
    protected String department;   // accessible in same package + subclasses
    private   double salary;       // accessible only within Employee

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary     = salary;
    }

    // Public getter for private salary
    public double getSalary() {
        return salary;
    }

    // Public setter – only valid way to modify private salary
    public void setSalary(double salary) {
        if (salary > 0)
            this.salary = salary;
        else
            System.out.println("Salary must be a positive value.");
    }

    public void display() {
        System.out.println("ID: " + employeeID
                         + " | Dept: " + department
                         + " | Salary: Rs." + salary);
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    // Manager-specific method to apply a bonus
    void giveBonus(double bonus) {
        if (bonus > 0) {
            setSalary(getSalary() + bonus);   // uses public getter/setter
            System.out.println("Bonus of Rs." + bonus
                             + " granted to Manager ID " + employeeID);
        } else {
            System.out.println("Bonus must be positive.");
        }
    }

    @Override
    public void display() {
        // employeeID → public    : directly accessible ✓
        // department → protected : accessible in subclass ✓
        // salary     → private   : NOT directly accessible, use getSalary() ✓
        System.out.println("Manager"
                         + " | ID: " + employeeID
                         + " | Dept: " + department
                         + " | Team: " + teamName
                         + " | Salary: Rs." + getSalary());
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        System.out.println("-- Employee --");
        Employee emp = new Employee(1001, "Engineering", 60000.0);
        emp.display();

        emp.setSalary(65000.0);   // public setter modifies private salary
        System.out.println("After Salary Revision:");
        emp.display();

        emp.setSalary(-100);      // invalid – prints error

        System.out.println("\n-- Manager (subclass) --");
        Manager mgr = new Manager(2001, "Operations", 90000.0, "Alpha Team");
        mgr.display();

        mgr.giveBonus(10000.0);
        mgr.display();
    }
}
