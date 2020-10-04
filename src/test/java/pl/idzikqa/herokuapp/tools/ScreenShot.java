package pl.idzikqa.herokuapp.tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ScreenShot {

    private static String getRandomString() {
        return Stream
                .generate(() -> Math.random())
                .limit(10).reduce((a, b) -> a + b)
                .get()
                .toString().replace(".", "");
    }

    public static String takeScreenShot(WebDriver driver, String directory) {
        String file = "screen" + getRandomString() + ".png";
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(directory.replace("../","./"), file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directory + file;
    }
}
