
package a222_skip1103_project;

import java.util.*;
public class Millionare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuestionLifeline game = new QuestionLifeline();
        EditData edit = new EditData();
        
        Menu menu = new Menu();
        //Question question = new Question(question, answers, correctAnswerIndex, award);
        Score score = new Score();
        
        int currentWinnings = 0;
        int lifelineCount = 1;

        System.out.println("Welcome to Who Wants To Be A Millionaire!");

        List<Lifeline> lifelines = game.getLifelines();
            System.out.print("Enter your Name = ");
            System.out.println("");
            String name = sc.next() + sc.nextLine();
            
        for (int i = 1; i <= 9; i++) {
            QuestionCoding currentQuestion = game.getRandomQuestion();
            
            System.out.println("");
            System.out.println("Question " + i + ":");
            System.out.println(currentQuestion.getQuestion());
            String[] answers = currentQuestion.getAnswers();
            for (int j = 0; j < answers.length; j++) {
                System.out.println(answers[j]);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer (1-" + answers.length + "): ");
            int answerIndex = scanner.nextInt() - 1;
            System.out.println("");

            if (answerIndex == currentQuestion.getCorrectAnswerIndex()) {
                currentWinnings += currentQuestion.getAward();
                System.out.println("Correct! You've won RM" + currentWinnings);
            } else {
                System.out.println("Wrong answer! Game over. You've won RM" + currentWinnings);
                break;
            }

            if (lifelineCount <= lifelines.size()) {
                System.out.print("Do you want to use a lifeline? (yes/no): ");
                String useLifeline = scanner.next().toLowerCase();

                if (useLifeline.equals("yes")) {
                    Lifeline lifeline = lifelines.get(lifelineCount - 1);
                    if (!lifeline.isUsed()) {
                        System.out.println("Lifeline: " + lifeline.getName() + " - " + lifeline.getDescription());
                        lifeline.setUsed(true);
                        lifelineCount++;
                    } else {
                        System.out.println("You have already used that lifeline.");
                    }
                }
            }
        }
    }
}
