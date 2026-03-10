package co.sofka.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InterfazModalCambioEstado {

    public static final Target TITULO_MODAL =
            Target.the("título del modal de cambio de estado")
                    .locatedBy("//h2[contains(text(),'Cambiar estado del ticket')]");

    public static final Target SELECTOR_ESTADO =
            Target.the("selector de estado")
                    .locatedBy("#change-state-select");

    public static final Target BOTON_CONFIRMAR =
            Target.the("botón Confirmar")
                    .locatedBy("//button[normalize-space(text())='Confirmar']");

    public static final Target BOTON_CANCELAR =
            Target.the("botón Cancelar")
                    .locatedBy("//button[normalize-space(text())='Cancelar']");

    public static final Target MENSAJE_EXITO =
            Target.the("mensaje de éxito")
                    .locatedBy("//*[contains(@class,'bg-green-50') and contains(.,'Estado actualizado exitosamente')]");

    public static final Target MENSAJE_ERROR =
            Target.the("mensaje de error")
                    .locatedBy("//*[contains(@class,'bg-red') or contains(@class,'text-red') or contains(.,'No se pudo') or contains(.,'Error')]");
}
