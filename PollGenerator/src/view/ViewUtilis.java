package view;

import java.util.Arrays;

public class ViewUtilis {
    public static final String WRONG_COMMANT_MESSAGE = "Not understandeble command";
    public static final String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of customers";

    public static String [] tail (String [] commands) {
        return Arrays.copyOfRange(commands, 1,commands.length);
    }


}
