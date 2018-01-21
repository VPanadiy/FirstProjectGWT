package dream.development.firstProjectGWT.validator;

/**
 * FieldVerifier validates that the name the user enters is valid
 */
public class FieldVerifier {

    /**
     * Verify that the specified name is valid for our service
     *
     * @param name tha name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        return name != null && name.length() > 3;
    }

}
