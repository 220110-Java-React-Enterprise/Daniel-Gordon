package Debuggin_DonFar;
public class Main {

    public static void main(String[] args){
        //System.out.println("This is working!");
        ViewManager viewManager = ViewManager.getViewManager();


        viewManager.registerView(new LoginMenu());
        viewManager.registerView(new MenuOptions());
        
        viewManager.navigate("LoginMenu");
      
        

        while(viewManager.isRunning()) {
            viewManager.render();

        }

    }
}