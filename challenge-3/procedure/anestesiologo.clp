(defrule r-anestesiar
   (estoy listo) (msg ?msg)
   =>
   (assert (paciente anesteciado))
   (printout t ?msg ": Paciente anestesiado" crlf)
)

(defrule r-celebrar
   (paciente monitorear) (msg ?msg)
   =>
   (assert (paciente celebrar))
   (printout t ?msg ": VIVA!!" crlf)
)
