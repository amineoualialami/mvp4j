# How to use JRadioButton #

### The vue class ###
```

@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

ButtonGroup buttonGroup;

@Model(property="profil", initProperty="profil1")
JRadioButton profilRadioButton1;

@Model(property="profil" , initProperty="profil2" )
JRadioButton profilRadioButton2;

public ClientView() {

		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
                add(getButtonGroup ());

	}

      public ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getProfilRadioButton1());
			buttonGroup.add(getProfilRadioButton2());
		}
		return buttonGroup;
	}

	
	public JRadioButton getProfilRadioButton1() {
		if (profilRadioButton1 == null) {
			profilRadioButton1 = new JRadioButton("profil 1");
			profilRadioButton1.setBounds(10, 180, 80, 50);
		}
		return profilRadioButton1;
	}

	
	public JRadioButton getProfilRadioButton2() {
		if (profilRadioButton2 == null) {
			profilRadioButton2 = new JRadioButton("profil 2");
			profilRadioButton2.setBounds(10, 220, 80, 50);
		}
		return profilRadioButton2;
	}

}
```

### The model Class ###
```

public class ClientModel implements Serializable {

	private ProfilDTO profil;
        private ProfilDTO profil1;
	private ProfilDTO profil2;    
       
        public ProfilDTO getProfil() {
		return profil;
	}
    
        public ProfilDTO getProfil1() {
		//some initialization code for profil1
		return profil1;
	}


	public ProfilDTO getProfil2() {
		//some initialization code for profil2
		return profil2;
	}
```

  * When the selection of the JRadioButton changes the model attribute **_profil_** is automatically initialized by the selected profil, the **_property_** attribute  must contain the same type as the **_initProperty_**.
  * If the **_initProperty_** or **_property_** attributs does not refer to existing objects in the model class, a PropertyNotFoundException is thrown.
  * If the **_initProperty_** attribute refers to an Object Model that is not initialized, a PropertyNotInitializedException is thrown.