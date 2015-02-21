package tlaloc.mng687.tlalocsample.model;

import java.io.Serializable;

/**
 * Created by mng687 on 2/21/15.
 */
public class Tip implements Serializable {
    private int id;
    private int category_id;
    private String content;
    private String image;
    private boolean shown;
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Tip " + id + ": " + getContent() + "\nCategory: " + getCategory().getName();
    }
}
