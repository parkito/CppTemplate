package com.karnov.crud.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
@Entity
public class Result implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double score;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Puzzle puzzle;

    //    @ElementCollection(fetch=FetchType.EAGER)
//    @CollectionTable(name = "Question", joinColumns = @JoinColumn(name = "questionId"))
//    @MapKeyColumn(name="question")
//    @Column(name = "mapValue")
//    @Column(nullable = false)
//    private Map<Question, Variant> rightAnswers = new HashMap<Question, Variant>();

    //    @ElementCollection(fetch=FetchType.EAGER)
//    @CollectionTable(name = "FOO_TABLE", joinColumns = @JoinColumn(name = "fooId"))
//    @MapKeyColumn(name="mapKey")
//    @Column(name = "mapValue")
//    @Column(nullable = false)
//    private Map<Question, Variant> mistakenAnswers = new HashMap<Question, Variant>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

//    public Map<Question, Variant> getRightAnswers() {
//        return rightAnswers;
//    }
//
//    public void setRightAnswers(Map<Question, Variant> rightAnswers) {
//        this.rightAnswers = rightAnswers;
//    }
//
//    public Map<Question, Variant> getMistakenAnswers() {
//        return mistakenAnswers;
//    }
//
//    public void setMistakenAnswers(Map<Question, Variant> mistakenAnswers) {
//        this.mistakenAnswers = mistakenAnswers;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (id != result.id) return false;
        if (Double.compare(result.score, score) != 0) return false;
        if (user != null ? !user.equals(result.user) : result.user != null) return false;
        return puzzle != null ? puzzle.equals(result.puzzle) : result.puzzle == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (puzzle != null ? puzzle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", score=" + score +
                ", user=" + user +
                ", puzzle=" + puzzle +
//                ", rightAnswers=" + rightAnswers +
//                ", mistakenAnswers=" + mistakenAnswers +
                '}';
    }

}
