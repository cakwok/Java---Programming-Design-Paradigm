package questions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestQuestion {
    private Question questionaire;

    //@org.junit.Test
    @Test(expected = IllegalArgumentException.class)
    public void Test_MultipleChoice() {
        Question questionaire;
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

        questionaire = new MultipleSelect("Which of these are included in the Bill " + "of Rights?",
                "1 4", "Freedom of speech", "Freedom to not pay taxes",
                "Freedom to travel anywhere in the world",
                "Right against unreasonable searches and seizures");

        assertEquals("Which of these are included in the Bill " + "of Rights?", questionaire.getText());
        assertEquals("Correct", questionaire.answer("1 4"));
        assertEquals("Correct", questionaire.answer("1   4"));
        assertEquals("Incorrect", questionaire.answer("4 1"));
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

    @Test
    public void testQuestionOrdering() {
        List<Question> questions = new ArrayList<>();
        Question f = new MultipleSelect("Which of these are included in the Bill " + "of Rights?",
                "1 4", "Freedom of speech", "Freedom to not pay taxes",
                "Freedom to travel anywhere in the world",
                "Right against unreasonable searches and seizures");
        questions.add(f);

        Question h = new Likert("Assignment 2 was an easy assignment.");
        questions.add(h);

        Question a = new TrueFalse(
                "Did you test to verify that increasing the speed " + "beyond the limit does not work?",
                "True");
        questions.add(a);

        Question c = new MultipleChoice(
                "Which one of these options accurately describes your experience in Assignment 2?", "1",
                "I wrote all my tests before my implementation", // option 1
                "I wrote some but not all tests before my implementation",
                // option 2
                "I tested a little, coded a little, and so on", // option 3
                "I wrote most of my implementation before I wrote tests"); // option 4
        questions.add(c);

        Question e = new MultipleSelect("What is one hour equal to? ", "1 3", // correct answer
                "60 minutes", "60 seconds", "3600 seconds", "half a day");
        questions.add(e);

        Question b = new TrueFalse("Did you test for the constructor throwing an "
                + "exception if the speed intervals for gears " + "did not overlap?", "True");
        questions.add(b);

        Question g = new Likert("I think PDP is a waste of time.");
        questions.add(g);

        Question d = new MultipleChoice("How flexible is your design to adding an extra gear?", // text
                "1", // correct option
                "Very flexible: very less or no code changes required", // option 1
                "Somewhat flexible: some code changes required", // option 2
                "Extensive code changes required"); // option 3
        questions.add(d);


        System.out.println("Before: \n" + questions.toString().replace(",", "\n"));

        Collections.sort(questions);

        System.out.println("After: \n" + questions.toString().replace(",", "\n"));

        assertEquals(b.getText(), questions.get(0).getText());
        assertEquals(a.getText(), questions.get(1).getText());
        assertEquals(d.getText(), questions.get(2).getText());
        assertEquals(c.getText(), questions.get(3).getText());
        assertEquals(e.getText(), questions.get(4).getText());
        assertEquals(f.getText(), questions.get(5).getText());
        assertEquals(h.getText(), questions.get(6).getText());
        assertEquals(g.getText(), questions.get(7).getText());
    }

}
