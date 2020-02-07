Projet n°7 pour Openclassroom

----------------------------
Restaurer la base de données
----------------------------

Pour restaurer la base de données de l'application, vous devez créer sur un serveur, puis une base de données.
Les fichiers avec la terminologie « dump » contiennent les fichiers nécessaires à la création des tables de l'application.
Les fichiers avec la terminologie « data » contiennent un jeu de donnée de l'application.
Utilisez la fonction « Restore » puis sélectionnez le fichier de votre choix. Il est noté que pour toute création d’une nouvelle base de données, vous devrez obligatoirement débuté par le fichier « dump » qui contient la création des tables. Le fichier « data » s’utilise après.

Les terminologies et les adresses employées pour chaque unes des bases de données peuvent être retrouver dans les fichiers applications.properties des différents micro-services.


--------------------------------------------
Installation et utilisation de l’application
--------------------------------------------
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
