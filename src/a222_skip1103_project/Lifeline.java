
package a222_skip1103_project;

public class Lifeline {
    private String name;
    private String description;
    private boolean used;

    public Lifeline(String name, String description) {
        this.name = name;
        this.description = description;
        this.used = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}


