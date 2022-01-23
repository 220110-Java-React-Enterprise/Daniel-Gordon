package Debuggin_DonFar;
public abstract class View {


    protected String userName;
    protected String userPassword;
    protected String viewMenu;
    protected ViewManager viewManager;

    public String getViewMenu() {
        return viewMenu;
    }

    public void setViewMenu(String viewMenu) {
        this.viewMenu = viewMenu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public abstract void renderView();
}