package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleSelect extends AbstractQuestion {
    String[] options;
    public MultipleSelect(String question, String answer, String... options) {
        this.question = question;
        this.answer = answer;
        this.options = options;

        if (this.options.length <3 || this.options.length > 8) {
            throw new IllegalArgumentException("Enter at least 3 parameters up to 8");
        }

        String[] splitted_answer = this.answer.trim().split("\\s+");

        if (splitted_answer.length > this.options.length) {
            throw new IllegalArgumentException("answer not in option");
        }

    }


    @Override
    public String answer(String answer) {
        if (answer.trim().split("\\s+") == this.answer.trim().split("\\s+")) {
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

    public int compare(MultipleSelect multipleselect) {
        return 0;
    }

    public int compare(MultipleChoice multiplechoice) {
        return -1;
    }
    public int compare(TrueFalse truefalse) {
        return -1;
    }
}
