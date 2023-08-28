package rohit.nohwar.lld.structuralpatterns.adapterpattern.classadapterpattern;

// Adapter
public class EmployeeClassAdapter extends Employee implements Customer{
    public String getFullName() {
        return this.getName();
    }

    public String getJobDesignation() {
        return this.getJobTitle();
    }
}
