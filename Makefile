.DEFAULT_GOAL := test

.PHONY: test
test:
	@mvn test

.PHONY: fmt
fmt:
	prettier --write "**/*.java"

.PHONY: install-formatter
install-formatter:
	@npm list --global prettier || npm install -g prettier prettier-plugin-java
	@echo "In an event of a permission error from npm, run sudo make install-formatter"