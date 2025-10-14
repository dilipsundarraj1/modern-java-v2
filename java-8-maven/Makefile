# This is the BUILD target, do not remove it, and do not modify it's name
.PHONY: java21-cli-build
java21-cli-build:
	mvn install -Dmaven.test.failure.ignore=true

# This is the RUN target, do not remove it, and do not modify it's name
.PHONY: java21-cli-run
java21-cli-run: ;

# This is the command run by the IDE's run button
.PHONY: lab-run
lab-run:
	mvn compile
	mvn exec:java -Dexec.mainClass="com.learnJava.streams.StreamsExercises"

# This is the command run by the IDE's test button
.PHONY: lab-test
lab-test:
	mvn -Dtest=$(subst src/test/java/,,$(basename $(FILE))) test
