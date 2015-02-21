package tlaloc.mng687.tlalocsample.model;

import java.io.Serializable;

/**
 * Created by mng687 on 2/21/15.
 */
public class Answer implements Serializable {
    private int id;
    private int question_id;
    private String answer;
    private boolean correct;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    @Override
    public String toString() {
        return "Answer " + getId() + ": " + getAnswer() + (isCorrect() ? "\nCorrect" : "Incorrect");
    }
}
