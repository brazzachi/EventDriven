package org.example.semester_02.week_02;

public class ProbA1SecondChild {
    public String chooseName(String Father, String Mather, String Child1, String Gender) {
        String[] fatherNames = Father.split(" ");
        String[] motherNames = Mather.split(" ");
        String[] child1Names = Child1.split(" ");

        boolean isChild1Female = isFemale(child1Names[0]);
        boolean isSecondChildFemale = Gender.equals("Girl");

        if (isChild1Female != isSecondChildFemale) {
            if (isSecondChildFemale) {
                return reverseOrder(motherNames);
            } else {
                return reverseOrder(fatherNames);
            }
        } else {
            if (isSecondChildFemale) {
                return motherNames[0] + " " + child1Names[1];
            } else {
                return fatherNames[0] + " " + child1Names[1];
            }
        }
    }

    private boolean isFemale(String firstName) {
        char firstLetter = Character.toUpperCase(firstName.charAt(0));
        return firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I' || firstLetter == 'O' || firstLetter == 'U' || firstLetter == 'Y';
    }

    private String reverseOrder(String[] names) {
        return names[1] + " " + names[0];
    }
}
