# SMTPrank
SMTPrank est un logiciel d'envoit de plaisanteries par e-mail.  

## Vue d'ensemble
![Vue d'ensemble](https://github.com/crabone/Teaching-HEIGVD-RES-2016-Labo-SMTP/blob/master/figures/abstract.png)

## Installation
### MockMock
Comme il n'est pas possible de se connecter directement auprès d'un serveur SMTP depuis un privé, il est conseillé d'installer un faux serveur mail, qui réceptionnera les plaisanteries. Nous utiliserons ici MockMock, attention toutefois, il est nescessaire d'avoir java 8 pré-installé.

1. Télécharger le programme ici: https://github.com/tweakers-dev/MockMock/blob/master/release/MockMock.jar?raw=true
2. Ouvrir un terminal et se rendre dans le dossier de téléchargement
3. Executer la commande suivante: java -jar MockMock.jar -p 2525

Note: Il est conseillé de mapper MockMock sur le port 2525. Sur certains systèmes d'exploitations (tel que GNU/Linux) il est nescessaire de bénéficier des droits administrateurs pour mapper MockMock sur le port 25.

### SMTPrank
A défaut d'executable, il est nescessaire de compiler l'application et de le lancé depuis un IDE (ici Netbeans)
1. Cloner le repository
2. Ouvrir le projet
3. Compiler et exécuter

## Configuration
SMTPrank est configurable par des fichiers situés dans /path/to/install/dir/config/*

Pour l'instant il est nescessaire de modifier le fichier default.cfg (user.cfg n'est pas pris en compte) pour modifier
le comportement de SMTPrank. En voici les options disponibles :
* smtpServerAddress permettant de spécifier l'adresse du serveur SMTP
* smtpServerPort pour le port du serveur SMTP
* pathToVictims le chemin du fichier "victimes"
* pathToPranks=config/pranks le chemin du fichier contenant les plaisanteries
* minVictimsInGroups=3 le nombre minimal de victimes dans un groupe
* numberOfGroups=2 le nombre de groupe à générer

Le fichier des victimes doit contenir la liste des adresses e-mails des victimes (une adresse par ligne). Le fichier contenant les plaisanteries doit s'articuler comme suit:
* Une première ligne avec pour préfixe "Subject: " et l'objet de la plaisanterie
* Ensuite le contenu de la plaisanterie (Sur plusieures lignes)
* Un séparateur "==="
Attention la dernière plaisanterie ne doit pas contenir de séparateur à la fin.

## Aspects techniques
### Diagramme de classe
![Diagrame de classe](https://github.com/crabone/Teaching-HEIGVD-RES-2016-Labo-SMTP/blob/master/figures/diagrame-de-classe.png)

