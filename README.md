# Store and Offers Management (Java console app)

[![Build](https://github.com/AbdelrahmanGamal1998/store-offers-management-java/actions/workflows/build.yml/badge.svg)](https://github.com/AbdelrahmanGamal1998/store-offers-management-java/actions/workflows/build.yml)

A console application for managing stores, products and offers, with four kinds of users. It was built as
the Sprint 4 team project of a university Software Engineering course (Agile/Scrum, UML design, design
patterns). It stores its data in plain text files, so it needs no database.

**Team:** [AbdelrahmanGamal1998](https://github.com/AbdelrahmanGamal1998), [Mahran-99](https://github.com/Mahran-99) and
[Alyzahra](https://github.com/Alyzahra). The full commit history of the original project is kept in this repository.

## What it does

After the welcome screen you create an account or log in as one of these roles:

| Role           | Can do                                                                                          |
| -------------- | ----------------------------------------------------------------------------------------------- |
| **Admin**      | Add products and brands, see user and product statistics, add, edit and delete offers           |
| **Customer**   | Buy a product from the offers                                                                   |
| **Store owner**| Add products and stores, add collaborators, view their data, edit a product price, delete a product, buy a product, and undo the last add, delete or price edit (menu options 8, 9 and 10) |
| **Collaborator** | Add, delete and edit products, and view statistics                                            |

Design patterns used: Command (the undo operations: `Command`, `UndoAddedProductCommand`,
`UndoDeletedProduct`, `UndoEditedProductPrice`, `RemoteControlForCommandPattern`) and controller classes that
separate the menus from the data access. The class diagrams are in [`docs/design`](docs/design).

## Run it

You need JDK 17 or newer and Maven.

```bash
git clone https://github.com/AbdelrahmanGamal1998/store-offers-management-java.git
cd store-offers-management-java
mvn compile exec:exec
```

This starts the app inside the `data/` folder, where it reads and writes its text files. Demo accounts
(type, username, password):

| Role        | Username     | Password     |
| ----------- | ------------ | ------------ |
| Admin       | `admin`      | `admin123`   |
| Customer    | `customer`   | `customer123`|
| Store owner | `storeowner` | `owner123`   |

When asked "Enter Your type" at login, type `admin`, `customer` or `storeowner`.

The app changes the files in `data/` while you use it. Run `git checkout -- data` to restore the demo data.

## Tests

```bash
mvn test
```

The tests (`src/test/java/store/AppFlowsTest.java`) type into the real menus with scripted input: an invalid
menu choice, creating an account, rejecting a duplicate username, and an admin logging in and adding a
product. They run on a copy of `data/` in `target/test-data`, so your files are not changed.

## Project structure

```
src/main/java/store/    the application (menus, controllers, models, undo commands)
src/test/java/store/    scripted-input tests
data/                   demo data, the app's text "database"
docs/design/            class diagrams (PNG and ArgoUML .zargo)
```

## Notes on the code

This is a student project, and the code keeps its original style. Changes made when it was cleaned up:
a Maven build, a single `store` package, one shared keyboard reader instead of a new one in every menu (the
old version lost input when it was piped), string comparisons with `equals`, demo data, tests and CI.

## License

[MIT](LICENSE)
