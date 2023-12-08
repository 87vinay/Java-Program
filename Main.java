import java.util.*;

enum QuestionType {
    MULTIPLE_CHOICE,
    TRUE_FALSE
}

class Question {
    private String questionText;
    private QuestionType questionType;
    private List<String> options;
    private String correctAnswer;

    public Question(String text, QuestionType type, List<String> options, String correctAnswer) {
        this.questionText = text;
        this.questionType = type;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println(q.getQuestionText());
            if (q.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
                List<String> options = q.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                String correctAnswer = q.getCorrectAnswer();
                if (options.get(userChoice - 1).equalsIgnoreCase(correctAnswer)) {
                    score++;
                }
            } else if (q.getQuestionType() == QuestionType.TRUE_FALSE) {
                System.out.println("Enter 'true' or 'false' (or 't'/'f'): ");
                String userAnswer = scanner.nextLine().toLowerCase();

                if (userAnswer.equals("true") || userAnswer.equals("t")) {
                    userAnswer = "true";
                } else if (userAnswer.equals("false") || userAnswer.equals("f")) {
                    userAnswer = "false";
                } else {
                    System.out.println("Invalid input. Skipping question...");
                    continue;
                }

                if (userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                    score++;
                }
            }
        }

        scanner.close();
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        Question q1 = new Question("Which keyword is used in Java to define a constant?", QuestionType.MULTIPLE_CHOICE,
                Arrays.asList( "const", "final", "static", "let"), "final");

        Question q2 = new Question("Java supports multiple inheritance.", QuestionType.TRUE_FALSE, null, "false");

        Quiz quiz = new Quiz();
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        quiz.conductQuiz();
    }
}
