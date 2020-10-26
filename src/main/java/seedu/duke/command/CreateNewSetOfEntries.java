package seedu.duke.command;

import seedu.duke.storage.UserSetStorage;

public class CreateNewSetOfEntries extends Command {
    protected String trimmedInput;

    public CreateNewSetOfEntries(String trimmedUserInput) {
        this.canBeChained = true;
        this.trimmedInput = trimmedUserInput;
    }

    @Override
    public void execute() {
        UserSetStorage.prepareNewSet(trimmedInput);
    }
}
