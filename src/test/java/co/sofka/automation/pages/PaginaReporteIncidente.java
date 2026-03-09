package co.sofka.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaginaReporteIncidente extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade campoEmail;

    @FindBy(id = "lineNumber")
    private WebElementFacade campoNumeroLinea;

    @FindBy(id = "incidentType")
    private WebElementFacade selectorTipoIncidente;

    @FindBy(id = "description")
    private WebElementFacade campoDescripcion;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade botonEnviarReporte;

    @FindBy(id = "email-error")
    private WebElementFacade mensajeErrorEmail;

    @FindBy(id = "lineNumber-error")
    private WebElementFacade mensajeErrorNumeroLinea;

    @FindBy(id = "description-error")
    private WebElementFacade mensajeErrorDescripcion;

    public void ingresarEmail(String email) {
        campoEmail.type(email);
    }

    public void ingresarNumeroLinea(String numero) {
        campoNumeroLinea.type(numero);
    }

    public void seleccionarTipoIncidente(String etiquetaVisible) {
        selectorTipoIncidente.selectByVisibleText(etiquetaVisible);
    }

    public void ingresarDescripcion(String descripcion) {
        campoDescripcion.type(descripcion);
    }

    public void enviarFormulario() {
        botonEnviarReporte.click();
    }

    public String obtenerMensajeErrorEmail() {
        return mensajeErrorEmail.getText();
    }

    public String obtenerMensajeErrorNumeroLinea() {
        return mensajeErrorNumeroLinea.getText();
    }

    public String obtenerMensajeErrorDescripcion() {
        return mensajeErrorDescripcion.getText();
    }
}
