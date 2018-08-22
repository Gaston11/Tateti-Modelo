package Eventos;

import Controladores.Controlador;
import Vista.VistaCelda;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sun.text.resources.no.CollationData_no;

public class SeleccionarCeldaEventHandler implements EventHandler<MouseEvent> {

    private VistaCelda vistaCelda;
    private Controlador controlador;

    public SeleccionarCeldaEventHandler(VistaCelda unaVistaCelda, Controlador unControlador) {
        this.vistaCelda = unaVistaCelda;
        this.controlador = unControlador;

    }


    @Override
    public void handle(MouseEvent arg0) {
        this.controlador.jugar(this.vistaCelda);
        this.controlador.actualizarEtiquetaTurno();
    }
}