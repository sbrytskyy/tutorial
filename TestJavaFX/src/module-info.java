module TestJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.sb.test.app to javafx.graphics, javafx.fxml;
}
