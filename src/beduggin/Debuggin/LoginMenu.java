package Debuggin;
public class LoginMenu extends View {
	
	
	
	private int stage;
	
    public LoginMenu() {
        viewMenu = "LoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    
    
    
    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Login Menu ==========");
        System.out.println("Enter username to login: ");
        System.out.println("UN>"+DataStore.getUser()+"\n");
        System.out.println("PW>"+DataStore.getPass()+"\n");
        String input = viewManager.getScanner().nextLine();
        abrakadabra(input);
                	
        
        if(DataStore.getUser()!= null && DataStore.getPass()==null)
        	DataStore.setPass(input);

        if(DataStore.getUser()==null) 
        	DataStore.setUser(input);
        //navigate to next menu

    }
    
    
    public void abrakadabra(String dothething)
    {
    	System.out.println("|>>-<<|");
    }
}