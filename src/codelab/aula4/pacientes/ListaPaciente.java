package codelab.aula4.pacientes;

import lista.dupla.ListaDuplaGenerica;
import lista.dupla.NodoGenerico;

public class ListaPaciente extends ListaDuplaGenerica<Paciente> {

    @Override
    public String toString() {
        String output = "";
        NodoGenerico<Paciente> curr = this.getInicio();

        while (curr != null) {
            output += String.format("===========\n%s\n", curr.getDado());

            curr = curr.getDireita();
        }

        output += "===========\n";

        return output;
    }

}
