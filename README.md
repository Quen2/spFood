# 🥘 SpFood

Une application **Spring Boot + JWT** permettant de créer, partager et gérer des recettes entre utilisateurs.

---

## 🚀 Fonctionnalités principales

- 🔹 **CRUD de recettes** : créer, lire, mettre à jour et supprimer des recettes.
- 🔹 **Favoris** : ajouter des recettes en favoris.
- 🔹 **Gestion utilisateurs** : inscription, login avec JWT.
- 🔹 **Sécurité** : accès aux endpoints via token JWT et rôles utilisateurs.

---

## Routes API
| Méthode | Endpoint          | Description                          | Authentification requise |
|---------|-------------------|--------------------------------------|--------------------------|
| POST    | /api/users        | Inscription d’un nouvel utilisateur  | Non                      |
| POST    | /api/auth/login   | Connexion et obtention d’un token JWT | Non                      |
| POST    | /api/recipes      | Créer une nouvelle recette           | Oui                      |
| GET     | /api/recipes      | Récupérer toutes les recettes        | Oui                      |
| GET     | /api/recipes/{id} | Récupérer une recette par ID         | Oui                      |
| PUT     | /api/recipes/{id} | Mettre à jour une recette par ID     | Oui                      |
| DELETE  | /api/recipes/{id} | Supprimer une recette par ID         | Oui                      |
| GET     | /api/products     | Récupérer les produits               | Oui                      |
| POST |  /api/products     | Ajouter un produit                   | Oui                      |
| GET  | /api/recipes/{id}/pdf | Exporte une recette au format PDF | Oui |

---

## 📦 Prérequis

Avant de commencer, assurez-vous d’avoir installé :

- Java 17+
- Maven ou Gradle
- MySQL ou PostgreSQL

Vérifiez vos versions :

```bash
java -version
mvn -v