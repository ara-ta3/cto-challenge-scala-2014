SBT=$(shell which sbt)

test:
	${SBT} test

coverage:
	${SBT} clean coverage test
	${SBT} coverageReport
