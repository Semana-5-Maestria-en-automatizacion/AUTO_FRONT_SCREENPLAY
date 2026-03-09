package co.sofka.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaginaDashboard extends PageObject {

    @FindBy(css = "table tbody tr[role='button']")
    private WebElementFacade primeraFilaTicket;

    @FindBy(css = "h1.text-3xl")
    private WebElementFacade tituloDashboard;

    @FindBy(xpath = "//td[@colspan='7']//span[contains(text(),'No hay tickets para mostrar')]")
    private WebElementFacade mensajeSinTickets;

    public boolean tieneFichasListadas() {
        try {
            return primeraFilaTicket.waitUntilVisible().isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public void hacerClicEnPrimerTicket() {
        primeraFilaTicket.waitUntilClickable().click();
    }
}
