package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractQuestion implements Question {
    protected String question;
    protected String answer;


    @Override
    public String getText() {
        return this.question;
    }
    @Override
    public abstract String answer(String answer);
    public abstract int compare(Likert likert);

    public abstract int compare(MultipleChoice multiplechoice);

    public abstract int compare(MultipleSelect multipleselect);

    public abstract int compare(TrueFalse truefalse);


}