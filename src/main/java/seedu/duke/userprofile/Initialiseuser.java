package seedu.duke.userprofile;

import seedu.duke.Duke;
import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.ArrayList;
import seedu.duke.Ui;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;

public class Initialiseuser {
//    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[7];

    public static String input() {
        return Duke.in.nextLine();
    }

    public static Userinfo createNewProfile() {
        Userinfo profile = null;
        gatherUserInfo();
        try {
            profile = enterNewUserInfo();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }

    public static void gatherUserInfo() {
        name();
        gender();
        weight();
        height();
        age();
        activityLevel();
        weightGoal();
    }

    public static void name()  {
        Ui.displayAskUserNameMessage();
        data[0] = input();
    }

    public static void gender() {
        Ui.displayAskUserGenderMessage();
        data[1] = input();
    }

    public static void weight() {
        Ui.displayAskUserWeightMessage();
        data[2] = input();
    }

    public static void height() {
        Ui.displayAskUserHeightMessage();
        data[3] = input();
    }

    public static void age() {
        Ui.displayAskUserAgeMessage();
        data[4] = input();
    }

    public static void activityLevel() {
        Ui.displayAskUserActivityLevelMessage();
        data[5] = input();
    }

    public static void weightGoal() {
        Ui.displayAskUserWeightGoalMessage();
        data[6] = input();
    }

    public static Userinfo enterNewUserInfo() throws IOException {
        Userinfo profile = new Userinfo(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        System.out.println(profile.calculateNewUserDetails());
        Initialiseuser.save(profile);
        return profile;
    }

    public static void saveExistingUserInfo(Userinfo profile) {
        Initialiseuser.save(profile);
    }

    public static void save(Userinfo profile) {
        try {
            Userinfotextfilestorage storage = new Userinfotextfilestorage();
            storage.save(profile.toString());
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
    }

    public static Userinfo loadProfile() {
        String[] data = new String[7];
        ArrayList<String> previous = Userinfotextfilestorage.update();
        for (int i = 0; i < 7; i++) {
            data[i] = previous.get(i);
        }
        Userinfo profile =  new Userinfo(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        profile.calculateNewUserDetails();
        Initialiseuser.saveExistingUserInfo(profile);
        return profile;
    }
}