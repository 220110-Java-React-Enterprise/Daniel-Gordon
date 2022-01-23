package Debuggin_DonFar;
public class MenuOptions extends View {

    public MenuOptions(){
        viewMenu = "MenuOptions";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Menu Options ==========");
        DataStore.getUser();
        DataStore.getPass();
        System.out.println("Welcome, " + DataStore.getName());
        System.out.println("1. View Accounts ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit");


        //view account
        //withdraw
        //deposit


        viewManager.quit();
    }
}