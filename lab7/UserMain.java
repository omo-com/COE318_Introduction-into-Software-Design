/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab7;
/*
This is the UserMain file that runs the whole program. 
Contains the only main in the project.
*/

public class UserMain {
   
    //Set UserInterface varible.
    private UserInterface interact;
    
    public UserMain(UserInterface interact)
    {
        this.interact = interact;
    }
    public static void main(String[]args)
    {
        //Construct object using UserInterface as a paramter.
        UserMain makeCircuit = new UserMain(new UI());
        makeCircuit.interact.promptUser();
    }
    
    
    
    /*Why I used Interface... [Self Note]
          Interface was used because the methods in UI class are not static. You cannot 
          use a non-static method in a static method (which was the main). If I were to 
          simply intialize Circuit into the UserMain, running Circuit in the main would
          result in the error preivously mentioned.
          The result would be different if I were allowed to have the main run in the Circuit
          Class or intialize a Circuit object durring the main. However, that would be not
          be efficent and confusing to follow as all the operations are done with the main
          and no methods.
        Therefore, I use interface in order to access the non-static methods and use them 
        in the static main.
        */
    
    /* **********************I LEARNED MORE ABOUT INTERFACE*********************************
    The previous comment was what I thought Interfaces did. NoW I realize its is actually useless, no need to actually use it.
    You could basically just use UI.java by it self. What UserInterface actually does is create a outline for the method one must use.
    All methods within the Interface must be used, that is why Lab 5 Blackjack uses Interface to ensure the student is using the proper 
    methods for the assignment.
    */
    
}
