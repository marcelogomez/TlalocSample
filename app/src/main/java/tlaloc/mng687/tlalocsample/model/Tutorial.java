package tlaloc.mng687.tlalocsample.model;

import java.io.Serializable;

/**
 * Created by mng687 on 2/21/15.
 */
public class Tutorial implements Serializable {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private TutorialContent[] tutorial_contents;
    private Category category;

    public TutorialContent[] getTutorial_contents() {
        return tutorial_contents;
    }

    public void setTutorial_contents(TutorialContent[] tutorial_contents) {
        this.tutorial_contents = tutorial_contents;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Tutorial " + getId() + ": " + getName() + "\nCategory: " + getCategory().getName() + "\n" + getDescription();
    }
}
