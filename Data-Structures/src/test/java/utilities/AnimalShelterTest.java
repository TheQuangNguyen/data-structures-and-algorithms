package utilities;

import org.junit.Before;
import org.junit.Test;
import stacksandqueues.Node;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AnimalShelterTest {

    AnimalShelter animalShelter;
    @Before
    public void setUp() throws Exception {
        animalShelter = new AnimalShelter();
    }

    // test if we can enqueue a dog and dequeue with null
    @Test
    public void testEnqueueDogDequeueNull() {
        Dog newDog = new Dog("Mr. Tickle");
        animalShelter.enqueue(newDog);
        assertEquals(newDog, animalShelter.dequeue(null));
    }
    // test if we can enqueue a cat and dequeue with null
    @Test
    public void testEnqueueCatDequeueNull() {
        Cat newCat = new Cat("Mr. Hangry");
        animalShelter.enqueue(newCat);
        assertEquals(newCat, animalShelter.dequeue(null));
    }

    // test if we get an exception if we enqueue something that is not a dog or cat
    @Test(expected = IllegalArgumentException.class)
    public void testEnqueueNeitherDogOrCat() {
        Node notCatOrDog = new Node("test");
        animalShelter.enqueue(notCatOrDog);
    }

    // test if we can enqueue a dog then cat and specify that we dequeue a cat first then dog
    @Test
    public void testEnqueueDogCatThenSpecifyDequeueCatDog() {
        Dog newDog = new Dog("Mr. Tickle");
        Cat newCat = new Cat("Mr. Hangry");
        animalShelter.enqueue(newDog);
        animalShelter.enqueue(newCat);
        assertEquals(newCat, animalShelter.dequeue("cat"));
        assertEquals(newDog, animalShelter.dequeue("dog"));
    }

    // test if we can enqueue a dog then cat and without specify dequeue a dog first then cat
    @Test
    public void testEnqueueDogCatThenDequeueDogCat() {
        Dog newDog = new Dog("Mr. Tickle");
        Cat newCat = new Cat("Mr. Hangry");
        animalShelter.enqueue(newDog);
        animalShelter.enqueue(newCat);
        assertEquals(newDog, animalShelter.dequeue(null));
        assertEquals(newCat, animalShelter.dequeue(null));
    }

    // test if we enqueue dog then cat but dequeue with specifying dog and dog
    @Test(expected = NoSuchElementException.class)
    public void testEnqueueDogCatThenSpecifyDequeueDogDog() {
        Dog newDog = new Dog("Mr. Tickle");
        Cat newCat = new Cat("Mr. Hangry");
        animalShelter.enqueue(newDog);
        animalShelter.enqueue(newCat);
        assertEquals(newDog, animalShelter.dequeue("dog"));
       animalShelter.dequeue("dog");
    }

    // test if we enqueue bunch of dogs then one cat and dequeue with specifying cat
    @Test
    public void testEnqueueMultipleDogsOneCatThenSpecifyDequeueCat() {
        Dog newDog = new Dog("Mr. Tickle");
        Dog newDog2 = new Dog("Mr. Ticklish");
        Dog newDog3 = new Dog("Mr. Tickly");
        Cat newCat = new Cat("Mr. Hangry");
        animalShelter.enqueue(newDog);
        animalShelter.enqueue(newDog2);
        animalShelter.enqueue(newDog3);
        animalShelter.enqueue(newCat);
        assertEquals(newCat, animalShelter.dequeue("cat"));
        assertEquals(newDog, animalShelter.dequeue("dog"));
        assertEquals(newDog2, animalShelter.dequeue(null));
        assertEquals(newDog3, animalShelter.dequeue("dog"));
    }

    // test if we enqueue bunch of dogs then one cat and dequeue with specifying cat
    // then enqueue mix of cats and dogs and dequeue specifying cat
    @Test
    public void testEnqueueMultipleDogsOneCatThenSpecifyDequeueCatThenEnqueueDogsAndCatsThenSpecifyDequeueCat() {
        Dog newDog = new Dog("Mr. Tickle");
        Dog newDog2 = new Dog("Mr. Ticklish");
        Dog newDog3 = new Dog("Mr. Tickly");
        Dog newDog4 = new Dog("Mr. Tick");
        Cat newCat = new Cat("Mr. Hangry");
        Cat newCat2 = new Cat("Mr. Angry");
        Cat newCat3 = new Cat("Mr. Anger");
        animalShelter.enqueue(newDog);
        animalShelter.enqueue(newDog2);
        animalShelter.enqueue(newDog3);
        animalShelter.enqueue(newCat);
        assertEquals(newCat, animalShelter.dequeue("cat"));

        animalShelter.enqueue(newDog4);
        animalShelter.enqueue(newCat2);
        animalShelter.enqueue(newCat3);

        assertEquals(newCat2, animalShelter.dequeue("cat"));
        assertEquals(newDog, animalShelter.dequeue(null));
        assertEquals(newDog2, animalShelter.dequeue("dog"));
        assertEquals(newCat3, animalShelter.dequeue("cat"));
    }
}