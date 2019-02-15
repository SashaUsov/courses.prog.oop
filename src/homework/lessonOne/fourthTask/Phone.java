package homework.lessonOne.fourthTask;

public class Phone {

    private String phoneNumber;

    /*
    * True if the number is registered on the network, otherwise - false
    * */
    private boolean registration;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
    * Registering the number in the network and assigning the result to the corresponding parameter
    * */
    public boolean registrationInNetwork() {

        if (Network.baseOfTelephoneNumbers.add(this.phoneNumber)) {

            return registration = true;

        } else {

            return registration = false;
        }
    }

    /*
    * Attempt to make a call.
    * Checks the registration in the network of dialing and dialed subscribers.
    * In case of its absence, displays the appropriate message.
    * Prevents attempts to call yourself
    * */
    public String phoneCall(Phone phone) {

        if (!registration) {

            return "Your number is not registered on the network!";

        } else if(phoneNumber.equals(phone.getPhoneNumber())) {

            return "You can't call yourself :(";

        } else {

            if (Network.baseOfTelephoneNumbers.contains(phone.getPhoneNumber())) {

                return "Call in progress..." + "\n" + phone.incomingCall(phoneNumber) + "\n";

            } else {

                return "The number you dialed is not registered on the network!";
            }
        }
    }

    public String incomingCall(String nomber) {

        return "Phone " + phoneNumber + " you have an incoming call from " + nomber;

    }
}
