package seedu.duke.userprofile;

import seedu.duke.Duke;
import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.ArrayList;

import seedu.duke.Ui;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;

public class Initialiseuser {
    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[7];

    public static String input(String text) {
        System.out.print(text);
        return Duke.in.nextLine();
    }

    public static String input() {
        return Duke.in.nextLine();
    }

    public static void createNewProfile() {
        name();
        try {
            gender();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
    }

    public static void name()  {
        Ui.displayAskUserNameMessage();
        data[0] = input();
    }

    public static void gender() throws IOException {
        data[1] = input("What is your gender (male/female)?\n");
        weight();
    }

    public static void weight() throws IOException {
        data[2] = input("What is your weight in kg?\n");
        height();
    }

    public static void height() throws IOException {
        data[3] = input("What is your height in cm?\n");
        age();
    }

    public static void age() throws IOException {
        data[4] = input("What is your age?\n");
        activityfactor();
    }

    public static void activityfactor() throws IOException {
        data[5] = input("How active are you on a scale of 1-5? With 1 being least active and 5 being most active.\n");
        weightGoal();
    }

    public static void weightGoal() throws IOException {
        data[6] = input("Do you want to lose/maintain/gain weight?\n");
        enterNewUserInfo();
    }

    public static void enterNewUserInfo() throws IOException {
        Userinfo profile = new Userinfo(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        profile.printNewUserCalculatedDetails();
        Initialiseuser.save(profile);
    }

    public static void saveExistingUserInfo(Userinfo profile) throws IOException {
        Initialiseuser.save(profile);
    }

    public static void save(Userinfo profile) throws IOException {
        Userinfotextfilestorage storage = new Userinfotextfilestorage();
        storage.save(profile.toString());
    }

    public static void loadProfile() {
        String[] data = new String[7];
        ArrayList<String> previous = Userinfotextfilestorage.update();
        for (int i = 0; i < 7; i++) {
            data[i] = previous.get(i);
        }
        userInfo = new Userinfo(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        try {
            Initialiseuser.saveExistingUserInfo(userInfo);
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
    }
}