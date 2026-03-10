package co.sofka.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InterfazDashboard {

    public static final Target PRIMERA_FILA_TICKET =
            Target.the("primera fila de ticket en la tabla")
                    .locatedBy("table tbody tr[role='button']");
}
