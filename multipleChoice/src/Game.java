import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private ArrayList<Question> questionSet;
    public Game(){
        questionSet = new ArrayList<Question>();
        String q = "How many championships have the LA Lakers won?";
        String[] a = {"5","11","13","17"};
        questionSet.add(new Question(q, a, "17"));
        q = "Which NBA star has five MVP trophies?";
        a = new String[]{"Michael Jordan","Steve Nash","Kevin Durant",
            "Charles Barkley"};
        questionSet.add(new Question(q,a,"Michael Jordan"));
        q = "What city did the Atlanta Hawks used to play in?";
        a = new String[]{"St. Louis","Minneapolis","Memphis","Charlotte"};
        questionSet.add(new Question(q,a,"St. Louis"));
        Collections.shuffle(questionSet, new Random());
        }
    public void start(){
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        //show questions
        for (int question = 0; question < questionSet.size(); question++){
            System.out.println(questionSet.get(question).getQuestion());
            int numChoices = questionSet.get(question).getChoices().size();
            for (int choice = 0; choice < numChoices; choice++){
                System.out.println((choice + 1) + ": " + 
                        questionSet.get(question).getChoices().get(choice));
            }
            int playerAnswer = scan.nextInt();
            ArrayList<String> choiceSet = questionSet.get(question).getChoices();
            String correctAnswer = questionSet.get(question).getAnswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
            if (playerAnswer == correctAnswerIndex + 1){
                numCorrect++;
            }
        }
        scan.close();
        System.out.println("You got" + numCorrect + " correct answer(s)");
    }
}
