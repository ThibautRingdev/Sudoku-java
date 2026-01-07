## Projet Sudoku – Java / Swing

Ce projet est une application Java qui affiche une fenêtre de jeu **Sudoku** à l’aide de **Swing** (`JFrame`) et du toolkit **AWT**.

### Structure du projet

- **`src/`** : contient le code source Java  
  - `App.java` : point d’entrée de l’application (`main`) qui crée une instance de `Sudoku`.  
  - `Sudoku.java` : classe qui configure la fenêtre principale (taille, titre, position, fermeture, layout, etc.).
- **`bin/`** : contient les fichiers compilés (`.class`).  
- **`lib/`** : emplacement prévu pour d’éventuelles dépendances externes (actuellement vide).

### Prérequis

- **Java 8** ou version supérieure installé sur votre machine  
  (commande `java -version` et `javac -version` doivent fonctionner dans le terminal).

### Compilation

Depuis la racine du projet (`Sudoku`), compile les fichiers Java vers le dossier `bin` :

```bash
javac -d bin src\\App.java src\\Sudoku.java
```

### Exécution

Une fois la compilation réussie, lance l’application depuis le dossier racine :

```bash
java -cp bin App
```

Une fenêtre intitulée **"Sudoku"** devrait s’ouvrir avec la taille définie dans `Sudoku.java`.

### Évolutions possibles

- Ajouter la grille de Sudoku (dessin de la grille, chiffres, etc.).  
- Gérer les interactions utilisateur (saisie des chiffres, vérification de la solution).  
- Charger / sauvegarder des grilles de Sudoku.  
- Ajouter un menu (nouvelle partie, difficulté, aide, etc.).

### Développement avec VS Code

Le projet est compatible avec **Visual Studio Code** et les extensions Java.  
Tu peux utiliser la vue **JAVA PROJECTS** pour gérer la compilation, l’exécution et d’éventuelles dépendances.
