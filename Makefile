# Requires mvnc.sh from https://gist.github.com/japgolly/4104053

all: build

build:
	@echo 'Build: clean install'
	mvnc.sh clean install

eclipse:
	@echo 'Build: Eclipse projects'
	@mvnc.sh clean package eclipse:eclipse -D eclipse.pde install

eclipse-notest:
	@echo 'Build: Eclipse projects - no test'
	@mvnc.sh eclipse:eclipse -D eclipse.pde -DskipTests

clean:
	@echo 'Build: clean'
	find . -name "*~" -print0 | xargs -0 rm -rf
	mvnc.sh clean

test:
	@echo 'Build: test'
	mvnc.sh test
