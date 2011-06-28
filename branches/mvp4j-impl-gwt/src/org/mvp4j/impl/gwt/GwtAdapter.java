package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Tree;

public class GwtAdapter implements MVPAdapter{

	@Override
	public Class<? extends ActionComponent> getComponentAction(
			Class<?> componentKlass) {
		if(componentKlass.equals(Button.class)){
			return ButtonActionComponent.class;
		}
		if(componentKlass.equals(PushButton.class)){
			return ButtonActionComponent.class;
		}
		if(componentKlass.equals(ToggleButton.class)){
			return ButtonActionComponent.class;
		}
		if(componentKlass.equals(ListBox.class)){
			return ListBoxActionComponent.class;
		}
		if(componentKlass.equals(RadioButton.class)){
			return RadioButtonActionComponent.class;
		}
		if(componentKlass.equals(RichTextArea.class)){
			return RichTextAreaActionComponent.class;
		}
		if(componentKlass.equals(CheckBox.class)){
			return CheckBoxActionComponent.class;
		}
		if(componentKlass.equals(Tree.class)){
			return TreeActionComponent.class;
		}
		return null;
	}

	@Override
	public Class<? extends ModelComponent> getComponentModel(
			Class<?> componentKlass) {
		if(componentKlass==TextBox.class){
			return TextBoxModelComponent.class;
		}
		if(componentKlass==PasswordTextBox.class){
			return TextBoxModelComponent.class;
		}
		
		if(componentKlass==TextArea.class){
			return TextBoxModelComponent.class;
		}
		if(componentKlass==RichTextArea.class){
			return RichTextAreaModelComponent.class;
		}
		if(componentKlass==RadioButton.class){
			return RadioButtonModelComponent.class;
		}
		if(componentKlass==ListBox.class){
			return ListBoxModelComponent.class;
		}
		if(componentKlass==CheckBox.class){
			return CheckBoxModelComponent.class;
		}
		return null;
	}

}
