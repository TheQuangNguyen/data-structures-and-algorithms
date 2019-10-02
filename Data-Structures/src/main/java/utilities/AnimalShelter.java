package utilities;

import stacksandqueues.Queue;
import stacksandqueues.Stack;
import java.util.Date;

// Implement Animal Shelter using two queues. Each object inserted will contain the actual animal as well as a Date object
// that keep track of what time the animal got into the Animal Shelter.
public class AnimalShelter {
    Queue<Object[]> catQueue;
    Queue<Object[]> dogQueue;

    public AnimalShelter() {
        this.catQueue = new Queue<>();
        this.dogQueue = new Queue<>();
    }

    // adds animal of either Cat or Dog to Animal Shelter
    // along with every animal is Date object that time stamp the time the animal was enqueued
    public void enqueue(Object animal) {
        Object[] item = new Object[2];
        item[0] = animal;
        if (animal instanceof Dog) {
            item[1] = new Date();
            this.dogQueue.enqueue(item);
        } else if (animal instanceof Cat) {
            item[1] = new Date();
            this.catQueue.enqueue(item);
        } else {
            throw new IllegalArgumentException("Animal must be either of type Cat or Dog");
        }
    }

    // dequeue either Cat or Dog depends on if pref is cat, dog, or null
    public Object dequeue(String pref) {
        Date catTime;
        Date dogTime;

        // if there is no preference, then check if either catQueue or dogQueue is empty
        // if one of them is empty, return the first one in the other queue
        // if none of them are empty, look at the front of the queue for both of them and compare the time stamp
        // whichever has the lower time stamp would be dequeue first
        if (pref == null) {
            if (!catQueue.isEmpty() && dogQueue.isEmpty()) {
                return dequeueCatOrDog(catQueue);
            } else if (!dogQueue.isEmpty() && catQueue.isEmpty()){
                return dequeueCatOrDog(dogQueue);
            } else {
                Object[] cat = catQueue.peek();
                catTime = (Date) cat[1];
                Object[] dog = dogQueue.peek();
                dogTime = (Date) dog[1];
            }

            if (catTime.before(dogTime)) {
                return dequeueCatOrDog(catQueue);
            } else {
                return dequeueCatOrDog(dogQueue);
            }
            // if preference is either cat or dog then just dequeue the respective queue
        } else if (pref.equals("cat")) {
            return dequeueCatOrDog(catQueue);
        } else if (pref.equals("dog")) {
            return dequeueCatOrDog(dogQueue);
        } else {
            throw new IllegalArgumentException("preference must be either Dog, Cat, or null");
        }
    }

    // helper method for getting the animal from dequeue either catQueue or dogQueue
    private Object dequeueCatOrDog(Queue<Object[]> animal) {
        Object[] result = animal.dequeue();
        return result[0];
    }
}
