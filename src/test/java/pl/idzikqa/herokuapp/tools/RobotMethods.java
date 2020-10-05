package pl.idzikqa.herokuapp.tools;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static java.awt.event.KeyEvent.*;

public class RobotMethods {
    public static void fileUpload(StringSelection file) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        Robot robot = null;
        try {
            robot = new Robot();
            robot.keyPress(VK_CONTROL);
            robot.keyPress(VK_V);
            robot.keyRelease(VK_V);
            robot.keyRelease(VK_CONTROL);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
