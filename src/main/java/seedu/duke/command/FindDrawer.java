package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.Food;
import seedu.duke.ListDrawer;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDrawer extends ListDrawer {


    protected static final int START_INDEX_FOR_DESCRIPTION = 49;
    protected static final int START_INDEX_FOR_CALORIES = 100;
    protected static final int MAX_STRING_FOR_DESCRIPTION = 36 + DESCRIPTION.length();
    protected static final int START_INDEX_FOR_EXERCISE_TYPE = 19;
    protected static final int START_INDEX_FOR_FOOD_TYPE = 21;
    private static final int START_INDEX_FOR_ACTIVITY_DATE = 9;


    public FindDrawer(ActivityList lastSeenList) {
        super(lastSeenList);
    }

    @Override
    public void printListDrawing() {
        System.out.println(listHeaderString()
                + NEWLINE
                + increaseStringLength(DIVIDER, listHeaderString().length())
                + NEWLINE
                + allActivityString());
    }

    @Override
    protected String singleActivityString(int index) {
        ArrayList<String> descriptions = new ArrayList<>();
        String restOfDescription = "";

        String indexString = Integer.toString(index + 1);
        int lengthOfIndex = indexString.length();

        String descriptionString = activityList.getActivity(index).getActivityDescription();
        int lengthOfDescription = descriptionString.length();


        String dateString = activityList.getActivity(index).getActivityDate().toString();
        int lengthOfDateString = dateString.length();

        String typeString;
        int lengthOfType;

        int lengthLeftForWhiteSpaceDate = START_INDEX_FOR_ACTIVITY_DATE - lengthOfIndex;
        int lengthLeftForWhiteSpaceType;
        int lengthLeftForWhiteSpace;



        if (activityList.getActivity(index) instanceof Food) {
            typeString = FOOD_TYPE;
            lengthOfType = FOOD_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_FOOD_TYPE - lengthOfIndex - lengthLeftForWhiteSpaceDate;

        } else {
            typeString = EXERCISE_TYPE;
            lengthOfType = EXERCISE_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_EXERCISE_TYPE - lengthOfIndex - lengthLeftForWhiteSpaceDate;
        }


        int lengthLeftForWhiteSpaceDescription = START_INDEX_FOR_DESCRIPTION - lengthOfIndex
                - lengthLeftForWhiteSpaceType - lengthOfType - lengthLeftForWhiteSpaceDate - lengthOfDateString;


        if (lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType
                    - lengthLeftForWhiteSpaceType - lengthLeftForWhiteSpaceDescription - lengthLeftForWhiteSpaceDate
                    - MAX_STRING_FOR_DESCRIPTION;
        } else {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType
                    - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - lengthLeftForWhiteSpaceDate
                    - lengthOfDescription;
        }


        //Extract the rest of the string if the description length exceeds the maximum length
        while (lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            String description = descriptionString.substring(0, MAX_STRING_FOR_DESCRIPTION);
            descriptions.add(description);
            System.out.println(Arrays.toString(descriptions.toArray()));
            descriptionString = descriptionString.substring(MAX_STRING_FOR_DESCRIPTION);
            lengthOfDescription = descriptionString.length();

        }
        descriptions.add(descriptionString);


        if (descriptions.size() > 1) {
            for (int i = 1; i < descriptions.size(); i++) {
                restOfDescription = restOfDescription
                        + increaseStringLength(" ", START_INDEX_FOR_DESCRIPTION)
                        + descriptions.get(i) + NEWLINE;
            }
        }

        String calorieString = Integer.toString(activityList.getActivity(index).getActivityCalories());

        return indexString
                + increaseStringLength(" ", lengthLeftForWhiteSpaceDate) + dateString
                + increaseStringLength(" ", lengthLeftForWhiteSpaceType) + typeString
                + increaseStringLength(" ", lengthLeftForWhiteSpaceDescription) + descriptions.get(0)
                + increaseStringLength("_", lengthLeftForWhiteSpace) + calorieString
                + NEWLINE
                + restOfDescription;

    }

    @Override
    protected String listHeaderString() {
        String header = NUMBERS
                + INDENT + DATE
                + increaseStringLength(INDENT, 2) + ACTIVITY_TYPE
                + increaseStringLength(INDENT, 4) + DESCRIPTION
                + increaseStringLength(INDENT,3) + CALORIES_GAIN_OR_LOST;
        return header;
    }


}