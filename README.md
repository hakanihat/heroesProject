# heroesProject

1.Service

Могат да се добавят герои/злодеи (id,name,Intalligence,Strength,Speed,durability,combat, abilities?)
Moгат да се редактират всички атрибути 

Заявка кой герой би спечелил битката:
Героите ще имат статове: Intelligence,Strength,Speed,Durability
Combat, които се взимат от  Marvel API -
Победителят на битката е героят с повече точки ( точките за всеки герой се получават като съберем статовете им 
и ги разделим на тяхната бройка)
 
Да имам таблица за суперсили, която да съдържа името на суперсила и типа 

Принтвам всички герои, които са високи x см  

Принтвам всички меле/елементал/range герои

Принтвам  колко комикса има даден герой


2. Service (heroClassification) с отделна база данни 

Принтвам кой герой каква връзка има с друг герой  
Като в този сървис ще имам логиката за получаване на връзката между героите (getRelationship),
 редактиране на връзката (updateRealitonShip)
И ще мога да историята на връзките между тях, където ще има данни защо примерно са станали врагове, как се се запознали, в кой комикс 
се срещнали и т.н (getHistory)



3. service- служи като междинен клиент между другите два сървиса и всички външни апи-та, които ползвам


https://github.com/hakanihat/heroesAPIProject
https://github.com/hakanihat/heroesRealitonshipsProject
