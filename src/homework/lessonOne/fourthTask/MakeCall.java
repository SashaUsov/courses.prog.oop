package homework.lessonOne.fourthTask;

public class MakeCall {

    public static void main(String[] args) {

        Phone phoneOne = new Phone("+3212345");

        Phone phoneTwo = new Phone("+3954897486");

        /*
        Register phoneOne in the network. Must return true
        * */
        System.out.println(phoneOne.registrationInNetwork() + "\n");

        /*
        Attempt to call the number without registering with the network
        * In this case must return message "The number you dialed is not registered on the network!"
        * */
        System.out.println(phoneOne.phoneCall(phoneTwo) + "\n");

        /*
        * Attempting to call from a non-registered number
        * In this case must return message "Your number is not registered on the network!"
        * */
        System.out.println(phoneTwo.phoneCall(phoneOne) + "\n");

        /*
        * Register phoneTwo in the network. Must return true
        * */
        System.out.println(phoneTwo.registrationInNetwork() + "\n");

        /*
        * Call from phoneOne to phoneTwo
        * In this case must return messages "Call in progress..."
        * and "Phone +3954897486 you have an incoming call from +3212345"
        * */
        System.out.println(phoneOne.phoneCall(phoneTwo) + "\n");

        /*
        * Call from phoneTwo to phoneOne
        * In this case must return messages "Call in progress..."
        * and "Phone +3212345 you have an incoming call from +3954897486"
        * */
        System.out.println(phoneTwo.phoneCall(phoneOne) + "\n");

        /*
        * Attempt to call yourself
        * In this case must return message "You can't call yourself :("
        * */
        System.out.println(phoneOne.phoneCall(phoneOne));
    }
}
