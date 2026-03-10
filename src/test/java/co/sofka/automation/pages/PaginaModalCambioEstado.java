package co.sofka.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaginaModalCambioEstado extends PageObject {

    @FindBy(xpath = "//h2[contains(text(),'Cambiar estado del ticket')]")
    private WebElementFacade tituloModal;

    @FindBy(id = "change-state-select")
    private WebElementFacade selectorEstado;

    @FindBy(xpath = "//button[normalize-space(text())='Confirmar']")
    private WebElementFacade botonConfirmar;

    @FindBy(xpath = "//button[normalize-space(text())='Cancelar']")
    private WebElementFacade botonCancelar;

    @FindBy(xpath = "//*[contains(@class,'bg-green-50') and contains(.,'Estado actualizado exitosamente')]")
    private WebElementFacade mensajeExito;

    public boolean estaVisible() {
        try {
            return tituloModal.waitUntilVisible().isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerTitulo() {
        return tituloModal.waitUntilVisible().getText();
    }

    public void seleccionarEstado(String etiquetaVisible) {
        selectorEstado.selectByVisibleText(etiquetaVisible);
    }

    public void confirmar() {
        botonConfirmar.click();
    }

    public void cancelar() {
        botonCancelar.click();
    }

    public String obtenerMensajeExito() {
        return mensajeExito.withTimeoutOf(java.time.Duration.ofSeconds(5)).waitUntilVisible().getText();
    }

    public boolean estaOculto() {
        try {
            tituloModal.withTimeoutOf(java.time.Duration.ofSeconds(8)).waitUntilNotVisible();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
