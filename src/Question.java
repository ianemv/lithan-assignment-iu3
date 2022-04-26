import java.util.List;

public class Question implements IQuestion{

    String question;
    List<String> options;
    String answer;

    public Question(){}

    public Question(String question, List<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public void display()
    {
        this.displayQuestion();
        this.showOptions();
    }

    private void displayQuestion()
    {
       System.out.println("Q: "+this.question);
    }

    private void showOptions()
    {
        int counter = 1;
        for(int i=0; i < this.options.stream().count()  ; i++ )
        {
          if(this.options.get(i).length() > 1){
            System.out.println( counter +" "+ this.options.get(i));
            counter++;
          }

        }
    }

    public void setOptions(List<String> options){
        this.options = options;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer(int index)
    {
        return this.options.get( index - 1).toString();
    }

    public String getAnswer()
    {
        return this.answer;
    }

    public boolean isAnswerCorrect(String userAnswer)
    {
        return  this.answer.equals(userAnswer);
    }
}
