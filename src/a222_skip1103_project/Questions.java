/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a222_skip1103_project;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import a222_skip1103_project.Player;
import a222_skip1103_project.HallOfFame;

public class Questions extends javax.swing.JFrame 
{
    private static Player newPlayer;
    private final HallOfFame lbf;
    private int[] correctAnswers = {0, 2, 1, 1, 0, 1, 3, 0, 1};
    private int[] prizes = {100, 500, 1000, 5000, 15000, 50000, 100000, 500000, 1000000};
    private int currentQuestionIndex = 0;
    private int currentPrize = 0;
    private boolean gameOver = false;
    private ButtonGroup answerGroup;
    private boolean[] lifelinesUsed;
    
        private String[] questions = {
        "What is an accessor method other form?",
        "What OOP characteristics that shows the essential details and hiding its complexity?",
        "_______ are a special kind of methods that are invoked to construct objects.",
        "class A\n"
        + "{\n"
        + "int i = 10 ;\n"
        + "}\n"
        + "class B extends A\n"
        + "{\n"
        + "int i = 20 ;\n"
        + "}\n"
        + "public class MainClass\n"
        + "{\n"
        + "public static void main (String [ ] args)\n"
        + "{\n"
        + "A a = new B ( );\n"
        + "System.out.println( a.i );\n"
        + "}\n"
        + "}",
        "What does the following output?\n"
        + "public class TestingConstructor\n"
        + "{\n"
        + "void TestingConstructor()\n"
        + "{\n"
        + "System.out.println(\"Amsterdam\");\n"
        + "}\n"
        + "TestingConstructor()\n"
        + "{\n"
        + "System.out.println(\"Antarctica\");\n"
        + "}\n"
        + "public static void main(String[] args) { TestingConstructor tc = new TestingConstructor();\n"
        + "}\n"
        + "}",
        "String colour;\n"
        + "colour = new String(“Blue”);\n"
        + "colour = new String(“Black”);\n"
        + "colour = new String(“Yellow”);\n"
        + "colour = new String(“Green”);\n"
        + "How many objects were created by the 5 statements above?\n"
        + "How many reference variables are there?",
        "public class StringExamples{ public class StringExamples{\n"
        + "public static void main(String [] args){\n"
        + "String word1 = \"I\"; //String word1=new String (\"I\");\n"
        + "String word2 = \"miss\"; //String word2=new String (\"miss\");\n"
        + "String word3 = \"you\"; //String word3=new String (\"you\");\n"
        + "String word4= word1 + word2 + word3;\n"
        + "System.out.println(\"substring: \"+word4.substring(1,8)); }//end main }//end class\n",
        "What will be the output of the following program? class A\n"
                + "{\n"
                + "String s = \"Class A\" ; }\n"
                + "class B extends A\n"
                + "{\n"
                + "String s = \"Class B\" ;\n"
                + "{\n"
                + "System.out.println(super.s) ;\n"
                + "}\n"
                + "}\n"
                + "class C extends B\n"
                + "{\n"
                + "String s = \"Class C\" ;\n"
                + "{\n"
                + "System.out.println(super.s) ;\n"
                + "} }\n"
                + "public class MainClass\n"
                + "{ public static void main (String [ ] args)\n"
                + "{\n"
                + "C c = new C ( );\n"
                + "System.out.println(c.s);\n"
                + "}\n"
                + "}",
        "What will be the output of the following program?\n"
        + "class W {\n"
        + "static int c= 0;\n"
        + " public static void main( String 1 args)\n"
        + "{\n"
        + "W w1 = c();\n"
        + "W w2 = c(w1);\n"
        + "W w3 = c(w2);\n"
        + "W w4 = c(w3);\n"
        + "} \n"
        + "private W()\n"
        + "{\n"
        + "System. out. println(\"c = \" +c);\n"
        + "}\n"
        + " static W c( )\n"
        + "{ \n"
        + "return c++ <= 0 ? new W() :null;\n"
        + "} \n"
        + "static W c(W w) { \n"
        + "return w.c++ ==1 ? new W( ) : null;"
    };

