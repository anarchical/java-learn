package mvc;

/**
 * @author YeYaqiao
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getNameById(int id) {
        return userService.getNameById(id);
    }
}
