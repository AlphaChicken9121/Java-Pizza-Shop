package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class Controller {
	public static class AlphabetException extends Exception {
		@Override
		public String toString() {
			return "Only Numbers!";
		}
		
		@Override
		public String getMessage() {return "Only Numbers!";}
	}
	
	public boolean isNumber() {
		return !(Integer.parseInt(q1.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(q2.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(q3.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(q4.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(q5.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(u1.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(u2.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(u3.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(u4.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999) ||
				!(Integer.parseInt(u5.getText()) >= 0 && Integer.parseInt(q1.getText()) <= 1999999999);
	}
	
	@FXML
	private RadioButton smallRadio, mediumRadio, largeRadio;
	@FXML
	private TextField smallVal, mediumVal, largeVal, netTotal, pricePerVal;
	@FXML
	private TextField t1,t2,t3,t4,t5,q1,q2,q3,q4,q5,u1,u2,u3,u4,u5;
	@FXML
	private CheckBox cbFries, cbBottle, cbTea, cbSoftDrink, cbIceCream;
	int f,b,t,s,i, pizzaTotal, extrasTotal, dealsTotal;
	
	
	public void pizzaSize(ActionEvent e){
		try {
			if(smallRadio.isSelected()) {
				pizzaTotal = Integer.parseInt(smallVal.getText());
			}else if(mediumRadio.isSelected()) {
				pizzaTotal = Integer.parseInt(mediumVal.getText());
			}else if(largeRadio.isSelected()) {
				pizzaTotal = Integer.parseInt(largeVal.getText());
			}
			netTotal.setText(Integer.toString(pizzaTotal+extrasTotal+dealsTotal));
		}
		catch(Exception exception) {
			netTotal.setText("INVALID");
		}
	}
	
	public void extras() {
		try {
			if(cbFries.isSelected()) {
				f = Integer.parseInt(pricePerVal.getText());
			}else{
				f = 0;
			}
			
			if(cbBottle.isSelected()) {
				b = Integer.parseInt(pricePerVal.getText());
			}else{
				b = 0;
			}
			
			if(cbTea.isSelected()) {
				t = Integer.parseInt(pricePerVal.getText());
			}else{
				t = 0;
			}
			
			if(cbSoftDrink.isSelected()) {
				s = Integer.parseInt(pricePerVal.getText());
			}else{
				s = 0;
			}
			
			if(cbIceCream.isSelected()) {
				i = Integer.parseInt(pricePerVal.getText());
			}else{
				i = 0;
			}
			extrasTotal = f+b+t+s+i;
			netTotal.setText(Integer.toString(pizzaTotal+extrasTotal+dealsTotal));
		}
		catch(Exception exception) {
			netTotal.setText("INVALID");
		}
	}
	
	public void deals() throws AlphabetException{
		try {
			if (isNumber()) {
				throw new AlphabetException();
			}
			t1.setText(Integer.toString(Integer.parseInt(q1.getText())*Integer.parseInt(u1.getText())));
			t2.setText(Integer.toString(Integer.parseInt(q2.getText())*Integer.parseInt(u2.getText())));
			t3.setText(Integer.toString(Integer.parseInt(q3.getText())*Integer.parseInt(u3.getText())));
			t4.setText(Integer.toString(Integer.parseInt(q4.getText())*Integer.parseInt(u4.getText())));
			t5.setText(Integer.toString(Integer.parseInt(q5.getText())*Integer.parseInt(u5.getText())));
			dealsTotal = Integer.parseInt(t1.getText())+Integer.parseInt(t2.getText())+Integer.parseInt(t3.getText())+
					Integer.parseInt(t4.getText())+Integer.parseInt(t5.getText());
			netTotal.setText(Integer.toString(pizzaTotal+extrasTotal+dealsTotal));
		}
		catch (NumberFormatException e) {
			netTotal.setText("INVALID");
		}
		catch (Exception e){
			netTotal.setText("INVALID");
		}
	}
}
