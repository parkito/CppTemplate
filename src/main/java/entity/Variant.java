package entity;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class Variant {

    private long id;
    private Question question;
    private String variantText;
    private String answerField;
    private boolean variantIsCorrect;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getVariantText() {
        return variantText;
    }

    public void setVariantText(String variantText) {
        this.variantText = variantText;
    }

    public String getAnswerField() {
        return answerField;
    }

    public void setAnswerField(String answerField) {
        this.answerField = answerField;
    }

    public boolean isVariantIsCorrect() {
        return variantIsCorrect;
    }

    public void setVariantIsCorrect(boolean variantIsCorrect) {
        this.variantIsCorrect = variantIsCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variant variant = (Variant) o;

        if (id != variant.id) return false;
        if (variantIsCorrect != variant.variantIsCorrect) return false;
        if (question != null ? !question.equals(variant.question) : variant.question != null) return false;
        if (variantText != null ? !variantText.equals(variant.variantText) : variant.variantText != null) return false;
        return answerField != null ? answerField.equals(variant.answerField) : variant.answerField == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (variantText != null ? variantText.hashCode() : 0);
        result = 31 * result + (answerField != null ? answerField.hashCode() : 0);
        result = 31 * result + (variantIsCorrect ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "id=" + id +
                ", question=" + question +
                ", variantText='" + variantText + '\'' +
                ", answerField='" + answerField + '\'' +
                ", variantIsCorrect=" + variantIsCorrect +
                '}';
    }

}
