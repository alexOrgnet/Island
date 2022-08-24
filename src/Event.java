public final class Event {

    public static boolean probability (int probability){

        //probability with which event occurs
        //from 0 to 100
        //max probability 100%

        int p = (int) (Math.random() * 100);
        if (p <= probability) {
            return true;
        } else return false;
    }
}
