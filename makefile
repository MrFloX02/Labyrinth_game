
all : jeu.jar
	java -jar jeu.jar

1 : jeu.jar
	java -jar jeu.jar 1

2 : jeu.jar
	java -jar jeu.jar 2

jeu.jar : cls
	jar cvfe jeu.jar mazegame.MazeMain -C classes mazegame

cls : src/mazegame/MazeMain.java
	javac -sourcepath src -d classes src/mazegame/*.java

main : cls
	java -classpath classes mazegame/MazeMain

docs : 
	javadoc -sourcepath src -d docs -subpackages mazegame



clean : 
	rm -rf classes
	rm -rf docs
	rm -rf *.jar