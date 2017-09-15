package entity;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class Puzzle {

    private long id;
    private String title;
    private String explanation;
    private double weight;
    private List<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puzzle puzzle = (Puzzle) o;

        if (id != puzzle.id) return false;
        if (Double.compare(puzzle.weight, weight) != 0) return false;
        if (title != null ? !title.equals(puzzle.title) : puzzle.title != null) return false;
        return explanation != null ? explanation.equals(puzzle.explanation) : puzzle.explanation == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (explanation != null ? explanation.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", explanation='" + explanation + '\'' +
                ", weight=" + weight +
                ", questions=" + questions +
                '}';
    }

}
