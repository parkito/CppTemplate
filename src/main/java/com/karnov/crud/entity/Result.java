package com.karnov.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @JoinColumn(name = "personId", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "puzzleId", nullable = false)
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (id != result.id) return false;
        if (Double.compare(result.score, score) != 0) return false;
        if (person != null ? !person.equals(result.person) : result.person != null) return false;
        return puzzle != null ? puzzle.equals(result.puzzle) : result.puzzle == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (puzzle != null ? puzzle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", score=" + score +
                ", person=" + person +
                ", puzzle=" + puzzle +
                '}';
    }

}
