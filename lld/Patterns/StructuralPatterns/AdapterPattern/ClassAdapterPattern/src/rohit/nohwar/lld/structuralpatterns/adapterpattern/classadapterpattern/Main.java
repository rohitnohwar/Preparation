package rohit.nohwar.lld.structuralpatterns.adapterpattern.classadapterpattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        adapter.setName("sdfghj");
        adapter.setJobTitle("ertfghbjn");

        System.out.println(adapter.getFullName());
        System.out.println(adapter.getJobDesignation());
    }
}