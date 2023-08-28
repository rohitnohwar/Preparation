package rohit.nohwar.lld.structuralpatterns.adapterpattern.objectadapterpattern;

// Adaptee
public class Employee {
    private String name;
    private String jobTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
