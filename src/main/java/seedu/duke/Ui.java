package seedu.duke;

/**
 * Deals with interactions with the user.
 */
public class Ui {
    /**
     * Prints out traKCAL logo.
     */
    public static void displayDuke() {
        drawDivider();
        String logo = "  _                  _  __   ___     _     _\n"
                + " | |_   _ _   __ _  | |/ /  / __|   /_\\   | |\n"
                + " |  _| | '_| / _` | | ' <  | (__   / _ \\  | |__\n"
                + "  \\__| |_|   \\__,_| |_|\\_\\  \\___| /_/ \\_\\ |____|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prints out a line divider.
     */
    public static void drawDivider() {
        String divider = "=========================================================================================";
        System.out.println(divider);
    }

    /**
     * Prints out hello message.
     */
    public static void helloMessage() {
        System.out.println("Hello! I'm traKCAL.");
        drawDivider();
    }

    /**
     * Prints out help list showing the commands available.
     */
    public static void displayHelpMessage() {
        drawDivider();
        String helpList = "Commands available: create new user, list, help, add, delete, find, bye\n"
                + "The expected format of input values:\n"
                + "\tcreate new user         - Adds a new user profile\n"
                + "\ttarget X                - Adds a target calorie, X\n"
                + "\thelp                    - Prints out commands available and their input format\n"
                + "\tadd f/ X c/ Y d/ Z      - Adds food consumed, X, calories gained, Y and date(YYYY-MM-DD), Z\n"
                + "\tadd e/ X c/ Y d/ Z      - Adds exercise done, X, calories lost, Y and date(YYYY-MM-DD), Z\n"
                + "\tlist                    - Prints out the list of entries.\n"
                + "\tedit n/U, g/V, w/W, h/X, a/Y, af/Z\n"
                + "\t                        - Edit user profile to name, U, gender, V, weight, W, height, X,\n"
                + "\t                          age, Y, activity factor(1-5), Z\n"
                + "\tedita W f/ X c/ Y       - Edits activity at index W of list to food consumed, X,\n"
                + "\t                          calories gained, Y\n"
                + "\tedita W e/ X c/ Y       - Edits activity at index W of list to exercise done, X,\n"
                + "\t                          calories lost, Y\n"
                + "\tfind d/ X               - Searches for all activities with description of X\n"
                + "\tfind c/ X               - Searches for all activities with calories of X\n"
                + "\tfind a/ X1 / X2 / X3 ... / Xn\n"
                + "\t                        - Searches for all activities with ALL matching keywords from X1 to Xn\n"
                + "\tfind e/ X1 / X2 / X3 ... / Xn\n"
                + "\t                        - Searches for all activities with AT LEAST one matching keyword from X1 to Xn\n"
                + "\tmove index/ X below/ Y  - Moves the activity at X to the index below Y\n"
                + "\tdelete X                - Deletes activity located at index X of the list\n"
                + "\tbye                     - Terminates the program";
        System.out.println(helpList);
        drawDivider();
    }

    /**
     * Prints out welcome message to user when program is run.
     */
    public static void displayWelcomeMessage() {
        displayDuke();
        helloMessage();
        promptUserOfHelpMessage();
    }

    /**
     * Prints out acknowledgement of saving current activity list in file.
     */
    public static void displaySavedMessage() {
        System.out.println("The current activity list has been saved.");
    }

    /**
     * Prints out error in saving current activity list in file.
     */
    public static void displayNotSavedMessage() {
        System.out.println("The current activity list has not been saved.");
        System.out.println("An error has occurred!");
        promptUserOfHelpMessage();
        System.out.println();
    }

    public static void displayDefaultMessage() {
        drawDivider();
        System.out.println("Invalid command. Please type 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints out bye message and let the user know that the current list has been saved to file.
     */
    public static void displayByeMessage() {
        drawDivider();
        System.out.println("Thank you for using TraKCAL. See you again!");
        drawDivider();
    }

    /**
     * Prints out message to recommend user to print out help list.
     */
    public static void promptUserOfHelpMessage() {
        System.out.println("Please do input 'help' for the commands and their respective input format.");
    }

    /**
     * Prints out message when list command given but activity list is empty.
     */
    public static void displayEmptyActivityCounterMessage() {
        System.out.println("Nothing was added!");
    }

}
