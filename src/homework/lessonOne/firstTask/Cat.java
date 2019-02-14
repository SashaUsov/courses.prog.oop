package homework.lessonOne.firstTask;

public class Cat {

    private String color;

    private String name;

    private String gender;

    private double age;

    private double tailLength;

    private double bodyLength;

    private double weight;

    private String eyeColor;

    public Cat() {
    }

    public Cat(String color, String name,
               String gender, double age,
               double tailLength, double bodyLength,
               double weight, String eyeColor
    ) {

        this.color = color;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tailLength = tailLength;
        this.bodyLength = bodyLength;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /*
    * General characteristic for all Cats
    * */
    public static String voice() {

        return "Meow meow";

    }

    /*
    * Briefly tells about your cat
    * */
    public String representationOfCat() {

        return "Your cat's name is " + name +
                ". He has fluffy " + color +
                " wool and big " + eyeColor + " eyes.";
    }

    /*Find out the length of your cat
    * */
    public String catSize() {

        return "The length of the cat without tail " + bodyLength +
                " cm. With the tail it will be slightly longer - " +
                (tailLength + bodyLength) + " cm";

    }

    /*
    * Ask the cat about age
    * */
    public String catAge() {

        if (age <= 1) {

            return "I'm very young";

        } else if (age < 5) {

            return "I'm in my prime";

        } else {

            return "I'm old and tired";
        }
    }

    /*
    * Ask the cat about weight
    * */
    public String askCatAboutWeight() {

        return "female".equals(gender) ? "The girl should be with a mystery" : name + " weighs " + weight + " kg";
    }

    @Override
    public String toString() {
        return "Cat info : " +
                "color -'" + color + '\'' +
                ", name-'" + name + '\'' +
                ", gender-'" + gender + '\'' +
                ", age= " + age +
                ", tailLength= " + tailLength +
                ", bodyLength= " + bodyLength +
                ", weight= " + weight +
                ", eyeColor-'" + eyeColor + '\'' +
                '.';
    }
}
