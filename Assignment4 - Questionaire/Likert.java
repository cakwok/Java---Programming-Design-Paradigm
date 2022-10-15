package questions;

import java.util.List;

public class Likert extends AbstractQuestion {
    private static final List<String> choices = List.of("1", "2", "3", "4", "5");

    public Likert(String question) {
        this.question = question;
    }
    @Override
    public String answer(String answer) {
        if (choices.contains(answer)) {
            return "Correct";
        }
        return "Incorrect";
    }

    @Override
    public int compareTo(Question questionaire) {
        AbstractQuestion abstractquestion = (AbstractQuestion) questionaire;
        int value = abstractquestion.compare(this);
        if (value == 0) {
            return this.question.compareTo(questionaire.getText());
        }
        return value;
    }

    public int compare(Likert likert) {
        return 0;
    }

    public int compare(MultipleChoice multiplechoice) {
        return -1;
    }

    public int compare(MultipleSelect multipleselect) {
        return -1;
    }

    public int compare(TrueFalse truefalse) {
        return -1;
    }

}