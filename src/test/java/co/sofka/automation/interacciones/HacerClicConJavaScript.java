package co.sofka.automation.interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

public class HacerClicConJavaScript implements Interaction {

    private final Target objetivo;

    public HacerClicConJavaScript(Target objetivo) {
        this.objetivo = objetivo;
    }

    @Step("{0} hace clic con JavaScript sobre {1}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        var elemento = objetivo.resolveFor(actor).waitUntilVisible();
        var js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
        js.executeScript("arguments[0].click();", elemento);
    }

    public static HacerClicConJavaScript en(Target objetivo) {
        return new HacerClicConJavaScript(objetivo);
    }
}
