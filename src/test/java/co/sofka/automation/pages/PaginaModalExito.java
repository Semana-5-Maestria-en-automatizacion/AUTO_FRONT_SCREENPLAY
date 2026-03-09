package co.sofka.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaginaModalExito extends PageObject {

    @FindBy(xpath = "//h2[contains(text(),'¡Reporte Enviado!')]")
    private WebElementFacade tituloExito;

    @FindBy(xpath = "//p[contains(text(),'Hemos recibido tu reporte de incidente')]")
    private WebElementFacade mensajeCuerpo;

    @FindBy(xpath = "//button[normalize-space(text())='Entendido']")
    private WebElementFacade botonEntendido;

    public boolean estaMostrandoTitulo(String titulo) {
        return tituloExito.waitUntilVisible().getText().contains(titulo);
    }

    public boolean contieneMensaje(String texto) {
        return mensajeCuerpo.waitUntilVisible().getText().contains(texto);
    }

    public void cerrarModal() {
        botonEntendido.click();
    }
}
