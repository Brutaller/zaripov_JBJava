package model;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
public enum Subjects {
    MATH(0),
    ENGLISH(1),
    SCINCE(2),
    PI(3),
    INFORMATIC(4);

    private int value;
    private Subjects(int value){
        this.value = value;
    }

    public static Subjects getSubject(int i){
        for (Subjects subject : values()) {
            if (subject.value == i){
                return subject;
            }
        }
        return null;
    }
}