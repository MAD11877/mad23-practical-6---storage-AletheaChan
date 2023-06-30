package sg.edu.np.mad.practical6;

import java.io.Serializable;

public class User implements Serializable {
    public String userName;
    public String userDescription;
    public int userID;
    public boolean userFollowed;

    public User() {}

    public User(String userName, String userDescription, int userID, boolean userFollowed) {
        this.userName = userName;
        this.userDescription = userDescription;
        this.userID = userID;
        this.userFollowed = userFollowed;
    }
}