    private String[][] answers = {
        {"a) get", "b) set", "c) mutators", "d) setters"},
        {"a) Encapsulation", "b) Inheritance", "c) Abstraction", "d) Polymorphism"},
        {"a) Mutator", "b) Constructors", "c) Object", "d) Accessor"},
        {"a) 1", "b) 10", "c) 2", "d) 20"},
        {"a) Antarctica", "b) Amsterdam", "c) No output", "d) Compiler error"},
        {"a) 5 , 1", "b) 4 , 1 ", "c) 5 , 4", "d) 1 , 4"},
        {"a) I miss you", "b) I missyou", "c) I miss", "d) Missyou "},
        {"a) Class A\n Class B\n Class C", "b) Class B\n Class A\n Class C", "c) Class A\n Class C\n Class B", "d) Class C\n Class B\n Class A "},
        {"a) c=1\n c=2 \nc=3 \nc=4", "b) c=1\n c=2 ", "c) c=1\n c=2\n c=3", "d) Compilation error"}
    };
    
    public Questions(Player player) {
        shuffleQuestions();
        initComponents();
        Questions.newPlayer = player;
        this.lbf = new HallOfFame();
        showNextQuestion();

        // Initialize the lifelinesUsed array
        lifelinesUsed = new boolean[questions.length];
        for (int i = 0; i < lifelinesUsed.length; i++) {
            lifelinesUsed[i] = false;
        }
    }
    private void shuffleQuestions() {
        // Create a list of question indices
        List<Integer> questionIndices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionIndices.add(i);
        }

        // Shuffle the list using random numbers
        Collections.shuffle(questionIndices, new Random());

        // Create a new array to hold the shuffled questions and answers
        String[] shuffledQuestions = new String[questions.length];
        String[][] shuffledAnswers = new String[answers.length][answers[0].length];
        int[] shuffledCorrectAnswers = new int[correctAnswers.length];

        // Copy the questions, answers, and correct answers in the shuffled order
        for (int i = 0; i < questionIndices.size(); i++) {
            int index = questionIndices.get(i);
            shuffledQuestions[i] = questions[index];
            for (int j = 0; j < answers[0].length; j++) {
                shuffledAnswers[i][j] = answers[index][j];
            }
            shuffledCorrectAnswers[i] = correctAnswers[index];
        }

