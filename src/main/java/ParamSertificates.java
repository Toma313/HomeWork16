import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class ParamSertificates  extends BaseSert{
    @Parameterized.Parameters
    public static Collection options(){
        return Arrays.asList(SertificateEnam.values());
    }
    public ParamSertificates(SertificateEnam sertificateEnam){
        driver.get("https://certificate.ithillel.ua/");
        bundle = ResourceBundle.getBundle(sertificateEnam.getType());
        sertificatePage = PageFactory.initElements(driver, SertificatePage.class);
    }
@Test
public void checkSertif() throws InterruptedException {
    sertificatePage.sendSertificateForm(bundle.getString("textInput"));
    Assert.assertEquals(bundle.getString("error"),String.valueOf(sertificatePage.messageCheckEn()));

}
}
