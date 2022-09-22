# Aperçu

Serveur API REST pour exécuter des requêtes GET de test sur des données incluant des milliers de lignes.

# Données

La base de données inclue <b>3221</b> lignes. Voici un extrait des données
<pre>
{
    [
        {
            "id": 1,
            "country_code": "AFG",
            "country_name": "Afghanistan",
            "age": 12,
            "y2000": 526777,
            "y2001": 546360,
            "y2002": 569501,
            "y2003": 595573,
            "y2004": 623433
        },
        {
            "id": 2,
            "country_code": "AFG",
            "country_name": "Afghanistan",
            "age": 11,
            "y2000": 545527,
            "y2001": 565966,
            "y2002": 590081,
            "y2003": 617076,
            "y2004": 645577
        }
    ]
}
</pre>

# Requêtes

<i>NB : toutes les requêtes sont en GET.</i>
<pre>
"/" => Liste globale

"/age/{age}" => Liste dont l'âge égal à la valeur passée sous {age} (ex. : "localhost:9002/age/12")
"/age/up/{age}" => Liste dont l'âge est supérieur ou égal à la valeur passée sous {age} (ex. : "localhost:9002/age/up/15")
"/age/less/{age}" =>  Liste dont l'âge est inférieur ou égal à la valeur passée sous {age} (ex. : "localhost:9002/age/less/20")

"/country-name/{cname}" =>  Liste dont le nom du pays égal à la valeur passée sous {cname} (ex. : "localhost:9002/country-name/morocco")
"/country-code/{ccode}" =>  Liste dont le code du pays égal à la valeur passée sous {ccode} (ex. : "localhost:9002/country-code/mar")

"/age/{age}/country-name/{cname}" => Liste dont l'âge égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost:9002/age/16/country-name/morocco")
"/age/up/{age}/country-name/{cname}" => Liste dont l'âge est supérieur ou égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost:9002/age/up/15/country-name/morocco")
"/age/less/{age}/country-name/{cname}" => Liste dont l'âge est inférieur ou égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost:9002/age/less/15/country-name/morocco")
</pre> 

# Exemple
Voici le résultat de la requête suivante :
> localhost:9002/age/up/12/country-name/morocco
<pre>
{
    "totalElem": 9,
    "entity": [
        {
            "id": 2017,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 12,
            "y2000": 675207,
            "y2001": 669650,
            "y2002": 664153,
            "y2003": 658554,
            "y2004": 652425
        },
        {
            "id": 2021,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 13,
            "y2000": 678127,
            "y2001": 674386,
            "y2002": 669676,
            "y2003": 664145,
            "y2004": 657887
        },
        {
            "id": 2022,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 14,
            "y2000": 679586,
            "y2001": 678203,
            "y2002": 674388,
            "y2003": 668756,
            "y2004": 662136
        },
        {
            "id": 2023,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 15,
            "y2000": 679725,
            "y2001": 680598,
            "y2002": 677670,
            "y2003": 672001,
            "y2004": 665156
        },
        {
            "id": 2024,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 16,
            "y2000": 679717,
            "y2001": 682760,
            "y2002": 680411,
            "y2003": 674302,
            "y2004": 666895
        },
        {
            "id": 2025,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 17,
            "y2000": 672055,
            "y2001": 677330,
            "y2002": 676762,
            "y2003": 672080,
            "y2004": 665947
        },
        {
            "id": 2026,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 18,
            "y2000": 653401,
            "y2001": 660948,
            "y2002": 663990,
            "y2003": 663624,
            "y2004": 661591
        },
        {
            "id": 2027,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 19,
            "y2000": 627649,
            "y2001": 637357,
            "y2002": 644982,
            "y2003": 650550,
            "y2004": 654235
        },
        {
            "id": 2028,
            "country_code": "MAR",
            "country_name": "Morocco",
            "age": 20,
            "y2000": 601810,
            "y2001": 613631,
            "y2002": 625615,
            "y2003": 636799,
            "y2004": 645891
        }
    ]
}
</pre>
