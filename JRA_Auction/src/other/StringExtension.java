package other;

public class StringExtension {
	private String stringExpression;
	
	public String getStringExp() {return this.stringExpression;}
	public void setStringExp(String newString) {this.stringExpression = newString;}
	
	public void attachString(String newString) {
		if(this.stringExpression == null || this.stringExpression.equals("")) {
			this.stringExpression = newString;
		}
		else {
			this.stringExpression.concat(newString);
		}
	}

	public StringExtension(String stringExpression) {
		this.stringExpression = stringExpression;
	}
	
}
