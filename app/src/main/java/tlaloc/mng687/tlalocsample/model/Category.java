package tlaloc.mng687.tlalocsample.model;

import java.io.Serializable;

/**
 * Created by mng687 on 2/21/15.
 */
public class Category implements Serializable {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category " + getId() + ": " + getName() + "\n" + getDescription();
    }
}
