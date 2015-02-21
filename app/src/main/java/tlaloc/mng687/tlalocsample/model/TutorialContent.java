package tlaloc.mng687.tlalocsample.model;

import java.io.Serializable;

/**
 * Created by mng687 on 2/21/15.
 */
public class TutorialContent implements Serializable {
    private int id;
    private int tutorial_id;
    private String name;
    private String image;
    private int sequence;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getTutorial_id() {
        return tutorial_id;
    }

    public void setTutorial_id(int tutorial_id) {
        this.tutorial_id = tutorial_id;
    }

    @Override
    public String toString() {
        return "TutorialContent " + getId() + "\n" + getName() + "\nSeq: " + getSequence();
    }
}
