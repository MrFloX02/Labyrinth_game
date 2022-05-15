# Equipe

- David ADAMOV
- Enzo DEMEULENAERE
- Eric MESSAGER
- Valentin POULAIN

# Sujet

[Le sujet 2022](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

### Atteinte des objectifs
* diagramme UML mis en place 
* Mise en place de l'algorithme Sidewinder
* Mise en place de l'affichage de la labyrinthe
* Mise en place de l'algorithme RandomFusion

### Difficultés restant à résoudre
* Nous n'avons pas encore placé les startCell et les winCell

## Livrable 2

### Atteinte des objectifs

#### INDICES :

* Direction :

	- **description:** On pointe la case d'arivee dans quatre directions : Nord-Ouest, Nord-Est, Sud-Ouest, Sud-Est. 

* Vol d'oiseau :

	- **description:** On indique combien de cases faut-il passer pour atteindre la case d'arrivee (les murs ne comptent pas). 

* Position :

	- **description:** Donne directement la position de La case d'arrivee

* Zone :

	- **description:** cree une liste des cellules dans un certain rayon (encore indetermine) autour de la cellule d'arrivee.


#### OBJETS :
* Parchemin :

	- **description:** Le parchemin est un objet contenant un indice pour vous aider dans votre quete.
	
	
* Bourse :

	- **description:** La bourse est ici pour contenir l'argent recolte dans votre aventure ,elle vous servira pour acheter different item ou indice.
	
	
	

#### PERSONNAGES :
* Heros(joueur): 

	- **description:** nous jouons un heros et nous avons pour but d'aller a la case final (apres avoir recu une certaine quantite d'or).
	
	
* Fou :

	- **description:** Le fou est un personnage donnant des fausses indications au joueur dans sa quete de sortir du labyrinthe .Le fou donne un faux indice que nous pouvons utiliser. 
	
	
	
* Sphinx : 

	- **description:** lorsqu'on interagis avec le sphinx, un enigme est posee. Si notre reponse est correct, une indice est donne. Sinon notre argent est volee.

	
	
* Marchand :

	- **description:** Le marchand est un vendeur qui dispose de different indice que l'on peut acheter dans un shop.
	 Vous pourrez alors avec votre bourse acheter ces different indice.
	
	
* Altruiste :

	- **description:** L'altruiste est une gentille personne qui vous donnera un indice pour vous aider dans votre quête.
	
	

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

#### ACTIONS :

* LookAround :
	le personnage regarde autour de lui, cet action ne change pas de tour.
	
* Move : 
	le personnage se deplace d'une case a une autre.

* PickItem : 
	le personnage recolte l'objet dans la case
	
* UseItem :
	Le personnage utilise l'objet

* Stay : 
	Le personnage reste sur place et ne bouge pas.
	
* Speak : 
	Le personnage interagis avec un autre.

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
* Comprehension du projet, choix de l'algorithme de labyrinthe et modélisation globale de l'UML.
* Creation du [Diagramme UML](https://lucid.app/lucidchart/27dd82e3-0ed9-4c81-ae46-7fd4e1479e99/edit?invitationId=inv_ad29cb2e-4a2a-453d-9f32-061dde8564b9)

## Semaine 2
Développement des classes.
Conception du premier algorithme sidewinder et son affichage.

## Semaine 3
* **Lundi :** Reflexion autour de l'algorithme "sidewinder" et de l'affichage
* Mardi : l'affichage de la labyrinthe a été complétée (la compilation est en attente)

## Semaine 4
* Refonte de la premiere partie du [Diagramme UML](https://lucid.app/lucidchart/f630e7d4-050c-45e9-bedc-c889d06ef7ed/edit?invitationId=inv_62b8bf13-cc8f-4141-8472-071f597f43ac)
* Conception final du deuxieme algorithme de fusion et son affichage.
* Implementaion des classes tests
* travail sur l'algorithme de fusion des cellules
* réorganisation de la structure conceptionel de Board.java

## Semaine 5
* **OBJECTIF :** Avancer sur la programmation des personnages et du joueur 
* Refonte de la premiere partie du [Diagramme UML](https://lucid.app/lucidchart/0cdc63f3-feff-4e75-9128-c0781f535ab5/edit?invitationId=inv_cd22acfe-efa6-4cad-8204-32c9294f7ce3)
* Reorganisation des packages

## Semaine 6
* Documentation des mobs et des items
* modifications des diagrammes UML
* creation des classes indices
* Création de different package pour les mobs les indices et les items.
* modifications des [Diagrammes UML](https://lucid.app/lucidchart/0cdc63f3-feff-4e75-9128-c0781f535ab5/edit?invitationId=inv_cd22acfe-efa6-4cad-8204-32c9294f7ce3)

## Semaine 7
* Ajout dans la classe board
* (affichage d'un mob sur le labyrithe (00),code couleur labyrinthe)
* Ajout dans la classe bourse
* Changement dans le package Hint
* ajout du makefile

## Semaine 8
**a faire : **
* heriter Player a la classe Mob
* Retyper l'attrubut Cell.neighbourCell (List--->Map)
* Creer une boucle de jeu dans Game
* Modeliser les actions a partir des classe ([UML](https://lucid.app/lucidchart/d9e23509-b25e-44d2-b17f-18a268da96a9/edit?invitationId=inv_9dbf289e-3b77-4697-ad1a-0d483a28961a))

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