        // Update the original arrays with the shuffled questions, answers, and correct answers
        questions = shuffledQuestions;
        answers = shuffledAnswers;
        correctAnswers = shuffledCorrectAnswers;
    }
     private void showNextQuestion() {
        if (!gameOver) {
            if (currentQuestionIndex >= questions.length) {
                // Congratulations, you won the game!
                gameOver = true;
                JOptionPane.showMessageDialog(this, "Congratulations! You won RM1,000,000!");
                System.exit(0);
            } else {
                String question = questions[currentQuestionIndex];
                String[] currentAnswers = answers[currentQuestionIndex];

                // Update the GUI components with the new question and answers
                soalan.setText(question);
                jawapan1.setText(currentAnswers[0]);
                jawapan2.setText(currentAnswers[1]);
                jawapan3.setText(currentAnswers[2]);
                jawapan4.setText(currentAnswers[3]);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();
        soalan = new javax.swing.JTextField();
        BtnLifeline1 = new javax.swing.JButton();
        BtnLifeline2 = new javax.swing.JButton();
        jawapan2 = new javax.swing.JRadioButton();
        jawapan1 = new javax.swing.JRadioButton();
        jawapan3 = new javax.swing.JRadioButton();
        jawapan4 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submit.setBackground(new java.awt.Color(153, 153, 255));
        submit.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        submit.setForeground(new java.awt.Color(51, 51, 255));
        submit.setText("SUBMIT");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        soalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soalanActionPerformed(evt);
            }
        });
        getContentPane().add(soalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 760, 210));

        BtnLifeline1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        BtnLifeline1.setText("50/50");
        BtnLifeline1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLifeline1ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLifeline1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        BtnLifeline2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        BtnLifeline2.setText("ASK THE AUDIENCE");
        BtnLifeline2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLifeline2ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLifeline2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, -1, -1));

        jawapan2.setText("jRadioButton1");
        getContentPane().add(jawapan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 360, 50));

        jawapan1.setText("jRadioButton1");
        jawapan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jawapan1ActionPerformed(evt);
            }
        });
        getContentPane().add(jawapan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 370, 50));

        jawapan3.setText("jRadioButton1");
        getContentPane().add(jawapan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 370, 50));

        jawapan4.setText("jRadioButton1");
        getContentPane().add(jawapan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 360, 50));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a222_skip1103_project/backgrounf.jpg"))); // NOI18N
        jLabel29.setText("jLabel29");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soalanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soalanActionPerformed

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        if (!gameOver) {
            String selectedAnswer = getSelectedAnswer();

            int selectedAnswerIndex = -1;
            String[] currentAnswers = answers[currentQuestionIndex];
            for (int i = 0; i < currentAnswers.length; i++) {
                if (selectedAnswer.equals(currentAnswers[i])) {
                    selectedAnswerIndex = i;
                    break;
                }
            }

            if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
                // Correct answer
                currentPrize = prizes[currentQuestionIndex]; // Set the prize for the current question
                if (currentQuestionIndex == questions.length - 1) {
                    // Congratulations, you won the game!
                    gameOver = true;
                    JOptionPane.showMessageDialog(this, "Congratulations! You won RM" + currentPrize);
                    new HallOfFame().setVisible(true);
                    dispose();
                } else {
                    // Proceed to the next question
                    currentQuestionIndex++;
                    showNextQuestion();
                    JOptionPane.showMessageDialog(this, "Correct answer! You won RM" + currentPrize);
                }
            } else {
                // Wrong answer, game over
                gameOver = true;
                JOptionPane.showMessageDialog(this, "Sorry, wrong answer. You won RM" + currentPrize);
                new HallOfFame().setVisible(true);
                dispose();
            }

            // Reset the answer buttons after processing the click
            resetAnswerButtons();
        }
    }//GEN-LAST:event_submitMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void jawapan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jawapan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jawapan1ActionPerformed

    private void BtnLifeline1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLifeline1ActionPerformed
        // Call the fiftyFiftyLifeline method if the lifeline is available and not used yet
        if (!lifelinesUsed[currentQuestionIndex]) {
            lifeline1();
            lifelinesUsed[currentQuestionIndex] = true;
            BtnLifeline1.setEnabled(false);
        }
    }//GEN-LAST:event_BtnLifeline1ActionPerformed

    private void BtnLifeline2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLifeline2ActionPerformed
        // Call the lifeline2 method
        if (!lifelinesUsed[currentQuestionIndex]) {
            lifeline2();
            lifelinesUsed[currentQuestionIndex] = true;
            BtnLifeline2.setEnabled(false);
        }
    }//GEN-LAST:event_BtnLifeline2ActionPerformed

    private void lifeline1() {
        // Get the current question's answers
    String[] currentAnswers = answers[currentQuestionIndex];
    int correctAnswerIndex = correctAnswers[currentQuestionIndex];

    // Get the wrong answer index to remove
    int wrongAnswerIndexToRemove = getRandomWrongAnswerIndex(correctAnswerIndex);

    // Update the GUI to display only the remaining correct and wrong answers
    for (int i = 0; i < currentAnswers.length; i++) {
        if (i != correctAnswerIndex && i != wrongAnswerIndexToRemove) {
            currentAnswers[i] = "";
        }
    }

    // Update the answer buttons with the remaining answers
    jawapan1.setText(currentAnswers[0]);
    jawapan2.setText(currentAnswers[1]);
    jawapan3.setText(currentAnswers[2]);
    jawapan4.setText(currentAnswers[3]);
    }

   private int getRandomWrongAnswerIndex(int correctAnswerIndex) {
    Random random = new Random();
    int randomWrongAnswerIndex;

    do {
        randomWrongAnswerIndex = random.nextInt(4);
    } while (randomWrongAnswerIndex == correctAnswerIndex);

    return randomWrongAnswerIndex;
}

    private void lifeline2() {
        // Get the current question's index and question
        int questionIndex = currentQuestionIndex;
        String currentQuestion = questions[questionIndex];

        // Get the audience response for the current question
        String audienceResponse = getAudienceResponse(currentQuestionIndex);

        // Show the "ASK THE AUDIENCE" message
        StringBuilder message = new StringBuilder("ASK THE AUDIENCE : ");
        message.append(audienceResponse);

        // Show the audience response in a message dialog
        JOptionPane.showMessageDialog(this, message.toString(), "LIFELINE 2 (ASK THE AUDIENCE)", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getAudienceResponse(int questionIndex) {
        String audienceResponse = "";
        // Check the question and set the audience response accordingly
        if (questions[questionIndex].equals("What is an accessor method other form?")) {
            audienceResponse = "They are sometimes called \"getters\"";
        } else if (questions[questionIndex].equals("What OOP characteristics that shows the essential details and hiding its complexity?")) {
            audienceResponse = "It focuses upon the essential characteristics of object, relative to the perspective of the viewer.";
        } else if (questions[questionIndex].equals("_______ are a special kind of methods that are invoked to construct objects.")) {
            audienceResponse = "These methods have the same name as the class itself and are responsible for initializing the object's state when it is created.";
        } else if (questions[questionIndex].equals("class A\n"
                + "{\n"
                + "int i = 10 ;\n"
                + "}\n"
                + "class B extends A\n"
                + "{\n"
                + "int i = 20 ;\n"
                + "}\n"
                + "public class MainClass\n"
                + "{\n"
                + "public static void main (String [ ] args)\n"
                + "{\n"
                + "A a = new B ( );\n"
                + "System.out.println( a.i );\n"
                + "}\n"
                + "}")) {
            audienceResponse = "Pay attention to the concept of polymorphism and the relationship between the variable type and the actual object type when accessing the variable value.";
        } else if (questions[questionIndex].equals("What does the following output?\n"
                + "public class TestingConstructor\n"
                + "{\n"
                + "void TestingConstructor()\n"
                + "{\n"
                + "System.out.println(\"Amsterdam\");\n"
                + "}\n"
                + "TestingConstructor()\n"
                + "{\n"
                + "System.out.println(\"Antarctica\");\n"
                + "}\n"
                + "public static void main(String[] args) { TestingConstructor tc = new TestingConstructor();\n"
                + "}\n"
                + "}")) {
            audienceResponse = "The constructor with or without return type.";
        } else if (questions[questionIndex].equals("String colour;\n"
                + "colour = new String(“Blue”);\n"
                + "colour = new String(“Black”);\n"
                + "colour = new String(“Yellow”);\n"
                + "colour = new String(“Green”);\n"
                + "How many objects were created by the 5 statements above?\n"
                + "How many reference variables are there?")) {
            audienceResponse = "Maybe D?";
        } else if (questions[questionIndex].equals("public class StringExamples{\n"
                + "public static void main(String [] args){\n"
                + "String word1 = \"I\"; //String word1=new String (\"I\");\n"
                + "String word2 = \"miss\"; //String word2=new String (\"miss\");\n"
                + "String word3 = \"you\"; //String word3=new String (\"you\");\n"
                + "String word4= word1 + word2 + word3;\n"
                + "System.out.println(\"substring: \"+word4.substring(1,8)); }//end main }//end class\n"
                + "What is the output?")) {
            audienceResponse = "The parameter counts from zero";
        } else if (questions[questionIndex].equals("What will be the output of the following program? class A\n"
                + "{\n"
                + "String s = \"Class A\" ; }\n"
                + "class B extends A\n"
                + "{\n"
                + "String s = \"Class B\" ;\n"
                + "{\n"
                + "System.out.println(super.s) ;\n"
                + "}\n"
                + "}\n"
                + "class C extends B\n"
                + "{\n"
                + "String s = \"Class C\" ;\n"
                + "{\n"
                + "System.out.println(super.s) ;\n"
                + "} }\n"
                + "public class MainClass\n"
                + "{ public static void main (String [ ] args)\n"
                + "{\n"
                + "C c = new C ( );\n"
                + "System.out.println(c.s);\n"
                + "}\n"
                + "}")) {
            audienceResponse = "Maybe A?";
        } else if (questions[questionIndex].equals("What will be the output of the following program?\n"
        + "class W {\n"
        + "static int c= 0;\n"
        + " public static void main( String 1 args)\n"
        + "{\n"
        + "W w1 = c();\n"
        + "W w2 = c(w1);\n"
        + "W w3 = c(w2);\n"
        + "W w4 = c(w3);\n"
        + "} \n"
        + "private W()\n"
        + "{\n"
        + "System. out. println(\"c = \" +c);\n"
        + "}\n"
        + " static W c( )\n"
        + "{ \n"
        + "return c++ <= 0 ? new W() :null;\n"
        + "} \n"
        + "static W c(W w) { \n"
        + "return w.c++ ==1 ? new W( ) : null;")) {
            audienceResponse = "Maybe B?";
        }
        // Add responses for other questions in a similar manner

        return audienceResponse;

    }

    private String getSelectedAnswer() {
        if (jawapan1.isSelected()) {
            return jawapan1.getText();
        }
        if (jawapan2.isSelected()) {
            return jawapan2.getText();
        }
        if (jawapan3.isSelected()) {
            return jawapan3.getText();
        }
        if (jawapan4.isSelected()) {
            return jawapan4.getText();
        }
        return "";
    }

    private void resetAnswerButtons() {
        jawapan1.setSelected(false);
        jawapan2.setSelected(false);
        jawapan3.setSelected(false);
        jawapan4.setSelected(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questions(newPlayer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLifeline1;
    private javax.swing.JButton BtnLifeline2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JRadioButton jawapan1;
    private javax.swing.JRadioButton jawapan2;
    private javax.swing.JRadioButton jawapan3;
    private javax.swing.JRadioButton jawapan4;
    private javax.swing.JTextField soalan;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
