
package a222_skip1103_project;

public class QuestionCoding {
    private char choice;
    private String hint;
    private boolean valid;
    private String question;
    private String[] answers;
    private int correctAnswerIndex;
    private int award;
    
    public QuestionCoding(String question, String[] answers, int correctAnswerIndex, int award) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.award = award;
    }
    
        public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getAward() {
        return award;
    }

    public boolean validity(){
        return valid;
    }
    
}
