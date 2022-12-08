(defrule r-detener-corazon
   (paciente incision) (msg ?msg)
   =>
   (assert (paciente corazon-detenido))
   (printout t ?msg ": Deteniendo el corazon" crlf)
)

(defrule r-reiniciar-corazon
   (paciente cerrar-incision) (msg ?msg)
   =>
   (assert (paciente reiniciar-corazon))
   (printout t ?msg ": Reanimando el corazon" crlf)
)

(defrule r-monitorear
   (paciente administrar-antibiotico) (msg ?msg)
   =>
   (assert (paciente monitorear))
   (printout t ?msg ": Todos los monitores en verde. La operacion ha sido un exito." crlf)
)

(defrule r-celebrar
   (paciente monitorear) (msg ?msg)
   =>
   (assert (paciente celebrar))
   (printout t ?msg ":D" crlf)
)
