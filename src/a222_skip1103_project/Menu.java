
package a222_skip1103_project;

public class Menu {
    private char choice;
    
    public void displayRules(){
        System.out.println("-----");
        System.out.println("Rules");
        System.out.println("-----");
        System.out.println("After viewing a question, the contestant can leave the game with the\n" +
                           "money already won rather than attempting an answer.");
        System.out.println("");
        System.out.println("Each question will be displayed together with 4 different possible answers which only\n" +
                           "one has to be correct.");
        System.out.println("");
        System.out.println("There is no time limit to answer a question");
        System.out.println("");
        System.out.println("If the contestant answers a question incorrectly, then all of their winnings are lost,\n" +
                           "except that the RM1,000 and RM100,000 prizes are guaranteed: if a player gets a\n" +
                           "question wrong above these levels, then the prize drops to the previous\n" +
                           "guaranteed prize.");
        System.out.println("");
        System.out.println("The prizes are not cumulative. For example, answering the RM500 question gives\n" +
                           "the contestant RM500, not the previous RM100 plus RM500 (i.e. RM600).");
        System.out.println("");
        System.out.println("The game ends when the contestant answers a question incorrectly, decides not\n" +
                           "to answer a question, or answers all questions correctly.");
        System.out.println("");
        System.out.println("Lifelines: The system will provide the possibility of choosing “lifelines”: If at any point\n" +
                           "the contestant is unsure of the answer to a question, he or she can use one or more\n" +
                           "“lifelines’ which provide some form of assistance. After using a lifeline, the contestant\n" +
                           "2\n" +
                           "can either answer the question, use another lifeline, or walk away and keep the\n" +
                           "money. Each lifeline can only be used once per game.\n" +
                           "a) 50/50: The contestant asks the system to randomly eliminate two of the incorrect\n" +
                           "answer choices, leaving the contestant with a choice between the correct answer\n" +
                           "and one incorrect one.\n" +
                           "b) Ask the Audience: The contestant asks the system to simulate the audience's\n" +
                           "opinion on correct answers. The result shall reflect a predefined outcome with a\n" +
                           "distribution of answers over all four answer choices.");
    }
    public void menu(char choice){
        this.choice = choice;
    }
    public void displayHighestPrize(){
        System.out.println("");
    }
    
}
