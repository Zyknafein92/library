Projet n°7 pour OpenClassrooms

- Licence : license libre
- Auteur : Jérôme Deneux

---------------------
Description du projet
---------------------

Application Web APIREST pour les utilisateurs des bibliothèques d'une grande ville.

1e Release du projet :

 - Application Web avec la possibilité de rechercher un ouvrage, voir le nombre d'exemplaire disponible et leurs disponibilités, consulter ses emprunts ses emprunts en cours, et pouvoir les prolonger de 4 semaines si cela n'a déjà été fait.
 
 - Réaliser un batch pour envoyer un email aux utilisateurs qui n'ont pas rendu les ouvrages dans le temps imparti à la fréquence d'une fois par jour.
 
----------------------
Technologies employées
----------------------
Langage :
-Java 8
-TypeScript

Front : 
- Angular

Back :
- Spring Data
- Spring Web
- Spring Mail
- Spring Security
- Zuul
- Eureka
- Lombok
- MapStruct

Base de données :
- PostgreSQL

Serveur d'application :
Apache Tomcat v.9

----------
Pré-requis
----------

Pour utiliser correctement l'application, il vous faut avant tout restaurer la base de données (cf: Restaurer la base de données), et pouvoir lancer une application .jar.

Restaurer la base de données
----------------------------

Pour restaurer la base de données de l'application, vous devez créer un serveur, puis une base de données pour chaque fichier dump.
Les fichiers avec la terminologie « dump » contiennent les fichiers nécessaires à la création des tables de l'application.
Les fichiers avec la terminologie « data » contiennent un jeu de donnée de l'application.
Utilisez la fonction « Restore » puis sélectionnez le fichier de votre choix. Il est noté que pour toute création d’une nouvelle base de données, vous devrez obligatoirement débuté par le fichier « dump » qui contient la création des tables. Le fichier « data » s’utilise sur la base de données du même nom que vous venez de restaurer.

Les terminologies et les adresses employées pour chaque unes des bases de données peuvent être retrouver dans les fichiers applications.properties des différents micro-services.


--------------------------------------------
Installation et utilisation de l’application
--------------------------------------------

Sur votre IDE
-------------

-	Extraire le fichier .zip
-	Ouvrez votre IDE, et importez le projet.
-	Importez si nécessaire les fichiers avec Maven.
-	Lancez « eurekamicroservice»
-	Lancez « gatewaymicroservice »
-	Lancez « bookmicroservice »
-	Lancez « usermicroservice »
-	Lancez « librarymicroservice »
-	Lancez « borrowmicroservice »
-	Lancez « AngularCLI »
-	Rendez-vous sur http://localhost:4200

Deployer l'application 
----------------------



