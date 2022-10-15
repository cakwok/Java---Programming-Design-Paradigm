package questions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestQuestion {
    private Question questionaire;

    //@org.junit.Test
    @Test(expected = IllegalArgumentException.class)
    public void Test_MultipleChoice() {
        questionaire = new MultipleChoice("How many hidden layers in the described CNN?", "1", "1", "2", "3", "7");
        assertEquals("How many hidden layers in the described CNN?", questionaire.getText());
        assertEquals("Correct", questionaire.answer("1"));
        assertEquals("Incorrect", questionaire.answer("7"));

        // test not enough number of arguments
        questionaire = new MultipleChoice("How many pooling layers in the CNN?", "8", "1", "9");

        // test options if start from 1
        questionaire = new MultipleChoice("How many pooling layers in the CNN?", "0", "0", "3", "9");

        // test answer not in options
        questionaire = new MultipleChoice("Which of the followings is composed of CNN?", "2", "1", "3", "4", "5");
    }

    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void Test_MultipleSelect() {
        Question questionaire;

        questionaire = new MultipleSelect("State the networks which composed of CNN.", "0 2 3",
                "Resnets", "Transformer", "Yolo", "UNET", "MLP");

        assertEquals("State the networks which composed of CNN.", questionaire.getText());
        assertEquals("Correct", questionaire.answer("0 2 3"));
        assertEquals("Correct", questionaire.answer("0   2   3"));
        assertEquals("Incorrect", questionaire.answer("0 1 3"));
        assertNotEquals("Incorrect", questionaire.answer("2 0 3"));
        assertNotEquals("Incorrect", questionaire.answer("3    2  0  "));
    }

    @org.junit.Test
    public void Test_Likert() {
        Question questionaire;
        questionaire = new Likert("Would you recommend our product to others?");

        assertEquals("Would you recommend our product to others?", questionaire.getText());
        assertEquals("Correct", questionaire.answer("1"));

        questionaire = new Likert("How would you rate the purchase experience?");
        assertNotEquals("Incorrect", questionaire.answer("3"));

        questionaire = new Likert("How would you rate the agent you have talk to?");
        assertEquals("Incorrect", questionaire.answer("7"));
    }

    @Test
    public void Test_TrueFalse() {
        Question questionaire;
        questionaire = new TrueFalse("Is logistics regression a deep network?", "False");
        assertEquals("Is logistics regression a deep network?", questionaire.getText());
        assertEquals("Incorrect", questionaire.answer("f"));
        assertEquals("Correct", questionaire.answer("False"));
        assertEquals("Incorrect", questionaire.answer("True"));
    }

    @org.junit.Test
    public void Test_sorting() {
        Question q1, q2, q3, q4, q5, q6;

        q1 = new Likert("How satisfied are you with the purchase?");
        q6 = new Likert("How satisfied are you with the purchase?");
        q2 = new MultipleSelect("State the networks which composed of CNN.", "0 2 3",
                "Resnets", "Transformer", "Yolo", "UNET", "MLP");
        q3 = new MultipleChoice("How many hidden layers in the described CNN?", "1", "1", "2", "3", "7");
        q4 = new Likert("How likely are you to recommend our product?");
        q5 = new TrueFalse("Is logistics regression a deep network?", "F");

        Question[] questionnaires = {q1, q2, q3, q4, q5, q6};
        Question[] ordered_questionnaires = {q5, q3, q2, q4, q1, q6};

        Arrays.sort(questionnaires);
        assertEquals(ordered_questionnaires, questionnaires);
    }



}
