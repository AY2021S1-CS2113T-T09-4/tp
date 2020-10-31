package seedu.duke.command;


import seedu.duke.exception.ListNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.duke.ui.ExceptionMessages.displayListNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;

/**
 * This command moves an activity from one index to another.
 */
public class MoveActivityCommand extends Command {
    private int indexToBeMovedFrom;
    private int indexToBeInsertedBelow;

    public MoveActivityCommand(int indexToBeChanged, int indexToBeInsertedBelow) {
        this.indexToBeMovedFrom = indexToBeChanged;
        this.indexToBeInsertedBelow = indexToBeInsertedBelow;
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            dayMap.move(indexToBeMovedFrom, indexToBeInsertedBelow);
        } catch (IndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
            commandLogger.log(Level.WARNING, "Accessing an index that is out of bounds");
        } catch (ListNotFoundException e) {
            displayListNotFoundExceptionMessage();
            commandLogger.log(Level.WARNING, "Accessing a list that does not exist");
        }

    }
}