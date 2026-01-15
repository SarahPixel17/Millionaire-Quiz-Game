
package a222_skip1103_project;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class QuestionLifeline {
    private List<QuestionCoding> questionPool;
    private List<Lifeline> lifelines;

    public QuestionLifeline() {
        questionPool = new ArrayList<>();
        lifelines = new ArrayList<>();

        // Populate the question pool with questions and answers
        questionPool.add(new QuestionCoding(
                "What is an accessor method other form?",
                new String[]{"a) get", "b) set", "c) mutators", "d) setters"},
                0,
                100
        ));

        questionPool.add(new QuestionCoding(
                "What OOP characteristics that shows the essential details and hiding its complexity?",
                new String[]{"a) Encapsulation", "b) Inheritance", "c) Abstraction", "d) Polymorphism"},
                0,
                500
        ));

        questionPool.add(new QuestionCoding(
                "________ are a special kind of methods that are invoked to construct objects.",
                new String[]{"a) Mutator", "b) Constructors", "c) Object", "d) Accessor"},
                1,
                1000
        ));
        questionPool.add(new QuestionCoding(
                "What will be the output of the following program? \nclass A\n" +
                "{\n" +
                "int i = 10 ;\n" +
                "}\n" +
                "class B extends A\n" +
                "{\n" +
                "int i = 20 ;\n" +
                "}\n" +
                "public class MainClass\n" +
                "{\n" +
                "public static void main (String [ ] args)\n" +
                "{\n" +
                "A a = new B ( );\n" +
                "System.out.println( a.i );\n" +
                "}\n" +
                "}",
                new String[]{"a) 1", "b) 10", "c) 2", "d) 20"},
                1,
                5000
        ));
        questionPool.add(new QuestionCoding(
                "What will be the output of the following program? \nclass A\n" +
                "{\n" +
                "int i = 10 ;\n" +
                "}\n" +
                "class B extends A\n" +
                "{\n" +
                "int i = 20 ;\n" +
                "}\n" +
                "public class MainClass\n" +
                "{\n" +
                "public static void main (String [ ] args)\n" +
                "{\n" +
                "A a = new B ( );\n" +
                "System.out.println( a.i );\n" +
                "}\n" +
                "}",
                new String[]{"a) 1", "b) 10", "c) 2", "d) 20"},
                1,
                5000
        ));
        questionPool.add(new QuestionCoding(
                "What does the following output? \npublic class TestingConstructor\n" +
                "{\n" +
                "void TestingConstructor()\n" +
                "{\n" +
                "System.out.println(\"Amsterdam\");\n" +
                "}\n" +
                "TestingConstructor()\n" +
                "{\n" +
                "System.out.println(\"Antarctica\");\n" +
                "}\n" +
                "public static void main(String[] args) { TestingConstructor tc = new TestingConstructor();\n" +
                "}\n" +
                "}",
                new String[]{"a) Antartica", "b) Amsterdam", "c) No output", "d) Compiler error"},
                0,
                15000
        ));
        questionPool.add(new QuestionCoding(
                "String colour;\n" +
                "colour = new String(“Blue”);\n" +
                "colour = new String(“Black”);\n" +
                "colour = new String(“Yellow”);\n" +
                "colour = new String(“Green”);\n"+
                "How many objects were created by the 5 statements above?\n" +
                "How many reference variables are there?",
                new String[]{"a) 5 , 1", "b) 4 , 1", "c) 5 , 4", "d) 1 , 4"},
                1,
                50000
        ));
        questionPool.add(new QuestionCoding(
                "public class StringExamples{\n" +
                "public static void main(String [] args){\n" +
                "String word1 = \"I\"; //String word1=new String (\"I\");\n" +
                "String word2 = \"miss\"; //String word2=new String (\"miss\");\n" +
                "String word3 = \"you\"; //String word3=new String (\"you\");\n" +
                "String word4= word1 + word2 + word3;\n" +
                "System.out.println(\"substring: \"+word4.substring(1,8)); }//end main }//end class\n" +
                "What is the output?",
                new String[]{"a) I miss you", "b) Imissyou", "c) I miss", "d) Missyou"},
                3,
                100000
        ));
        questionPool.add(new QuestionCoding(
                "What will be the output of the following program?\n" +
                "class A\n" +
                "{\n" +
                "String s = “Class A” ;\n" +
                "}\n" +
                "class B extends A\n" +
                "{\n" +
                "String s = “Class B” ;\n" +
                "{\n" +
                "System.out.println(super.s) ;\n" +
                "}\n" +
                "}\n" +
                "class C extends B\n" +
                "{\n" +
                "String s = “Class C” ;\n" +
                "{\n" +
                "System.out.println(super.s) ;\n" +
                "}\n" +
                "}\n" +
                "public class MainClass\n" +
                "{\n" +
                "public static void main (String [ ] args)\n" +
                "{\n" +
                "C c = new C ( );\n" +
                "System,out,println(c.s);\n" +
                "}\n" +
                "}",
                new String[]{"a) Class A \nClass B \nClass C", "b) Class B \nClass A \nClass C", "c) Class A \nClass C \nClass B", "d) Class C \nClass B \nClass A"},
                0,
                500000
        ));
         questionPool.add(new QuestionCoding(
                "What will be the output of the following program?\n" +
                "class W {\n" +
                "static int c= 0;\n" +
                "public static void main(String l args)\n" +
                "{\n" +
                "W w1 = c();\n" +
                "W w2 = c(w1);\n" +
                "W w3 = c(w2);\n" +
                "W w4 = c(w3);\n" +
                "}\n" +
                "private W()\n" +
                "{\n" +
                "System. out. println(\"c = \" +c);\n" +
                "}\n" +
                "static W c( )\n" +
                "{\n" +
                "return c++ <= 0 ? new W() :null;\n" +
                "}\n" +
                "static W c(W w) {\n" +
                "return w.c++ ==1 ? new W( ) : null;",
                new String[]{"a) c = 1 \nc = 2 \nc = 3 \nc = 4","", "b) c = 1 \nc = 2","", "c) c = 1 \nc = 2 \nc = 3","", "d) Compilation Error"},
                1,
                1000000
        ));
         //Extra Questions
         questionPool.add(new QuestionCoding(
                "Java method overloading implements the OOPS concept",
                new String[]{"a) Inheritance", "b) Encapsulation", "c) Polymorphism", "d) None"},
                2,
                100
        ));
         questionPool.add(new QuestionCoding(
                "How many of the following are legal declarations?\n" +
                "String lion[] = new String [] {\"lion\"};\n" +
                "String tiger [] = new String[1] {\"tiger\");\n" +
                "String bear [] = new String[] {};\n" +
                "String cat [] = new String [0] {};",
                new String[]{"a) None", "b) One", "c) Two", "d) Three"},
                2,
                15000
        ));
         questionPool.add(new QuestionCoding(
                "A ______ is blue print that defines certain states and behavior. It is simply a representation of\n" +
                "a different types of object.",
                new String[]{"a) object", "b) class", "c) characteristics", "d) attribute"},
                1,
                1000
        ));
         questionPool.add(new QuestionCoding(
                "Which of the following would successfully call a superclass constructor ?",
                new String[]{"a) superclass( );", "b) superclass(“parameter”);", "c) construct( );", "d) super( );"},
                3,
                5000
        ));
         questionPool.add(new QuestionCoding(
                "Creating an object is called ________.",
                new String[]{"a) Constructors", "b) Abstraction", "c) Inheritance", "d) Instantiation"},
                3,
                100000
        ));
         questionPool.add(new QuestionCoding(
                "What is the purpose of the javax.swing package?",
                new String[]{"a) Creating applets for the web", "b) General support", "c) Additional graphics capabilities", "d) Utilities"},
                2,
                500000
        ));

        // Add lifelines
        lifelines.add(new Lifeline("50/50", "The system will eliminate two incorrect answer choices."));
        lifelines.add(new Lifeline("Ask the Audience", "The system will simulate the audience's opinion on correct answers."));

        // Shuffle the question pool
        Random random = new Random();
        for (int i = questionPool.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            QuestionCoding temp = questionPool.get(i);
            questionPool.set(i, questionPool.get(j));
            questionPool.set(j, temp);
        }
    }

    public QuestionCoding getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questionPool.size());
        return questionPool.remove(index);
    }

    public List<Lifeline> getLifelines() {
        return lifelines;
    }
}

