package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoice extends AbstractQuestion {
    String[] options;
    public MultipleChoice(String question, String answer, String... options) {
        this.question = question;
        this.answer = answer;
        this.options = options;

        if (this.options.length <3 || this.options.length > 8) {
            throw new IllegalArgumentException("Enter at least 3 parameters up to 8");
        }

        if (Integer.parseInt(this.answer) > this.options.length) {
            throw new IllegalArgumentException("Choose an answer from the options");
        }

    }

    @Override
    public String answer(String answer) {
        if (answer == this.answer) {
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
        return 1;
    }

    public int compare(MultipleChoice multiplechoice) {
        return 0;
    }

    public int compare(MultipleSelect multipleselect) {
        return 1;
    }
    public int compare(TrueFalse truefalse) {
        return -1;
    }
}
