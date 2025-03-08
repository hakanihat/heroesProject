# heroesProject
The prject includes 3 services:


1. Main service :
Ability to add heroes/villains (id, name, Intelligence, Strength, Speed, Durability, Combat, Abilities?).
Ability to edit all attributes.

Battle Request:
Heroes will have stats: Intelligence, Strength, Speed, Durability, Combat, which are retrieved from the Marvel API.
The winner of the battle is the hero with the most points (points for each hero are calculated by summing their stats and dividing by the number of stats).

Additional Features:
A superpowers table containing the name of the superpower and its type.
Print all heroes who are X cm tall.
Print all melee/elemental/range heroes.
Print how many comics a given hero appears in.

2Hero Classification Service (heroClassification) – Separate Database

This service contains logic for:
-Printing what kind of relationship one hero has with another.
-Retrieving relationships between heroes (getRelationship).
-Editing relationships (updateRelationship).
-Viewing the history of relationships (getHistory), which includes:
  * Why they became enemies.
  * How they met.
  * In which comic they first appeared together, etc.

3Middleware Service:
-Acts as an intermediary client between the other two services and any external APIs used.


https://github.com/hakanihat/heroesAPIProject
https://github.com/hakanihat/heroesRealitonshipsProject
