public class GradeRater {
    public double total;
    public double score;

    public GradeRater(double total, double score)
    {
        this.total = total;
        this.score = score;
    }

    public void calculateRate()
    {
        double rate = score/total * 100;
        System.out.println("Rate is : " + rate);
    }
}
