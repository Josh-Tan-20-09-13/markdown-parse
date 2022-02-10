all: MarkdownParse.java MarkdownParseTest.java
	javac -cp lib/hamcrest.jar:lib/junit.jar:. MarkdownParse.java MarkdownParseTest.java

clean: MarkdownParse.class MarkdownParseTest.class
	rm MarkdownParse.class MarkdownParseTest.class

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java 

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp lib/hamcrest.jar:lib/junit.jar:. MarkdownParseTest.java 

test: MarkdownParseTest.class
	java -cp lib/hamcrest.jar:lib/junit.jar:. MarkdownParseTest
