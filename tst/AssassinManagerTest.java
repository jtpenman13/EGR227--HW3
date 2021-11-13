import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Put your comments here
 */

//Test constructor
public class AssassinManagerTest {

    /**
     * Test case 1 provided as an example
     * Test graveyardContains should not have the person who wasn't killed
     */
    @Test
    public void graveyardContainsNegtiveTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Grayson");
        Assert.assertFalse(manager.graveyardContains("Ocean"));
    }
    @Test
    public void graveyardContainsNegtiveTest2(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Grayson");
        Assert.assertTrue(manager.graveyardContains("Grayson"));
    }
    @Test
    public void printKillRingNegative(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertFalse(manager.graveyardContains("Jacob"));
    }
    @Test
    public void printKillRingPositive(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertFalse(manager.graveyardContains("Grayson"));
    }
    @Test // positively tests the AssassinManager constructor
    public void AssassinManagerPositive() {
        List<String> list = new ArrayList<>();
        list.add("Grayson");
        list.add("Chris");
        list.add("Ocean");
        AssassinManager manager = new AssassinManager(list);
        Assert.assertTrue(manager.killRingContains("Grayson"));
    }

    @Test // negatively tests the AssassinManager constructor, catching the error if the list is empty
    public void AssassinManagerNegative() {
        try {
            List<String> list = new ArrayList<>();
            AssassinManager manager = new AssassinManager(list);
            Assert.fail("List should not be empty.");
        } catch (IllegalArgumentException e) {
        }
    }
    @Test // positively tests the isGameOver method
    public void isGameOverPositive() {
        List<String> list = new ArrayList<>();
        list.add("Jacob");
        list.add("Bob");
        list.add("John");
        AssassinManager manager = new AssassinManager(list);
        manager.kill("Jacob");
        manager.kill("Bob");
        Assert.assertTrue(manager.isGameOver());
    }

    @Test // positively tests the isGameOver method
    public void isGameOverNegative() {
        List<String> list = new ArrayList<>();
        list.add("Jacob");
        list.add("Bob");
        list.add("John");
        AssassinManager manager = new AssassinManager(list);
        Assert.assertFalse(manager.isGameOver());
    }
    @Test // positively tests the winner method
    public void winnerPositive() {
        List<String> list = new ArrayList<>();
        list.add("Jacob");
        list.add("Bob");
        list.add("John");
        AssassinManager manager = new AssassinManager(list);
        manager.kill("Jacob");
        manager.kill("Bob");
        Assert.assertEquals("John", manager.winner());
    }
    @Test // negatively tests the kill method, catching the error if the game ends
    public void killNegative() {
        try {
            List<String> list = new ArrayList<>();
            list.add("Jacob");
            list.add("Bob");
            list.add("John");
            AssassinManager manager = new AssassinManager(list);
            manager.kill("Bob");
            manager.kill("John");
            manager.kill("Jacob");
            Assert.fail("Cannot run: Game is over.");
        } catch (IllegalStateException e) {
        }
    }
    /**
     * Test case 2 provided as an example
     * Test constructor with invalid argument
     * Should throw IllegalArgumentException
     */
    @Test
    public void constructorNegativeTest(){
        try{
            List<String> emptyList = new ArrayList<String>();
            AssassinManager manager = new AssassinManager(emptyList);
            Assert.fail("AssassinManager should throw IllegalArgumentExeption for empty list");
        }catch (IllegalArgumentException e) {
        }
    }
}