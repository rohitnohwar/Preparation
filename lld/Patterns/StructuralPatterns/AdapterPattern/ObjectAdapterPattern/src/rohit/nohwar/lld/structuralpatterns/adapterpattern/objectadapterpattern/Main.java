package rohit.nohwar.lld.structuralpatterns.adapterpattern.objectadapterpattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("sdfghj");
        employee.setJobTitle("ertfghbjn");
        EmployeeObjectAdapter adapter = new EmployeeObjectAdapter(employee);

        System.out.println(adapter.getFullName());
        System.out.println(adapter.getJobDesignation());
    }
}