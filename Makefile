include scripts.mk

.ONESHELL:
.DEFAULT_GOAL := test

.PHONY: test
test:
	@mvn test

.PHONY: fmt
fmt: ; @$(value format_if_executable_present)

.PHONY: install-formatter
install-formatter:
	@npm list --global prettier || npm install -g prettier prettier-plugin-java
	@echo "In an event of a permission error from npm, run sudo make install-formatter"