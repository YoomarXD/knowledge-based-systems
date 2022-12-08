(defrule r-administrar-antibiotico
   (paciente reiniciar-corazon) (msg ?msg)
   =>
   (assert (paciente administrar-antibiotico))
   (printout t ?msg ": Limpiando la zona y admnistrando antibioticos" crlf)
)

(defrule r-celebrar
   (paciente monitorear) (msg ?msg)
   =>
   (assert (paciente celebrar))
   (printout t ?msg ": YAAAAAAY!!!! :)))))" crlf)
)
