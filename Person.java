class Person {
    String name;
    int yearOfBirth;
    int currentYear;

    Person(String name, int yearOfBirth, int currentYear) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.currentYear = currentYear;
    }

    int computeAge() {
        return currentYear - yearOfBirth;
    }
}
