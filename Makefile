all: build

build:
	@echo 'Build: clean install'
	mvn clean install

eclipse:
	@echo 'Build: Eclipse projects'
	@mvn clean package eclipse:eclipse -D eclipse.pde install

clean:
	@echo 'Build: clean'
	find . -name "*~" -print0 | xargs -0 rm -rf
	mvn clean
