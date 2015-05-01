# How to use JTable #

A full example on how to use Jtable with MVP4J to load data and a delete button

### The view Class ###

```

@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

   @Model(initProperty="users", property = "user")
   private JTable jtable;

   @Action(name = "removeUser")
   JButton delButton;

   
   public ClientView() {
		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
                add(getScrollPane());
                add(getDelButton());
	}

    public JTable getTable() {
		if(jtable==null){
			jtable= new JTable();
		}
		return jtable;
	}

     public JScrollPane getScrollPane() {
		JScrollPane scrollPane = new JScrollPane(getTable());
		scrollPane.setBounds(10, 10, 350, 350);
		return scrollPane;
	}

      public JButton getDelButton() {
		if (delButton == null) {
			delButton = new JButton("Delete");
			delButton.setBounds(850, 10, 70, 40);
		}
		return delButton;
	}
}
```

### The model class ###
```

public class ClientModel implements Serializable {

        private List<UserDTO> users;
        private UserDTO user;

        public List<UserDTO> getUsers() {
		// some code to retrieve your users
		return users;
	}

        public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

        public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
```

### The Presenter class ###
```

public class ClientPresenter {

        ClientView view;
        ClientModel model;

        
        public ClientPresenter(ClientView view, ClientModel model) {
                this.view = view;
                this.model = model;
        }

        public void removeUser(){
          // this is the user selected by the JTable
          UserDto user = model.getUser();
          // some code to delete the user from the database
          
          AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
          // call the AppController to refresh the view
          appController.refreshView(view);
        }

        
}
```