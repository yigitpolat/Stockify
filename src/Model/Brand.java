package Model;

/**
 * Created by berku on 7.12.2017.
 */
public class Brand {
    private int id;
    private String name;
    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
