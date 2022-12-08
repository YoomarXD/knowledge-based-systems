(defrule r-resfriado
   (sintoma congestion-nasal) (sintoma estornudos) (sintoma tos) (paciente ?paciente)
   =>
   (assert (sintoma n-resfriado))
   ;;(printout t "Neumologo -> " ?paciente ": Te diagnostico resfriado comun" crlf)
)

(defrule r-gripe
   (sintoma congestion-nasal) (sintoma fiebre) (sintoma fatiga) (paciente ?paciente)
   =>
   (assert (sintoma n-gripe))
   ;;(printout t "Neumologo -> " ?paciente ": Te diagnostico gripe" crlf)
)

(defrule r-asma
   (sintoma falta-aire) (sintoma tos) (sintoma dolor-pecho) (paciente ?paciente)
   =>
   (assert (sintoma n-asma))
   ;;(printout t "Neumologo -> " ?paciente ": Te diagnostico asma" crlf)
)

(defrule r-rinitis
   (sintoma congestion-nasal) (sintoma estornudos) (sintoma comezon-nasal) (paciente ?paciente)
   =>
   (assert (sintoma n-rinitis))
   ;;(printout t "Neumologo -> " ?paciente ": Te diagnostico rinitis" crlf)
)

(defrule r-sinusitis
   (sintoma n-rinitis) (sintoma perdida-olfato) (sintoma fatiga) (paciente ?paciente)
   =>
   (assert (sintoma n-sinusitis))
   ;;(printout t "Neumologo -> " ?paciente ": Te diagnostico sinusitis" crlf)
)