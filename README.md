# API JSON SERVER pour vos tests RESTful
Serveur API REST pour exécuter des requêtes GET/POST/PUT/DELETE de test sur des données incluant des milliers de lignes.

# Dockerhub
Le projet est disponible également sous format Docker, référez vous à l'adresse suivante :

<pre>
<a href="https://hub.docker.com/r/abatalib/fake_db_api_rest" target="_blank">https://hub.docker.com/r/abatalib/fake_db_api_rest</a>
</pre>

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

<pre>
    -------------------------- Requêtes GET --------------------------
    GET "/list" => Liste globale
    GET "/age/{age}" => Liste dont l'âge égal à la valeur passée sous {age} (ex. : "localhost/age/12")
    GET "/age/up/{age}" => Liste dont l'âge est supérieur ou égal à la valeur passée sous {age} (ex. : "localhost/age/up/15")
    GET "/age/less/{age}" =>  Liste dont l'âge est inférieur ou égal à la valeur passée sous {age} (ex. : "localhost/age/less/20")

    GET "/country-name/{cname}" =>  Liste dont le nom du pays égal à la valeur passée sous {cname} (ex. : "localhost/country-name/morocco")
    GET "/country-code/{ccode}" =>  Liste dont le code du pays égal à la valeur passée sous {ccode} (ex. : "localhost/country-code/mar")

    GET "/age/{age}/country-name/{cname}" => Liste dont l'âge égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost/age/16/country-name/morocco")
    GET "/age/up/{age}/country-name/{cname}" => Liste dont l'âge est supérieur ou égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost/age/up/15/country-name/morocco")
    GET "/age/less/{age}/country-name/{cname}" => Liste dont l'âge est inférieur ou égal à la valeur passée sous {age} et le nom du pays est égal à la valeur passée sous {cname} (ex. : "localhost/age/less/15/country-name/morocco")

    -------------------- Requêtes POST/PUT/DELETE --------------------
    POST "/" => Ajouter un nouvel enregistrement
    PUT "/" => Modifier l'enregistrement envoyé dans le corps de la requête
    DELETE "/{id}" => Supprimer l'enregistrement dont l'id égal à la valeur passée sous {id}
    </pre>

# Principales fonctionnalités

<ul>
        <li>
            Il existe deux types de réponses "success" et "failure", cette dernière est en cas d'erreur (doublant, inexistence de l'id, etc)
        </li>
        <li>
            En cas d'ajout d'un nouvel enregistrement existant, un message d'erreur est affiché
            <pre style="padding: 5px; height: 100px">
    {
        "messageType": "failure",
        "message": "Valeur(s) de(s) champ(s) exist(ent) déjà country_name, country_code pour le même âge!"
    }
            </pre>
        </li>
        <li>
            En cas de suppression d'un enregistrement dont l'id passé n'existe pas
            <pre style="padding: 5px; height: 100px">
    {
        "messageType": "failure",
        "message": "Id n'existe pas!"
    }
            </pre>
        </li>
        <li>
            etc
        </li>
    </ul>

# Exemple
Voici le résultat de la requête [GET] suivante :
> localhost/age/up/12/country-name/morocco
<pre>
{
    "messageType": "success",
    "message": "Liste Age >= 12 et country_name = morocco",
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

Voici un exemple d'une requête [POST] pour ajouter un nouvel enregistrement
<pre>
{
    "country_code": "PAY",
    "country_name": "Pays",
    "age": 20,
    "y2000": 290154,
    "y2001": 299469,
    "y2002": 308301,
    "y2003": 316415,
    "y2004": 323545
}
</pre>
