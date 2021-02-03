package alerts;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("D:/Images/Aventurile lui Tom.png");
        assertEquals("Aventurile lui Tom.png", uploadPage.getUploadedFiles(), "Uploaded file incorrect");
    }
}
