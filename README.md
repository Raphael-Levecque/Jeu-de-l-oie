# Raphaël LEVECQUE, TP8 POO

## TP et ses objectifs

Réalisation du jeu de l'oie. Travail presque fait dans son intégralité, je me suis rendu compte un peu tardivemment qu'il manque notamment quelques tests. 
Ce TP a par ailleurs été un rappel de prendre l'habitude d'écrire les tests avant de plonger directement dans l'écriture de code. 

Je pense que j'aurais probablement pu/dû décomposer encore plus la méthode Game.playerPlay(). La trace semble correcte mais j'ignore si l'implémentation est correcte.
J'ai un peu patogé au départ puisque je n'avais malheureusement pas pu assister au TD dans lequel vous aviez donné des pistes de conception, mais j'ai quand même finalement réussi
à m'approcher de ce que mes camarades avaient noté de ce TD.

Dans le MainGame j'ai uniquement offert la possibilité de faire jouer deux joueurs.

Je profite de ce dernier rendu de TP pour vous dire que cela a été un réel plaisir de suivre l'UE de POO ce semestre. J'étais très enthousiaste à l'idée d'apprendre la POO, et en regardant le code de C# que j'avais écrit il y a quelques mois pour un projet Unity, je dois dire que je suis fier des progrès réalisés :smiley: ! 

Je vous souhaite de bonnes fêtes de fin d'année.

## Génération de la documentation 

```
javadoc -sourcepath src -subpackages goosegame cells -d docs
```

## Compilation des sources 

```
javac -sourcepath src src/goosegame/*.java -d classes
```

## Compilation des tests

sous linux : 
```
javac -classpath classes:junit-console.jar test/goosegame/*.java
```

sous windows :
```
javac -classpath "classes;junit-console.jar" test/goosegame/*.java
```

## Exécution des tests

sous linux : 
```
java -jar junit-console.jar -classpath test:classes -scan-classpath
```

sous windows :
```
java -jar junit-console.jar -classpath "test;classes" -scan-classpath
```

## Exécution du programme

```
java -classpath classes goosegame.MainGame 
```

## Création du jar pour ImageMain

```
jar cvfe goosegame.jar goosegame.MainGame -C classes goosegame
```

## Exécution du jar 

```
java -jar goosegame.jar <player1> <player2>
```

**Exemple :** 
```
java -jar goosegame.jar Astarion MindFlayer
```