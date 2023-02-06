package questions;

public class TrueFalse extends AbstractQuestion {

    public TrueFalse(String question, String answer) {
        this.question = question;
        this.answer = answer;

        if (this.answer != "True" && this.answer != "False") {
            throw new IllegalArgumentException("Only True or False is accepted");
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

    public int compare(MultipleSelect multipleselect) {
        return 1;
    }

    public int compare(MultipleChoice multiplechoice) {
        return 1;
    }

    public int compare(TrueFalse truefalse) {
        return 0;
    }
}
