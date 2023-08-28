package rohit.nohwar.lld.structuralpatterns.adapterpattern.objectadapterpattern;

public class EmployeeObjectAdapter implements Customer{
    private Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    public String getFullName() {
        return employee.getName();
    }

    public String getJobDesignation() {
        return employee.getJobTitle();
    }
}
