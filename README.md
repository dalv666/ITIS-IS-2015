# ITIS-IIS-2015
Семестровый курс по Интеллектуальным ИС

####Преподаватель: Иванов В.В.

##### Задания:

###### Задание№?
  <ul>
      <li>Построить запрос: <code>найти человека, имеющего наибольшее число знакомых</code></li>
  </ul>

```
PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>
SELECT ?friend, (count (?friend) as ?countFriend)
WHERE
 {
 ?person foaf:knows ?friend.
 }
GROUP BY ?friend
ORDER BY DESC(?countFriend)
```

###### Задание№?
  <ul>
      <li>Расширить свой foaf-profile</li>
  </ul>

```
@prefix : <http://cll.niimm.ksu.ru/swcourse/>.
@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>.
@prefix xsd: <http://www.w3.org/2001/XMLSchema#>.
@prefix foaf: <http://xmlns.com/foaf/0.1/>.
@prefix schema: <http://schema.org/>.

:vladislav_pishchulin   rdf:type 		foaf:Person;
						foaf:name 		"Vladislav Pishchulin"@en,
										"Владислав Пищулин"@ru;
						schema:birthDate "1995-03-03"^^xsd:date;
						foaf:mbox		<mailto:dalv6666@gmail.com>,
										<mailto:djdalv666@yandex.ru>;
						foaf:knows 		:michail_shulgin,
										[
										rdf:type foaf:Person;
											 	 foaf:name "Marsel Ganiev"@en,
														   "Марсель Ганиев"@ru
										];
						foaf:interest	<http://dbpedia.org/resource/Thinking_Out_Loud_(Ed_Sheeran_song)>,
										<http://dbpedia.org/resource/Heaven_Has_No_Favorites>,
										<http://dbpedia.org/resource/The_Prestige_(film)>,
										<http://dbpedia.org/resource/Card_flourish>,
										<http://dbpedia.org/resource/Grand_Theft_Auto:_Vice_City>;
						itisLab 		"Android",
										"JavaLav";
						programmingLang <http://dbpedia.org/resource/Java_(programming_language)>,
										<http://dbpedia.org/resource/Python_(programming_language)>,
										<http://dbpedia.org/resource/Haskell_(programming_language)>;
						prefersOS		<http://dbpedia.org/resource/Android_(operating_system)>,
										<http://dbpedia.org/resource/Windows_8>.
```
###### Задание№?
  <ul>
      <li>Коррелирование биномиальных векторов</li>
  </ul>

######Исходники: [sources](src/main/java/su/dalv/itis/is/corelation)
