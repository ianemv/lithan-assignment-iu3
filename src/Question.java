import java.util.List;

public class Question {

    String question;
    List<String> options;
    String answer;


    Question(String question, List<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public void display()
    {
        this.displayQuestion();
        this.displayOptions();
    }

    private void displayQuestion()
    {
       System.out.println(this.question);
    }

    private void displayOptions()
    {
        int counter = 1;
        for(int i=0; i < this.options.stream().count() ; i++ )
        {
          if(this.options.get(i).length() > 1){
            System.out.println( counter + this.options.get(i));
            counter++;
          }

        }
    }

    public void getAnswer(String question)
    {
        System.out.println("");
        System.out.println(question);
    }

    public String getAnswer()
    {
        return this.answer;
    }

    public boolean isAnswerCorrect(String[] userAnswer)
    {
        String[] tempArr;
        tempArr = this.answer.split(";");
       // if ()
        return  true;
    }
}
