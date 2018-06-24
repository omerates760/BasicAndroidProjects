package merhabadunya.com.sqlliterecyclerview;

/**
 * Created by omera on 29.04.2018.
 */

public class ContactModel {
    private String ID, firstName, lastName;
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
