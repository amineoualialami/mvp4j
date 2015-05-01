# How to use JCheckBox #

### The view Class ###
```

@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

   @Model(property="profils", initProperty="profil1")
   JCheckBox profilCheckBox1;

   @Model(property="profils", initProperty="profil2")
   JCheckBox profilCheckBox2;

public ClientView() {

		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
                add(getProfilCheckBox1 ());
                add(getProfilCheckBox2 ());

	}


      
	public JCheckBox getProfilCheckBox1() {
		if(profilCheckBox1==null){
			profilCheckBox1 = new JCheckBox("profil 1");
			profilCheckBox1.setBounds(10, 260, 80, 50);
		}
		return profilCheckBox1;
	}


	
	public JCheckBox getProfilCheckBox2() {
		if(profilCheckBox2==null){
			profilCheckBox2 = new JCheckBox("profil 2");
			profilCheckBox2.setBounds(10, 300, 80, 50);
		}
		return profilCheckBox2;
	}


}
```

### The model class ###
```
public class ClientModel implements Serializable {

	
      private ProfilDTO profil1;
      private ProfilDTO profil2;    
      private List<ProfilDTO> profils;  
          

      public List<ProfilDTO> getProfils() {
            if(profils==null){
		profils = new ArrayList<ProfilDTO>();
		}
	    return profils;
	}
      public ProfilDTO getProfil1() {
		//initialization profil1
		return profil1;
	}


	public ProfilDTO getProfil2() {
		//initialization profil2
		return profil2;
	}
}
```


  * When a checkbox is checked, the 